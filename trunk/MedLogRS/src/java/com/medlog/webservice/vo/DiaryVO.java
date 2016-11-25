/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.medlog.webservice.CONST.*;
import static com.medlog.webservice.CONST.API_ACTIONS.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.util.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.util.Date;
import org.apache.commons.lang3.builder.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class DiaryVO implements Serializable, IEntityBase<DiaryVO> {

private static final long serialVersionUID = -2971191299069097176L;

public static DiaryVO create(final int id, final String title, final String notes, final String notesActivity, final Date createdDate, final Date updatedDate, final String includeMedsCurrent, final String attachmentPath, final int mood, final int productivity, final List<TagVO> tagList, final PatientVO patientID) {
   return new DiaryVO( id, title, notes, notesActivity, createdDate, updatedDate, includeMedsCurrent, attachmentPath, mood, productivity, tagList, patientID );
}


/**
 * @return the attachmentPath
 */
public String getAttachmentPath() {
   return StrUtl.toS(attachmentPath);
}

/**
 * @param attachmentPath the attachmentPath to set
 */
public void setAttachmentPath(String attachmentPath) {
   this.attachmentPath = attachmentPath;
}

/**
 * @return the createdDate
 */
public Date getCreatedDate() {
   return createdDate != null ? createdDate : new Date(new java.util.Date().getTime());
}

/**
 * @param createdDate the createdDate to set
 */
public void setCreatedDate(Date createdDate) {
   this.createdDate = createdDate;
}

/**
 * @return the id
 */
public int getId() {
   return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
   this.id = id;
}

/**
 * @return the includceMedsCurrent
 */
public String getIncludeMedsCurrent() {
   return StrUtl.toS(includeMedsCurrent);
}

/**
 * @param includceMedsCurrent the includceMedsCurrent to set
 */
public void setIncludeMedsCurrent(String includeMedsCurrent) {
   this.includeMedsCurrent = includeMedsCurrent;
}

/**
 * @return the mood
 */
public int getMood() {
   return mood;
}

/**
 * @param mood the mood to set
 */
public void setMood(int mood) {
   this.mood = mood;
}

/**
 * @return the notes
 */
public String getNotes() {
   return StrUtl.toS( notes );
}

/**
 * @param notes the notes to set
 */
public void setNotes(String notes) {
   this.notes = notes;
}

/**
 * @return the notesActivity
 */
public String getNotesActivity() {
   return StrUtl.toS( notesActivity );
}

/**
 * @param notesActivity the notesActivity to set
 */
public void setNotesActivity(String notesActivity) {
   this.notesActivity = notesActivity;
}

/**
 * @return the patientID
 */
public PatientVO getPatientID() {
   return patientID;
}

/**
 * @param patientID the patientID to set
 */
public void setPatientID(PatientVO patientID) {
   this.patientID = patientID;
}

/**
 * @return the productivity
 */
public int getProductivity() {
   return productivity;
}

/**
 * @param productivity the productivity to set
 */
public void setProductivity(int productivity) {
   this.productivity = productivity;
}

   /**
    * @return the row
    */
   public int getRow() {
	  return row;
   }

   /**
    * @param row the row to set
    */
   public void setRow(int row) {
	  this.row = row;
   }

/**
 * @return the tagList
 */
public List<TagVO> getTagList() {
   return tagList;
}

/**
 * @param tagList the tagList to set
 */
public void setTagList(List<TagVO> tagList) {
   this.tagList = tagList;
}

/**
 * @return the title
 */
public String getTitle() {
   return title;
}

/**
 * @param title the title to set
 */
public void setTitle(String title) {
   this.title = title;
}

/**
 * @return the updatedDate
 */
public Date getUpdatedDate() {
   return updatedDate;
}

/**
 * @param updatedDate the updatedDate to set
 */
public void setUpdatedDate(Date updatedDate) {
   this.updatedDate = updatedDate;
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
 *
 * @param _ACTION {@linkplain API_ACTIONS#INSERT} does not validate ID.
 * @return
 * @see API_ACTIONS#INSERT
 * @see API_ACTIONS#DELETE
 */
@Override
public boolean isValid(int _ACTION) {
   if ( this.getPatientID() == null || this.getPatientID().getPatientID() <= 0 ) {
	  if ( DEBUG ) {
		 LOG.warning( "Diary: PatientID invalid" );
	  }
	  return false;
   }
   if ( _ACTION != INSERT ) {
	  if ( this.getId() <= 0 ) {
		 if ( DEBUG ) {
			LOG.warning( "Diary: ID invalid" );
		 }
		 return false;
	  }
   } else {
	  if ( ( this.getMood() * this.getProductivity() == 0 ) ) {
		 if ( DEBUG ) {
			LOG.warning( "Diary: mood/prod invalid" );
		 }
		 return false;
	  }
	  if ( this.getNotes().isEmpty() ) {
		 return false;
	  }

   }
   return true;
}

@Override
public String toJSON() {
   return new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").excludeFieldsWithoutExposeAnnotation().create().toJson( this );
}

   @Override
   public String toString() {
	ToStringBuilder  tsb = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
	return tsb.build();
   }

@Override
public String toTableRow() {//(\"[, =A-Za-z\"]+)(\"[, =A-Za-z\"]+)
    return  "<tr><td>"+ id + "</td><td>"+ StrUtl.truncateAtWord(title,30) + "</td><td>"+ StrUtl.truncateAtWord( getNotes(), 40) + "</td><td>"+ StrUtl.getDateWithFormat( createdDate ) + "</td><td>"+ mood + "</td><td>"+ productivity + "</td><td >"+ patientID + "</td></tr>";
   
   
   
}
@Expose(deserialize = true,serialize = true)
private int id;//1

@Expose(deserialize = true,serialize = true)
private String title; //2

@Expose(deserialize = true,serialize = true)
private String notes;

@Expose(deserialize = true,serialize = true)
private String notesActivity;//4

@Expose(deserialize = true,serialize = true)
private Date createdDate;

@Expose(deserialize = true,serialize = true)
private Date updatedDate;

@Expose(deserialize = true,serialize = true)
private String includeMedsCurrent;

@Expose(deserialize = true,serialize = true)
private String attachmentPath;

@Expose(deserialize = true,serialize = true)
private int mood;

@Expose(deserialize = true,serialize = true)
private int productivity;
private List<TagVO> tagList;
@Expose(deserialize = true,serialize = false)
private PatientVO patientID;

@Expose(deserialize = true,serialize = true)
private int row = 0;
private static final Logger LOG = Logger.getLogger( DiaryVO.class.getName() );

public static class Builder {

private int id;
private String title;
private String notes;
private String notesActivity;
private Date createdDate;
private Date updatedDate;
private String includeMedsCurrent;
private String attachmentPath;
private int mood;
private int productivity;
private List<TagVO> tagList;  //no
private PatientVO patientID; //no

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

public Builder includeMedsCurrent(final String value) {
   this.includeMedsCurrent = value;
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
   return DiaryVO.create( id, title, notes, notesActivity, createdDate, updatedDate, includeMedsCurrent, attachmentPath, mood, productivity, tagList, patientID );
}
public DiaryVO build(int ct) {
  DiaryVO vo =   DiaryVO.create( id, title, notes, notesActivity, createdDate, updatedDate, includeMedsCurrent, attachmentPath, mood, productivity, tagList, patientID );
  vo.setRow( ct );
  return vo;
}
   }

public static DiaryVO.Builder builder() {
   return new DiaryVO.Builder();
}

private DiaryVO(final int id, final String title, final String notes, final String notesActivity, final Date createdDate, final Date updatedDate, final String includeMedsCurrent, final String attachmentPath, final int mood, final int productivity, final List<TagVO> tagList, final PatientVO patientID) {
   this.id = id;
   this.title = title;
   this.notes = notes;
   this.notesActivity = notesActivity;
   this.createdDate = createdDate;
   this.updatedDate = updatedDate;
   this.includeMedsCurrent = includeMedsCurrent;
   this.attachmentPath = attachmentPath;
   this.mood = mood;
   this.productivity = productivity;
   this.tagList = tagList;
   this.patientID = patientID;
}

}
