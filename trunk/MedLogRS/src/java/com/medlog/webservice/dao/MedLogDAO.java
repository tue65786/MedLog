/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.medlog.webservice.dao;

import com.medlog.webservice.vo.*;
import java.util.*;
import java.util.logging.*;

/**
 * Implementation of {@linkplain IMedLogDAO}
 * @author (c)2016
 */
public class MedLogDAO implements IMedLogDAO{

   private static final Logger LOG = Logger.getLogger( MedLogDAO.class.getName() );

   @Override
   public int createDiary(DiaryVO _vo) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public int createPatient(PatientVO _vo) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public boolean deletePatient(PatientVO _vo) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public ArrayList<StateVO> findAllStates() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public int findDiaryByID(int _id) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public ArrayList<DiaryVO> findDiaryByPatient(PatientVO _vo) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public ArrayList<DiaryVO> findDiaryByPatientAndKeyword(PatientVO _vo, String _keyword) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public ArrayList<DiaryVO> findDiaryByPatientAndTag(PatientVO _vo, TagVO _tag) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public PatientVO findPatientByID(int _id) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public PatientVO findPatientByName(String _username) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public PatientVO findPatientByPatientNameAndPassword(String _username, String _password) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public ArrayList<PatientVO> getPatients() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public int updateDiary(DiaryVO _vo) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public boolean updatePatient(PatientVO _vo) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

}
