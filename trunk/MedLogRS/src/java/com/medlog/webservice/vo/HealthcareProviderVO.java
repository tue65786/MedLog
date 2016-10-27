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
public class HealthcareProviderVO implements Serializable, IEntityBase<HealthcareProviderVO> {

private static final long serialVersionUID = -6426975328081170068L;
/**
 * Factory method.
 * @param physicianID
 * @param lastName
 * @param firstName
 * @param specialty
 * @param phoneWork
 * @param phoneMobile
 * @param phonePager
 * @param phoneFax
 * @param email
 * @param patientLogCommunicationPreference
 * @param addressStreet
 * @param addressCity
 * @param addressZip
 * @param patientList
 * @param addressStateID
 * @return 
 */
   public static HealthcareProviderVO create(final int physicianID, final String lastName, final String firstName, final String specialty, final String phoneWork, final String phoneMobile, final byte[] phonePager, final String phoneFax, final String email, final String patientLogCommunicationPreference, final String addressStreet, final String addressCity, final String addressZip, final List<PatientVO> patientList, final StateVO addressStateID) {
	  return new HealthcareProviderVO( physicianID, lastName, firstName, specialty, phoneWork, phoneMobile, phonePager, phoneFax, email, patientLogCommunicationPreference, addressStreet, addressCity, addressZip, patientList, addressStateID );
   }

@Override
public boolean isValid() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean isValid(HealthcareProviderVO _vo) {
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
public int physicianID;
public String lastName;
public String firstName;
public String specialty;
public String phoneWork;
public String phoneMobile;
public byte[] phonePager;
public String phoneFax;
public String email;
public String patientLogCommunicationPreference;
public String addressStreet;
public String addressCity;
public String addressZip;
public List<PatientVO> patientList;
public StateVO addressStateID;

   public static class Builder {

   private int physicianID;
   private String lastName;
   private String firstName;
   private String specialty;
   private String phoneWork;
   private String phoneMobile;
   private byte[] phonePager;
   private String phoneFax;
   private String email;
   private String patientLogCommunicationPreference;
   private String addressStreet;
   private String addressCity;
   private String addressZip;
   private List<PatientVO> patientList;
   private StateVO addressStateID;

   private Builder() {
   }

   public Builder physicianID(final int value) {
	  this.physicianID = value;
	  return this;
   }

   public Builder lastName(final String value) {
	  this.lastName = value;
	  return this;
   }

   public Builder firstName(final String value) {
	  this.firstName = value;
	  return this;
   }

   public Builder specialty(final String value) {
	  this.specialty = value;
	  return this;
   }

   public Builder phoneWork(final String value) {
	  this.phoneWork = value;
	  return this;
   }

   public Builder phoneMobile(final String value) {
	  this.phoneMobile = value;
	  return this;
   }

   public Builder phonePager(final byte[] value) {
	  this.phonePager = value;
	  return this;
   }

   public Builder phoneFax(final String value) {
	  this.phoneFax = value;
	  return this;
   }

   public Builder email(final String value) {
	  this.email = value;
	  return this;
   }

   public Builder patientLogCommunicationPreference(final String value) {
	  this.patientLogCommunicationPreference = value;
	  return this;
   }

   public Builder addressStreet(final String value) {
	  this.addressStreet = value;
	  return this;
   }

   public Builder addressCity(final String value) {
	  this.addressCity = value;
	  return this;
   }

   public Builder addressZip(final String value) {
	  this.addressZip = value;
	  return this;
   }

   public Builder patientList(final List<PatientVO> value) {
	  this.patientList = value;
	  return this;
   }

   public Builder addressStateID(final StateVO value) {
	  this.addressStateID = value;
	  return this;
   }

   public HealthcareProviderVO build() {
	  return HealthcareProviderVO.create( physicianID, lastName, firstName, specialty, phoneWork, phoneMobile, phonePager, phoneFax, email, patientLogCommunicationPreference, addressStreet, addressCity, addressZip, patientList, addressStateID );
   }
   }
/**
 * Builder
 * @return Builder factory 
 */
   public static HealthcareProviderVO.Builder builder() {
	  return new HealthcareProviderVO.Builder();
   }

   private HealthcareProviderVO(final int physicianID, final String lastName, final String firstName, final String specialty, final String phoneWork, final String phoneMobile, final byte[] phonePager, final String phoneFax, final String email, final String pathientLogCommunicationPreference, final String addressStreet, final String addressCity, final String addressZip, final List<PatientVO> patientList, final StateVO addressStateID) {
	  this.physicianID = physicianID;
	  this.lastName = lastName;
	  this.firstName = firstName;
	  this.specialty = specialty;
	  this.phoneWork = phoneWork;
	  this.phoneMobile = phoneMobile;
	  this.phonePager = phonePager;
	  this.phoneFax = phoneFax;
	  this.email = email;
	  this.patientLogCommunicationPreference = patientLogCommunicationPreference;
	  this.addressStreet = addressStreet;
	  this.addressCity = addressCity;
	  this.addressZip = addressZip;
	  this.patientList = patientList;
	  this.addressStateID = addressStateID;
   }

private static final Logger LOG = Logger.getLogger( HealthcareProviderVO.class.getName() );
}
