/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.CONST;

import com.medlog.webservice.vo.*;

/**
 * MedLog web service application settings.
 * @author DK
 */
public class SETTINGS {
/**
 * Context Path
 */
public static final String CONTEXT_PATH = "MedLogRS";
/**
 * Standard date format
 */
public static final String DATE_FORMAT = "yyyy-MM-dd";
/**
 * Standard Err result code
 */
public static final int DB_ERROR_CODE  = -1;

/**
 * Global debugging state.. Verbose logging (etc)...
 */
public static final boolean DEBUG = true;
public static final boolean TEST_MODE=true; 
/**
 * JDBC Driver Class
 */
public static final String JDBC_DRIVE_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
/**
 * Name of db property file
 */
public static final String PROPS_FILE = "database.properties";
/**
 * Session JavaBan for current user.
 * @see PatientVO
 */
public static final String SESSION_BEAN_USER = "user" ;
/**
 * No instantiation.
 */
private SETTINGS() {

}
}
