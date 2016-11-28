package com.medlog.webservice.util;

import com.medlog.webservice.sql.DbConnection;

public class PrepStatement {

    private java.sql.PreparedStatement ps = null;
    private String sql = "";
    private String errorMessage = ""; // All error messages concatenated

    
    public PrepStatement(DbConnection dbc, String sql) {
        this.sql = sql;
        try {
            java.sql.Connection con = dbc.getConnnection();
            this.ps = con.prepareStatement(sql);
        } catch (Exception e) {
            String msg = " PrepStatement: Exception in constructor. Sql is " +this.sql + " Error message is " 
                    + e.getMessage();
            System.out.println("====> " + msg);
            this.errorMessage += msg;
        }
    }

    // this.errorMsg contains all the error messages that ever occured in this object
    public String getErrorMessage() {
        return this.errorMessage;
    }
    
    // Replace the position-th question mark with newDate.
    // If newDate is null, encode null into that question mark.
    public String setDate(int position, java.sql.Date newDate) {
        try {
            if (newDate == null) {
                ps.setNull(position, java.sql.Types.DATE);

            } else {
                this.ps.setDate(position, newDate);
            }
            return ""; // no error
        } catch (Exception e) {
            String msg = " PrepStatement: Exception in setDate(). Sql is " + this.sql
                    + ", position: " + position + ". Error Msg: " + e.getMessage();
            System.out.println("====> " + msg);
            this.errorMessage += msg;
            return msg;
        }
    }

    // Replace the position-th question mark with newInt.
    // If newInt is null, encode null into that question mark.
    public String setInt(int position, Integer newInt) {
        try {
            if (newInt == null) {
                ps.setNull(position, java.sql.Types.INTEGER);

            } else {
                this.ps.setInt(position, newInt);
            }
            return ""; // no error
        } catch (Exception e) {
            String msg = " PrepStatement: Exception in setInt(). Sql is " + this.sql
                    + ", position: " + position + ". Error Msg: " + e.getMessage();
            System.out.println("====> " + msg);
            this.errorMessage += msg;
            return msg;
        }
    }

    // Replace the position-th question mark with newBigDecimal.
    // If newBigDecimal is null, encode null into that question mark.
    public String setBigDecimal(int position, java.math.BigDecimal newBigDecimal) {
        try {
            if (newBigDecimal == null) {
                ps.setNull(position, java.sql.Types.DECIMAL);

            } else {
                this.ps.setBigDecimal(position, newBigDecimal);
            }
            return ""; // no error
        } catch (Exception e) {
            String msg = " PrepStatement: Exception in setBigDec(). Sql is " + this.sql
                    + ", position: " + position + ". Error Msg: " + e.getMessage();
            System.out.println("====> " + msg);
            this.errorMessage += msg;
            return msg;
        }
    }

    // Replace the position-th question mark with newString.
    // If newString is null, encode "" empty string into that question mark.
    public String setString(int position, String newString) {
        try {
            if (newString == null) {
                newString = "";
            }
            this.ps.setString(position, newString);
            return ""; // no error
        } catch (Exception e) {
            String msg = " PrepStatement: Exception in setString(). Sql is " + this.sql
                    + ", position: " + position + ". Error Msg: " + e.getMessage();
            System.out.println("====> " + msg);
            this.errorMessage += msg;
            return msg;
        }
    }

    // returns the number of rows affected - like PreparedStatement.executeUpdate() would have done
    public int executeUpdate() {
        try {
            int numRows = this.ps.executeUpdate();
            return numRows;
        } catch (Exception e) {
            String msg = " PrepStatement: Exception in executeUpdate(). Sql is " + this.sql
                    + ". Error Msg: " + e.getMessage();
            System.out.println("====> " + msg);
            this.errorMessage += msg;
            return -1;
        }
    }
    
}