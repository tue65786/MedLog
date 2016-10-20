/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.sql;

import com.medlog.webservice.CONST.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.util.*;
import static com.medlog.webservice.util.StrUtl.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 * Implementation of {@linkplain IDbConnection}
 *
 * @author (c)2016
 */
public class DbConnection implements IDbConnection {

/**
 * Properties as defined in database.properties file
 *
 * @see PropUtils
 */
private static Properties dbProps = null;
/**
 * Tracks open connections
 */
private static int openConnections = 0;

   @Override
   public boolean hasError() {
	  return !toS(error).isEmpty();
   }
/**
 * Connection Object
 */
private Connection dbconn;
/**
 * Connection string loaded from property file.
 * @see SETTINGS#PROPS_FILE
 * @see SETTINGS#JDBC_DRIVE_CLASS
 */
private String dbConnString;
private String error;
private static final Logger LOG = Logger.getLogger( DbConnection.class.getName() );
public static int getOpenConnections(){
   return DbConnection.openConnections;
}
public DbConnection() {
   if ( DEBUG ) {
	  System.out.println( "com.medlog.webservice.sql.DbConnection.<init>()\n" + initConn() + "\n" );
   } else {
	  initConn();
   }
}

/**
 * Retrieves server connection properties from database.properties file
 * TODO - Only load when string is null.
 *
 * @return Connection string.
 * @see database.properties
 */
public final String getConnectionStringFromProps() {
   StringBuilder sb = new StringBuilder( "" );
   try {
	  dbProps = PropUtils.getFromClassPath( PROPS_FILE );
	  sb.append( "jdbc:sqlserver://" );
	  sb.append( PropUtils.getValue( dbProps, "dbServer" ) );
	  sb.append( ";database=" );
	  sb.append( PropUtils.getValue( dbProps, "dbName" ) );
	  sb.append( ";user=" );
	  sb.append( PropUtils.getValue( dbProps, "dbUser" ) );
	  sb.append( ";password=" );
	  sb.append( PropUtils.getValue( dbProps, "dbPassword" ) );
	  dbConnString = sb.toString();
   } catch (Exception e) {
	  LOG.log( Level.SEVERE, "Prop loader", e );
   }
   return dbConnString;
}

/**
 * Prep driver and open connection
 * <ol>
 * <li>Load JDBC Driver</li>
 * <li>Instantiate Connection objection</li>
 * <ol>
 *
 * @return messages
 */
private String initConn() {
   StringBuilder ret = new StringBuilder( "" );
   try {
	  ret.append( "Looking up driver...." );
	  Class.forName( JDBC_DRIVE_CLASS ).newInstance();
	  dbconn = DriverManager.getConnection( getConnectionStringFromProps() );
	  ret.append( "\r\nDriver loaded" );
	  try {
	  } catch (Exception e) {
		 ret.append( "[ERROR] getting connection:" + e.getMessage() + "com.medlog.webservice.sql.DbConnection.initConn()\r\n" );
		 this.error = "Error connecting to SQL [com.medlog.webservice.sql.DbConnection.initConn()]" + e.getMessage();
		 LOG.log( Level.SEVERE, error, e );
	  }
   } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
	  ret.append( "[ERROR] Loading driver from classpath:" ).append( e.getMessage() ).append( "com.medlog.webservice.sql.DbConnection.initConn()\r\n" );
	  this.error = "Error loading JDBC driver from classpath [com.medlog.webservice.sql.DbConnection.initConn()]" + e.getMessage();
	  LOG.log( Level.SEVERE, error, e );

   }
   if ( DEBUG && openConnections > 0 ) {
	  LOG.warning( "You have opened a connection without closing previous connection. Open connections are bad! \r\nCall com.medlog.webservice.sql.DbConnection.close()" );
   }
   openConnections++;
   ret.append( "\r\n" ).append( "Open connections: " ).append( openConnections ).append( "\r\n" );
   return ret.toString();
}

@Override
public void close() {
   if ( dbconn != null ) {
	  try {
		 System.out.println( "com.medlog.webservice.sql.DbConnection.close()" );
		 if ( !dbconn.isClosed() ) {
			dbconn.close();
			if ( DEBUG ) {
			   LOG.info( "Connection Closed --com.medlog.webservice.sql.DbConnection.close()" );
			   openConnections--;
			   if ( openConnections > 0 ) {
				  LOG.warning( "There are unclosed connections. Oepn connections are bad! Call com.medlog.webservice.sql.DbConnection.close()" );
			   }
			}
		 }
	  } catch (Exception e) {
		 error = "Error closing connection in com.medlog.webservice.sql.DbConnection.close(): "
				 + e.getMessage();
		 LOG.warning( error );
		 LOG.log( Level.SEVERE, null, e );
		 e.printStackTrace();
	  } // catch
   } // if
   else {
	  error = "Null connection : com.medlog.webservice.sql.DbConnection.close()";
	  LOG.warning( error );
   }
}


@Override
public Connection getConnnection() {
   if (dbconn == null){
	  LOG.severe("com.medlog.webservice.sql.DbConnection.getConnnection() -- NULL CONNECTION");
   }
   return this.dbconn;
}

@Override
public String getError() {
   return this.error;
}

}
