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
 * Assign/Unassign patient med.
 * Params:<ol> <li> PatientID int,</li><li>PharmID int,</li><li>PhysicanID int=NULL,</li><li>Instructions nvarchar(max) = NULL,</li><li>Sig varchar(50),</li><li>StartDate date = getdate,</li><li>endDate date = NULL,@active bit = 1</li></ol>
 */
public static final String SP_PATIENT_MEDICATION = "{call spMedicationPatientChangeBinding(?,?,?,?,?,?,?,?)}";
/**
 * INSERT PATIENT STORED PROCEDURE
 */
public static final String SP_PATIENT_INSERT = "{call [spPatientInsert]("
						   + "?,?,?,?,?,"
						   + "?,?,?,?,?,"
						   + "?,?,?,?,?,"
						   + "?,?,?,?,?,?"
						   + ",?,?,?)}";
/**
 * UPDATE PATIENT STORED PROCEDURE
 */
public static final String SP_PATIENT_UPDATE = "{call [spPatientUpdate](}";
/**
 * SELECT PATIENT STORED PROCEDURE
 */
public static final String SP_PATIENT_SELECT = "{call [spPatientSelect](?,?,?)}";
public static final String SP_DIARY_INSERT = "{call [spDiaryInsert](?,?,?,?,?,?,?,?,?,?,?}";
private DB_STRINGS(){
   
}
}
