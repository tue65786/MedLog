/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.dao;

import static com.medlog.webservice.CONST.DB_STRINGS.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.sql.*;
import com.medlog.webservice.vo.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 * Implementation of {@linkplain IMedLogDAO}
 *
 * @author (c)2016
 */
public class MedLogDAO implements IMedLogDAO {

/**
 * Connection wrapper getter
 *
 * @return the connection wrapper
 */
@Override
public DbConnection getDB() {
   if ( db == null ) {
	  throw new NullPointerException( "Null Connection in com.medlog.webservice.dao.MedLogDAO.getDB() " );
   }
   return db;
}
private  DbConnection db = null;
private final PatientVO user = null;
public MedLogDAO(DbConnection db) {
   this.db = db;
}
private static final Logger LOG = Logger.getLogger( MedLogDAO.class.getName() );

@Override
public int createDiary(DiaryVO _vo) {
   CallableStatement cs = null;
   try {
	  cs = db.getConnnection().prepareCall( SP_DIARY_INSERT);
	  if (_vo.title != null){
	  cs.setString(1,_vo.title);
	  }else{
		 cs.setNull( 1, java.sql.Types.NVARCHAR);
	  }
	  if (_vo.notes != null){
	  cs.setString(2,_vo.notes);
	  }else{
		 cs.setNull( 2, java.sql.Types.NVARCHAR);
	  }
	  
	  cs.setNull(3,java.sql.Types.NVARCHAR);
	 
	  
	  //3..10
	  cs.registerOutParameter( 11, java.sql.Types.INTEGER);
	  cs.executeUpdate();
	  int returnVal = cs.getInt( 11);
	  
	  return returnVal;
	  
   } catch (SQLException ex) {
	  Logger.getLogger( MedLogDAO.class.getName() ).log( Level.SEVERE, null, ex );
	  return DB_ERROR_CODE;
   }
   
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
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public ArrayList<DiaryVO> findDiaryByPatient(PatientVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public ArrayList<DiaryVO> findDiaryByPatientAndKeyword(PatientVO _vo, String _keyword) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public ArrayList<DiaryVO> findDiaryByPatientAndTag(PatientVO _vo, TagVO _tag) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public PatientVO findPatientByID(int _id) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public PatientVO findPatientByName(String _username) {
   throw new UnsupportedOperationException( "Not supported yet." );
   
}

@Override
public PatientVO findPatientByPatientNameAndPassword(String _username, String _password) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public ArrayList<StateVO> findStatesByKeyword(String _keyword) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public ArrayList<PatientVO> getPatients() {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public int updateDiary(DiaryVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public boolean updatePatient(PatientVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

}
