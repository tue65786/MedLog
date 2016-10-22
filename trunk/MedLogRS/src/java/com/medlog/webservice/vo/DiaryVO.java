/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import com.medlog.webservice.CONST.*;
import static com.medlog.webservice.CONST.API_ACTIONS.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class DiaryVO implements Serializable, IEntityBase<DiaryVO> {

private static final long serialVersionUID = -2971191299069097176L;

@Override
public boolean isValid() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean isValid(DiaryVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

   /**
    * Validates DiaryVO Object.
    * @param _ACTION {@linkplain API_ACTIONS#INSERT} does not validate ID.
    * @return 
	* @see API_ACTIONS#INSERT
	* @see API_ACTIONS#DELETE
    */
   @Override
public boolean isValid(int _ACTION) {
   if ( this.patientID == null || this.patientID.getPatientID() <= 0 ) {
	  return false;
   }
   if ( _ACTION != INSERT ) {
	  if ( this.id <= 0 ) {
		 return false;
	  }
   } else {
	  if ( ( this.mood * this.productivity == 0 ) ) {
	  return false;
   }
	  if (this.notes.isEmpty()){
		 return false;
	  }
	  
   }
   return true;
}

@Override
public String toJSON() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public String toTableRow() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}
public int id;//1
public String title; //2
public String notes;
public String notesActivity;//4
public Date createdDate;
public Date updatedDate;
public String includceMedsCurrent;
public String attachmentPath;
public int mood;
public int productivity;

public List<TagVO> tagList;
public PatientVO patientID;
private static final Logger LOG = Logger.getLogger( DiaryVO.class.getName() );

}
