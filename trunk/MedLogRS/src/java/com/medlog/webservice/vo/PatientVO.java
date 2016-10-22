/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import com.medlog.webservice.CONST.*;
import static com.medlog.webservice.CONST.API_ACTIONS.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class PatientVO implements Serializable, IEntityBase<PatientVO> {

private static final long serialVersionUID = 7503965982970314783L;

public static PatientVO create(final int patientID, final String userName, final String userPassword, final String userHash, final String firstName, final String lastName, final String phoneHome, final String phoneMobile, final String email, final String status, final String addressStreet, final String addressCity, final StateVO addressState, final String addressCountry, final String addressPostalcode, final String userPreferences, final Date pwdLastChanged, final String lang, final String timezoneId, final Date dateOfBirth, final Date dateJoined, final String picture, final String metaData, final int userRole, final List<DiaryVO> diaryList, final List<MedicationVO> medicationList, final HealthcareProviderVO primaryPhyssician, final List<HealthcareProviderVO> healthcareProviderList, final List<TagVO> tagList) {
   return new PatientVO( patientID, userName, userPassword, userHash, firstName, lastName, phoneHome, phoneMobile, email, status, addressStreet, addressCity, addressState, addressCountry, addressPostalcode, userPreferences, pwdLastChanged, lang, timezoneId, dateOfBirth, dateJoined, picture, metaData, userRole, diaryList, medicationList, primaryPhyssician, healthcareProviderList, tagList );
}

@Override
public boolean isValid() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean isValid(PatientVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

/**
 * Validates:<ul><li> {@linkplain StateVO#stateID}</li></ul>
 *
 * @param _ACTION {@linkplain API_ACTIONS#INSERT} does not validate ID.
 * @return
 */
@Override
public boolean isValid(int _ACTION) {
   if ( _ACTION == INSERT ) {
	  if ( this.addressState == null || this.addressState.getStateID() <= 0 ) {
		 if ( DEBUG ) {
			System.err.println( "com.medlog.webservice.vo.PatientVO.isValid() -- Error: State is NULL " );
		 }
		 return false;
	  }
	  if ( this.userName.length() * this.userPassword.length() == 0 ) {
		 if ( DEBUG ) {
			System.err.println( "com.medlog.webservice.vo.PatientVO.isValid() -- Error: UserInfo is NULL " );
		 }
		 return false;
	  }
   } else if ( this.patientID <= 0 ) {
	  if ( DEBUG ) {
		 System.err.println( "com.medlog.webservice.vo.PatientVO.isValid() -- Error: PatientID is NULL " );
	  }
	  return false;
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
public int patientID;
public String userName;
public String userPassword;
public String userHash;
public String firstName;
public String lastName;
public String phoneHome;
public String phoneMobile;
public String email;
public String status;
public String addressStreet;
public String addressCity;
public StateVO addressState;
public String addressCountry;
public String addressPostalcode;
public String userPreferences;
public Date pwdLastChanged;
public String lang;
public String timezoneId;
public Date dateOfBirth;
public Date dateJoined;
public String picture;
public String metaData;
public int userRole;
public List<DiaryVO> diaryList;
public List<MedicationVO> medicationList;
public HealthcareProviderVO primaryPhyssician;
public List<HealthcareProviderVO> healthcareProviderList;
public List<TagVO> tagList;

public static class Builder {

private int patientID;
private String userName;
private String userPassword;
private String userHash;
private String firstName;
private String lastName;
private String phoneHome;
private String phoneMobile;
private String email;
private String status;
private String addressStreet;
private String addressCity;
private StateVO addressState;
private String addressCountry;
private String addressPostalcode;
private String userPreferences;
private Date pwdLastChanged;
private String lang;
private String timezoneId;
private Date dateOfBirth;
private Date dateJoined;
private String picture;
private String metaData;
private int userRole;
private List<DiaryVO> diaryList;
private List<MedicationVO> medicationList;
private HealthcareProviderVO primaryPhyssician;
private List<HealthcareProviderVO> healthcareProviderList;
private List<TagVO> tagList;

private Builder() {
}

public Builder patientID(final int value) {
   this.patientID = value;
   return this;
}

public Builder userName(final String value) {
   this.userName = value;
   return this;
}

public Builder userPassword(final String value) {
   this.userPassword = value;
   return this;
}

public Builder userHash(final String value) {
   this.userHash = value;
   return this;
}

public Builder firstName(final String value) {
   this.firstName = value;
   return this;
}

public Builder lastName(final String value) {
   this.lastName = value;
   return this;
}

public Builder phoneHome(final String value) {
   this.phoneHome = value;
   return this;
}

public Builder phoneMobile(final String value) {
   this.phoneMobile = value;
   return this;
}

public Builder email(final String value) {
   this.email = value;
   return this;
}

public Builder status(final String value) {
   this.status = value;
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

public Builder addressState(final StateVO value) {
   this.addressState = value;
   return this;
}

public Builder addressCountry(final String value) {
   this.addressCountry = value;
   return this;
}

public Builder addressPostalcode(final String value) {
   this.addressPostalcode = value;
   return this;
}

public Builder userPreferences(final String value) {
   this.userPreferences = value;
   return this;
}

public Builder pwdLastChanged(final Date value) {
   this.pwdLastChanged = value;
   return this;
}

public Builder lang(final String value) {
   this.lang = value;
   return this;
}

public Builder timezoneId(final String value) {
   this.timezoneId = value;
   return this;
}

public Builder dateOfBirth(final Date value) {
   this.dateOfBirth = value;
   return this;
}

public Builder dateJoined(final Date value) {
   this.dateJoined = value;
   return this;
}

public Builder picture(final String value) {
   this.picture = value;
   return this;
}

public Builder metaData(final String value) {
   this.metaData = value;
   return this;
}

public Builder userRole(final int value) {
   this.userRole = value;
   return this;
}

public Builder diaryList(final List<DiaryVO> value) {
   this.diaryList = value;
   return this;
}

public Builder medicationList(final List<MedicationVO> value) {
   this.medicationList = value;
   return this;
}

public Builder primaryPhyssician(final HealthcareProviderVO value) {
   this.primaryPhyssician = value;
   return this;
}

public Builder healthcareProviderList(final List<HealthcareProviderVO> value) {
   this.healthcareProviderList = value;
   return this;
}

public Builder tagList(final List<TagVO> value) {
   this.tagList = value;
   return this;
}

/**
 * Build method
 *
 * @return factory.
 */
public PatientVO build() {
   return PatientVO.create( patientID, userName, userPassword, userHash, firstName, lastName, phoneHome, phoneMobile, email, status, addressStreet, addressCity, addressState, addressCountry, addressPostalcode, userPreferences, pwdLastChanged, lang, timezoneId, dateOfBirth, dateJoined, picture, metaData, userRole, diaryList, medicationList, primaryPhyssician, healthcareProviderList, tagList );
}
}

/**
 * PatientVO Builder.
 *
 * @return
 */
public static PatientVO.Builder builder() {
   return new PatientVO.Builder();
}

/**
 * Instance creation method
 *
 * @param vo method
 * @return Instance
 */
public static PatientVO newInstance(PatientVO vo) {
   return PatientVO.create( vo.patientID, vo.userName, vo.userPassword, vo.userHash, vo.firstName, vo.lastName, vo.phoneHome, vo.phoneMobile, vo.email, vo.status, vo.addressStreet, vo.addressCity, vo.addressState, vo.addressCountry, vo.addressPostalcode, vo.userPreferences, vo.pwdLastChanged, vo.lang, vo.timezoneId, vo.dateOfBirth, vo.dateJoined, vo.picture, vo.metaData, vo.userRole, vo.diaryList, vo.medicationList, vo.primaryPhyssician, vo.healthcareProviderList, vo.tagList );
}

/**
 * Consrtructs Patient.
 *
 * @param patientID
 * @param userName
 * @param userPassword
 * @param userHash
 * @param firstName
 * @param lastName
 * @param phoneHome
 * @param phoneMobile
 * @param email
 * @param status
 * @param addressStreet
 * @param addressCity
 * @param addressState
 * @param addressCountry
 * @param addressPostalcode
 * @param userPreferences
 * @param pwdLastChanged
 * @param lang
 * @param timezoneId
 * @param dateOfBirth
 * @param dateJoined
 * @param picture
 * @param metaData
 * @param userRole
 * @param diaryList
 * @param medicationList
 * @param primaryPhyssician
 * @param healthcareProviderList
 * @param tagList
 */
private PatientVO(final int patientID, final String userName, final String userPassword, final String userHash, final String firstName, final String lastName, final String phoneHome, final String phoneMobile, final String email, final String status, final String addressStreet, final String addressCity, final StateVO addressState, final String addressCountry, final String addressPostalcode, final String userPreferences, final Date pwdLastChanged, final String lang, final String timezoneId, final Date dateOfBirth, final Date dateJoined, final String picture, final String metaData, final int userRole, final List<DiaryVO> diaryList, final List<MedicationVO> medicationList, final HealthcareProviderVO primaryPhyssician, final List<HealthcareProviderVO> healthcareProviderList, final List<TagVO> tagList) {
   this.patientID = patientID;
   this.userName = userName;
   this.userPassword = userPassword;
   this.userHash = userHash;
   this.firstName = firstName;
   this.lastName = lastName;
   this.phoneHome = phoneHome;
   this.phoneMobile = phoneMobile;
   this.email = email;
   this.status = status;
   this.addressStreet = addressStreet;
   this.addressCity = addressCity;
   this.addressState = addressState;
   this.addressCountry = addressCountry;
   this.addressPostalcode = addressPostalcode;
   this.userPreferences = userPreferences;
   this.pwdLastChanged = pwdLastChanged;
   this.lang = lang;
   this.timezoneId = timezoneId;
   this.dateOfBirth = dateOfBirth;
   this.dateJoined = dateJoined;
   this.picture = picture;
   this.metaData = metaData;
   this.userRole = userRole;
   this.diaryList = diaryList;
   this.medicationList = medicationList;
   this.primaryPhyssician = primaryPhyssician;
   this.healthcareProviderList = healthcareProviderList;
   this.tagList = tagList;
}

public PatientVO() {

}
//
//   public List<PatientDietaryRestriction> patientDietaryRestrictionList;
//
//   public List<Activity> activityList;
//
//   public List<PatientMedication> patientMedicationList;
//
//
//
//
//
//   public List<USERFieldA> uSERFieldAList;
//
//   public PatientVitals patientVitals;
//
//  
//
//   public List<DiarySentLog> diarySentLogList;
private static final Logger LOG = Logger.getLogger( PatientVO.class.getName() );

}
