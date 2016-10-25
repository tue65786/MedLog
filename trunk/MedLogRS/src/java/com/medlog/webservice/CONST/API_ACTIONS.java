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
public static final int DELETE = 4;
/**
 * Valid {@linkplain PatientVO} API Functions
 */
public static final String[] STATE_STATUS = { "error", "info" };
public static final int ERROR = 0;
public static final int INFO = 1;
/**
 * Valid {@linkplain DiaryVO} API functions
 */

public static final String API_PARAM_RESOURCE = "res";
public static final String API_RESOURCE_DIARY = "d";
public static final String API_RESOURCE_HEALTHCARE_PROVIDER = "h";
public static final String API_RESOURCE_MEDICATION = "m";
public static final String API_RESOURCE_PATIENT = "p";
public static final String API_RESOURCE_DIATARY_RESTRICTION = "r";

public static final String API_PARAM_FUNCTION = "fn";
public static final String API_FUNCTION_FIND = "find";
public static final String API_FUNCTION_FIND_BY_KEYWORD = "findByKeyword";
public static final String API_FUNCTION_FIND_BY_ID = "findByID";
public static final String API_FUNCTION_INSERT = "add";
public static final String API_FUNCTION_UPDATE = "update";
public static final String API_FUNCTION_ASSIGN = "assign";
public static final String API_FUNCTION_UNASSIGN = "unassign";
public static final String API_FUNCTION_DELETE = "delete";

/**
 * No instantiation
 */
private API_ACTIONS() {
   //
}
}
