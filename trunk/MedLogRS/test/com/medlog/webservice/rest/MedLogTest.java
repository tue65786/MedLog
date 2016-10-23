/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import com.meterware.httpunit.*;
import com.meterware.servletunit.*;
import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class MedLogTest {

public MedLogTest() {
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
 * Test of getServletInfo method, of class MedLog.
 */
@Test
public void testGetServletInfo() {
   System.out.println( "getServletInfo" );
   MedLog instance = new MedLog();
   String expResult = "";
   String result = instance.getServletInfo();
   assertEquals( instance.getServletInfo(), result );
   // TODO review the generated test code and remove the default call to fail.
  // fail( "The test case is a prototype." );
}

@Test
public void testOne() throws IOException, SAXException {
   ServletRunner sr = new ServletRunner();
   sr.registerServlet( "myServlet", MedLog.class.getName() );
   ServletUnitClient sc = sr.newClient();
   
   WebRequest request = new PostMethodWebRequest( "http://108.161.127.42/MedLogRS/" );
   request.setParameter( "fn", "login" );
   request.setParameter( "username", "dan" );
   request.setParameter( "password", "asdfasdf" );
   InvocationContext ic = sc.newInvocation( request );
   
   WebResponse response =ic.getServletResponse();// sc.getResponse( request );
  
   System.out.println( "com.medlog.webservice.rest.MedLogTest.testOne()" + response.getText() );
   System.out.println( "type:"+ response.getContentType() );
   assertNotNull( "No response received", response );
   
//   assertEquals( "content type", "text/plain", response.getContentType() );
//   assertEquals( "requested resource", "You selected red", response.getText() );
}

}
