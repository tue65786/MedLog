/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.medlog.webservice.sql;

import java.sql.*;
import java.util.logging.*;

/**
 * Implementation of {@linkplain IDbConnection}
 * @author (c)2016
 */
public class DbConnection implements IDbConnection{

   private static final Logger LOG = Logger.getLogger( DbConnection.class.getName() );

   @Override
   public void close() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void close(CallableStatement _cs) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void close(ResultSet _rs) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public Connection getConnnection() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public String getError() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

}
