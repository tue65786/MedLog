/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.medlog.webservice.rest;

import com.medlog.webservice.vo.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.*;
import org.apache.catalina.core.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class ApplicationBean {

   public ApplicationBean(ServletContext _context) {
	  this.context = _context;
   }
/**
 * Puts list in application
 * @param <T>
 * @param name
 * @param voList
 * @return 
 */
   public  <T extends IEntityBase>  boolean putList(String name,ArrayList<T> voList){
	  return true;
	  
   }
   /**
	* Puts single VO in application
	* @param <T>
	* @param name
	* @param vo
	* @return 
	*/
   public  <T extends IEntityBase>  boolean putSingle(String name,T vo){
	  return true;
   }
   
    public  <T extends IEntityBase>  boolean putPut(String name,Map<Integer,T> voMap){
	  return true;
	  
   }
   public <T extends IEntityBase> Map<Integer,T> getMap(String name){
	   try {
			return  (Map<Integer, T>) context.getAttribute( name );
		 }
		 catch(Exception e){
			
		 }
	   return null;
   }
   public <T extends IEntityBase> ArrayList<T> getList(String name){
	  
	  if (context != null && context.getAttribute( name ) != null){
		 try {
			return (ArrayList<T>) context.getAttribute( name );
		 }
		 catch(Exception e){
			
		 }
	  }
	  return null;
   }
   
ServletContext context;

   private static final Logger LOG = Logger.getLogger( ApplicationBean.class.getName() );



}
