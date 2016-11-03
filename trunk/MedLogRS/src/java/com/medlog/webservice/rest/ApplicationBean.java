/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.dao.*;
import com.medlog.webservice.sql.*;
import com.medlog.webservice.util.*;
import com.medlog.webservice.vo.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.*;
import org.apache.catalina.core.*;
import org.apache.commons.collections4.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class ApplicationBean {

DbConnection db;
MedLogDAO dao;

public ApplicationBean(ServletContext _context, DbConnection db, MedLogDAO dao) {
   this.context = _context;
   this.db = db;
   this.dao = dao;
}

public synchronized void setApplicationStores() {

   if ( context.getAttribute( APPLICATION_STATE_BEAN ) == null ) {
	  context.setAttribute( APPLICATION_STATE_BEAN, dao.findAllStates( true ) );
   }

   if ( context.getAttribute( APPLICATION_SIG_BEAN ) == null ) {

   }

}

/**
 * Puts list in application
 *
 * @param <T>
 * @param name
 * @param voList
 * @return
 */
public <T extends IEntityBase> boolean putList(String name, ArrayList<T> voList) {
   return true;

}

/**
 * Puts single VO in application
 *
 * @param <T>
 * @param name
 * @param vo
 * @return
 */
public <T extends IEntityBase> boolean putSingle(String name, T vo) {
   return true;
}

public <T extends IEntityBase> boolean putPut(String name, Map<Integer, T> voMap) {
   return true;

}

public <T extends IEntityBase> Map<Integer, T> getMap(String name) {
   try {
	  return (Map<Integer, T>) context.getAttribute( name );
   } catch (Exception e) {

   }
   return null;
}

public <T extends IEntityBase> ArrayList<T> getList(String name) {

   if ( context != null && context.getAttribute( name ) != null ) {
	  try {
		 return (ArrayList<T>) context.getAttribute( name );
	  } catch (Exception e) {

	  }
   }
   return null;
}



ServletContext context;

private static final Logger LOG = Logger.getLogger( ApplicationBean.class.getName() );

}
