/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.dao;

import static com.medlog.webservice.CONST.API_ACTIONS.*;
import static com.medlog.webservice.CONST.DB_STRINGS.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.sql.*;
import com.medlog.webservice.util.*;
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

@Override
public ArrayList<DiaryVO> findDiaryByKeyword(String _keyword) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ArrayList<DiaryVO> findDiaryByPatient() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ArrayList<DiaryVO> findDiaryByTag(TagVO _tag) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public PatientVO getCurrentUser() {
   try {
	  if ( user != null && user.getPatientID() > 0 && user.getUserName() != null ) {
		 loggedIn = true;
	  }
   } catch (Exception e) {

   }
   return user;
}

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
private final DbConnection db;
private final PatientVO user;
private boolean loggedIn;
private boolean stateOK;
private String errorMessage;

public MedLogDAO(DbConnection db, PatientVO u) {
   this.db = db;
   this.user = u;
   stateOK = true;
   errorMessage = "";
}
private static final Logger LOG = Logger.getLogger( MedLogDAO.class.getName() );

@Override
public int createDiary(DiaryVO _vo) {
   CallableStatement cs = null;
   try {
	  cs = db.getConnnection().prepareCall( SP_DIARY_INSERT );
	  if ( _vo.title != null ) {
		 cs.setString( 1, _vo.title );
	  } else {
		 cs.setNull( 1, java.sql.Types.NVARCHAR );
	  }
	  if ( _vo.notes != null ) {
		 cs.setString( 2, _vo.notes );
	  } else {
		 cs.setNull( 2, java.sql.Types.NVARCHAR );
	  }

	  cs.setNull( 3, java.sql.Types.NVARCHAR );

	  //3..10
	  cs.registerOutParameter( 11, java.sql.Types.INTEGER );
	  cs.executeUpdate();
	  int returnVal = cs.getInt( 11 );

	  return returnVal;

   } catch (SQLException ex) {
	  Logger.getLogger( MedLogDAO.class.getName() ).log( Level.SEVERE, null, ex );
	  return DB_ERROR_CODE;
   }

}

@Override
public int createPatient(PatientVO _vo) {
   //REMOVE INVALID HTML
   CallableStatement cs = null;
   int newID = DB_ERROR_CODE;
   if ( _vo.isValid( INSERT ) ) {
	  try {
		 cs = db.getConnnection().prepareCall( SP_PATIENT_INSERT );

		 cs.setString(1, _vo.getUserName());
		 cs.setString(2, _vo.getUserPassword());
		 cs.setNull( 3, java.sql.Types.NVARCHAR );
		 cs.setString(4, _vo.getFirstName());
		 cs.setString(5, _vo.getLastName());
		 cs.setString(6, _vo.getPhoneHome());
		 cs.setString(7, _vo.getPhoneMobile());
		 cs.setString(8, _vo.getEmail());
//		 cs.setString( PROPS_FILE, PROPS_FILE );
		 cs.setNull( 9, java.sql.Types.NVARCHAR ); //status
		 cs.setString(10, _vo.getAddressStreet());
		 cs.setString(11, _vo.getAddressCity());
		 cs.setInt( 12, _vo.getAddressState().getStateID() );//CHECK FOR VALID STATE
		 cs.setString(13, _vo.getAddressCountry());
		 cs.setString(14, _vo.getAddressPostalcode());
		 cs.setString(15, _vo.getUserPreferences());
		 cs.setNull( 16, java.sql.Types.DATE );//Password last changed
		 cs.setNull( 17, java.sql.Types.NVARCHAR );//Lang
		 cs.setNull( 18, java.sql.Types.DATE );//Timezone
		 cs.setNull( 19, java.sql.Types.INTEGER );//Physician
		 try {
			cs.setDate( 20, (java.sql.Date) _vo.getDateOfBirth() );
		 } catch (Exception e) {
			cs.setNull( 20, java.sql.Types.DATE );//Date Joined	
		 }
		 cs.setNull( 21, java.sql.Types.DATE );//Date Joined
		 cs.setNull( 22, java.sql.Types.NVARCHAR );//Picture
		 cs.setNull( 23, java.sql.Types.SQLXML );//metadata
		 cs.setInt(24, _vo.getUserRole());

		 cs.registerOutParameter( 25, java.sql.Types.INTEGER );
		 int rows = cs.executeUpdate();
		 newID = cs.getInt( 25 );
	  } catch (SQLException ex) {
		 if ( DEBUG ) {
			System.err.println( "com.medlog.webservice.dao.MedLogDAO.createPatient()\n" + DbUtl.printJDBCExceptionMsg( ex ) );
		 }
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createPatient()", "SQLEx", ex );
	  } catch (NullPointerException npe) {
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createPatient()", "Null Pointer", npe );
	  }
   }
   return newID;
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

/**
 * Handle patient lookup for login etal
 *
 * @param _id
 * @param _username
 * @param _password
 * @return
 */
private ArrayList<PatientVO> findPatient(int _id, String _username, String _password) {
   _username = StrUtl.toS( _username );
   _password = StrUtl.toS( _password );
   ArrayList<PatientVO> voList = new ArrayList<PatientVO>();
   CallableStatement cs = null;
   ResultSet rs = null;
   boolean valid = false;
   try {
	  cs = db.getConnnection().prepareCall( SP_PATIENT_SELECT );
	  if ( _id > 0 ) {
		 cs.setInt( 1, _id );
		 valid = true;
	  } else {
		 cs.setNull( 1, java.sql.Types.INTEGER );
	  }
	  if ( _username.isEmpty() ) {
		 cs.setNull( 2, java.sql.Types.NVARCHAR );
	  } else {
		 valid = true;
		 cs.setString( 2, _username );
		 if ( _password.isEmpty() ) {
			cs.setNull( 3, java.sql.Types.NVARCHAR );
		 } else {
			cs.setString( 3, _password );
		 }
	  }
	  if ( valid ) {
		 rs = cs.executeQuery();
		 while ( rs.next() ) {
			voList.add( PatientVO.builder()
					.patientID( rs.getInt( 1 ) )
					.userName( rs.getString( 2 ) )
					.userPassword( rs.getString( 3 ) )
					.firstName( rs.getString( 4 ) )
					.lastName( rs.getString( 5 ) )
					.phoneHome( rs.getString( 6 ) )
					.phoneMobile( rs.getString( 7 ) )
					.build() );

		 }
	  } else {
		 this.stateOK = false;
		 this.errorMessage = "com.medlog.webservice.dao.MedLogDAO.findPatient() - Invalid Params: Username is required";
		 if ( DEBUG ) {
			LOG.severe( this.errorMessage );
		 }
	  }
   } catch (SQLException ex) {
	  LOG.log( Level.SEVERE, null, ex );
   } finally {
	  DbUtl.close( rs );
	  DbUtl.close( cs );
   }
   return voList;
}

@Override
public PatientVO findPatientByID(int _id) {
   ArrayList<PatientVO> voList = findPatient( _id, null, null );
   if ( voList != null && !voList.isEmpty() ) {
	  if ( DEBUG && voList.size() > 1 ) {
		 
		 LOG.warning( "com.medlog.webservice.dao.MedLogDAO.findPatientByID()\n--Find by ID Returned Multiple VALUES -- something is wrong!" );
	  }
	  return voList.get( 0 );
   } else {
	  return null;
   }
}

@Override
public PatientVO findPatientByName(String _username) {
 ArrayList<PatientVO> voList = findPatient( 0, _username, null );
  if ( voList != null && !voList.isEmpty() ) {
	  if ( DEBUG && voList.size() > 1 ) {
		 
		 LOG.warning( "com.medlog.webservice.dao.MedLogDAO.findPatientByName()\n--- Returned Multiple VALUES -- something is wrong!" );
	  }
	  return voList.get( 0 );
   } else {
	  return null;
   }
}

@Override
public PatientVO findPatientByPatientNameAndPassword(String _username, String _password) {
   ArrayList<PatientVO> voList = findPatient( 0, _username, _password );
 if ( voList != null && !voList.isEmpty() ) {
	  if ( DEBUG && voList.size() > 1 ) {	 
		 LOG.warning( "com.medlog.webservice.dao.MedLogDAO.findPatientByPatientNameAndPassword()\n---Returned Multiple VALUES -- something is wrong!" );
	  }
	  return voList.get( 0 );
   } else {
	  return null;
   }
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
