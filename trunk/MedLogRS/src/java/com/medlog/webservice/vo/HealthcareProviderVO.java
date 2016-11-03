/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import static com.medlog.webservice.CONST.API_ACTIONS.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import org.apache.commons.lang3.builder.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class HealthcareProviderVO implements Serializable, IEntityBase<HealthcareProviderVO> {

private static final long serialVersionUID = -6426975328081170068L;

/**
 * Factory method.
 *
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

/**
 * @return the addressCity
 */
public String getAddressCity() {
   return addressCity;
}

/**
 * @param addressCity the addressCity to set
 */
public void setAddressCity(String addressCity) {
   this.addressCity = addressCity;
}

/**
 * @return the addressStateID
 */
public StateVO getAddressStateID() {
   if ( addressStateID == null || addressStateID.getStateID() <= 0 ) {
	  addressStateID = StateVO.create( 2, "Pa", "", null );
   }
   return addressStateID;
}

/**
 * @param addressStateID the addressStateID to set
 */
public void setAddressStateID(StateVO addressStateID) {
   this.addressStateID = addressStateID;
}

/**
 * @return the addressStreet
 */
public String getAddressStreet() {
   return addressStreet;
}

/**
 * @param addressStreet the addressStreet to set
 */
public void setAddressStreet(String addressStreet) {
   this.addressStreet = addressStreet;
}

/**
 * @return the addressZip
 */
public String getAddressZip() {
   return addressZip;
}

/**
 * @param addressZip the addressZip to set
 */
public void setAddressZip(String addressZip) {
   this.addressZip = addressZip;
}

/**
 * @return the email
 */
public String getEmail() {
   return email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
   this.email = email;
}

/**
 * @return the firstName
 */
public String getFirstName() {
   return firstName;
}

/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
   this.firstName = firstName;
}

/**
 * @return the lastName
 */
public String getLastName() {
   return lastName;
}

/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
   this.lastName = lastName;
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
 * @return the patientLogCommunicationPreference
 */
public String getPatientLogCommunicationPreference() {
   return patientLogCommunicationPreference;
}

/**
 * @param patientLogCommunicationPreference the patientLogCommunicationPreference to set
 */
public void setPatientLogCommunicationPreference(String patientLogCommunicationPreference) {
   this.patientLogCommunicationPreference = patientLogCommunicationPreference;
}

/**
 * @return the phoneFax
 */
public String getPhoneFax() {
   return phoneFax;
}

/**
 * @param phoneFax the phoneFax to set
 */
public void setPhoneFax(String phoneFax) {
   this.phoneFax = phoneFax;
}

/**
 * @return the phoneMobile
 */
public String getPhoneMobile() {
   return phoneMobile;
}

/**
 * @param phoneMobile the phoneMobile to set
 */
public void setPhoneMobile(String phoneMobile) {
   this.phoneMobile = phoneMobile;
}

/**
 * @return the phonePager
 */
public byte[] getPhonePager() {
   return phonePager;
}

/**
 * @param phonePager the phonePager to set
 */
public void setPhonePager(byte[] phonePager) {
   this.phonePager = phonePager;
}

/**
 * @return the phoneWork
 */
public String getPhoneWork() {
   return phoneWork;
}

/**
 * @param phoneWork the phoneWork to set
 */
public void setPhoneWork(String phoneWork) {
   this.phoneWork = phoneWork;
}

/**
 * @return the physicianID
 */
public int getPhysicianID() {
   return physicianID;
}

/**
 * @param physicianID the physicianID to set
 */
public void setPhysicianID(int physicianID) {
   this.physicianID = physicianID;
}

/**
 * @return the specialty
 */
public String getSpecialty() {
   return specialty;
}

/**
 * @param specialty the specialty to set
 */
public void setSpecialty(String specialty) {
   this.specialty = specialty;
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
   if ( _ACTION == INSERT ) {

   } else if ( _ACTION == UPDATE ) {
	  if ( getAddressStateID() == null ) {
		 this.setAddressStateID( StateVO.builder().stateID( 2 ).build() );
		 if ( this.getPhysicianID() <= 0 ) {
			return false;
		 }
	  }
   }
   return !( getLastName() == null || getFirstName() == null || getLastName().length() * getFirstName().length() == 0 );
}

@Override
public String toJSON() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public String toString() {
   return "<td>" + physicianID + "</td><td>" + lastName + "</td><td>" + firstName + "</td><td>" + phoneWork + "</td><td>" + addressCity + "</td><td>" + addressZip + "</td><td>" + addressStateID + "</td><td><input type='button' class='edit' value='" + physicianID + "'>Edit</input></td></tr>";
}

@Override
public String toTableRow() {

   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}
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
private StateVO addressStateID;
private List<PatientVO> patientList;

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
 *
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
