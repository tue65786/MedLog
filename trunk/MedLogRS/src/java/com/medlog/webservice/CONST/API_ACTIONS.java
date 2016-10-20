/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.CONST;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class API_ACTIONS {

public static final int GET = 1;
public static final int INSERT = 2;
public static final int UPDATE = 3;
public static final String[] PATIENT_API = {"findPatients","updatePatient","addPatient"};
public static final String[] DIARY_API =  {"findDiary","addDiary","updateDiary"};

private API_ACTIONS() {
   //No instantiation
}
}
