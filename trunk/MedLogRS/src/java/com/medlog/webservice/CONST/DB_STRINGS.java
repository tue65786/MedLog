/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.medlog.webservice.CONST;

/**
 * SQL Statements
 * @author (c)2016 Dan Kauffman
 */
public class DB_STRINGS {
/**
 * Do not allow instantiation.
 * 
 */
/**
 * INSERT PATIENT STORED PROCEDURE
 */
public static final String SP_PATIENT_INSERT = "{call spPatientInsert("
						   + "?,?,?,?,?,"
						   + "?,?,?,?,?,"
						   + "?,?,?,?,?,"
						   + "?,?,?,?,?,?"
						   + ",?,?,?)}";
/**
 * UPDATE PATIENT STORED PROCEDURE
 */
public static final String SP_PATIENT_UPDATE = "{call spPatientUpdate(}";
/**
 * SELECT PATIENT STORED PROCEDURE
 */
public static final String SP_PATIENT_SELECT = "{call spPatientSelect(?,?,?)}";
private DB_STRINGS(){
   
}
}
