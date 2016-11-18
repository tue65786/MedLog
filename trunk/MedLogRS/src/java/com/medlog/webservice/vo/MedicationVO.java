/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import com.google.gson.*;
import static com.medlog.webservice.CONST.API_ACTIONS.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import org.apache.commons.lang3.builder.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class MedicationVO implements Serializable, IEntityBase<MedicationVO>,Comparable<MedicationVO> {

private static final long serialVersionUID = -1124169927037703504L;

public static MedicationVO create(final int medicationID, final PatientVO patientID, final PharmaRxOtcVO pharmID, final HealthcareProviderVO physicianID, final String instructions, final SigVO sig, final Date startDate, final Date endDate, final String dosage, final String frequencySig, final boolean active, final List<TagVO> tagList) {
   return new MedicationVO( medicationID, patientID, pharmID, physicianID, instructions, sig, startDate, endDate, dosage, frequencySig, active, tagList );
}

   @Override
   public int compareTo(MedicationVO that) {
	  CompareToBuilder ctb = new CompareToBuilder();
	  ctb.append( this.getMedicationID(), that.getMedicationID());
	  try{
	  ctb.append( this.getPharmID().getPharmID(), that.getPharmID().getPharmID());
	  }catch(Exception e){
		 
	  }
	  return ctb.build();
   }

   @Override
   public boolean equals(Object obj) {
	  if ( this == obj ) {
		 return true;
	  }
	  if ( obj == null ) {
		 return false;
	  }
	  if ( getClass() != obj.getClass() ) {
		 return false;
	  }
	  final MedicationVO other = (MedicationVO) obj;
	  if ( this.medicationID != other.medicationID  && this.medicationID > 0) {
		 return false;
	  }
	  
	  return true;
   }

/**
 * @return the dosage
 */
public String getDosage() {
   return dosage;
}

/**
 * @param dosage the dosage to set
 */
public void setDosage(String dosage) {
   this.dosage = dosage;
}

/**
 * @return the endDate
 */
public Date getEndDate() {
   return endDate;
}

/**
 * @param endDate the endDate to set
 */
public void setEndDate(Date endDate) {
   this.endDate = endDate;
}

/**
 * @return the frequencySig
 */
public String getFrequencySig() {
   return frequencySig;
}

/**
 * @param frequencySig the frequencySig to set
 */
public void setFrequencySig(String frequencySig) {
   this.frequencySig = frequencySig;
}

/**
 * @return the instructions
 */
public String getInstructions() {
   return instructions;
}

/**
 * @param instructions the instructions to set
 */
public void setInstructions(String instructions) {
   this.instructions = instructions;
}

/**
 * @return the medicationID
 */
public int getMedicationID() {
   return medicationID;
}

/**
 * @param medicationID the medicationID to set
 */
public void setMedicationID(int medicationID) {
   this.medicationID = medicationID;
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
 * @return the pharmID
 */
public PharmaRxOtcVO getPharmID() {
   return pharmID;
}

/**
 * @param pharmID the pharmID to set
 */
public void setPharmID(PharmaRxOtcVO pharmID) {
   this.pharmID = pharmID;
}

/**
 * @return the physicianID
 */
public HealthcareProviderVO getPhysicianID() {
   return physicianID;
}

/**
 * @param physicianID the physicianID to set
 */
public void setPhysicianID(HealthcareProviderVO physicianID) {
   this.physicianID = physicianID;
}

/**
 * @return the sig
 */
public SigVO getSig() {
   if (sig == null ){
	  sig = SigVO.builder().sigAbbrID( "prn").build();
   }
   return sig;
}

/**
 * @param sig the sig to set
 */
public void setSig(SigVO sig) {
   this.sig = sig;
}

/**
 * @return the startDate
 */
public Date getStartDate() {
   return startDate;
}

/**
 * @param startDate the startDate to set
 */
public void setStartDate(Date startDate) {
   this.startDate = startDate;
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

   @Override
   public int hashCode() {
	  int hash = 3;
	  hash = 61 * hash + this.medicationID;
	  hash = 61 * hash + Objects.hashCode( this.patientID );
	  hash = 61 * hash + Objects.hashCode( this.pharmID );
	  hash = 61 * hash + Objects.hashCode( this.sig );
	  hash = 61 * hash + Objects.hashCode( this.dosage );
	  return hash;
   }

/**
 * @return the active
 */
public boolean isActive() {
   return active;
}

/**
 * @param active the active to set
 */
public void setActive(boolean active) {
   this.active = active;
}

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
   if ( _ACTION != INSERT ) {
	  if (this.pharmID == null ){
		 return false;
	  }
	  
   }
   return true;
}

   /**
    * Json representation of obj.
    * @return
    */
   @Override
public String toJSON() {
   return new GsonBuilder()
		   .serializeNulls()
		   .setPrettyPrinting()
		   .create()
		   .toJson( this );

}

@Override
public String toTableRow() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}
private int medicationID;
private PatientVO patientID;
/**
 * Name of medication
 */
private PharmaRxOtcVO pharmID;
private HealthcareProviderVO physicianID;
private String instructions;
private SigVO sig;//use or not!
private Date startDate;
private Date endDate;
private String dosage;
private String frequencySig;
private boolean active;
private List<TagVO> tagList;

public static class Builder {

private int medicationID;
private PatientVO patientID;
private PharmaRxOtcVO pharmID;
private HealthcareProviderVO physicianID;
private String instructions;
private SigVO sig;
private Date startDate;
private Date endDate;
private String dosage;
private String frequencySig;
private boolean active;
private List<TagVO> tagList;

private Builder() {
}

public Builder medicationID(final int value) {
   this.medicationID = value;
   return this;
}

public Builder patientID(final PatientVO value) {
   this.patientID = value;
   return this;
}

public Builder pharmID(final PharmaRxOtcVO value) {
   this.pharmID = value;
   return this;
}

public Builder physicianID(final HealthcareProviderVO value) {
   this.physicianID = value;
   return this;
}

public Builder instructions(final String value) {
   this.instructions = value;
   return this;
}

public Builder sig(final SigVO value) {
   this.sig = value;
   return this;
}

public Builder startDate(final Date value) {
   this.startDate = value;
   return this;
}

public Builder endDate(final Date value) {
   this.endDate = value;
   return this;
}

public Builder dosage(final String value) {
   this.dosage = value;
   return this;
}

public Builder frequencySig(final String value) {
   this.frequencySig = value;
   return this;
}

public Builder active(final boolean value) {
   this.active = value;
   return this;
}

public Builder tagList(final List<TagVO> value) {
   this.tagList = value;
   return this;
}

public MedicationVO build() {
   return MedicationVO.create( medicationID, patientID, pharmID, physicianID, instructions, sig, startDate, endDate, dosage, frequencySig, active, tagList );
}
}

public static MedicationVO.Builder builder() {
   return new MedicationVO.Builder();
}

private MedicationVO(final int medicationID, final PatientVO patientID, final PharmaRxOtcVO pharmID, final HealthcareProviderVO physicianID, final String instructions, final SigVO sig, final Date startDate, final Date endDate, final String dosage, final String frequencySig, final boolean active, final List<TagVO> tagList) {
   this.medicationID = medicationID;
   this.patientID = patientID;
   this.pharmID = pharmID;
   this.physicianID = physicianID;
   this.instructions = instructions;
   this.sig = sig;
   this.startDate = startDate;
   this.endDate = endDate;
   this.dosage = dosage;
   this.frequencySig = frequencySig;
   this.active = active;
   this.tagList = tagList;
}

//public List<PatientMedication> patientMedicationList;
private static final Logger LOG = Logger.getLogger( MedicationVO.class.getName() );

}
