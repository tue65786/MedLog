/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.CONST;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class SETTINGS {

/**
 * Global debugging state.. Verbose logging (etc)...
 */
public static final boolean DEBUG = true;
public static final String JDBC_DRIVE_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
/**
 * Name of db property file
 */
public static final String PROPS_FILE = "database.properties";
public static final String CONTEXT_PATH = "MedLogRS";

/**
 * No instantiation.
 */
private SETTINGS() {

}
}
