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
 * Translate3 Diary
 *
 * @return
 */
public DiaryVO transformDiaryFromRequest() {
   if ( getCurrentUser() == null ) {
	  System.err.println( "com.medlog.webservice.rest.MedLogControllerStrategy.loadDiaryFromRequest() -- USER NOT LOGGED IN" );
	  return null;
   }
   ServletHelpers sh = new ServletHelpers( request, response );
   DiaryVO.Builder transformer = DiaryVO.builder();
   transformer.id( sh.getIntParameter( "id", 0 ) );
   transformer.notes( sh.getStrParameter( "notes", "" ) );
   transformer.title( sh.getStrParameter( "title", "" ) );
   transformer.patientID( getCurrentUser() );
   transformer.mood( sh.getIntParameter( "mood", 0 ) );
   transformer.productivity( sh.getIntParameter( "productivity", 0 ) );
   return transformer.build();
}

public PatientVO loadMedicationFromRequest() {
   throw new UnsupportedOperationException( "Not supported yet." );
}

public PatientVO loadPatientFromRequest() {
   throw new UnsupportedOperationException( "Not supported yet." );
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
