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

   public static DiaryVO create(final int id, final String title, final String notes, final String notesActivity, final Date createdDate, final Date updatedDate, final String includceMedsCurrent, final String attachmentPath, final int mood, final int productivity, final List<TagVO> tagList, final PatientVO patientID) {
	  return new DiaryVO( id, title, notes, notesActivity, createdDate, updatedDate, includceMedsCurrent, attachmentPath, mood, productivity, tagList, patientID );
   }

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

   public static class Builder {

   private int id;
   private String title;
   private String notes;
   private String notesActivity;
   private Date createdDate;
   private Date updatedDate;
   private String includceMedsCurrent;
   private String attachmentPath;
   private int mood;
   private int productivity;
   private List<TagVO> tagList;
   private PatientVO patientID;

   private Builder() {
   }

   public Builder id(final int value) {
	  this.id = value;
	  return this;
   }

   public Builder title(final String value) {
	  this.title = value;
	  return this;
   }

   public Builder notes(final String value) {
	  this.notes = value;
	  return this;
   }

   public Builder notesActivity(final String value) {
	  this.notesActivity = value;
	  return this;
   }

   public Builder createdDate(final Date value) {
	  this.createdDate = value;
	  return this;
   }

   public Builder updatedDate(final Date value) {
	  this.updatedDate = value;
	  return this;
   }

   public Builder includceMedsCurrent(final String value) {
	  this.includceMedsCurrent = value;
	  return this;
   }

   public Builder attachmentPath(final String value) {
	  this.attachmentPath = value;
	  return this;
   }

   public Builder mood(final int value) {
	  this.mood = value;
	  return this;
   }

   public Builder productivity(final int value) {
	  this.productivity = value;
	  return this;
   }

   public Builder tagList(final List<TagVO> value) {
	  this.tagList = value;
	  return this;
   }

   public Builder patientID(final PatientVO value) {
	  this.patientID = value;
	  return this;
   }

   public DiaryVO build() {
	  return DiaryVO.create( id, title, notes, notesActivity, createdDate, updatedDate, includceMedsCurrent, attachmentPath, mood, productivity, tagList, patientID );
   }
   }

   public static DiaryVO.Builder builder() {
	  return new DiaryVO.Builder();
   }

   private DiaryVO(final int id, final String title, final String notes, final String notesActivity, final Date createdDate, final Date updatedDate, final String includceMedsCurrent, final String attachmentPath, final int mood, final int productivity, final List<TagVO> tagList, final PatientVO patientID) {
	  this.id = id;
	  this.title = title;
	  this.notes = notes;
	  this.notesActivity = notesActivity;
	  this.createdDate = createdDate;
	  this.updatedDate = updatedDate;
	  this.includceMedsCurrent = includceMedsCurrent;
	  this.attachmentPath = attachmentPath;
	  this.mood = mood;
	  this.productivity = productivity;
	  this.tagList = tagList;
	  this.patientID = patientID;
   }

}
