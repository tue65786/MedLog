/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import com.medlog.webservice.CONST.*;
import static com.medlog.webservice.CONST.API_ACTIONS.*;
import com.medlog.webservice.util.*;
import com.medlog.webservice.vo.*;
import java.util.*;
import org.apache.commons.lang3.builder.*;

/**
 * API Resources and Valid Functions
 *
 * @author Dan
 */
public enum RES_ENUM {

/**
 * Valid {@linkplain DiaryVO} API functions
 */
API_RESOURCE_DIARY( API_ACTIONS.API_RESOURCE_DIARY, new String[]{ API_FUNCTION_FIND,
																  API_FUNCTION_FIND_BY_KEYWORD,
																  API_FUNCTION_FIND_BY_ID,
																  API_FUNCTION_INSERT,
																  API_FUNCTION_UPDATE,
																  API_FUNCTION_DELETE
} ),
API_RESOURCE_DIATARY_RESTRICTION( API_ACTIONS.API_RESOURCE_DIATARY_RESTRICTION, new String[]{ API_FUNCTION_ASSIGN, API_FUNCTION_UNASSIGN,API_FUNCTION_FIND } ),
/**
 * Valid {@linkplain HealthcareProviderVO Health-care Provider} API Function
 */
API_RESOURCE_HEALTHCARE_PROVIDER( API_ACTIONS.API_RESOURCE_HEALTHCARE_PROVIDER, new String[]{ API_FUNCTION_ASSIGN,
																							  API_FUNCTION_UNASSIGN,
																							  API_FUNCTION_INSERT,
																							  API_FUNCTION_UPDATE,
																							  API_FUNCTION_FIND,
																							  API_FUNCTION_FIND_BY_KEYWORD,
																							  API_FUNCTION_FIND_BY_ID,
																							  API_FUNCTION_DELETE } ),
/**
 * Medication API Resource Functions
 *
 * @see MedicationVO
 * @see PharmaRxOtcVO
 */
API_RESOURCE_MEDICATION( API_ACTIONS.API_RESOURCE_MEDICATION, new String[]{ API_FUNCTION_ASSIGN,
																			API_FUNCTION_UNASSIGN,
																			API_FUNCTION_FIND } ),
/**
 * {@linkplain PatientVO Patient} Resource Functions
 *
 * @see PatientVO
 */
API_RESOURCE_PATIENT( API_ACTIONS.API_RESOURCE_PATIENT, new String[]{ API_FUNCTION_INSERT,
																	  API_FUNCTION_UPDATE,
																	  API_FUNCTION_DELETE,
																	  API_FUNCTION_FIND,
																	  API_FUNCTION_FIND_BY_ID
} ),
API_RESOURCE_PHARM( API_ACTIONS.API_RESOURCE_PHARM, new String[]{ API_FUNCTION_INSERT,
																  API_FUNCTION_UPDATE,
																  API_FUNCTION_FIND,
																  API_FUNCTION_FIND_BY_ID } ),
/**
 * {@linkplain StateVO} Lookup Resource Functions.
 *
 * @see StateVO
 */
API_RESOURCE_STATES( API_ACTIONS.API_RESOURCE_STATES, new String[]{ API_FUNCTION_FIND,
																	API_FUNCTION_FIND_BY_ID } ),
API_RESOURCE_SIG( API_ACTIONS.API_RESOURCE_SIG, new String[]{ API_FUNCTION_FIND,
															  API_FUNCTION_FIND_BY_ID } ),


INVALID( "-", new String[]{ API_FUNCTION_LOGIN } );

/**
 * Constructs Resource ENUM
 *
 * @param rCode         Request param value
 * @param validFunction validFunctions list
 */
RES_ENUM(String rCode, String[] validFunction) {
   RESOURCE_Code = rCode;
   VALID_Functions = validFunction;
}

public final String getCode() {
   return RESOURCE_Code;
}

/**
 * List of valid functions for resource
 *
 * @return csv
 */
public final String getValidFunctions() {
   return Arrays.toString( VALID_Functions );
}

/**
 * Tranform
 *
 * @param k
 * @return
 */
public static RES_ENUM findByChar(String k) {
   for ( RES_ENUM e : values() ) {
	  if ( k.equals( e.getCode() ) ) {
		 return e;
	  }
   }
   return INVALID;
}

public boolean isValidFunction(String fn) {
   return StrUtl.matchOR( fn, VALID_Functions );
}

/**
 * Funtion requires login
 *
 * @param fn
 * @return
 */
public boolean isLoginRequired(String fn) {
   boolean a = this.getCode().compareTo( "p" ) + fn.compareTo( API_FUNCTION_INSERT ) == 0;
   return !( a ||  StrUtl.matchOR( true, fn.equals( API_FUNCTION_LOGIN ), fn.equals( API_FUNCTION_LOGOUT ) ));
}

@Override
public String toString() {

   return "{\"" + name() + "\":{\"" + RESOURCE_Code + "\":\"{functions\":" + getValidFunctions() + "}}}" + ( this.equals( INVALID ) ? "" : "," );
}

private final String RESOURCE_Code;
private final String[] VALID_Functions;

}
