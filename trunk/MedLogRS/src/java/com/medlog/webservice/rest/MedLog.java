/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import com.google.gson.*;
import com.medlog.webservice.CONST.*;
import com.medlog.webservice.rest.helpers.*;
import com.medlog.webservice.util.*;
import com.medlog.webservice.vo.*;
import java.io.IOException;
import java.io.PrintWriter;
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
   response.setContentType( "application/json" );
   ServletHelpers sh;
   HttpSession session = null;
   String fn = null;
   PatientVO currentUser = null;
   Gson gson = null;
   try (PrintWriter out = response.getWriter()) {

	  sh = new ServletHelpers( request, response );
	  session = request.getSession();

	  fn = sh.getStrParameter( "fn", "" );
	  currentUser = getCurrentUser( session );

	  //Valid login functions
	  if ( currentUser == null && ( fn.equalsIgnoreCase( "login" ) || fn.equalsIgnoreCase( "findPatient" ) ) ) {
		 //Security Controller
	  } else if ( fn.equalsIgnoreCase( "logout" ) ) {

	  } else //		 currentUser = getCurrentUser( session );
	  //Check for saved user cred.
	  {
		 if ( currentUser == null ) {
			out.print( makeJSONErrorMsg( "Not logged in." ) );
		 } else//User is Logged in
		 {
			if ( StrUtl.matchOR( fn, API_ACTIONS.PATIENT_API ) ) {

			} else if ( StrUtl.matchOR( fn, API_ACTIONS.DIARY_API ) ) {

			} else {
			   out.print( makeJSONErrorMsg( "Invalid function." ) );
			}
		 }
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
 * Attempts to retrieve user from session.
 *
 * @param session
 * @return
 */
private PatientVO getCurrentUser(HttpSession session) {
   if ( session != null && session.getAttribute( "user" ) != null ) {
	  try {
		 return (PatientVO) session.getAttribute( "user" );
	  } catch (Exception e) {
		 return null;
	  }
   }
   return null;

}

/**
 * Creates error-state response
 *
 * @param msg message.
 * @return JSON
 */
private String makeJSONErrorMsg(String msg) {
   return getJSONMsg( "error", msg );
}

/**
 * Create info-state response
 *
 * @param msg message
 * @return JSON
 */
private String makeJSONInfoMsg(String msg) {
   return getJSONMsg( "info", msg );
}

private String getJSONMsg(String state, String msg) {
   JsonObject json = new JsonObject();
   json.addProperty( "state", StrUtl.toS( state ) );
   json.addProperty( "message", StrUtl.toS( msg, state.equals( "error" ) ? "Something went wrong!" : "Unknown" ) );
   return json.toString();
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
public String getServletInfo() {
   return "Short description";
}// </editor-fold>

}
