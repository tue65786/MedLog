/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.dao;

import com.medlog.webservice.sql.*;
import com.medlog.webservice.vo.*;
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
public MedLogDAOTest() {
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
	  System.out.println( "createDiary" );
	  DiaryVO _vo = null;
	  MedLogDAO instance = null;
	  int expResult = 0;
	  int result = instance.createDiary( _vo );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
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
	  System.out.println( "findAllStates" );
	  MedLogDAO instance = null;
	  ArrayList<StateVO> expResult = null;
	  ArrayList<StateVO> result = instance.findAllStates();
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
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
	  int result = instance.findDiaryByID( _id );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of findDiaryByPatient method, of class MedLogDAO.
    */
   @Test
   public void testFindDiaryByPatient() {
	  System.out.println( "findDiaryByPatient" );
	  PatientVO _vo = null;
	  MedLogDAO instance = null;
	  ArrayList<DiaryVO> expResult = null;
	  ArrayList<DiaryVO> result = instance.findDiaryByPatient( _vo );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of findDiaryByPatientAndKeyword method, of class MedLogDAO.
    */
   @Test
   public void testFindDiaryByPatientAndKeyword() {
	  System.out.println( "findDiaryByPatientAndKeyword" );
	  PatientVO _vo = null;
	  String _keyword = "";
	  MedLogDAO instance = null;
	  ArrayList<DiaryVO> expResult = null;
	  ArrayList<DiaryVO> result = instance.findDiaryByPatientAndKeyword( _vo, _keyword );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of findDiaryByPatientAndTag method, of class MedLogDAO.
    */
   @Test
   public void testFindDiaryByPatientAndTag() {
	  System.out.println( "findDiaryByPatientAndTag" );
	  PatientVO _vo = null;
	  TagVO _tag = null;
	  MedLogDAO instance = null;
	  ArrayList<DiaryVO> expResult = null;
	  ArrayList<DiaryVO> result = instance.findDiaryByPatientAndTag( _vo, _tag );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
   }

   /**
    * Test of findPatientByID method, of class MedLogDAO.
    */
   @Test
   public void testFindPatientByID() {
	  System.out.println( "findPatientByID" );
	  int _id = 0;
	  MedLogDAO instance = null;
	  PatientVO expResult = null;
	  PatientVO result = instance.findPatientByID( _id );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
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
    * Test of findPatientByPatientNameAndPassword method, of class MedLogDAO.
    */
   @Test
   public void testFindPatientByPatientNameAndPassword() {
	  System.out.println( "findPatientByPatientNameAndPassword" );
	  String _username = "";
	  String _password = "";
	  MedLogDAO instance = null;
	  PatientVO expResult = null;
	  PatientVO result = instance.findPatientByPatientNameAndPassword( _username, _password );
	  assertEquals( expResult, result );
	  // TODO review the generated test code and remove the default call to fail.
	  fail( "The test case is a prototype." );
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

}
