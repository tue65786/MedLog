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
public class MedicationVO  implements Serializable, IEntityBase<MedicationVO> {

   private static final long serialVersionUID = -1124169927037703504L;

   @Override
   public boolean isValid() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public boolean isValid(MedicationVO _vo) {
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
public Integer medicationID;
public PatientVO patientID;
public PharmaRxOtcVO pharmID;
public HealthcareProviderVO physicianID;
public String instructions;
public SigVO sig;
public Date startDate;
public Date endDate;
public String dosage;
public String frequencySig;
public boolean active;
public List<TagVO> tagList;

//public List<PatientMedication> patientMedicationList;
   private static final Logger LOG = Logger.getLogger( MedicationVO.class.getName() );




}
