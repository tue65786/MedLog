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
 * @param st
 */
public static void close(CallableStatement st) {
   try {
	  st.close();
   } catch (Exception e) {
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

	  }
	  st.close();
   } catch (Exception e) {
   }

}
}
