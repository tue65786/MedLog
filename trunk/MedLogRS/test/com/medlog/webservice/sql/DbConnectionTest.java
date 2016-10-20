/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.sql;

import com.medlog.webservice.util.*;
import java.sql.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class DbConnectionTest {

public DbConnectionTest() {
}

@BeforeClass
public static void setUpClass() {
}

@AfterClass
public static void tearDownClass() {
}

@Before
public void setUp() {
}

@After
public void tearDown() {
}

   /**
    * Test of getConnectionStringFromProps method, of class DbConnection.
    */
   @Test
   public void testGetConnectionStringFromProps() {
	  System.out.println( "getConnectionStringFromProps" );
	  DbConnection instance = new DbConnection();
	  String expResult = "";
	  String result = instance.getConnectionStringFromProps();
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of close method, of class DbConnection.
    */
   @Test
   public void testClose_0args() {
	  System.out.println( "close" );
	  DbConnection instance = new DbConnection();
	  instance.close();
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of close method, of class DbConnection.
    */
   @Test
   public void testClose_CallableStatement() {
	  System.out.println( "close" );
	  CallableStatement _cs = null;
	  DbConnection instance = new DbConnection();
	  DbUtl.close( _cs );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of close method, of class DbConnection.
    */
   @Test
   public void testClose_ResultSet() {
	  System.out.println( "close" );
	  ResultSet _rs = null;
	  DbConnection instance = new DbConnection();
	  DbUtl.close( _rs );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of getConnnection method, of class DbConnection.
    */
   @Test
   public void testGetConnnection() {
	  System.out.println( "getConnnection" );
	  DbConnection instance = new DbConnection();
	  Connection expResult = null;
	  Connection result = instance.getConnnection();
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of getError method, of class DbConnection.
    */
   @Test
   public void testGetError() {
	  System.out.println( "getError" );
	  DbConnection instance = new DbConnection();
	  String expResult = "";
	  String result = instance.getError();
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

}
