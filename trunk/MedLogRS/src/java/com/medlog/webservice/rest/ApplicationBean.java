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
import java.io.*;
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
public class ApplicationBean implements Serializable {
private static final Logger LOG = Logger.getLogger( ApplicationBean.class.getName() );

private static final long serialVersionUID = 3372922617040246869L;

public ApplicationBean(ServletContext context, DbConnection db, MedLogDAO dao) {
   try {
	  try {
		 if ( context.getAttribute( APPLICATION_STATE_BEAN ) != null ) {
			this.statesMap = (Map<Integer, StateVO>) context.getAttribute( APPLICATION_STATE_BEAN );
			stateSet = !statesMap.isEmpty();
		 }
	  } catch (Exception ea) {
		 
	  }
	  try {
		 if ( context.getAttribute( APPLICATION_SIG_BEAN ) != null ) {
			this.sigMap = (Map<String, SigVO>) context.getAttribute( APPLICATION_SIG_BEAN );
			sigSet = !sigMap.isEmpty();
		 }
	  } catch (Exception eb) {
		 
	  }
	  try {
		 if ( context.getAttribute( APPLICATION_RX_BEAN ) != null ) {
			this.rxMap = (Map<Integer, PharmaRxOtcVO>) context.getAttribute( APPLICATION_RX_BEAN ) ;
			rxSet = !rxMap.isEmpty();
		 }
	  } catch (Exception ec) {
		 
	  }
   } catch (Exception e) {
	  
   }
   this.context = context;
   this.db = db;
   this.dao = dao;
}

/**
 * @return the context
 */
public ServletContext getContext() {
   return context;
}

/**
 * @param context the context to set
 */
public void setContext(ServletContext context) {
   this.context = context;
}
public <T extends IEntityBase> ArrayList<T> getList(String name) {
   
   if ( getContext() != null && getContext().getAttribute( name ) != null ) {
	  try {
		 return (ArrayList<T>) getContext().getAttribute( name );
	  } catch (Exception e) {
		 
	  }
   }
   return null;
}
public <T extends IEntityBase> Map<Integer, T> getMap(String name) {
   try {
	  return (Map<Integer, T>) getContext().getAttribute( name );
   } catch (Exception e) {
	  
   }
   return null;
}

/**
 * @return the rxMap
 */
public Map<Integer, PharmaRxOtcVO> getRxMap() {
   return rxMap;
}

/**
 * @param rxmap the rxMap to set
 */
public void setRxMap(Map<Integer, PharmaRxOtcVO> rxmap) {
   this.rxMap = rxmap;
   if (rxMap != null && !rxMap.isEmpty()){
	  setRxSet( true);
   }
   
	
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
   if (sigMap != null && !sigMap.isEmpty()){
	  setSigSet( true);
   }
}

/**
 * @return the statesMap
 */
public Map<Integer, StateVO> getStatesMap() {
   return statesMap;
}

/**
 * @param statesMap the statesMap to set
 */
public void setStatesMap(Map<Integer, StateVO> statesMap) {
   
   this.statesMap = statesMap;
    if (statesMap != null && !statesMap.isEmpty()){
	  setStateSet(true);
   }
}

   /**
    * @return the rxSet
    */
   public boolean isRxSet() {
	  return rxSet;
   }

   /**
    * @param rxSet the rxSet to set
    */
   public void setRxSet(boolean rxSet) {
	  this.rxSet = rxSet;
   }

   /**
    * @return the sigSet
    */
   public boolean isSigSet() {
	  return sigSet;
   }

   /**
    * @param sigSet the sigSet to set
    */
   public void setSigSet(boolean sigSet) {
	  this.sigSet = sigSet;
   }

   /**
    * @return the stateSet
    */
   public boolean isStateSet() {
	  return stateSet;
   }

   /**
    * @param stateSet the stateSet to set
    */
   public void setStateSet(boolean stateSet) {
	  this.stateSet = stateSet;
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


public <T extends IEntityBase> boolean putPut(String name, Map<Integer, T> voMap) {
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


private ServletContext context;
private Map<Integer, PharmaRxOtcVO> rxMap;
private boolean rxSet;
private Map<String, SigVO> sigMap;
private boolean sigSet;
private Map<Integer, StateVO> statesMap;
private boolean stateSet;
private MedLogDAO dao;
private DbConnection db;

}
