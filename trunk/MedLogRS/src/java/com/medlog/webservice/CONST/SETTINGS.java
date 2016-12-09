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
public static final int LENGTH_OF_JOURNAL = 2048;
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
 * Map<Integer,StateVO> stored in {@linkplain ServletContext} 
 * @see StateVO
 * 
 */
public static final String APPLICATION_STATE_BEAN = "com.medlog.webservice.vo.StateVO";
public static final String APPLICATION_SIG_BEAN = "com.medlog.webservice.vo.SigVO";
public static final String APPLICATION_RX_BEAN = "com.medlog.webservice.vo.PharmaRXOtcVO";
public static final String APPLICATION_DR_BEAN = "com.medlog.webservice.vo.HealthcareProviderVO";
/**
 * API  Credentials. Valud for 30 days beginning 11.25.16
 */
public static final String WATSON_USER = "d2f6715f-5baf-4420-bd22-a9a87854c7b1";
/**
 * Valid 30days + 11/26/30  
 */
//{
//  "url": "https://gateway.watsonplatform.net/personality-insights/api",
//  "password": "K8gDBEtxhIjX",
//  "username": "850e4164-6c83-416d-b356-9ad6bac09fa1"
//}
public static final String WATSON_PASS = "oOxW06RaXCCE";
    public static final String FLDR_APIDOC = "apidoc";
/**
 * No instantiation.
 */
private SETTINGS() {

}
}
