/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.CONST;

import com.medlog.webservice.vo.*;
import java.util.logging.*;

/**
 * <b>Contents</b>
 *
 * <ol>
 * <li>API Constants</li>
 * <li>HTTP Methods</li>
 * <li>API Functions</li>
 * </ol>
 * @author (c)2016
 */
public class API_ACTIONS {

/**
 * HTTP Method Code: GET.
 */
public static final int GET = 1;
/**
 * HTTP Method Code: PUT/INSERT.
 */
public static final int INSERT = 2;
/**
 * HTTP Method Code: PUSH/UPDATE.
 */
public static final int UPDATE = 3;
public static final int DELETE  = 4;
/**
 * Valid {@linkplain PatientVO} API Functions
 */
public static final String[] PATIENT_API = { "findPatients", "updatePatient", "addPatient" };
/**
 * Valid {@linkplain DiaryVO} API functions
 */
public static final String[] DIARY_API = { "findDiary", "addDiary", "updateDiary" };
/**
 * Valid Health-care Provider API Function
 */
public static final String[] HEALTHCAREPROVIDER_API = { "find", "add", "update","assign" };
/**
 * Valid Medication API Function
 */
public static final String[] MEDICATION_API = { "find", "add", "update","assign" };
public static final String API_PARAM_RESOURCE = "res";
public static final String API_PARAM_FUNCTION = "fn";

public static final String API_RESOURCE_DIARY = "d";
public static final String API_RESOURCE_HEALTHCARE_PROVIDER = "h";
public static final String API_RESOURCE_MEDICATION = "m";
public static final String API_RESOURCE_PATIENT = "p";
public static final String API_RESOURCE_DIATARY_RESTRICTION = "r";


/**
 * No instantiation
 */
private API_ACTIONS() {
   //
}
}