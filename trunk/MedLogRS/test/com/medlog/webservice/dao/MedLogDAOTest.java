/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.dao;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.medlog.webservice.rest.*;
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
    MedLogDAO dao;
    PatientVO testPatient;
    int testNum = 0;
    int USER_ID = 2;

    public MedLogDAOTest() {
    }

    public int getTestNum() {
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
        PatientVO tmpPatient = PatientVO.builder().patientID(2).userName("dan").userPassword("asdf").build();
        dao = new MedLogDAO(db, tmpPatient);
        testPatient = dao.findPatientByPatientNameAndPassword("dan", "asdf");

    }

    @After
    public void tearDown() {
        db.close();
    }
//
//    @Test
//    public void testSomeMethod() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getDB method, of class MedLogDAO.
     */
    @Test
    public void testGetDB() {
        System.out.println("getDB");
        MedLogDAO instance = null;
        DbConnection expResult = this.db;
//        DbConnection result = instance.getDB();
        assertNotNull(expResult);
    }

    /**
     * Test of createDiary method, of class MedLogDAO.
     */
    @Test
    public void testCreateDiary() {
        System.out.println("GOOD createDiary");
        Type gt = new TypeToken<DiaryVO>() {
        }.getType();
        Gson g = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();

        String diary = "{"
                //			  + "\"id\":2,"
                + "\"title\":\"AAAAtest\",\"notes\":\"testNotes\""
                //			  + ",\"createdDate\":\"Oct 25, 2016\""
                + ",\"mood\":1,\"productivity\":9,\"patientID\":{\"patientID\":2,\"userName\":\"dan\",\"userPassword\":\"asdf\",\"firstName\":\"dan\",\"lastName\":\"kauffman\",\"addressStreet\":\"158 Edge\",\"addressCity\":\"BC\",\"addressState\":{\"stateID\":2,\"stateName\":\"Pennsylvania\",\"stateAbbreviation\":\"PA\"},\"dateJoined\":\"Oct 22, 2016\",\"userRole\":1}}";

        DiaryVO _vo = g.fromJson(diary, gt);

        MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID(2).userName("dan").userPassword("asdf").build());
//	  PatientVO pVO = instance.findPatientByID( USER_ID );
//	     instance = new MedLogDAO(db, pVO );
//System.out.println( "com.medlog.webservice.dao.MedLogDAOTest.testCreateDiary()" +new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson( pVO));	  
//	  instance.setUser( pVO );
        int result = instance.createDiary(_vo);
        _vo.setId(result);
        System.out.println("com.medlog.webservice.dao.MedLogDAOTest.testCreateDiary()" + new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(_vo));
        assertTrue(result > 0);
        // TODO review the generated test code and remove the default call to fail.
//	  fail( "The test case is a prototype." );
    }

    /**
     * Test of createPatient method, of class MedLogDAO.
     */
    @Test
    public void testCreatePatient() {
//        System.out.println("createPatient");
//        PatientVO _vo = null;
//        MedLogDAO instance = null;
//        int expResult = 0;
//        int result = instance.createPatient(_vo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePatient method, of class MedLogDAO.
     */
    @Test
    public void testDeletePatient() {
        System.out.println("deletePatient");
        PatientVO _vo = null;
        MedLogDAO instance = null;
        boolean expResult = false;
//        boolean result = instance.deletePatient(_vo);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllStates method, of class MedLogDAO.
     */
    @Test
    public void testFindAllStates() {
//        System.out.println("$ findAllStates");
//        MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID(2).userName("dan").userPassword("asdf").build());
//        ArrayList<StateVO> expResult = instance.findAllStates();
//        ArrayList<StateVO> result = instance.findAllStates();
//        assertNotNull("State list NULL", result);
//        assertEquals(expResult, result);

    }

    /**
     * Test of findDiaryByID method, of class MedLogDAO.
     */
    @Test
    public void testFindDiaryByID() {
        System.out.println("findDiaryByID");
        int _id = 1;
        MedLogDAO instance = null;
        int expResult = 1;
//        DiaryVO result = instance.findDiaryByID(_id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * (VALID)Test of findPatientByID method, of class MedLogDAO.
     */
    @Test
    public void testFindPatientByID() {
        System.out.println("findPatientByID");
        int _id = 2;
        MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID(2).userName("dan").userPassword("asdf").build());
//        PatientVO expResult = null;
        PatientVO result = instance.findPatientByName("dan");
//        System.out.println("com.medlog.webservice.dao.MedLogDAOTest.testFindPatientByID()\n" + result.toJSON());
//        assertEquals(2, result.getPatientID());
        // TODO review the generated test code and remove the default call to fail.
        // fail( "The test case is a prototype." );
    }

    /**
     * Test of findPatientByName method, of class MedLogDAO.
     */
    @Test
    public void testFindPatientByName() {
//        System.out.println("findPatientByName");
//        String _username = "";
//        MedLogDAO instance = null;
//        PatientVO expResult = null;
//        PatientVO result = instance.findPatientByName(_username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * (VALID) Test of findPatientByPatientNameAndPassword method, of class
     * MedLogDAO.
     */
    @Test
    public void testFindPatientByPatientNameAndPassword() {

        System.out.println("$ findPatientByPatientNameAndPassword");
        String _username = "dan";
        String _password = "asdf";
        MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID(2).userName("dan").userPassword("asdf").build());
        String expResStr = "{\"patientID\":2,\"userName\":\"dan\",\"userPassword\":\"asdf\",\"userHash\":null,\"firstName\":\"dan\",\"lastName\":\"kauffman\",\"phoneHome\":null,\"phoneMobile\":null,\"email\":null,\"status\":null,\"addressStreet\":\"158 Edge\",\"addressCity\":\"BC\",\"addressState\":{\"stateID\":2,\"stateName\":\"Pennsylvania\",\"stateAbbreviation\":\"PA\",\"patientList\":null},\"addressCountry\":null,\"addressPostalcode\":null,\"userPreferences\":null,\"pwdLastChanged\":null,\"lang\":null,\"timezoneId\":null,\"dateOfBirth\":null,\"dateJoined\":\"Oct 22, 2016\",\"picture\":null,\"metaData\":null,\"userRole\":1,\"diaryList\":null,\"medicationList\":null,\"primaryPhyssician\":null,\"healthcareProviderList\":null,\"tagList\":null}";
        PatientVO result = instance.findPatientByPatientNameAndPassword(_username, _password);
        assertEquals(2, result.getPatientID());
//        System.out.println("com.medlog.webservice.dao.MedLogDAOTest.testFindPatientByPatientNameAndPassword()" + result.toJSON());
//        assertEquals(expResStr, result.toJSON());
        // TODO review the generated test code and remove the default call to fail.
        //  fail( "The test case is a prototype." );
    }

    /**
     * Test of findStatesByKeyword method, of class MedLogDAO.
     */
    @Test
    public void testFindStatesByKeyword() {
//        System.out.println("findStatesByKeyword");
//        String _keyword = "";
//        MedLogDAO instance = null;
//        ArrayList<StateVO> expResult = null;
//        ArrayList<StateVO> result = instance.findStatesByKeyword(_keyword);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatients method, of class MedLogDAO.
     */
    @Test
    public void testGetPatients() {
        System.out.println("getPatients");
//        MedLogDAO instance = null;
//        ArrayList<PatientVO> expResult = null;
//        ArrayList<PatientVO> result = instance.getPatients();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDiary method, of class MedLogDAO.
     */
    @Test
    public void testUpdateDiary() {
//        System.out.println("updateDiary");
//        DiaryVO _vo = null;
//        MedLogDAO instance = null;
//        int expResult = 0;
//        boolean result = instance.updateDiary(_vo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePatient method, of class MedLogDAO.
     */
    @Test
    public void testUpdatePatient() {
        System.out.println("working updatePatient");

        MedLogDAO instance = null;
        PatientVO _vo = null;
        boolean expResult = false;
        String _username = "dan";
        String _password = "asdf";
        instance = new MedLogDAO(db, PatientVO.builder().patientID(2).userName("dan").userPassword("asdf").build());
        String expResStr = "{\"patientID\":2,\"userName\":\"dan\",\"userPassword\":\"asdf\",\"userHash\":null,\"firstName\":\"dan\",\"lastName\":\"Kauffman2\",\"phoneHome\":null,\"phoneMobile\":null,\"email\":null,\"status\":null,\"addressStreet\":\"158 Edge\",\"addressCity\":\"BC\",\"addressState\":{\"stateID\":2,\"stateName\":\"Pennsylvania\",\"stateAbbreviation\":\"PA\",\"patientList\":null},\"addressCountry\":null,\"addressPostalcode\":null,\"userPreferences\":null,\"pwdLastChanged\":null,\"lang\":null,\"timezoneId\":null,\"dateOfBirth\":null,\"dateJoined\":\"Oct 22, 2016\",\"picture\":null,\"metaData\":null,\"userRole\":1,\"diaryList\":null,\"medicationList\":null,\"primaryPhyssician\":null,\"healthcareProviderList\":null,\"tagList\":null}";
        _vo = instance.findPatientByPatientNameAndPassword(_username, _password);

        _vo.setLastName("Kauffman2");
        boolean result = instance.updatePatient(_vo);
        _vo = instance.findPatientByPatientNameAndPassword(_username, _password);
        assertTrue("Method returned false. ", result);
        assertEquals("Data didn't match", expResStr.substring(1, 20), _vo.toJSON().substring(1, 20));
        // TODO review the generated test code and remove the default call to fail.
//   fail( "The test case is a prototype." );
    }

    /**
     * Test of findDiaryByKeyword method, of class MedLogDAO.
     */
    @Test
    public void testFindDiaryByKeyword() {
//        System.out.println("findDiaryByKeyword");
//        String _keyword = "";
//        MedLogDAO instance = null;
//        ArrayList<DiaryVO> expResult = null;
//        ArrayList<DiaryVO> result = null; //instance.findDiaryByKeyword( _keyword );
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//	  fail( "The test case is a prototype." );
    }

    /**
     * Test of findDiaryByTag method, of class MedLogDAO.
     */
    @Test
    public void testFindDiaryByTag() {
//        System.out.println("findDiaryByTag");
//        TagVO _tag = null;
//        MedLogDAO instance = null;
//        ArrayList<DiaryVO> expResult = null;
//        ArrayList<DiaryVO> result = instance.findDiaryByTag(_tag);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     *
     * (Valid) Test of getCurrentUser method, of class MedLogDAO.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("$getCurrentUser");
        MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID(2).userName("dan").userPassword("asdf").build());
        PatientVO expResult = PatientVO.builder().patientID(2).userName("dan").userPassword("asdf").build();
        PatientVO result = instance.getCurrentUser();
        assertEquals(expResult.getPatientID(), result.getPatientID());

    }

    /**
     * Test of findMedicationByPatient method, of class MedLogDAO.
     */
    @Test
    public void testFindMedicationByPatient() {
        System.out.println("$$$$findMedicationByPatient");
        MedLogDAO instance = new MedLogDAO(db,testPatient);
//        ArrayList<MedicationVO> expResult = null;
        ArrayList<MedicationVO> result = instance.findMedicationByPatient();
        assertTrue(result != null);
        System.out.println("com.medlog.webservice.dao.MedLogDAOTest.testFindMedicationByPatient() Medications: " + new GsonBuilder()
                .serializeNulls().setPrettyPrinting().create().toJson(result) + "\n\n\n");
//        assertEquals(1, result.get(0).getMedicationID());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getRxMap method, of class MedLogDAO.
     */
    @Test
    public void testGetRxMap() {
//        System.out.println("getRxMap");
//        MedLogDAO instance = null;
//        Map<Integer, PharmaRxOtcVO> expResult = null;
//        Map<Integer, PharmaRxOtcVO> result = instance.getRxMap();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setRxMap method, of class MedLogDAO.
     */
    @Test
    public void testSetRxMap() {
//        System.out.println("setRxMap");
//        Map<Integer, PharmaRxOtcVO> rxMap = null;
//        MedLogDAO instance = null;
//        instance.setRxMap(rxMap);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    public void testPredictTone() {
        fail("this is a fail");
    }

    /**
     * Test of getSigMap method, of class MedLogDAO.
     */
    @Test
    public void testGetSigMap() {
//        System.out.println("getSigMap");
//        MedLogDAO instance = null;
//        Map<String, SigVO> expResult = null;
//        Map<String, SigVO> result = instance.getSigMap();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setSigMap method, of class MedLogDAO.
     */
    @Test
    public void testSetSigMap() {
//        System.out.println("setSigMap");
//        Map<String, SigVO> sigMap = null;
//        MedLogDAO instance = null;
//        instance.setSigMap(sigMap);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatesMap method, of class MedLogDAO.
     */
    @Test
    public void testGetStatesMap() {
        System.out.println("getStatesMap");
//        MedLogDAO instance = null;
//        Map<Integer, StateVO> expResult = null;
//        Map<Integer, StateVO> result = instance.getStatesMap();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatesMap method, of class MedLogDAO.
     */
    @Test
    public void testSetStatesMap() {
        System.out.println("setStatesMap");
//        Map<Integer, StateVO> statesMap = null;
//        MedLogDAO instance = null;
//        instance.setStatesMap(statesMap);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppContext method, of class MedLogDAO.
     */
    @Test
    public void testSetAppContext() {
//        System.out.println("setAppContext");
//        ApplicationBean app = null;
//        MedLogDAO instance = null;
//        instance.setAppContext(app);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of assignMedication method, of class MedLogDAO.
     */
    @Test
    public void testAssignMedication() {
        System.out.println("assignMedication");
        int id = new Random().nextInt(12) + 1;
        
        System.out.println("com.medlog.webservice.dao.MedLogDAOTest.testAssignMedication() rand pharmID " + id );
        PharmaRxOtcVO rx = PharmaRxOtcVO.builder().pharmID(id).fullName("").build();
        HealthcareProviderVO dr = HealthcareProviderVO.builder().physicianID((int)(Math.random() * 6+1)).lastName("Allison").firstName("John").build();

        MedicationVO _vo = MedicationVO.builder().patientID(testPatient).pharmID(rx).physicianID(dr).sig(SigVO.builder()
                .sigAbbrID("p.r.n.").build()).dosage((id % 20 + 1) +"ML").instructions("take it ").active(true).build();
        
        System.out.println("com.medlog.webservice.dao.MedLogDAOTest.testAssignMedication()" + _vo.toJSON());
        MedLogDAO instance = new MedLogDAO(db, testPatient);
//        int expResult = 0;
        int result = instance.assignMedication(_vo);

        assertTrue("HAS NEW ID", result > 0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createHealthcareProviderVO method, of class MedLogDAO.
     */
    @Test
    public void testCreateHealthcareProviderVO() {
//        System.out.println("createHealthcareProviderVO");
//        HealthcareProviderVO _vo = null;
//        MedLogDAO instance = null;
//        int expResult = 0;
//        int result = instance.createHealthcareProviderVO(_vo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createPharmaRxOtcVO method, of class MedLogDAO.
     */
    @Test
    public void testCreatePharmaRxOtcVO() {
        System.out.println("createPharmaRxOtcVO");
//        PharmaRxOtcVO _vo = PharmaRxOtcVO.builder().build();
//        MedLogDAO instance = null;
//        int expResult = 0;
//        int result = instance.createPharmaRxOtcVO(_vo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findMedTypesMap method, of class MedLogDAO.
     */
    @Test
    public void testFindMedTypesMap() {
//        System.out.println("findMedTypesMap");
//        MedLogDAO instance = null;
//        Map<String, MedTypeVO> expResult = null;
//        Map<String, MedTypeVO> result = instance.findMedTypesMap();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllSigs method, of class MedLogDAO.
     */
    @Test
    public void testFindAllSigs() {
//        System.out.println("findAllSigs");
//        boolean onlyTime = false;
//        MedLogDAO instance = null;
//        ArrayList<SigVO> expResult = null;
//        ArrayList<SigVO> result = instance.findAllSigs(onlyTime);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllSigsMap method, of class MedLogDAO.
     */
    @Test
    public void testFindAllSigsMap() {
        System.out.println("findAllSigsMap");
//        MedLogDAO instance = null;
//        Map<String, SigVO> expResult = null;
//        Map<String, SigVO> result = instance.findAllSigsMap();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllStates method, of class MedLogDAO.
     */
    @Test
    public void testFindAllStates_0args() {
//        System.out.println("findAllStates");
//        MedLogDAO instance = null;
//        ArrayList<StateVO> expResult = null;
//        ArrayList<StateVO> result = instance.findAllStates();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllStates method, of class MedLogDAO.
     */
    @Test
    public void testFindAllStates_boolean() {
//        System.out.println("findAllStates");
//        boolean mustuseSQL = false;
//        MedLogDAO instance = null;
//        Map<Integer, StateVO> expResult = null;
//        Map<Integer, StateVO> result = instance.findAllStates(mustuseSQL);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findDiaryByPatient method, of class MedLogDAO.
     */
    @Test
    public void testFindDiaryByPatient() {
//        System.out.println("findDiaryByPatient");
//        MedLogDAO instance = null;
//        ArrayList<DiaryVO> expResult = null;
//        ArrayList<DiaryVO> result = instance.findDiaryByPatient();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findHealthcareProviderID method, of class MedLogDAO.
     */
    @Test
    public void testFindHealthcareProviderID() {
//        System.out.println("findHealthcareProviderID");
//        int _id = 0;
//        MedLogDAO instance = null;
//        HealthcareProviderVO expResult = null;
//        HealthcareProviderVO result = instance.findHealthcareProviderID(_id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findHealthcareProviders method, of class MedLogDAO.
     */
    @Test
    public void testFindHealthcareProviders() {
//        System.out.println("findHealthcareProviders");
//        MedLogDAO instance = null;
//        ArrayList<HealthcareProviderVO> expResult = null;
//        ArrayList<HealthcareProviderVO> result = instance.findHealthcareProviders();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findHealthcareProvidersByKeyword method, of class MedLogDAO.
     */
    @Test
    public void testFindHealthcareProvidersByKeyword() {
//        System.out.println("findHealthcareProvidersByKeyword");
//        String _keyword = "";
//        boolean _onlyAssigned = false;
//        MedLogDAO instance = null;
//        ArrayList<HealthcareProviderVO> expResult = null;
//        ArrayList<HealthcareProviderVO> result = instance.findHealthcareProvidersByKeyword(_keyword, _onlyAssigned);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findHealthcareProvidersByPatient method, of class MedLogDAO.
     */
    @Test
    public void testFindHealthcareProvidersByPatient() {
//        System.out.println("findHealthcareProvidersByPatient");
//        MedLogDAO instance = null;
//        ArrayList<HealthcareProviderVO> expResult = null;
//        ArrayList<HealthcareProviderVO> result = instance.findHealthcareProvidersByPatient();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findPharmaRxOtcVO method, of class MedLogDAO.
     */
    @Test
    public void testFindPharmaRxOtcVO() {
        System.out.println("findPharmaRxOtcVO");
//        boolean _onlyAssigned = false;
//        MedLogDAO instance = null;
//        PharmaRxOtcVO expResult = null;
//        PharmaRxOtcVO result = instance.findPharmaRxOtcVO(_onlyAssigned);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findPharmaRxOtcVOByID method, of class MedLogDAO.
     */
    @Test
    public void testFindPharmaRxOtcVOByID() {
//        System.out.println("findPharmaRxOtcVOByID");
//        int _id = 0;
//        MedLogDAO instance = null;
//        PharmaRxOtcVO expResult = null;
//        PharmaRxOtcVO result = instance.findPharmaRxOtcVOByID(_id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findPharmaRxOtcVOByKeword method, of class MedLogDAO.
     */
    @Test
    public void testFindPharmaRxOtcVOByKeword_String_boolean() {
//        System.out.println("findPharmaRxOtcVOByKeword");
//        String _keyword = "";
//        boolean _onlyAssigned = false;
//        MedLogDAO instance = null;
//        ArrayList<PharmaRxOtcVO> expResult = null;
//        ArrayList<PharmaRxOtcVO> result = instance.findPharmaRxOtcVOByKeword(_keyword, _onlyAssigned);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findPharmaRxOtcVOByKeword method, of class MedLogDAO.
     */
    @Test
    public void testFindPharmaRxOtcVOByKeword_4args() {
//        System.out.println("findPharmaRxOtcVOByKeword");
//        String _keyword = "";
//        int pageNumber = 0;
//        int pageSize = 0;
//        boolean onlyAssigned = false;
//        MedLogDAO instance = null;
//        ArrayList<PharmaRxOtcVO> expResult = null;
//        ArrayList<PharmaRxOtcVO> result = instance.findPharmaRxOtcVOByKeword(_keyword, pageNumber, pageSize, onlyAssigned);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findPharmaMapRxOtcVOByKeword method, of class MedLogDAO.
     */
    @Test
    public void testFindPharmaMapRxOtcVOByKeword() {
//        System.out.println("findPharmaMapRxOtcVOByKeword");
//        String _keyword = "";
//        int _pageNumber = 0;
//        int _pageSize = 0;
//        boolean _onlyAssigned = false;
//        MedLogDAO instance = null;
//        Map<Integer, PharmaRxOtcVO> expResult = null;
//        Map<Integer, PharmaRxOtcVO> result = instance.findPharmaMapRxOtcVOByKeword(_keyword, _pageNumber, _pageSize, _onlyAssigned);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class MedLogDAO.
     */
    @Test
    public void testGetUser() {
//        System.out.println("getUser");
//        MedLogDAO instance = null;
//        PatientVO expResult = null;
//        PatientVO result = instance.getUser();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class MedLogDAO.
     */
    @Test
    public void testSetUser() {
//        System.out.println("setUser");
//        PatientVO user = null;
//        MedLogDAO instance = null;
//        instance.setUser(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of syncDiary method, of class MedLogDAO.
     */
    @Test
    public void testSyncDiary() {
//        System.out.println("syncDiary");
//        ArrayList<DiaryVO> _voList = null;
//        MedLogDAO instance = null;
//        int expResult = 0;
//        int result = instance.syncDiary(_voList);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of syncMedication method, of class MedLogDAO.
     */
    @Test
    public void testSyncMedication() {
        System.out.println("syncMedication");
//        ArrayList<MedicationVO> _voList = null;
//        MedLogDAO instance = null;
//        int expResult = 0;
//        int result = instance.syncMedication(_voList);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of unassignMedication method, of class MedLogDAO.
     */
    @Test
    public void testUnassignMedication() {
        System.out.println("unassignMedication");
//        MedicationVO _vo = null;
//        MedLogDAO instance = null;
//        boolean expResult = false;
//        boolean result = instance.unassignMedication(_vo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateHealthcareProviderVO method, of class MedLogDAO.
     */
    @Test
    public void testUpdateHealthcareProviderVO() {
//        System.out.println("updateHealthcareProviderVO");
//        HealthcareProviderVO _vo = null;
//        MedLogDAO instance = null;
//        boolean expResult = false;
//        boolean result = instance.updateHealthcareProviderVO(_vo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePharmaRxOtcVO method, of class MedLogDAO.
     */
    @Test
    public void testUpdatePharmaRxOtcVO() {
        System.out.println("updatePharmaRxOtcVO");
//        PharmaRxOtcVO _vo = null;
//        MedLogDAO instance = null;
//        boolean expResult = false;
//        boolean result = instance.updatePharmaRxOtcVO(_vo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findMedicationByID method, of class MedLogDAO.
     */
    @Test
    public void testFindMedicationByID() {
//        System.out.println("findMedicationByID");
//        int _id = 0;
//        MedLogDAO instance = null;
//        MedicationVO expResult = null;
//        MedicationVO result = instance.findMedicationByID(_id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findDiaryByPatientFull method, of class MedLogDAO.
     */
    @Test
    public void testFindDiaryByPatientFull() {
//        System.out.println("findDiaryByPatientFull");
//        MedLogDAO instance = null;
//        ArrayList<DiaryVO> expResult = null;
//        ArrayList<DiaryVO> result = instance.findDiaryByPatientFull();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findDiaryCrossTab method, of class MedLogDAO.
     */
    @Test
    public void testFindDiaryCrossTab() {
//        System.out.println("findDiaryCrossTab");
//        int patientid = 0;
//
//        MedLogDAO instance = new MedLogDAO(db, PatientVO.builder().patientID(2).userName("dan").userPassword("asdf").build());
//        ArrayList<DiaryAnalysisVO> expResult = null;
//        ArrayList<DiaryAnalysisVO> result = instance.findDiaryCrossTab(patientid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
