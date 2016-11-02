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
											 + "?)}";

//  CREATE_PROCEDURE - dbo.spPatientDietaryRestrictionChangeBinding
//  CREATE_PROCEDURE - dbo.spDietaryRestrictionSelect
//  CREATE_PROCEDURE - dbo.spDietaryRestrictionInsert
//  CREATE_PROCEDURE - dbo.spDietaryRestrictionUpdate
//  CREATE_PROCEDURE - dbo.spDietaryRestrictionDelete
/**
 * Select Diary Entries<ol><li>Id</li> <li> PatientID int</li><li>Keyword (null)</li></ol>
 */
public static final String SP_DIARY_SELECT = "{call [spDiarySelect](?,?,?)}";
/**
 * Select Healthcare provider Entries <b>Params:</b><ol><li>DoctorId int</li> <li> PatientID
 * int</li><li>Keyword
 * (null)</li></ol>
 * <b>Result Set</b>
 * <ol><li> [PhysicianID]
 * </li><li>	[lastname]
 * </li><li>	[firstname]
 * </li><li>	[specialty]
 * </li><li>	[phoneWork]
 * </li><li>	[phoneMobile]
 * </li><li>	[phonePager]
 * </li><li>	[phoneFax]
 * </li><li>	[email]
 * </li><li>	[pathient_log_communication_preference]
 * </li><li>	[addressStreet]
 * </li><li>	[addressCity]
 * </li><li>	[addressStateID]
 * </li><li>	[addressZip]</li></ol>
 */
public static final String SP_HEALTHCAREPROVIDER_SELECT = "{call [spHealthcareProviderSelect](?,?,?)}";
/**
 * Params:
 * <ol>
 * <li> @lastname nvarchar (max)
 * </li><li>@firstname nvarchar (max)
 * </li><li>@specialty nvarchar (256) = NULL
 * </li><li>@phoneWork nvarchar (256) =''
 * </li><li>@phoneMobile nvarchar (256) = NULL
 * </li><li>@phonePager varbinary (50) = NULL
 * </li><li>@phoneFax nchar (10) = NULL
 * </li><li>@email nvarchar (256) = NULL
 * </li><li>@pathient_log_communication_preference varchar (20) = NULL
 * </li><li>@addressStreet nvarchar (512) = NULL
 * </li><li>@addressCity nvarchar (128) = NULL
 * </li><li>@addressStateID int = NULL
 * </li><li>@addressZip varchar (10) = NULL
 * </li><li> @inserted int OUTPUT</li></ol>
 *
 * @see HealthcareProviderVO
 */
public static final String SP_HEALTHCARE_INSERT = "{call [dbo].[spHealthcareProviderInsert]("
												  + "?,?,?,?,?,"
												  + "?,?,?,?,?,"
												  + "?,?,?,?)}";
/**
 * Update {@linkplain HealthcareProviderVO}
 * Params:
 * <ol><li> @PATIENTID int </li>
 * <li> @lastname nvarchar (max)
 * </li><li>@firstname nvarchar (max)
 * </li><li>@specialty nvarchar (256) = NULL
 * </li><li>@phoneWork nvarchar (256) =''
 * </li><li>@phoneMobile nvarchar (256) = NULL
 * </li><li>@phonePager varbinary (50) = NULL
 * </li><li>@phoneFax nchar (10) = NULL
 * </li><li>@email nvarchar (256) = NULL
 * </li><li>@pathient_log_communication_preference varchar (20) = NULL
 * </li><li>@addressStreet nvarchar (512) = NULL
 * </li><li>@addressCity nvarchar (128) = NULL
 * </li><li>@addressStateID int = NULL
 * </li><li>@addressZip varchar (10) = NULL
 * </li></ol>
 *
 * @see HealthcareProviderVO
 */
public static final String SP_HEALTHCARE_UPDATE = "{call [dbo].[spHealthcareProviderUpdate]("
												  + "?,?,?,?,?,"
												  + "?,?,?,?,?,"
												  + "?,?,?,?)}";
/**
 * <ol><li>@PatientID int
 * </li><li>@PharmID int
 * </li><li>@PhysicanID int = NULL
 * </li><li>@Instructions nvarchar (max) = NULL
 * </li><li>@Sig varchar (50) = NULL
 * </li><li>@StartDate date = getdate
 * </li><li>@endDate date = NULL
 * </li><li>@active bit = 1 <i>Set to 0 to delete</i></li></ol>
 */
public static final String SP_MEDICATION_CHANGE_BINDING = "{call  [spMedicationPatientChangeBinding]("
														  + "?,?,?,?,?,"
														  + "?,?,?)}";
/**
 * Param
 * * <ol><li>MedID <i>null</i>
 * </li><li>PatientID <b>Req</b></li></ol>
 * Result
 * <ol> <li>[MedicationID]
 * </li><li>	[PatientID]
 * </li><li>	[PharmID]
 * </li><li>	[PhysicianID]
 * </li><li>	[Instructions]
 * </li><li>	[Sig]
 * </li><li>	[StartDate]
 * </li><li>	[EndDate]
 * </li><li>	[Dosage]
 * </li><li>	[FrequencySig]
 * </li><li>	[Active]</li></ol>
 */
public static final String SP_MEDICATION_SELECT = "{call [spMedicationSelect](?,?)}";
/**
 * Assigns / Removes {@linkplain PatientVO} to/from {@linkplain HealthcareProviderVO}
 * Params: <ol>
 * <li>PatientID</li>
 * <li>HealthCareID</li>
 * <li>Assign?</li>
 * </ol>
 *
 * @see PatientVO
 * @see HealthcareProviderVO
 */
public static final String SP_PATIENT_HEALTHCARE_CHANGEBINDING = "{call dbo.[spPatientChangeHealthCareProviderBinding](?,?,?)}";
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
 * SELECT PATIENT STORED PROCEDURE
 */
public static final String SP_PATIENT_SELECT = "{call [spPatientSelect](?,?,?)}";
/**
 * UPDATE PATIENT STORED PROCEDURE
 *
 *
 *
 *
 *
 *
 *
 *
 * <ol><li>@PatientID int
 * </li><li>@userPassword nvarchar (30) = NULL
 * </li><li>@firstName nvarchar (30) = NULL
 * </li><li>@lastName nvarchar (30) = NULL
 * </li><li>@phoneHome nvarchar (50) = NULL
 * </li><li>@phoneMobile nvarchar (50) = NULL
 * </li><li>@email nvarchar (100) = NULL
 * </li><li>@addressStreet nvarchar (150) = NULL
 * </li><li>@addressCity nvarchar (100) = NULL
 * </li><li>@addressState int = NULL
 * </li><li>@address_country nvarchar (25) = NULL
 * </li><li>@address_postalcode nvarchar (9) = NULL
 * </li><li>@date_of_birth date = NULL</li></ol>
 */
public static final String SP_PATIENT_UPDATE = "{call [spPatientUpdate]("
											   + "?,?,?,?,?,"
											   + "?,?,?,?,?,"
											   + "?,?,?"
											   + ")}";
/**
 * Insert Phar/Otc Record
 * <ol><li>@MedType varchar (16) = NULL
 * </li><li>@RXCUI varchar (8)
 * </li><li>@GENERIC_RXCUI varchar (8) = NULL
 * </li><li>@TTY varchar (20)
 * </li><li>@FULL_NAME varchar (3000)
 * </li><li>@RXN_DOSE_FORM varchar (100)
 * </li><li>@FULL_GENERIC_NAME varchar (3000)
 * </li><li>@BRAND_NAME varchar (500) = NULL
 * </li><li>@DISPLAY_NAME varchar (3000)
 * </li><li>@ROUTE varchar (100)
 * </li><li>@NEW_DOSE_FORM varchar (100)
 * </li><li>@STRENGTH varchar (500)
 * </li><li>@SUPPRESS_FOR varchar (30) = NULL
 * </li><li>@DISPLAY_NAME_SYNONYM varchar (500) = NULL
 * </li><li>@IS_RETIRED varchar (8) = NULL
 * </li><li>@SXDG_RXCUI varchar (8) = NULL
 * </li><li>@SXDG_TTY varchar (20) = NULL
 * </li><li>@SXDG_NAME varchar (3000) = NULL
 * </li><li>@PSN varchar (3000) = NULL
 * </li><li> @inserted int OUTPUT</li></ol>
 *
 * @see PharmaRxOtcVO
 */
public static final String SP_PHARM_INSERT = "{call [spPharma_RX_OTCInsert]("
											 + "?,?,?,?,?,"
											 + "?,?,?,?,?,"
											 + "?,?,?,?,?,"
											 + "?,?,?,?,?)}";
/**
 * @keyword nvarchar (128)
 * , @pageNum int = 1
 * , @pageSize int = 100
 * , @onlyMyRX bit = 0
 * , @PatientID int = 2--null
 */
public static final String SP_PHARM_SEARCH = "{call [[spPharma_RX_OTCSearch](?,?,?,?,?)}";
public static final String SP_PHARM_SELECT = "{call [spPharma_RX_OTCSelect](?,?)}";
/**
 * Params:
 * <ol><li>PharmID <i>null</i>
 * </li><li>PatientID <b>Req</b></li></ol>
 * Result set order:
 * <ol><li>ROW_NUMBER() OVER (ORDER BY DISPLAY_NAME,STRENGTH) AS Row
 * </li><li>d.PharmID
 * </li><li>d.MedType
 * </li><li>d.RXCUI
 * --</li><li>d.GENERIC_RXCUI
 * </li><li>d.TTY
 * </li><li>d.DISPLAY_NAME
 * </li><li>d.STRENGTH</li></ol>
 */
public static final String SP_PHARM_SELECT_SHORT = "{call [spPharma_RX_OTCSelectShort](?,?)}";
/**
 * SigID
 */
public static final String SP_SIGS_SELECT = "{call [spSigSelect](?)}";
/**
 * Retrieves all {@linkplain StateVO} objects.
 * Returns in order: ID, Name, Abbr.
 */
public static final String SP_STATE_SELECT = "{call spStateSelect()}";

/**
 * Do not allow instantiation.
 *
 */
private DB_STRINGS() {

}
}
