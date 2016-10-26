/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.dao;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.medlog.webservice.sql.*;
import com.medlog.webservice.vo.*;
import java.lang.reflect.*;
import java.util.*;
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
public class MedLogDAOTest {
DbConnection db;
int testNum = 0;
int USER_ID= 2;
public MedLogDAOTest() {
}
public int getTestNum(){
   return ++testNum;
}
@BeforeClass
public static void setUpClass() {
}

@AfterClass
public static void tearDownClass() {
}

@Before
public void setUp() {
   db = new DbConnection();
   
}

@After
public void tearDown() {
   db.close();
}

   @Test
   public void testSomeMethod() {
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of getDB method, of class MedLogDAO.
    */
   @Test
   public void testGetDB() {
	  System.out.println( "getDB" );
	  MedLogDAO instance = null;
	  DbConnection expResult = null;
	  DbConnection result = instance.getDB();
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of createDiary method, of class MedLogDAO.
    */
   @Test
   public void testCreateDiary() {
	  System.out.println( "GOOD createDiary" );
	  Type gt = new TypeToken<DiaryVO>(){}.getType();
	  Gson g = new GsonBuilder().setDateFormat( "MMM dd, yyyy").create();
	  
	  String diary = "{"
//			  + "\"id\":2,"
			  + "\"title\":\"AAAAtest\",\"notes\":\"testNotes\""
//			  + ",\"createdDate\":\"Oct 25, 2016\""
			  + ",\"mood\":1,\"productivity\":9,\"patientID\":{\"patientID\":2,\"userName\":\"dan\",\"userPassword\":\"asdf\",\"firstName\":\"dan\",\"lastName\":\"kauffman\",\"addressStreet\":\"158 Edge\",\"addressCity\":\"BC\",\"addressState\":{\"stateID\":2,\"stateName\":\"Pennsylvania\",\"stateAbbreviation\":\"PA\"},\"dateJoined\":\"Oct 22, 2016\",\"userRole\":1}}";
	  
	  DiaryVO _vo = g.fromJson( diary, gt );
	  
	  MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID( 2).userName( "dan").userPassword( "asdf").build() );
//	  PatientVO pVO = instance.findPatientByID( USER_ID );
//	     instance = new MedLogDAO(db, pVO );
//System.out.println( "com.medlog.webservice.dao.MedLogDAOTest.testCreateDiary()" +new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson( pVO));	  
//	  instance.setUser( pVO );
	  int result = instance.createDiary( _vo );
	  _vo.setId( result );
	  System.out.println( "com.medlog.webservice.dao.MedLogDAOTest.testCreateDiary()" +new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson( _vo));
	  assertTrue(result > 0 );
	  // TODO review the generated test code and remove the default call to fail.
//	  fail( "The test case is a prototype." );
   }

   /**
    * Test of createPatient method, of class MedLogDAO.
    */
   @Test
   public void testCreatePatient() {
	  System.out.println( "createPatient" );
	  PatientVO _vo = null;
	  MedLogDAO instance = null;
	  int expResult = 0;
	  int result = instance.createPatient( _vo );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of deletePatient method, of class MedLogDAO.
    */
   @Test
   public void testDeletePatient() {
	  System.out.println( "deletePatient" );
	  PatientVO _vo = null;
	  MedLogDAO instance = null;
	  boolean expResult = false;
	  boolean result = instance.deletePatient( _vo );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of findAllStates method, of class MedLogDAO.
    */
   @Test
   public void testFindAllStates() {
	  System.out.println( "$ findAllStates" );
	  MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID( 2).userName( "dan").userPassword( "asdf").build() );
	  ArrayList<StateVO> expResult = instance.findAllStates();
	  ArrayList<StateVO> result = instance.findAllStates();
	  assertNotNull( "State list NULL",result );
	  assertEquals( expResult, result );

   }

   /**
    * Test of findDiaryByID method, of class MedLogDAO.
    */
   @Test
   public void testFindDiaryByID() {
	  System.out.println( "findDiaryByID" );
	  int _id = 0;
	  MedLogDAO instance = null;
	  int expResult = 0;
	  DiaryVO result = instance.findDiaryByID( _id );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * (VALID)Test of findPatientByID method, of class MedLogDAO.
    */
   @Test
   public void testFindPatientByID() {
	  System.out.println( "findPatientByID" );
	  int _id = 2;
	  MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID( 2).userName( "dan").userPassword( "asdf").build() );
	  PatientVO expResult = null;
	  PatientVO result = instance.findPatientByID( _id );
	  System.out.println( "com.medlog.webservice.dao.MedLogDAOTest.testFindPatientByID()\n" + result.toJSON() );
	  assertEquals( 2, result.getPatientID() );
	  // TODO review the generated test code and remove the default call to fail.
	 // fail( "The test case is a prototype." );
   }

   /**
    * Test of findPatientByName method, of class MedLogDAO.
    */
   @Test
   public void testFindPatientByName() {
	  System.out.println( "findPatientByName" );
	  String _username = "";
	  MedLogDAO instance = null;
	  PatientVO expResult = null;
	  PatientVO result = instance.findPatientByName( _username );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * (VALID) Test of findPatientByPatientNameAndPassword method, of class MedLogDAO.
    */
   @Test
   public void testFindPatientByPatientNameAndPassword() {
	
	  System.out.println( "$ findPatientByPatientNameAndPassword" );
	  String _username = "dan";
	  String _password = "asdf";
	  MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID( 2).userName( "dan").userPassword( "asdf").build() );
	  String expResStr = "{\"patientID\":2,\"userName\":\"dan\",\"userPassword\":\"asdf\",\"userHash\":null,\"firstName\":\"dan\",\"lastName\":\"kauffman\",\"phoneHome\":null,\"phoneMobile\":null,\"email\":null,\"status\":null,\"addressStreet\":\"158 Edge\",\"addressCity\":\"BC\",\"addressState\":{\"stateID\":2,\"stateName\":\"Pennsylvania\",\"stateAbbreviation\":\"PA\",\"patientList\":null},\"addressCountry\":null,\"addressPostalcode\":null,\"userPreferences\":null,\"pwdLastChanged\":null,\"lang\":null,\"timezoneId\":null,\"dateOfBirth\":null,\"dateJoined\":\"Oct 22, 2016\",\"picture\":null,\"metaData\":null,\"userRole\":1,\"diaryList\":null,\"medicationList\":null,\"primaryPhyssician\":null,\"healthcareProviderList\":null,\"tagList\":null}";
	  PatientVO result = instance.findPatientByPatientNameAndPassword( _username, _password );
	  assertEquals( 2, result.getPatientID() );
	  System.out.println( "com.medlog.webservice.dao.MedLogDAOTest.testFindPatientByPatientNameAndPassword()" + result.toJSON());
	  assertEquals( expResStr, result.toJSON());
	  // TODO review the generated test code and remove the default call to fail.
	//  fail( "The test case is a prototype." );
   }

   /**
    * Test of findStatesByKeyword method, of class MedLogDAO.
    */
   @Test
   public void testFindStatesByKeyword() {
	  System.out.println( "findStatesByKeyword" );
	  String _keyword = "";
	  MedLogDAO instance = null;
	  ArrayList<StateVO> expResult = null;
	  ArrayList<StateVO> result = instance.findStatesByKeyword( _keyword );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of getPatients method, of class MedLogDAO.
    */
   @Test
   public void testGetPatients() {
	  System.out.println( "getPatients" );
	  MedLogDAO instance = null;
	  ArrayList<PatientVO> expResult = null;
	  ArrayList<PatientVO> result = instance.getPatients();
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of updateDiary method, of class MedLogDAO.
    */
   @Test
   public void testUpdateDiary() {
	  System.out.println( "updateDiary" );
	  DiaryVO _vo = null;
	  MedLogDAO instance = null;
	  int expResult = 0;
	  int result = instance.updateDiary( _vo );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of updatePatient method, of class MedLogDAO.
    */
   @Test
   public void testUpdatePatient() {
	  System.out.println( "updatePatient" );
	  PatientVO _vo = null;
	  MedLogDAO instance = null;
	  boolean expResult = false;
	  boolean result = instance.updatePatient( _vo );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of findDiaryByKeyword method, of class MedLogDAO.
    */
   @Test
   public void testFindDiaryByKeyword() {
	  System.out.println( "findDiaryByKeyword" );
	  String _keyword = "";
	  MedLogDAO instance = null;
	  ArrayList<DiaryVO> expResult = null;
	  ArrayList<DiaryVO> result =  null; //instance.findDiaryByKeyword( _keyword );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
//	  fail( "The test case is a prototype." );
   }

   /**
    * Test of findDiaryByTag method, of class MedLogDAO.
    */
   @Test
   public void testFindDiaryByTag() {
	  System.out.println( "findDiaryByTag" );
	  TagVO _tag = null;
	  MedLogDAO instance = null;
	  ArrayList<DiaryVO> expResult = null;
	  ArrayList<DiaryVO> result = instance.findDiaryByTag( _tag );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * 
	* (Valid) Test of getCurrentUser method, of class MedLogDAO.
    */
   @Test
   public void testGetCurrentUser() {
	  System.out.println( "$getCurrentUser" );
	  MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID( 2).userName( "dan").userPassword( "asdf").build() );
	  PatientVO expResult =  PatientVO.builder().patientID( 2).userName( "dan").userPassword( "asdf").build() ;
	  PatientVO result = instance.getCurrentUser();
	  assertEquals( expResult.getPatientID(), result.getPatientID() );
	  
	  
   }

}
