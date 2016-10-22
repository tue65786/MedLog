/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.CONST;

import com.medlog.webservice.vo.*;

/**
 * SQL Statements
 *
 * @author (c)2016 Dan Kauffman
 */
public class DB_STRINGS {


/**
 * Assign/Unassign patient med.
 * Params:<ol> <li> PatientID int,</li><li>PharmID int,</li><li>PhysicanID
 * int=NULL,</li><li>Instructions nvarchar(max) = NULL,</li><li>Sig varchar(50),</li><li>StartDate
 * date = getdate,</li><li>endDate date = NULL,@active bit = 1</li></ol>
 */
public static final String SP_PATIENT_MEDICATION = "{call spMedicationPatientChangeBinding("
												   + "?,?,?,?,?,"
												   + "?,?,?)}";
/**
 * INSERT PATIENT STORED PROCEDURE.
 * Param:
 * <ol><li>@userName nvarchar(60) = NULL,
 * </li><li>@userPassword nvarchar(30) = NULL,
 * </li><li>@user_hash nvarchar(32) = NULL,
 * </li><li>@firstName nvarchar(30) = NULL,
 * </li><li>@lastName nvarchar(30) = NULL,
 * </li><li>@phoneHome nvarchar(50) = NULL,
 * </li><li>@phoneMobile nvarchar(50) = NULL,
 * </li><li>@email nvarchar(100) = NULL,
 * </li><li>@status nvarchar(25) = NULL,
 * </li><li>@addressStreet nvarchar(150) = NULL,
 * </li><li>@addressCity nvarchar(100) = NULL,
 * </li><li>@addressState int = NULL,
 * </li><li>@address_country nvarchar(25) = NULL,
 * </li><li>@address_postalcode nvarchar(9) = NULL,
 * </li><li>@user_preferences nvarchar(MAX) = NULL,
 * </li><li>@pwd_last_changed datetime = NULL,
 * </li><li>@lang nvarchar(10) = NULL,
 * </li><li>@timezone_id nvarchar(128) = NULL,
 * </li><li>@primary_physsician int = NULL,
 * </li><li>@date_of_birth bit = NULL,
 * </li><li>@date_joined date,
 * </li><li>@picture nvarchar(MAX) = NULL,
 * </li><li>@meta_data xml = NULL,
 * </li><li>@userRole int = NULL
 * , </li><li>@inserted INT OUTPUT</li></ol>
 */
public static final String SP_PATIENT_INSERT = "{call [spPatientInsert]("
											   + "?,?,?,?,?,"
											   + "?,?,?,?,?,"
											   + "?,?,?,?,?,"
											   + "?,?,?,?,?,"
											   + "?,?,?,?,?)}";
/**
 * UPDATE PATIENT STORED PROCEDURE
 */
public static final String SP_PATIENT_UPDATE = "{call [spPatientUpdate](}";
/**
 * SELECT PATIENT STORED PROCEDURE
 */
public static final String SP_PATIENT_SELECT = "{call [spPatientSelect](?,?,?)}";
/**
 * Select Diary Entries<ol><li>Id</li> <li> PatientID int</li><li>Keyword (null)</li></ol>
 */
public static final String SP_DIARY_SELECT = "{call [spDiarySelect](?,?,?)}";
/**
 * Params for Sp.
 * <ol><li> @PatientID
 * </li><li>,@Title
 * </li><li>,@Notes
 * </li><li>,@NotesActivity
 * </li><li>,@createdDate
 * </li><li>,@updatedDate
 * </li><li>,@includce_meds_current
 * </li><li>,@attachmentPath
 * </li><li>,@ratingMood
 * </li><li>,@ratingProductivity
 * </li><li>,@inserted OUTPUT</li></ol>
 */
public static final String SP_DIARY_INSERT = "{call [spDiaryInsert]("
											 + "?,?,?,?,?,"
											 + "?,?,?,?,?,"
											 + "?}";
/**
 * Retrieves all {@linkplain StateVO} objects.
 * Returns in order:  ID, Name, Abbr.
 */
public static final String SP_STATE_SELECT = "{call spStateSelect()}";
/**
 * Do not allow instantiation.
 *
 */
private DB_STRINGS() {

}
}
