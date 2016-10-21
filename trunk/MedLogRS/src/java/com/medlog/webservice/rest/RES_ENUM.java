/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import com.medlog.webservice.util.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public enum RES_ENUM {
API_RESOURCE_DIARY("d",new String[]{"",""})
,API_RESOURCE_HEALTHCARE_PROVIDER("h",new String[]{"",""})
,API_RESOURCE_MEDICATION("m",new String[]{"",""})
,API_RESOURCE_PATIENT("p",new String[]{"",""})
,API_RESOURCE_DIATARY_RESTRICTION("r",new String[]{"",""});
//,// = "d";
//API_RESOURCE_HEALTHCARE_PROVIDER("d",new String{"",""}),//= "h";
//API_RESOURCE_MEDICATION("d",new String[]{"",""})// = "m";
//API_RESOURCE_PATIENT("d",new String[]{"","")},// = "p";
//API_RESOURCE_DIATARY_RESTRICTION("d",new String[]{"",""})// = "r";

RES_ENUM(String rCode, String[] validFunction){
  RESOURCE_Code = rCode;
VALID_Functions = validFunction;
}
public final String getCode(){
   return RESOURCE_Code;
}

public boolean isValidFunction(String fn){
   return StrUtl.matchOR( fn, VALID_Functions );
}

 private final String RESOURCE_Code;
 private  final String[] VALID_Functions;


}
