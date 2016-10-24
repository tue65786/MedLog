/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import com.google.gson.*;
import com.medlog.webservice.CONST.*;
import static com.medlog.webservice.CONST.API_ACTIONS.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.dao.*;
import static com.medlog.webservice.rest.RES_ENUM.*;
import com.medlog.webservice.rest.helpers.*;
import com.medlog.webservice.sql.*;
import com.medlog.webservice.util.*;
import com.medlog.webservice.vo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Primary API Servlet
 *
 * @author (c)2016
 */
public class MedLog extends HttpServlet {

/**
 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
 *
 * @param request  servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException      if an I/O error occurs
 */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
//   response.setContentType( "text/html;charset=UTF-8" );
   response.setContentType( "application/json;charset=UTF-8" );
   ServletHelpers sh;
   HttpSession session = null;
   String fn = null; //Action
   String res = null;//Entity
   PatientVO currentUser = null;
   Gson gson = null;
   MedLogDAO dao = null;
   DbConnection db = new DbConnection();
   try (PrintWriter out = response.getWriter()) {
	  sh = new ServletHelpers( request, response );
	  session = request.getSession();

	  //Get Request Function
	  fn = sh.getStrParameter( API_PARAM_FUNCTION, "" );
	  res = sh.getStrParameter( API_PARAM_RESOURCE, "" );
	  currentUser = getCurrentUser( session );
	  //Valid login functions
	  if ( /*
			   * currentUser == null &&
			   */ ( fn.equalsIgnoreCase( "login" ) /*
					 * || fn.equalsIgnoreCase( "findPatient" )
					 */ ) ) {

		 dao = new MedLogDAO( db, currentUser );
		 PatientVO userVO = dao.findPatientByPatientNameAndPassword(
				 sh.getStrParameter( "username", "" ),
				 sh.getStrParameter( "password", "" ) );

		 if ( userVO != null ) {
			currentUser = PatientVO.newInstance( userVO );
			if ( DEBUG ) {
			   gson = new GsonBuilder().setPrettyPrinting().
					   setDateFormat( DATE_FORMAT ).
					   serializeNulls().
					   create();
			} else {
			   gson = new GsonBuilder().
					   setDateFormat( DATE_FORMAT ).
					   create();
			}
			//Print current user and store it to session,
			out.print( gson.toJson( userVO ) );
			session.setAttribute( SESSION_BEAN_USER, currentUser );
		 } else {
			out.print( makeJSONErrorMsg( "Invalid login." ) );
		 }

		 //Security Controller
	  } else if ( fn.equalsIgnoreCase( "logout" ) ) {
		 session.removeAttribute( SESSION_BEAN_USER );
		 out.print( makeJSONInfoMsg( "User logged out." ) );

	  } else if ( currentUser == null ) {//Check for saved user cred.
		 out.print( makeJSONErrorMsg( "Not logged in." ) );
	  } else { //User is Logged in
		 dao = new MedLogDAO( db, currentUser );
		 switch ( res ) {
			case API_ACTIONS.API_RESOURCE_DIARY:
			   if ( RES_ENUM.API_RESOURCE_DIARY.isValidFunction( fn ) ) {

			   }
			   break;
			case API_ACTIONS.API_RESOURCE_HEALTHCARE_PROVIDER:
			   break;
			case API_ACTIONS.API_RESOURCE_MEDICATION:
			   break;
			case API_ACTIONS.API_RESOURCE_PATIENT:
			   if ( RES_ENUM.API_RESOURCE_PATIENT.isValidFunction( fn ) ) {

			   }
			   break;
			case API_ACTIONS.API_RESOURCE_DIATARY_RESTRICTION:
			   break;
			default:
			   out.print( makeJSONErrorMsg( "Invalid function." ) );
			   break;
		 }
	  }
   } finally {
	  try {
		 db.close();
	  } catch (Exception e) {
	  }
   }
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request  servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException      if an I/O error occurs
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
   processRequest( request, response );
}

/**
 * Handles the HTTP <code>POST</code> method.
 *
 * @param request  servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException      if an I/O error occurs
 */
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
   processRequest( request, response );
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
public String getServletInfo() {
   return "MedLog API";
}// </editor-fold>

/**
 * Attempts to retrieve user from session.
 *
 * @param session
 * @return
 */
private PatientVO getCurrentUser(HttpSession session) {
   if ( session != null && session.getAttribute( SESSION_BEAN_USER ) != null ) {
	  try {
		 return (PatientVO) session.getAttribute( SESSION_BEAN_USER );
	  } catch (Exception e) {
		 return null;
	  }
   }
   return null;

}

/**
 * Set states list
 *
 * @param request
 */
private ArrayList<StateVO> getStatesList(HttpServletRequest request) {
   boolean setStates = true;
   ArrayList<StateVO> states = null;
   try {
	  states = (ArrayList<StateVO>) request.getServletContext().getAttribute( "states" );
	  setStates = states.isEmpty();

   } catch (Exception e) {
	  setStates = true;
   }
   if ( setStates ) {
	  //POPULATE STATES
   }
   return states;
}

/**
 * Creates error-state response
 *
 * @param msg message.
 * @return JSON
 */
private String makeJSONErrorMsg(String msg) {
   if ( DEBUG ) {
	  LOG.severe( msg );
   }
   return StrUtl.getJSONMsg( "error", msg );
}

/**
 * Create info-state response
 *
 * @param msg message
 * @return JSON
 */
private String makeJSONInfoMsg(String msg) {
   if ( DEBUG ) {
	  LOG.info( msg );
   }
   return StrUtl.getJSONMsg( "info", msg );
}

private static final Logger LOG = Logger.getLogger( MedLog.class.getName() );

}
