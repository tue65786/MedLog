/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * 
 */
public class TagVO implements Serializable, IEntityBase<TagVO> {
public int id;
public String tagName;
public List<DiaryVO> diaryList;
//private List<Activity> activityList;
public List<MedicationVO> medicationList;
public PatientVO patientID;
private static final long serialVersionUID = -7405606046370227038L;

@Override
public boolean isValid() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean isValid(TagVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean isValid(int _ACTION) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public String toJSON() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public String toTableRow() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}
private static final Logger LOG = Logger.getLogger( TagVO.class.getName() );

}
