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
import java.util.concurrent.*;
import java.util.logging.*;

/**
 * Implementation of {@linkplain IMedLogDAO}
 *
 * @author (c)2016
 */
public class MedLogDAO implements IMedLogDAO {

private static final Logger LOG = Logger.getLogger( MedLogDAO.class.getName() );
private static Map<Integer, StateVO> statesList;

/**
 *
 * @param db
 * @param u
 */
public MedLogDAO(DbConnection db, PatientVO u) {
   this.db = db;
   this.user = u;
   stateOK = true;
   errorMessage = "";
   try {
	  if ( u != null && u.getPatientID() != -2 ) {
		 findAllStates();
	  }
   } catch (Exception eeee) {
   }
}


@Override
public int assignMedication(MedicationVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public int createDiary(DiaryVO _vo) {
   CallableStatement cs = null;
   int newID = DB_ERROR_CODE;
   try {
	  if ( _vo != null && _vo.getPatientID() == null && getCurrentUser() != null ) {
		 _vo.setPatientID( getCurrentUser() );
	  }
   } catch (Exception e) {
	  if ( DEBUG ) {
		 LOG.log( Level.SEVERE, "Error setting user", e );
		 e.printStackTrace();
	  }
   }
   if ( _vo.isValid( INSERT ) ) {
	  try {
		 cs = db.getConnnection().prepareCall( SP_DIARY_INSERT );
		 cs.setInt( 1, getCurrentUser().getPatientID() );

		 if ( _vo.getTitle() != null ) {
			cs.setString( 2, _vo.getTitle() );
		 } else {
			cs.setNull( 2, java.sql.Types.NVARCHAR );
		 }
//		 if ( _vo.notes != null ) {
		 cs.setString( 3, StrUtl.removeHtmlMarkups( _vo.getNotes() ) );
//		 } else {
//			cs.setNull( 3, java.sql.Types.NVARCHAR );
//		 }
		 if ( _vo.getNotesActivity().isEmpty() ) {
			cs.setNull( 4, java.sql.Types.NVARCHAR );
		 } else {
			cs.setString( 4, StrUtl.removeHtmlMarkups( _vo.getNotesActivity() ) );
		 }
		 cs.setNull( 5, java.sql.Types.DATE );
		 cs.setNull( 6, java.sql.Types.DATE );
		 cs.setNull( 7, java.sql.Types.NCHAR );
		 cs.setNull( 8, java.sql.Types.NVARCHAR );
		 cs.setInt( 9, _vo.getMood() );
		 cs.setInt( 10, _vo.getProductivity() );
		 cs.registerOutParameter( 11, java.sql.Types.INTEGER );
		 cs.executeUpdate();
		 newID = cs.getInt( 11 );

	  } catch (SQLException ex) {
		 if ( DEBUG ) {
			System.err.println( "com.medlog.webservice.dao.MedLogDAO.createDiary()\n" + DbUtl.printJDBCExceptionMsg( ex ) );
		 }
		 this.stateOK = false;
		 this.errorMessage = ex.getMessage();
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createDiary()", "SQLEx", ex );

	  } catch (NullPointerException npe) {
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createDiary()", "Null Pointer", npe );
		 this.stateOK = false;
		 this.errorMessage = npe.getMessage();
	  } finally {
		 DbUtl.close( cs );
	  }
   } else {
	  if ( DEBUG ) {
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createDiary()", "INVALID Parmas" );
	  }
	  this.stateOK = false;
	  this.errorMessage = "createDiary, invalid params.";

   }
   return newID;
}

@Override
public int createHealthcareProviderVO(HealthcareProviderVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public int createPatient(PatientVO _vo) {
   //REMOVE INVALID HTML
   CallableStatement cs = null;
   int newID = DB_ERROR_CODE;
   if ( _vo.isValid( INSERT ) ) {
	  try {
		 cs = db.getConnnection().prepareCall( SP_PATIENT_INSERT );

		 cs.setString( 1, _vo.getUserName() );
		 cs.setString( 2, _vo.getUserPassword() );
		 cs.setNull( 3, java.sql.Types.NVARCHAR );
		 cs.setString( 4, _vo.getFirstName() );
		 cs.setString( 5, _vo.getLastName() );
		 cs.setString( 6, _vo.getPhoneHome() );
		 cs.setString( 7, _vo.getPhoneMobile() );
		 cs.setString( 8, _vo.getEmail() );
//		 cs.setString( PROPS_FILE, PROPS_FILE );
		 cs.setNull( 9, java.sql.Types.NVARCHAR ); //status
		 cs.setString( 10, _vo.getAddressStreet() );
		 cs.setString( 11, _vo.getAddressCity() );
		 cs.setInt( 12, _vo.getAddressState().getStateID() );//CHECK FOR VALID STATE
		 cs.setString( 13, _vo.getAddressCountry() );
		 cs.setString( 14, _vo.getAddressPostalcode() );
		 cs.setString( 15, _vo.getUserPreferences() );
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
		 cs.setInt( 24, _vo.getUserRole() );

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
	  } finally {
		 DbUtl.close( cs );
	  }
   } else {
	  if ( DEBUG ) {
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createPatient()", "INVALID Parmas" );
	  }
	  this.stateOK = false;
	  this.errorMessage = "Create patient, invalid params.";
   }
   return newID;
}

@Override
public int createPharmaRxOtcVO(PharmaRxOtcVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean deletePatient(PatientVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ArrayList<SigVO> findAllSigs() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public final ArrayList<StateVO> findAllStates() {
   Map<Integer, StateVO> tmpVO = findAllStates( false );
   ArrayList<StateVO> vos = new ArrayList<StateVO>();
   vos.addAll( MedLogDAO.statesList.values() );
   return vos;
}

public final Map<Integer, StateVO> findAllStates(boolean mustuseSQL) {
   Map<Integer, StateVO> tmpVO = new ConcurrentHashMap<Integer, StateVO>( 64 );
   if ( MedLogDAO.statesList == null || mustuseSQL ) {

	  CallableStatement cs = null;
	  ResultSet rs = null;
	  try {
		 cs = db.getConnnection().prepareCall( SP_STATE_SELECT );
		 rs = cs.executeQuery();
		 while ( rs.next() ) {
			tmpVO.put( rs.getInt( 1 ), StateVO.builder().stateID( rs.getInt( 1 ) ).stateName( rs.getString( 2 ) ).stateAbbreviation( rs.getString( 3 ) ).build() );
		 }
		 MedLogDAO.statesList = new HashMap<Integer, StateVO>();
		 MedLogDAO.statesList.putAll( tmpVO );
	  } catch (SQLException ex) {
		 Logger.getLogger( MedLogDAO.class.getName() ).log( Level.SEVERE, null, ex );
	  } finally {
		 DbUtl.close( rs );
		 DbUtl.close( cs );
	  }
   }

   return tmpVO;
}

@Override
public DiaryVO findDiaryByID(int _id) {
   ArrayList<DiaryVO> voList = findDiary( 0, null );
   if ( voList == null || voList.isEmpty() ) {
	  return null;
   } else {
	  return voList.get( 0 );
   }

}

@Override
public ArrayList<DiaryVO> findDiaryByKeyword(String _keyword) {
   return findDiary( 0, StrUtl.toS( _keyword ) );
}

@Override
public ArrayList<DiaryVO> findDiaryByPatient() {
   return findDiary( 0, null );
}

@Override
public ArrayList<DiaryVO> findDiaryByTag(TagVO _tag) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}


@Override
public HealthcareProviderVO findHealthcareProviderID(int _id) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ArrayList<HealthcareProviderVO> findHealthcareProviders() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ArrayList<HealthcareProviderVO> findHealthcareProvidersByKeyword(String _keyword, boolean _onlyAssigned) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ArrayList<HealthcareProviderVO> findHealthcareProvidersByStudent() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
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
public PharmaRxOtcVO findPharmaRxOtcVO(boolean _onlyAssigned) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}
@Override
public PharmaRxOtcVO findPharmaRxOtcVOByID(int _id) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}
@Override
public ArrayList<PharmaRxOtcVO> findPharmaRxOtcVOByKeword(String _keyword, boolean _onlyAssigned) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ArrayList<StateVO> findStatesByKeyword(String _keyword) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public PatientVO getCurrentUser() {
   try {
	  if ( getUser() != null && getUser().getPatientID() > 0 && getUser().getUserName() != null ) {
		 loggedIn = true;
	  }
   } catch (Exception e) {

   }
   return getUser();
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

@Override
public ArrayList<PatientVO> getPatients() {
   throw new UnsupportedOperationException( "Not supported yet." );
}

/**
 * @return the user
 */
public PatientVO getUser() {
   return user;
}

/**
 * @param user the user to set
 */
public void setUser(PatientVO user) {
   this.user = user;
   getCurrentUser();
}
@Override
public int syncDiary(ArrayList<DiaryVO> _voList) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}
@Override
public int syncMedication(ArrayList<MedicationVO> _voList) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean unassignMedication() {

   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public int updateDiary(DiaryVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

@Override
public boolean updateHealthcareProviderVO(HealthcareProviderVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean updatePatient(PatientVO _vo) {
    CallableStatement cs = null;
   int newID = DB_ERROR_CODE;
   if ( _vo.isValid( UPDATE ) ) {
	  try {
		 cs = db.getConnnection().prepareCall( SP_PATIENT_UPDATE );

		 cs.setInt( 1,_vo.getPatientID());
		 cs.setString( 2, _vo.getUserPassword() );
		 cs.setString( 3, _vo.getFirstName() );
		 cs.setString( 4, _vo.getLastName() );
		 cs.setString( 5, _vo.getPhoneHome() );
		 cs.setString( 6, _vo.getPhoneMobile() );
		 cs.setString( 7, _vo.getEmail() );
		 cs.setString( 10, _vo.getAddressStreet() );
		 cs.setString( 11, _vo.getAddressCity() );
		 cs.setInt( 12, _vo.getAddressState().getStateID() );//CHECK FOR VALID STATE
		 cs.setString( 13, _vo.getAddressCountry() );
		 cs.setString( 14, _vo.getAddressPostalcode() );
		 cs.setString( 15, _vo.getUserPreferences() );
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
		 cs.setInt( 24, _vo.getUserRole() );

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
	  } finally {
		 DbUtl.close( cs );
	  }
   } else {
	  if ( DEBUG ) {
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createPatient()", "INVALID Parmas" );
	  }
	  this.stateOK = false;
	  this.errorMessage = "Create patient, invalid params.";
   }
   return true
		   ;
}
@Override
public boolean updatePharmaRxOtcVO(PharmaRxOtcVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

/**
 * Diary selection base
 *
 * @param _id
 * @param _keyword
 * @return
 */
private ArrayList<DiaryVO> findDiary(int _id, String _keyword) {
   ArrayList<DiaryVO> voList = new ArrayList<DiaryVO>();
   _keyword = StrUtl.toS( _keyword );

   CallableStatement cs = null;
   ResultSet rs = null;
   boolean valid = true;
   try {
	  cs = db.getConnnection().prepareCall( SP_DIARY_SELECT );
	  if ( _id > 0 ) {
		 cs.setInt( 1, _id );
		 valid = true;
	  } else {
		 cs.setNull( 1, java.sql.Types.INTEGER );
	  }
	  cs.setInt( 2, getCurrentUser().getPatientID() );
	  if ( DEBUG ) {
		 System.out.println( "com.medlog.webservice.dao.MedLogDAO.findDiary() UserID=" + getCurrentUser().getPatientID() );
	  }
	  if ( _keyword.isEmpty() ) {
		 cs.setNull( 3, java.sql.Types.NVARCHAR );
	  } else {
		 valid = true;
		 cs.setString( 3, _keyword );
		 cs.setNull( 3, java.sql.Types.NVARCHAR );
	  }

	  if ( valid ) {
		 rs = cs.executeQuery();
		 while ( rs.next() ) {
			voList.add( DiaryVO.builder()
					.id( rs.getInt( "id" ) )
					.title( rs.getString( "title" ) )
					.notes( rs.getString( "notes" ) )
					.notesActivity( rs.getString( "notesActivity" ) )
					.mood( rs.getInt( "ratingMood" ) )
					.productivity( rs.getInt( "ratingProductivity" ) )
					.patientID( getCurrentUser() )
					.createdDate( rs.getDate( "createdDate" ) )
					.build() );
		 }
	  } else {
		 this.stateOK = false;
		 this.errorMessage = "com.medlog.webservice.dao.MedLogDAO.findDiary() - Invalid Params: Username is required";
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
/**
 * HealtcareProvider Search
 *
 * @param _id           {@linkPlain
 * @param _keyword
 * @param _onlyAssigned For current {@linkplain PatientVO}
 * @return List
 */
private ArrayList<HealthcareProviderVO> findHealthcareProviders(int _id, String _keyword, boolean _onlyAssigned) {
   return null;
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
		 cs.setNull( 2, java.sql.Types.NVARCHAR );
		 cs.setNull( 3, java.sql.Types.NVARCHAR );
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
					.userHash( rs.getString( 4 ) )
					.firstName( rs.getString( 5 ) )
					.lastName( rs.getString( 6 ) )
					.phoneHome( rs.getString( 7 ) )
					.phoneMobile( rs.getString( 8 ) )
					.email( rs.getString( 9 ) )
					.status( rs.getString( 10 ) )
					.addressStreet( rs.getString( 11 ) )
					.addressCity( rs.getString( 12 ) )
					.addressState( statesList.get( rs.getInt( 13 ) ) )//Add error handling for state
					.addressCountry( rs.getString( 14 ) )
					.addressPostalcode( rs.getString( 15 ) )
					.userPreferences( rs.getString( 16 ) )
					.pwdLastChanged( rs.getDate( 17 ) )
					.lang( rs.getString( 18 ) )
					.timezoneId( rs.getString( 19 ) )
					//.primaryPhyssician( 20 )
					.dateOfBirth( rs.getDate( 21 ) )
					.dateJoined( rs.getDate( 22 ) )
					.picture( rs.getString( 23 ) )
					.metaData( rs.getString( 24 ) )
					.userRole( rs.getInt( 25 ) )
					.build() );
			/*
			 * [email]
			 * ,	[status]
			 * ,	[addressStreet]
			 * ,	[addressCity]
			 * ,	[addressState]
			 * ,	[address_country]
			 * ,	[address_postalcode]
			 * ,	[user_preferences]
			 * ,	[pwd_last_changed]
			 * ,	[lang]
			 * ,	[timezone_id]
			 * ,	[primary_physsician]
			 * ,	[date_of_birth]
			 * ,	[date_joined]
			 * ,	[picture]
			 * ,	[meta_data]
			 * ,	[userRole]
			 */
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
private int changeMedicationBinding(MedicationVO _vo) {
   
   CallableStatement cs = null;
   int newID = DB_ERROR_CODE;
   try {
	  if ( _vo != null && _vo.getPharmID() == null && getCurrentUser() != null ) {
		 _vo.setPatientID( getCurrentUser() );
	  }
   } catch (Exception e) {
	  if ( DEBUG ) {
		 LOG.log( Level.SEVERE, "Error setting user", e );
		 e.printStackTrace();
	  }
   }
   if ( (_vo.isActive() && _vo.isValid( INSERT ) ) || _vo.isValid( DELETE )  && !_vo.isActive()) {
	  try {
		 cs = db.getConnnection().prepareCall( SP_MEDICATION_CHANGE_BINDING );
		 cs.setInt( 1, getCurrentUser().getPatientID() );
		 cs.setInt(2,_vo.getPharmID().pharmID);
		 cs.setString( 3, _vo.getInstructions() );
		 cs.setString(4,_vo.getSig().sigAbbrID);
		 cs.setDate(5, (java.sql.Date) _vo.getStartDate());
	  } catch (Exception e) {
		 
	  }
   }
   return newID;
}
private final DbConnection db;
private String errorMessage;
private boolean loggedIn;
private boolean stateOK;
private PatientVO user;

}
