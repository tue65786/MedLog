/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.rest.helpers.*;
import com.medlog.webservice.vo.*;
import java.util.logging.*;
import javax.servlet.http.*;

/**
 * Strategies for connecting to data.
 *
 * @author (c)2016
 */
public class MedLogControllerStrategy {

private static final Logger LOG = Logger.getLogger( MedLogControllerStrategy.class.getName() );

public MedLogControllerStrategy(HttpServletRequest _request, HttpServletResponse _response) {
   this.request = _request;
   this.response = _response;
   this.session = request.getSession();
}

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

public DiaryVO loadDiaryFromRequest() {
   if ( getCurrentUser() == null ) {
	  System.err.println( "com.medlog.webservice.rest.MedLogControllerStrategy.loadDiaryFromRequest() -- USER NOT LOGGED IN" );
	  return null;
   }
   ServletHelpers sh = new ServletHelpers( request, response );
   DiaryVO.Builder builder = DiaryVO.builder();
   
   builder.notes( sh.getStrParameter( "notes", "" ) );
   builder.title( sh.getStrParameter( "title", "" ) );
   builder.patientID( getCurrentUser() );
   builder.mood( sh.getIntParameter( "mood", 0 ) );
   builder.productivity( sh.getIntParameter( "productivity", 0 ) );
   return builder.build();
}

public PatientVO loadPatientFromRequest(){
   throw new UnsupportedOperationException( "Not supported yet." );
}

public PatientVO loadMedicationFromRequest(){
   throw new UnsupportedOperationException( "Not supported yet." );
}
}
