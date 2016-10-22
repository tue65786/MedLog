/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.util;

import java.sql.*;

/**
 * Close DB Resources and quiet errors
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
   } catch (Exception e) {
	  //quiet
	  
   }

}

/**
 * Safe Close Compiled SQL
 *
 * @param st
 */
public static void close(PreparedStatement st) {
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

   public static String printBatchUpdateException(BatchUpdateException b) {

	  String err = "";
	  err += "\n----BatchUpdateException----";
	  err += "\nSQLState:  " + b.getSQLState();
	  err += "\nMessage:  " + b.getMessage();
	  err += "\nVendor:  " + b.getErrorCode();
	  err += "\nUpdate counts:  ";
	  int[] updateCounts = b.getUpdateCounts();
	  for (int i = 0; i < updateCounts.length; i++) {
		 err += updateCounts[i] + ", ";
	  }
	  return err;
   }

   /** 
	* Prints detailed SQL Exception for debugging.
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
			err.append( "\nSQLState: " ).append(((SQLException) e).getSQLState());
			err.append( "\nError Code: " ).append(((SQLException) e).getErrorCode());
			err.append( "\nMessage: " ).append(e.getMessage());
			Throwable t = ex.getCause();
			while (t != null) {
			   err.append( "\nCause: " ).append(t);
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
	  return StrUtl.coalesce(err.toString(),stackTracedAsString,ex.toString(),"UNKNOWN");
   }
}
