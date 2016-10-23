/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.rest.helpers.*;
import com.medlog.webservice.vo.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.http.*;

/**
 * Strategies for connecting to data.
 *
 * @author (c)2016
 */
public class MedLogControllerStrategy {

private static final Logger LOG = Logger.getLogger( MedLogControllerStrategy.class.getName() );
private RES_ENUM res;
private String fn;

public MedLogControllerStrategy(HttpServletRequest _request, HttpServletResponse _response, RES_ENUM res, String fn) {
   this.request = _request;
   this.response = _response;
   this.session = request.getSession();
   this.res = res;
   this.fn = fn;
}

public ArrayList<IEntityBase> getList() {
   ArrayList<IEntityBase> voList = null;
   return voList;
}

public IEntityBase getSingle() {
   return null;
}

/**
 * Translate Diary
 *
 * @return
 */
public DiaryVO transformDiaryFromRequest() {
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

public PatientVO loadMedicationFromRequest() {
   throw new UnsupportedOperationException( "Not supported yet." );
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
 * Current Request.
 */
private final HttpServletRequest request;
/**
 * Current Response.
 */
private final HttpServletResponse response;
/**
 * Session state.
 */
private final HttpSession session;

}
