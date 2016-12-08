/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import com.medlog.webservice.dao.MedLogDAO;
import com.medlog.webservice.sql.DbConnection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author westy
 */
public class DiaryAnalysisSummaryVOTest {
    DbConnection db;
    public DiaryAnalysisSummaryVOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    db =new DbConnection();
    }
    
    @After
    public void tearDown() {
        db.close();
    }

    /**
     * Test of runIt method, of class DiaryAnalysisSummaryVO.
     */
    @Test
    public void testRunIt() {
        System.out.println("runIt");
        
        MedLogDAO dao = new MedLogDAO(db, PatientVO.builder().userName("dan").userPassword("asdf").patientID(2).build());
        
        ArrayList<DiaryAnalysisVO> vl = dao.findDiaryCrossTab(2);
        DiaryAnalysisSummaryVO instance = new DiaryAnalysisSummaryVO();
        instance.runIt(vl);
        // TODO review the generated test code and remove the default call to fail.
    
    }
    
}
