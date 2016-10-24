/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import com.google.gson.*;
import static com.medlog.webservice.CONST.API_ACTIONS.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.dao.*;
import com.medlog.webservice.rest.helpers.*;
import com.medlog.webservice.sql.*;
import com.medlog.webservice.util.*;
import com.medlog.webservice.vo.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.http.*;
import jdk.nashorn.api.scripting.*;

/**
 * Strategies for connecting to data.
 *
 * @author (c)2016
 */
public class MedLogControllerStrategy {

private static final Logger LOG = Logger.getLogger( MedLogControllerStrategy.class.getName() );
public boolean success;
public String responseMessage = "";
public MedLogControllerStrategy(HttpServletRequest _request, HttpServletResponse _response, RES_ENUM res, String fn) {
   this.request = _request;
   this.response = _response;
   this.session = request.getSession();
   this.res = res;
   this.fn = fn;
   success = false;
}

public String execute(DbConnection dbc) {
//   JsonObject jo = new JsonObject();
   Gson g = new Gson();
   boolean v = true;
   MedLogDAO dao;
   if ( getCurrentUser() == null ) {
	  if ( !res.equals( RES_ENUM.API_RESOURCE_PATIENT ) || ( StrUtl.matchOR( fn, "login", API_FUNCTION_INSERT ) ) ) {
		 v = false;
	  }
   }
   

   
   if ( !v ) {
	  responseMessage = StrUtl.getJSONMsg( "error", "Not logged in." );
   } else {
	  dao = new MedLogDAO( dbc, getCurrentUser() );
	  switch ( res ) {
		 /////////////////
		 /////
		 /////  DIARY
		 /////
		 /////////////////////////////////////
		 case API_RESOURCE_DIARY:
			if ( StrUtl.matchOR( fn, API_FUNCTION_INSERT, API_FUNCTION_UPDATE ) ) {
			   DiaryVO vo = loadDiaryFromRequest();
			   if ( fn.equalsIgnoreCase( API_FUNCTION_INSERT ) && vo.isValid( INSERT ) ) {
				  int id = dao.createDiary(vo );
				  if ( id > 0 ) {
					 success = true;
					 vo.id = id ;
					 responseMessage = g.toJson( vo );
				  } else {
					 responseMessage = StrUtl.getJSONMsg( "error", "Diary not added." );
				  }
			   }//Insert
			   else if (fn.equalsIgnoreCase( API_FUNCTION_UPDATE ) && vo.isValid( UPDATE )){
				 success =  dao.updateDiary( vo ) > 0;
				 responseMessage = StrUtl.getJSONMsg( success ? "info" : "error", "Diary update" + ( success ? "d" : " failed" ) );
			   }//Update
			} else if ( StrUtl.matchOR( fn, API_FUNCTION_FIND, API_FUNCTION_FIND_BY_KEYWORD ) ) {
			   responseMessage = getDiaryResponse( dao, g );
			}//Search
			break;
		 ///////////////
		 /// 
		 /// PATIENT
		 /// 
		 ///////////////////////////////////////////////////
		 case API_RESOURCE_PATIENT:
			if ( StrUtl.matchOR( fn, API_FUNCTION_INSERT, API_FUNCTION_UPDATE ) ) {
			   PatientVO vo = loadPatientFromRequest();
			   if ( fn.equalsIgnoreCase( API_FUNCTION_INSERT ) && vo.isValid( INSERT ) ) {
				  int id = dao.createPatient( vo );
				  if ( id > 0 ) {
					 success = true;
					 vo.setPatientID( id );
					 session.setAttribute( SESSION_BEAN_USER, vo );
					 responseMessage = g.toJson( vo );
				  } else {
					 responseMessage = StrUtl.getJSONMsg( "error", "Patient not added." );
				  }

			   } else if ( fn.equalsIgnoreCase( API_FUNCTION_UPDATE )
						   && vo.isValid( UPDATE )
						   && getCurrentUser() != null
						   && vo.getPatientID() == getCurrentUser().getPatientID()
						   && vo.getPatientID() > 0 ) {
				  //Execute
				  success = dao.updatePatient( vo );
				  if ( success ) {
					 session.setAttribute( SESSION_BEAN_USER, vo );
				  }
				  responseMessage = StrUtl.getJSONMsg( success ? "info" : "error", " Update" + ( success ? "d" : " failed" ) );
			   } else {
				  responseMessage = StrUtl.getJSONMsg( "error", StrUtl.toS( fn, "?" ) + " params are invalid." );
			   }

			} else {//Not valid fn
			   responseMessage = StrUtl.getJSONMsg( "error", StrUtl.toS( fn, "?" ) + " is invalid." );
			}
			break;
		 default:
			responseMessage = StrUtl.getJSONMsg( "error", " Invalid res." );
			break;

	  }
   }
   return responseMessage;
}

public ArrayList<IEntityBase> getList() {
   ArrayList<IEntityBase> voList = null;
//   getSingle( sendDiaryToResponse( null,null ) );
   return voList;
}

public IEntityBase getSingle(ArrayList<? extends IEntityBase> voList) {
   return voList.get( 0 );
}

private String getDiaryResponse(MedLogDAO dao, Gson g) {
   ServletHelpers sh = new ServletHelpers( request, response );
   ArrayList<DiaryVO> voList = null;
   String key = sh.getStrParameter( "keyword", "" );
   if ( fn.equals( API_FUNCTION_FIND_BY_KEYWORD ) && !key.isEmpty() ) {
	  voList = dao.findDiaryByKeyword( key );
   } else if ( fn.equals( API_FUNCTION_FIND ) ) {
	  voList = dao.findDiaryByPatient();
   } else {
	  success = false;
   }

   if ( voList == null || voList.isEmpty() ) {
	  return StrUtl.getJSONMsg( "error", "No entries." );
   } else {
	  return g.toJson( voList );
   }

}

public MedicationVO loadMedicationFromRequest() {
   ServletHelpers sh = new ServletHelpers( request, response );
   MedicationVO.Builder t = MedicationVO.builder();
   //TODO Add request params
   return t.build();
}

public PatientVO loadPatientFromRequest() {
   ServletHelpers sh = new ServletHelpers( request, response );
   PatientVO.Builder p = PatientVO.builder();
   //Allow id or patientID
   p.patientID( sh.getIntParameter( "id", sh.getIntParameter( "patientID", 0 ) ) );
   p.userName( sh.getStrParameter( "userName", "" ) );
   p.userPassword( sh.getStrParameter( "userPassword", "" ) );
   p.firstName( sh.getStrParameter( "firstName", "" ) );
   p.lastName( sh.getStrParameter( "lastName", "" ) );
   p.phoneHome( sh.getStrParameter( "phoneHome", "" ) );
   p.phoneMobile( sh.getStrParameter( "phoneMobile", "" ) );
   p.email( sh.getStrParameter( "email", "" ) );
   p.status( sh.getStrParameter( "status", "" ) );
   p.addressStreet( sh.getStrParameter( "addressStreet", "" ) );
   //Allow stateID or stateid
   p.addressState( StateVO.builder().stateID( sh.getIntParameter( "stateID", sh.getIntParameter( "stateid", 0 ) ) ).build() );
   p.addressCountry( sh.getStrParameter( "addressCountry", "USA" ) );
   p.addressPostalcode( sh.getStrParameter( "addressPostalcode", "" ) );
   p.dateOfBirth( sh.getDateParameter( "dateOfBirth", new Date() ) );
   p.userRole( 1 );
   p.dateJoined( sh.getDateParameter( "dateJoined", new Date() ) );
   return p.build();
   // sh.getStrParameter( "", "")
   //phoneHome
//   phoneMobile": null,
//  "email": null,
//  "status": null,
//  "addressStreet": "158 Edge",
//  "addressCity": "BC",
//  "addressState": {
//    "stateID": 2,
//    "stateName": "Pennsylvania",
//    "stateAbbreviation": "PA",
//    "patientList": null
//  },
//  "addressCountry": null,
//  "addressPostalcode": null,
//  "userPreferences": null,
//  "pwdLastChanged": null,
//  "lang": null,
//  "timezoneId": null,
//  "dateOfBirth": null,
//  "dateJoined": "Oct 22, 2016",
//  "picture": null,
//  "metaData": null,
//  "userRole": 1,

}

/**
 * Translate Diary
 *
 * @return
 */
public DiaryVO loadDiaryFromRequest() {
   if ( getCurrentUser() == null ) {
	  System.err.println( "com.medlog.webservice.rest.MedLogControllerStrategy.loadDiaryFromRequest() -- USER NOT LOGGED IN" );
	  return null;
   }
   ServletHelpers sh = new ServletHelpers( request, response );
   DiaryVO.Builder t = DiaryVO.builder();
   t.id( sh.getIntParameter( "id", 0 ) );
   t.notes( sh.getStrParameter( "notes", "" ) );
   t.title( sh.getStrParameter( "title", "" ) );
   t.patientID( getCurrentUser() );
   t.mood( sh.getIntParameter( "mood", 0 ) );
   t.productivity( sh.getIntParameter( "productivity", 0 ) );
   return t.build();
}

/**
 * Retrieves current user object from session
 *
 * @see PatientVO
 * @return Patient or null
 */
private PatientVO getCurrentUser() {
   try {
	  return (PatientVO) session.getAttribute( SESSION_BEAN_USER );
   } catch (Exception e) {
	  return null;
   }
}
/**
 * Request function
 */
private final String fn;
/**
 * Current Request.
 */
private final HttpServletRequest request;
/**
 * Request Resource
 *
 * @see DiaryVO
 * @see PatientVO
 * @see MedicationVO
 * @see PharmaRxOtcVO
 * @see HealthcareProviderVO
 * @see DietaryRestrictionVO
 */
private final RES_ENUM res;
/**
 * Current Response.
 */
private final HttpServletResponse response;
/**
 * Session state.
 */
private final HttpSession session;

}
