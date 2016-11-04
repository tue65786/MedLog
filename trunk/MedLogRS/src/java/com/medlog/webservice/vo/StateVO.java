/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import org.apache.commons.lang3.builder.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class StateVO implements Serializable, IEntityBase<StateVO>,Comparable<StateVO> {

private static final long serialVersionUID = -7661073258202665741L;

   public static StateVO create(final int stateID, final String stateName, final String stateAbbreviation, final List<PatientVO> patientList) {
	  return new StateVO( stateID, stateName, stateAbbreviation, patientList );
   }

   @Override
   public int compareTo(StateVO that) {
	 CompareToBuilder b = new CompareToBuilder();
	b.append( this.getStateName().toLowerCase(), that.getStateName().toLowerCase());
	b.append( this.getStateAbbreviation(), that.getStateAbbreviation());
	return b.build();
   }

   /**
    * @return the patientList
    */
   public List<PatientVO> getPatientList() {
	  return patientList;
   }

   /**
    * @param patientList the patientList to set
    */
   public void setPatientList(List<PatientVO> patientList) {
	  this.patientList = patientList;
   }

   /**
    * @return the stateAbbreviation
    */
   public String getStateAbbreviation() {
	  return stateAbbreviation;
   }

   /**
    * @param stateAbbreviation the stateAbbreviation to set
    */
   public void setStateAbbreviation(String stateAbbreviation) {
	  this.stateAbbreviation = stateAbbreviation;
   }

   /**
    * @return the stateID
    */
   public int getStateID() {
	  return stateID;
   }

   /**
    * @param stateID the stateID to set
    */
   public void setStateID(int stateID) {
	  this.stateID = stateID;
   }

   /**
    * @return the stateName
    */
   public String getStateName() {
	  return stateName;
   }

   /**
    * @param stateName the stateName to set
    */
   public void setStateName(String stateName) {
	  this.stateName = stateName;
   }

   @Override
   public boolean isValid() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public boolean isValid(StateVO _vo) {
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

private int stateID;
private String stateName;
private String stateAbbreviation;
private List<PatientVO> patientList;

   public static class Builder {

   private int stateID;
   private String stateName;
   private String stateAbbreviation;
   private List<PatientVO> patientList;

   private Builder() {
   }

   public Builder stateID(final int value) {
	  this.stateID = value;
	  return this;
   }

   public Builder stateName(final String value) {
	  this.stateName = value;
	  return this;
   }

   public Builder stateAbbreviation(final String value) {
	  this.stateAbbreviation = value;
	  return this;
   }

   public Builder patientList(final List<PatientVO> value) {
	  this.patientList = value;
	  return this;
   }

   public StateVO build() {
	  return StateVO.create( stateID, stateName, stateAbbreviation, patientList );
   }
   }

   public static StateVO.Builder builder() {
	  return new StateVO.Builder();
   }

   private StateVO(final int stateID, final String stateName, final String stateAbbreviation, final List<PatientVO> patientList) {
	  this.stateID = stateID;
	  this.stateName = stateName;
	  this.stateAbbreviation = stateAbbreviation;
	  this.patientList = patientList;
   }


//   public List<HealthcareProvider> healthcareProviderList;
private static final Logger LOG = Logger.getLogger( StateVO.class.getName() );
}
