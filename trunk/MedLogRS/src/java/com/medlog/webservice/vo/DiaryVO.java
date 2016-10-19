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

@Override
public String toJSON() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public String toTableRow() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}
public int id;

public String title;

public String notes;

public String notesActivity;

public Date createdDate;

public Date updatedDate;

public String includceMedsCurrent;

public String attachmentPath;

public int mood;

public int productivity;

//   public List<Tag> tagList;
public PatientVO patientID;
private static final Logger LOG = Logger.getLogger( DiaryVO.class.getName() );

}
