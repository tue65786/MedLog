/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.util;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class PropUtils {

/**
 * No instantiation.
 */
private PropUtils() {
}
/**
 * Read properties file into properties object.
 * @param fileName source file
 * @return POJO 
 */
public static Properties getFromClassPath(String fileName) {
   Properties properties = new Properties();
   try {
	  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	  properties.load( classLoader.getResourceAsStream( fileName ) );
   } catch (IOException ex) {
	  LOG.log( Level.SEVERE, null, ex );
	  ex.printStackTrace();
   }

   return properties;
}
/**
 * Retrieves value from prop file
 * @param properties prop
 * @param key look up
 * @return  value
 */
public static String getValue(Properties properties, String key) {
   if ( properties == null || key == null || key.isEmpty() ) {
	  LOG.warning( "Key not found or properties are null.");
	  return "";
   }
   return properties.getProperty( key, "" );
}
private static final Logger LOG = Logger.getLogger( PropUtils.class.getName() );
}
