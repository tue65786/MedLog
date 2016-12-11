/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Close DB Resources and quiet errors
 *
 * @author (c)2016
 */
public class DbUtl {

    /**
     * No instantiation.
     */
    private DbUtl() {

    }

    /**
     * Safe Close Procedure
     *
     * @param st Stored Procedure Object
     */
    public static void close(CallableStatement st) {
        try {
            st.close();
            st = null;
        } catch (Exception e) {
            //quiet

        }

    }
     public static void close(PreparedStatement st) {
        try {
            st.close();
        } catch (Exception e) {
            //quiet

        }

    }

    /**
     * Safe Close Compiled SQL
     *
     * @param st
     */
    public static void close(Statement st) {
        try {
            st.close();
        } catch (Exception e) {
        }

    }

    /**
     * Safe Close Results
     *
     * @param rs
     */
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (Exception e) {
        }

    }

    /**
     * Safe Close Procedure and Results
     *
     * @param st Sproc
     * @param rs Results
     */
    public static void close(CallableStatement st, ResultSet rs) {
        try {
            try {
                rs.close();
            } catch (Exception ee) {
                //quiet

            }
            st.close();
        } catch (Exception e) {
            //quiet
        }
    }
/**
 * Batch Update special exception print
 * @param b
 * @return 
 */
    public static String printBatchUpdateException(BatchUpdateException b) {

        StringBuilder err = new StringBuilder("==>>>");
        err.append("\n----BatchUpdateException----\nSQLState:  ")
                .append(b.getSQLState()).append("\nMessage:  ").append(b.getMessage())
                .append("\nVendor:  ").append(b.getErrorCode())
                .append("\nUpdate counts:  ");
        int[] updateCounts = b.getUpdateCounts();
        for (int i = 0; i < updateCounts.length; i++) {
            err.append(String.format("%s, ", updateCounts[i]));
        }
        return err.toString();
    }

    /**
     * Prints detailed SQL Exception for debugging.
     *
     * @param ex Exception
     * @return Stacktrace plus!
     */
    public static String printJDBCExceptionMsg(SQLException ex) {
        String stackTracedAsString = "";
        StringBuilder err = new StringBuilder("");
        for (Throwable e : ex) {
            stackTracedAsString += StrUtl.throwableStackTraceToString(ex);
            if (e instanceof SQLException) {
                String state = ((SQLException) e).getSQLState();
                if (state != null && !state.isEmpty()) {
                    stackTracedAsString += "\nState: " + state + "\nMessage: " + e.getMessage();
                }
                e.printStackTrace(System.err);
                err.append("\nSQLState: ").append(((SQLException) e).getSQLState());
                err.append("\nError Code: ").append(((SQLException) e).getErrorCode());
                err.append("\nMessage: ").append(e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    err.append("\nCause: ").append(t);
                    t = t.getCause();
                }
                if (state != null) {
                    if (((SQLException) e).getSQLState()
                            .equalsIgnoreCase("S1000")) {
                        err.append("\nDetails: Cannot insert a record with that ID already exists.");
                    } else if (((SQLException) e).getMessage()
                            .toLowerCase()
                            .contains("foreign key")) {
                        err.append("\nDetails: Invalid foreign key reference.");
                    } else if (((SQLException) e).getMessage()
                            .toLowerCase()
                            .contains("duplicate entry")) {
                        err.append("\nDetails: Duplicate entry (PK).");
                    } else if (((SQLException) e).getMessage()
                            .toLowerCase()
                            .contains("incorrect syntax")) {
                        err.append("\nDetails: Syntax Error.");
                    }
                }

            }
        }
        return StrUtl.coalesce(err.toString(), stackTracedAsString, ex.toString(), "UNKNOWN");
    }

    public static void printWarnings(SQLWarning warning, Class clazz) throws SQLException {
        if (warning != null) {
            System.out.println("\n---Warning from: " + StrUtl.toS(clazz.getName(), "Unknown") + "---\n");
            while (warning != null) {
                System.out.println("Message: " + warning.getMessage());
                System.out.println("SQLState: " + warning.getSQLState());
                System.out.print("Vendor error code: ");
                System.out.println(warning.getErrorCode());
                System.out.println("");
                warning = warning.getNextWarning();
            }
        }
    }
/**
 * Display warnings
 * @param stmt 
 */
    public static void getWarningsFromStatement(CallableStatement stmt) {
        try {
            DbUtl.printWarnings(stmt.getWarnings(), CallableStatement.class);
            DbUtl.printWarnings(stmt.getConnection().getWarnings(), Connection.class);
        } catch (SQLException ex) {
            Logger.getLogger(DbUtl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DbUtl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
