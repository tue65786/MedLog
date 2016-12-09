/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.CONST;

import com.medlog.webservice.lifecycle.Security;
import com.medlog.webservice.rest.*;
import com.medlog.webservice.rest.helpers.ServletHelpers;
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
 *
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

    /**
     *API Action Delete
     */
    public static final int DELETE = 4;
/**
 * Valid {@linkplain PatientVO} API Functions
 */
public static final String[] STATE_STATUS = { "error", "info" };

    /**
     * API status error
     */
    public static final int ERROR = 0;

    /**
     * APi status INFO
     */
    public static final int INFO = 1;
/**
 * Valid {@linkplain DiaryVO} API functions
 */

public static final String API_PARAM_RESOURCE = "res";

    /**
     *Diary Resource
     * @see DiaryVO
     * @see DiaryAnalysisVO
     * 
     * @see RES_ENUM#API_RESOURCE_DIARY
     */
    public static final String API_RESOURCE_DIARY = "d";

    /**
     * Health Provider Resource Key
     * @see  HealthcareProviderVO
     * @see RES_ENUM#API_RESOURCE_HEALTHCARE_PROVIDER
     */
    public static final String API_RESOURCE_HEALTHCARE_PROVIDER = "h";

    /**
     * Medication Resource
     * @see MedicationVO
     * @see MedTypeVO
     * @see RES_ENUM#API_RESOURCE_MEDICATION
     */
    public static final String API_RESOURCE_MEDICATION = "m";

    /**
     *Patient Resource
     * @see PatientVO
     * @see Security
     * @see RES_ENUM#API_RESOURCE_PATIENT
     */
    public static final String API_RESOURCE_PATIENT = "p";
/**
 * PharmRX Resource
 * @see RES_ENUM#API_RESOURCE_PHARM
 */
public static final String API_RESOURCE_PHARM = "ph";
/**
 * Dietary Resource
 * @see RES_ENUM
 */
public static final String API_RESOURCE_DIATARY_RESTRICTION = "f";
/**
 * 
 * SHARED LIST OF STATES
 * @see RES_ENUM#API_RESOURCE_STATES
 */
public static final String API_RESOURCE_STATES = "s";
/**
 * SHARED LIST OF SIGS
 * @see RES_ENUM
 */
public static final String API_RESOURCE_SIG = "g";

    /**
     * Resource Function Param
     * @see ServletHelpers
     */
    public static final String API_PARAM_FUNCTION = "fn";

    /**
     *
     */
    public static final String API_FUNCTION_FIND = "find";

    /**
     *
     */
    public static final String API_FUNCTION_FIND_BY_KEYWORD = "findByKeyword";

    /**
     *
     */
    public static final String API_FUNCTION_FIND_BY_ID = "findByID";

    /**
     *
     */
    public static final String API_FUNCTION_INSERT = "add";

    /**
     *
     */
    public static final String API_FUNCTION_UPDATE = "update";

    /**
     *
     */
    public static final String API_FUNCTION_ASSIGN = "assign";

    /**
     *
     */
    public static final String API_FUNCTION_UNASSIGN = "unassign";

    /**
     *
     */
    public static final String API_FUNCTION_DELETE = "delete";

    /**
     *
     */
    public static final String API_FUNCTION_LOGIN = "login";

    /**
     *
     */
    public static final String API_FUNCTION_LOGOUT = "logout";

/**
 * No instantiation
 */
private API_ACTIONS() {
   //
}
}
