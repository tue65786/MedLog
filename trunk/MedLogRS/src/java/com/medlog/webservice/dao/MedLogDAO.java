/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.dao;

import static com.medlog.webservice.CONST.API_ACTIONS.*;
import static com.medlog.webservice.CONST.DB_STRINGS.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.rest.*;
import com.medlog.webservice.rest.controller.*;
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
//private static Map<Integer, StateVO> statesList;

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
	  //  if ( u != null && u.getPatientID() != -2 ) {
//	  findAllStates();
	  //  }
   } catch (Exception eeee) {
	  eeee.printStackTrace();
   }
}

public MedLogDAO(DbConnection db, PatientVO u, ApplicationBean app) {
   this.db = db;
   this.user = u;
   stateOK = true;
   errorMessage = "";
   try {
	  if ( app.isRxSet() ) {
		 rxMap = app.getRxMap();
	  }
	  if ( app.isSigSet() ) {
		 sigMap = app.getSigMap();
	  }
	  if ( app.isStateSet() ) {
		 statesMap = app.getStatesMap();
	  }
   } catch (Exception e) {

   }
   try {
	  //  if ( u != null && u.getPatientID() != -2 ) {
//	  findAllStates();
	  //  }
   } catch (Exception eeee) {
	  eeee.printStackTrace();
   }
}

@Override
public int assignMedication(MedicationVO _vo) {
   if ( _vo.isValid( INSERT ) ) {
	  return changeMedicationBinding( _vo );
   } else {
	  return DB_ERROR_CODE;
   }
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
   ///

   CallableStatement cs = null;
   int newID = DB_ERROR_CODE;
   if ( _vo.isValid( INSERT ) ) {
	  try {
		 cs = db.getConnnection().prepareCall( SP_HEALTHCARE_INSERT );
//@phoneFax nchar (10) = NULL
//@email nvarchar (256) = NULL
//@pathient_log_communication_preference varchar (20) = NULL
//@addressStreet nvarchar (512) = NULL
//@addressCity nvarchar (128) = NULL
//@addressStateID int = NULL
//@addressZip varchar (10) = NULL
//@inserted int OUTPUT
		 cs.setString( 1, _vo.getLastName() );
		 cs.setString( 2, _vo.getFirstName() );
		 cs.setNull( 3, java.sql.Types.NVARCHAR );
		 cs.setString( 4, _vo.getPhoneWork() );
		 cs.setString( 5, _vo.getPhoneMobile() );
		 cs.setNull( 6, java.sql.Types.VARBINARY );
		 cs.setString( 7, StrUtl.truncateAtWord( _vo.getPhoneFax(), 10 ) );
		 cs.setString( 8, _vo.getEmail() );
		 cs.setNull( 9, java.sql.Types.NVARCHAR );
		 cs.setString( 11, _vo.getAddressStreet() );
		 cs.setString( 12, _vo.getAddressCity() );
		 cs.setInt( 13, _vo.getAddressStateID().getStateID() );//CHECK FOR VALID STATE
		 cs.setString( 11, StrUtl.truncateAtWord( _vo.getAddressZip(), 10 ) );
		 cs.registerOutParameter( 12, java.sql.Types.INTEGER );
		 int rows = cs.executeUpdate();
		 newID = cs.getInt( 12 );
	  } catch (SQLException ex) {
		 if ( DEBUG ) {
			System.err.println( "com.medlog.webservice.dao.MedLogDAO.createHealthcareProviderVO()\n" + DbUtl.printJDBCExceptionMsg( ex ) );
		 }
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createHealthcareProviderVO()", "SQLEx", ex );
	  } catch (NullPointerException npe) {
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createHealthcareProviderVO()", "Null Pointer", npe );
	  } finally {
		 DbUtl.close( cs );
	  }
   } else {
	  if ( DEBUG ) {
		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createHealthcareProviderVO()", "INVALID Parmas" );
	  }
	  this.stateOK = false;
	  this.errorMessage = "Create healthcare valid, invalid params.";
   }
   return newID;

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
   CallableStatement cs = null;

   int newID = DB_ERROR_CODE;
   if ( _vo.isValid( INSERT ) ) {
	  try {
		 cs = db.getConnnection().prepareCall( SP_PHARM_INSERT );
		 cs.setString( 1, StrUtl.toS( _vo.getMedType().medTypeID, "OTC" ) );
		 cs.setString( 2, StrUtl.toS( _vo.getRxcui() ) );
		 cs.setString( 3, StrUtl.toS( _vo.getGenericRxcui() ) );
		 cs.setString( 4, StrUtl.toS( _vo.getTty(), "OTC" ) );
		 cs.setString( 5, _vo.getFullName() );
		 cs.setString( 6, _vo.getRxnDoseForm() );
		 cs.setNull( 7, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 8, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 9, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 10, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 11, java.sql.Types.VARCHAR );//full generic
		 cs.setString( 12, StrUtl.toS( _vo.getStrength() ) );
		 cs.setNull( 13, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 14, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 15, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 16, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 17, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 18, java.sql.Types.VARCHAR );//full generic
		 cs.setNull( 19, java.sql.Types.VARCHAR );//full generic
		 cs.registerOutParameter( 20, java.sql.Types.INTEGER );
		 int ct = cs.executeUpdate();
		 newID = cs.getInt( 20 );

	  } catch (SQLException e) {
		 if ( DEBUG ) {
			System.out.println( "com.medlog.webservice.dao.MedLogDAO.createPharmaRxOtcVO()" + DbUtl.printJDBCExceptionMsg( e ) );
			LOG.log( Level.SEVERE, null, e );
			e.printStackTrace();
		 }
	  } catch (Exception e) {
		 if ( DEBUG ) {
			System.out.println( "com.medlog.webservice.dao.MedLogDAO.createPharmaRxOtcVO()" + e.getMessage() );
			e.printStackTrace();
			LOG.log( Level.SEVERE, null, e );
		 }
	  } finally {
		 DbUtl.close( cs );
	  }

   }
   return newID;
}

@Override
public boolean deletePatient(PatientVO _vo
) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ArrayList<SigVO> findAllSigs(boolean onlyTime) {
   ArrayList<SigVO> voList = new ArrayList<SigVO>();
   voList.addAll( findAllSigsMap().values() );
   if ( onlyTime ) {
	  SigFacadeImpl _impl = new SigFacadeImpl( SigVO.class, voList );
	  return _impl.getPrimarySigs();
   }
   return voList;
}

@Override
public Map<String, SigVO> findAllSigsMap() {

   if ( getSigMap() == null || getSigMap().isEmpty() ) {
	  Map<String, SigVO> map = new HashMap<String, SigVO>();
	  CallableStatement cs = null;
	  ResultSet rs = null;
	  try {
		 cs = db.getConnnection().prepareCall( SP_SIGS_SELECT );
		 cs.setNull( 1, java.sql.Types.INTEGER );
		 rs = cs.executeQuery();
		 while ( rs.next() ) {
			map.put( rs.getString( 1 ), SigVO.builder().sigAbbrID( rs.getString( 1 ) ).definition( rs.getString( 2 ) ).category( rs.getString( 3 ) ).build() );
		 }
	  } catch (SQLException ex) {
		 Logger.getLogger( MedLogDAO.class.getName() ).log( Level.SEVERE, null, ex );
	  } finally {
		 DbUtl.close( rs );
		 DbUtl.close( cs );
	  }
	  setSigMap( map );
	  return map;
   } else {
	  if ( DEBUG ) {
		 LOG.info( "Using Sig Bean" );
	  }
	  return getSigMap();
   }
}

@Override
public final ArrayList<StateVO> findAllStates() {
   Map<Integer, StateVO> tmpVO = findAllStates( true );
   ArrayList<StateVO> vos = new ArrayList<StateVO>();
   vos.addAll( getStatesMap().values() );
   return vos;
}

public final Map<Integer, StateVO> findAllStates(boolean mustuseSQL) {
   Map<Integer, StateVO> tmpVO = new ConcurrentHashMap<Integer, StateVO>( 64 );
   if ( getStatesMap() == null || getStatesMap().isEmpty() ) {
	  if ( getStatesMap() == null || mustuseSQL && !statesLoading ) {
		 statesLoading = true;
		 CallableStatement cs = null;
		 ResultSet rs = null;
		 try {
			cs = db.getConnnection().prepareCall( SP_STATE_SELECT );
			rs = cs.executeQuery();
			while ( rs.next() ) {
			   tmpVO.put( rs.getInt( 1 ), StateVO.builder().stateID( rs.getInt( 1 ) ).stateName( rs.getString( 2 ) ).stateAbbreviation( rs.getString( 3 ) ).build() );
//			System.out.println(tmpVO.get(rs.getInt(1)).setStateName( DATE_FORMAT ));
			}
			if ( getStatesMap() == null ) {
			   setStatesMap( new ConcurrentHashMap<Integer, StateVO>( 64 ) );
			}
			getStatesMap().putAll( tmpVO );
		 } catch (SQLException ex) {
			Logger.getLogger( MedLogDAO.class.getName() ).log( Level.SEVERE, null, ex );
		 } finally {
			DbUtl.close( rs );
			DbUtl.close( cs );
			statesLoading = false;
		 }
	  }
	  setStatesMap( tmpVO );
	  statesLoading = false;
	  statesLoaded = true;
	  return tmpVO;
   } else {

	  statesLoading = false;
	  statesLoaded = true;
	  if ( DEBUG ) {
		 LOG.info( "Using state Bean" );
	  }
	  return getStatesMap();
   }

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
   return getFirstItem( findHealthCareProviders( _id, "", false ) );
}

@Override
public ArrayList<HealthcareProviderVO> findHealthcareProviders() {
   return findHealthCareProviders( -1, "", false );
}

@Override
public ArrayList<HealthcareProviderVO> findHealthcareProvidersByKeyword(String _keyword, boolean _onlyAssigned) {
   return findHealthCareProviders( -1, StrUtl.toS( _keyword ), _onlyAssigned );
}

@Override
public ArrayList<HealthcareProviderVO> findHealthcareProvidersByPatient() {
   return findHealthCareProviders( -1, "", true );
}

@Override
public Map<String, MedTypeVO> findMedTypesMap() {
   Map<String, MedTypeVO> m = new ConcurrentHashMap<>();
   m.put( "RX", MedTypeVO.GET_RX() );
   m.put( "OTC", MedTypeVO.GET_OTC() );
   return m;
}

@Override
public MedicationVO findMedicationByID(int _id) {
   Set<MedicationVO> voList = null;
   try {
	  voList = new TreeSet<MedicationVO>( findMedicationByPatient() );

	  for ( MedicationVO vo : voList ) {
		 if ( vo.getMedicationID() == _id ) {
			return vo;
		 }

	  }
   } catch (Exception e) {
	  if ( DEBUG ) {
		 System.err.println( "com.medlog.webservice.dao.MedLogDAO.findMedicationByID() - ERROR" );
		 e.printStackTrace();
	  }
   }
   return null;

}

@Override
public ArrayList<MedicationVO> findMedicationByPatient() {
   ArrayList<MedicationVO> voList = new ArrayList<MedicationVO>();
   CallableStatement cs = null;
   ResultSet rs = null;
   try {
	  cs = db.getConnnection().prepareCall( SP_MEDICATION_SELECT );
	  cs.setNull( 1, java.sql.Types.INTEGER );
	  cs.setInt( 1, getCurrentUser().getPatientID() );
	  rs = cs.executeQuery();
	  while ( rs.next() ) {
		 voList.add( MedicationVO.builder()
				 .medicationID( rs.getInt( "MedicationID" ) )
				 .pharmID( getRxMap().get( rs.getInt( "pharmID" ) ) )
				 .patientID( getCurrentUser() )
				 .startDate( rs.getDate( "startDate" ) )
				 .endDate( rs.getDate( "endDate" ) )
				 .sig( getSigMap().getOrDefault( rs.getString( "sig" ), getSigMap().get( "p.r.n." ) ) )
				 .instructions( rs.getString( "instructions" ) )
				 .build() );

	  }
   } catch (Exception e) {

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
public Map<Integer, PharmaRxOtcVO> findPharmaMapRxOtcVOByKeword(String _keyword, int _pageNumber, int _pageSize, boolean _onlyAssigned) {
   ArrayList<PharmaRxOtcVO> voList = new ArrayList<PharmaRxOtcVO>();
   Map<Integer, PharmaRxOtcVO> mapp = new ConcurrentHashMap<Integer, PharmaRxOtcVO>( 512 );
   CallableStatement cs = null;
   ResultSet rs = null;
   try {
	  cs = db.getConnnection().prepareCall( SP_PHARM_SEARCH );
	  if ( _keyword != null ) {
		 cs.setString( 1, StrUtl.truncateAtWord( _keyword, 40 ) );
	  } else {
		 cs.setNull( 1, java.sql.Types.NVARCHAR );
	  }
	  cs.setInt( 2, _pageNumber );
	  cs.setInt( 3, _pageSize );
	  cs.setBoolean( 4, false );
	  cs.setInt( 5, getCurrentUser().getPatientID() );
	  rs = cs.executeQuery();
	  while ( rs.next() ) {
		 mapp.put( rs.getInt( 1 ), PharmaRxOtcVO
				   .builder()
				   .pharmID( rs.getInt( 1 ) )
				   .medType( rs.getString( 2 ) )
				   .rxcui( rs.getString( 3 ) )
				   .tty( rs.getString( 3 ) )
				   .fullName( rs.getString( 4 ) )
				   .build() );
	  }
   } catch (SQLException ex) {
	  LOG.log( Level.SEVERE, null, ex );
   } catch (Exception ex) {
	  LOG.log( Level.SEVERE, null, ex );
   } finally {
	  DbUtl.close( cs, rs );
   }
   return mapp;
}

@Override
public PharmaRxOtcVO findPharmaRxOtcVO(boolean _onlyAssigned) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public PharmaRxOtcVO findPharmaRxOtcVOByID(int _id) {
   if ( rxMap.containsKey( _id ) ) {
	  return rxMap.get( _id );
   } else {

	  ArrayList<PharmaRxOtcVO> voList = new ArrayList<PharmaRxOtcVO>();
	  Map<Integer, PharmaRxOtcVO> mapp = new ConcurrentHashMap<Integer, PharmaRxOtcVO>( 512 );
	  CallableStatement cs = null;
//	  ResultSet rs = null;
//	  try {
//		 try {
//			cs = db.getConnnection().prepareCall( SP_PHARM_SELECT );
//
//			cs.setNull( 1, java.sql.Types.NVARCHAR 
//			);
//		 } catch (SQLException ex) {
//			Logger.getLogger( MedLogDAO.class.getName() ).log( Level.SEVERE, null, ex );
//		 }
   }
   return null;
}

@Override
public ArrayList<PharmaRxOtcVO> findPharmaRxOtcVOByKeword(String _keyword, boolean _onlyAssigned
) {
   return findPharmaRxOtcVOByKeword( _keyword, 1, 1000, _onlyAssigned );
}

@Override
public ArrayList<PharmaRxOtcVO> findPharmaRxOtcVOByKeword(String _keyword, int pageNumber, int pageSize, boolean onlyAssigned
) {
   return new ArrayList<PharmaRxOtcVO>( findPharmaMapRxOtcVOByKeword( _keyword, pageNumber, pageSize, onlyAssigned ).values() );
}

@Override
public ArrayList<StateVO> findStatesByKeyword(String _keyword
) {
   throw new UnsupportedOperationException( "Not supported yet." );
}

public void setAppContext(ApplicationBean app) {
   try {
	  if ( app.isRxSet() ) {
		 setRxMap( app.getRxMap() );
	  }
	  if ( app.isSigSet() ) {
		 setSigMap( app.getSigMap() );
	  }
	  if ( app.isStateSet() ) {
		 setStatesMap( app.getStatesMap() );
	  }
   } catch (Exception e) {
	  if ( DEBUG ) {
		 e.printStackTrace();
	  }
   }
   try {
   } catch (Exception eeee) {

   }
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
 * @return the rxMap
 */
public Map<Integer, PharmaRxOtcVO> getRxMap() {
   return rxMap;
}

/**
 * @param rxMap the rxMap to set
 */
public void setRxMap(Map<Integer, PharmaRxOtcVO> rxMap) {
   this.rxMap = rxMap;
}

/**
 * @return the sigMap
 */
public Map<String, SigVO> getSigMap() {
   return sigMap;
}

/**
 * @param sigMap the sigMap to set
 */
public void setSigMap(Map<String, SigVO> sigMap) {
   this.sigMap = sigMap;
}

/**
 * @return the statesMap
 */
public Map<Integer, StateVO> getStatesMap() {
//   if ( statesMap == null || statesMap.isEmpty() ) {
//	  if ( statesLoading  || !statesLoaded) {
//		 try {
//			Thread.sleep( 300 );
//			System.out.println( "com.medlog.webservice.dao.MedLogDAO.getStatesMap() zzz" );
//		 } catch (InterruptedException ex) {
//			Logger.getLogger( MedLogDAO.class.getName() ).log( Level.SEVERE, null, ex );
//		 }
//	  } else {
//		 findAllStates( true );
//	  }
//   }
   return statesMap;
}

/**
 * @param statesMap the statesMap to set
 */
public void setStatesMap(Map<Integer, StateVO> statesMap) {
   this.statesMap = statesMap;
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
public boolean unassignMedication(MedicationVO _vo) {
   if ( _vo.isValid( DELETE ) ) {
	  return changeMedicationBinding( _vo ) > 0;
   } else {
	  return false;
   }

}

@Override
public boolean updateDiary(DiaryVO _vo) {
   CallableStatement cs = null;
//
//   try {
//	  if ( _vo != null && _vo.getPatientID() == null && getCurrentUser() != null ) {
//		 _vo.setPatientID( getCurrentUser() );
//	  }
//   } catch (Exception e) {
//	  if ( DEBUG ) {
//		 LOG.log( Level.SEVERE, "Error setting user", e );
//		 e.printStackTrace();
//	  }
//   }
//   if ( _vo.isValid( INSERT ) ) {
//	  try {
//		 cs = db.getConnnection().prepareCall( SP );
//		 cs.setInt( 1, getCurrentUser().getPatientID() );
//
//		 if ( _vo.getTitle() != null ) {
//			cs.setString( 2, _vo.getTitle() );
//		 } else {
//			cs.setNull( 2, java.sql.Types.NVARCHAR );
//		 }
////		 if ( _vo.notes != null ) {
//		 cs.setString( 3, StrUtl.removeHtmlMarkups( _vo.getNotes() ) );
////		 } else {
////			cs.setNull( 3, java.sql.Types.NVARCHAR );
////		 }
//		 if ( _vo.getNotesActivity().isEmpty() ) {
//			cs.setNull( 4, java.sql.Types.NVARCHAR );
//		 } else {
//			cs.setString( 4, StrUtl.removeHtmlMarkups( _vo.getNotesActivity() ) );
//		 }
//		 cs.setNull( 5, java.sql.Types.DATE );
//		 cs.setNull( 6, java.sql.Types.DATE );
//		 cs.setNull( 7, java.sql.Types.NCHAR );
//		 cs.setNull( 8, java.sql.Types.NVARCHAR );
//		 cs.setInt( 9, _vo.getMood() );
//		 cs.setInt( 10, _vo.getProductivity() );
//		 cs.registerOutParameter( 11, java.sql.Types.INTEGER );
//		 cs.executeUpdate();
//		 newID = cs.getInt( 11 );
//
//	  } catch (SQLException ex) {
//		 if ( DEBUG ) {
//			System.err.println( "com.medlog.webservice.dao.MedLogDAO.createDiary()\n" + DbUtl.printJDBCExceptionMsg( ex ) );
//		 }
//		 this.stateOK = false;
//		 this.errorMessage = ex.getMessage();
//		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createDiary()", "SQLEx", ex );
//
//	  } catch (NullPointerException npe) {
//		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createDiary()", "Null Pointer", npe );
//		 this.stateOK = false;
//		 this.errorMessage = npe.getMessage();
//	  } finally {
//		 DbUtl.close( cs );
//	  }
//   } else {
//	  if ( DEBUG ) {
//		 LOG.logp( Level.SEVERE, this.getClass().getName(), "createDiary()", "INVALID Parmas" );
//	  }
//	  this.stateOK = false;
//	  this.errorMessage = "createDiary, invalid params.";
//
//   }
   return true;
}

@Override
public boolean updateHealthcareProviderVO(HealthcareProviderVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean updatePatient(PatientVO _vo) {
   CallableStatement cs = null;
   int rows = 0;
   if ( _vo.isValid( UPDATE ) ) {
	  try {
		 cs = db.getConnnection().prepareCall( SP_PATIENT_UPDATE );
		 cs.setInt( 1, _vo.getPatientID() );

		 cs.setString( 2, _vo.getUserPassword() );
		 cs.setString( 3, _vo.getFirstName() );
		 cs.setString( 4, _vo.getLastName() );
		 cs.setString( 5, _vo.getPhoneHome() );
		 cs.setString( 6, _vo.getPhoneMobile() );
		 cs.setString( 7, _vo.getEmail() );
		 cs.setString( 8, _vo.getAddressStreet() );
		 cs.setString( 9, _vo.getAddressCity() );
		 cs.setInt( 10, _vo.getAddressState().getStateID() );//CHECK FOR VALID STATE
		 cs.setString( 11, _vo.getAddressCountry() );
		 cs.setString( 12, _vo.getAddressPostalcode() );

		 try {
			cs.setDate( 13, (java.sql.Date) _vo.getDateOfBirth() );
		 } catch (Exception e) {
			cs.setNull( 13, java.sql.Types.DATE );//Date Joined	
		 }
		 rows = cs.executeUpdate();

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
   return rows > 0;
}

@Override
public boolean updatePharmaRxOtcVO(PharmaRxOtcVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
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
//@active bit = 1 Set to 0 to delete
   if ( ( _vo.isActive() && _vo.isValid( INSERT ) ) || _vo.isValid( DELETE ) && !_vo.isActive() ) {
	  try {
		 cs = db.getConnnection().prepareCall( SP_MEDICATION_CHANGE_BINDING );
		 cs.setInt( 1, getCurrentUser().getPatientID() );
		 cs.setInt( 2, _vo.getPharmID().getPharmID() );
		 cs.setInt( 3, _vo.getPhysicianID().getPhysicianID() );
		 cs.setString( 4, _vo.getInstructions() );
		 cs.setString( 4, _vo.getSig().getSigAbbrID() );
		 cs.setDate( 5, (java.sql.Date) _vo.getStartDate() );
		 cs.setNull( 6, java.sql.Types.BIT );
		 cs.executeUpdate();

	  } catch (Exception e) {

	  }
   }
   return newID;
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
   int ct = 0;
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
					.build( ct++ ) );
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
 * Search doctors
 *
 * @param _id           doctor id
 * @param _keyword      search key
 * @param _onlyassigned only current user (For current {@linkplain PatientVO})
 * @return list :
 *
 * <ol><li>[PhysicianID]
 * </li><li>[lastname]
 * </li><li>[firstname]
 * </li><li>[specialty]
 * </li><li>[phoneWork]
 * </li><li>[phoneMobile]
 * </li><li>[phonePager]
 * </li><li>[phoneFax]
 * </li><li>[email]
 * </li><li>[pathient_log_communication_preference]
 * </li><li>[addressStreet]
 * </li><li>[addressCity]
 * </li><li>[addressStateID]
 * </li><li>[addressZip]</li></ol>
 */
private ArrayList<HealthcareProviderVO> findHealthCareProviders(int _id, String _keyword, boolean _onlyassigned) {
   ArrayList<HealthcareProviderVO> voList = new ArrayList<HealthcareProviderVO>();

//   Select Healthcare provider Entries Params:
//DoctorId int
//PatientID int
//Keyword (null)
//Result Set
   CallableStatement cs = null;
   ResultSet rs = null;
   try {
	  cs = db.getConnnection().prepareCall( SP_HEALTHCAREPROVIDER_SELECT );
	  if ( _keyword != null ) {
		 cs.setString( 1, StrUtl.truncateAtWord( _keyword, 40 ) );
	  } else {
		 cs.setNull( 1, java.sql.Types.NVARCHAR );
	  }
	  if ( _id > 0 ) {
		 cs.setInt( 1, _id );
	  } else {
		 cs.setNull( 1, java.sql.Types.INTEGER );
	  }
	  if ( _onlyassigned ) {
		 cs.setInt( 2, getCurrentUser().getPatientID() );
	  } else {
		 cs.setNull( 2, java.sql.Types.INTEGER );
	  }
	  if ( StrUtl.toS( _keyword ).isEmpty() ) {
		 cs.setNull( 3, java.sql.Types.NVARCHAR );
	  } else {
		 cs.setString( 3, _keyword );
	  }
	  cs.setBoolean( 4, false );
	  cs.setInt( 5, getCurrentUser().getPatientID() );
	  rs = cs.executeQuery();
	  while ( rs.next() ) {
		 voList.add( HealthcareProviderVO.builder()
				 .physicianID( rs.getInt( 1 ) )
				 .lastName( rs.getString( 2 ) )
				 .firstName( rs.getString( 3 ) )
				 .specialty( rs.getString( 4 ) )
				 .phoneWork( rs.getString( 5 ) )
				 .phoneMobile( rs.getString( 6 ) )
				 .email( rs.getString( 8 ) )
				 .addressStreet( rs.getString( 7 ) )
				 .addressCity( rs.getString( 8 ) )
				 .addressStateID( getStatesMap().get( rs.getInt( 9 ) ) )//Add error handling for state
				 .addressZip( rs.getString( 10 ) )
				 .build()
		 );
	  }

   } catch (SQLException ex) {
	  LOG.log( Level.SEVERE, null, ex );
   } catch (Exception ex) {
	  LOG.log( Level.SEVERE, null, ex );
   } finally {
	  DbUtl.close( cs, rs );
   }
   return voList;
}

/**
 * HealtcareProvider Search
 *
 * @param _id           {@linkPlain
 * @param _keyword
 * @param _onlyAssigned
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
   findAllStates( true );
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
					.addressState( getStatesMap().get( rs.getInt( 13 ) ) )//Add error handling for state
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

/**
 *
 * @param <T>
 * @param _voList
 * @return
 */
private <T extends IEntityBase> T getFirstItem(ArrayList<T> _voList) {
   if ( _voList == null || _voList.isEmpty() ) {
	  return null;
   } else {
	  try {
		 return _voList.get( 0 );
	  } catch (Exception e) {
		 if ( DEBUG ) {
			LOG.log( Level.WARNING, StrUtl.toS( _voList.getClass().getName() + " " + _voList.getClass().toGenericString() ), e );
		 }
	  }
   }
   return null;

}
private final DbConnection db;
private String errorMessage;
private boolean loggedIn;
private Map<Integer, PharmaRxOtcVO> rxMap;
private Map<String, SigVO> sigMap;
private boolean stateOK;
private boolean statesLoaded = false;
private boolean statesLoading = false;
private Map<Integer, StateVO> statesMap;
private PatientVO user;

}
