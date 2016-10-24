/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import static com.medlog.webservice.CONST.API_ACTIONS.*;
import com.medlog.webservice.util.*;
import com.medlog.webservice.vo.*;

/**
 * API Resources and Valid Functions
 *
 * @author Dan
 */
public enum RES_ENUM {

/**
 * Valid {@linkplain DiaryVO} API functions
 */
API_RESOURCE_DIARY( "d", new String[]{ API_FUNCTION_FIND,
									   API_FUNCTION_FIND_BY_KEYWORD,
									   API_FUNCTION_INSERT,
									   API_FUNCTION_UPDATE,
									   API_FUNCTION_DELETE
} ),
/**
 * Valid {@linkplain HealthcareProviderVO Health-care Provider} API Function
 */
API_RESOURCE_HEALTHCARE_PROVIDER( "h", new String[]{ API_FUNCTION_ASSIGN,
													 API_FUNCTION_UNASSIGN,
													 API_FUNCTION_INSERT,
													 API_FUNCTION_UPDATE,
													 API_FUNCTION_FIND,
													 API_FUNCTION_FIND_BY_KEYWORD,
													 API_FUNCTION_DELETE } ),
/**
 * Valid Medication API Function
 */
API_RESOURCE_MEDICATION( "m", new String[]{ API_FUNCTION_ASSIGN,
											API_FUNCTION_UNASSIGN,
											API_FUNCTION_FIND,
											API_FUNCTION_FIND_BY_KEYWORD,
											API_FUNCTION_INSERT,
											API_FUNCTION_UPDATE, } ),
/**
 * {@linkplain PatientVO Patient} Resource Functions
 *
 * @see PatientVO
 */
API_RESOURCE_PATIENT( "p", new String[]{ API_FUNCTION_INSERT,
										 API_FUNCTION_UPDATE,
										 API_FUNCTION_DELETE,
										 API_FUNCTION_FIND_BY_ID
} ),
API_RESOURCE_DIATARY_RESTRICTION( "r", new String[]{ "", "" } );

RES_ENUM(String rCode, String[] validFunction) {
   RESOURCE_Code = rCode;
   VALID_Functions = validFunction;
}

public final String getCode() {
   return RESOURCE_Code;
}

public boolean isValidFunction(String fn) {
   return StrUtl.matchOR( fn, VALID_Functions );
}

private final String RESOURCE_Code;
private final String[] VALID_Functions;

}
