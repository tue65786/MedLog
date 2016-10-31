/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import com.google.gson.*;
import com.medlog.webservice.CONST.*;
import static com.medlog.webservice.CONST.API_ACTIONS.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import com.medlog.webservice.util.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import org.apache.commons.lang3.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class PatientVO implements Serializable, IEntityBase<PatientVO> {

private static final long serialVersionUID = 7503965982970314783L;

public static PatientVO create(final int patientID, final String userName, final String userPassword, final String userHash, final String firstName, final String lastName, final String phoneHome, final String phoneMobile, final String email, final String status, final String addressStreet, final String addressCity, final StateVO addressState, final String addressCountry, final String addressPostalcode, final String userPreferences, final Date pwdLastChanged, final String lang, final String timezoneId, final Date dateOfBirth, final Date dateJoined, final String picture, final String metaData, final int userRole, final List<DiaryVO> diaryList, final List<MedicationVO> medicationList, final HealthcareProviderVO primaryPhyssician, final List<HealthcareProviderVO> healthcareProviderList, final List<TagVO> tagList) {
   return new PatientVO( patientID, userName, userPassword, userHash, firstName, lastName, phoneHome, phoneMobile, email, status, addressStreet, addressCity, addressState, addressCountry, addressPostalcode, userPreferences, pwdLastChanged, lang, timezoneId, dateOfBirth, dateJoined, picture, metaData, userRole, diaryList, medicationList, primaryPhyssician, healthcareProviderList, tagList );
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
 * @return the addressCountry
 */
public String getAddressCountry() {
   return addressCountry;
}

/**
 * @param addressCountry the addressCountry to set
 */
public void setAddressCountry(String addressCountry) {
   this.addressCountry = addressCountry;
}

/**
 * @return the addressPostalcode
 */
public String getAddressPostalcode() {
   return StringUtils.left( StrUtl.toS( addressPostalcode ).trim(), 9 );
}

/**
 * @param addressPostalcode the addressPostalcode to set
 */
public void setAddressPostalcode(String addressPostalcode) {
   this.addressPostalcode = addressPostalcode;
}

/**
 * @return the addressState
 */
public StateVO getAddressState() {
   return addressState;
}

/**
 * @param addressState the addressState to set
 */
public void setAddressState(StateVO addressState) {
   this.addressState = addressState;
}

/**
 * @return the addressStreet
 */
public String getAddressStreet() {
   return StringUtils.left( StrUtl.toS( addressStreet ), 145 );
}

/**
 * @param addressStreet the addressStreet to set
 */
public void setAddressStreet(String addressStreet) {
   this.addressStreet = addressStreet;
}

/**
 * @return the dateJoined
 */
public Date getDateJoined() {
   return dateJoined;
}

/**
 * @param dateJoined the dateJoined to set
 */
public void setDateJoined(Date dateJoined) {
   this.dateJoined = dateJoined;
}

/**
 * @return the dateOfBirth
 */
public Date getDateOfBirth() {
   return dateOfBirth;
}

/**
 * @param dateOfBirth the dateOfBirth to set
 */
public void setDateOfBirth(Date dateOfBirth) {
   this.dateOfBirth = dateOfBirth;
}

/**
 * @return the diaryList
 */
public List<DiaryVO> getDiaryList() {
   return diaryList;
}

/**
 * @param diaryList the diaryList to set
 */
public void setDiaryList(List<DiaryVO> diaryList) {
   this.diaryList = diaryList;
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
 * @return the healthcareProviderList
 */
public List<HealthcareProviderVO> getHealthcareProviderList() {
   return healthcareProviderList;
}

/**
 * @param healthcareProviderList the healthcareProviderList to set
 */
public void setHealthcareProviderList(List<HealthcareProviderVO> healthcareProviderList) {
   this.healthcareProviderList = Collections.synchronizedList( healthcareProviderList );

   
}

/**
 * @return the lang
 */
public String getLang() {
   return lang;
}

/**
 * @param lang the lang to set
 */
public void setLang(String lang) {
   this.lang = lang;
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
 * @return the medicationList
 */
public List<MedicationVO> getMedicationList() {
   return medicationList;
}

/**
 * @param medicationList the medicationList to set
 */
public void setMedicationList(List<MedicationVO> medicationList) {
   this.medicationList = Collections.synchronizedList( medicationList ); ;
}

/**
 * @return the metaData
 */
public String getMetaData() {
   return metaData;
}

/**
 * @param metaData the metaData to set
 */
public void setMetaData(String metaData) {
   this.metaData = metaData;
}

/**
 * @return the patientID
 */
public int getPatientID() {
   return patientID;
}

/**
 * @param patientID the patientID to set
 */
public void setPatientID(int patientID) {
   this.patientID = patientID;
}

/**
 * @return the phoneHome
 */
public String getPhoneHome() {
   return phoneHome;
}

/**
 * @param phoneHome the phoneHome to set
 */
public void setPhoneHome(String phoneHome) {
   this.phoneHome = phoneHome;
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
 * @return the picture
 */
public String getPicture() {
   return picture;
}

/**
 * @param picture the picture to set
 */
public void setPicture(String picture) {
   this.picture = picture;
}

/**
 * @return the primaryPhyssician
 */
public HealthcareProviderVO getPrimaryPhyssician() {
   return primaryPhyssician;
}

/**
 * @param primaryPhyssician the primaryPhyssician to set
 */
public void setPrimaryPhyssician(HealthcareProviderVO primaryPhyssician) {
   this.primaryPhyssician = primaryPhyssician;
}

/**
 * @return the pwdLastChanged
 */
public Date getPwdLastChanged() {
   return pwdLastChanged;
}

/**
 * @param pwdLastChanged the pwdLastChanged to set
 */
public void setPwdLastChanged(Date pwdLastChanged) {
   this.pwdLastChanged = pwdLastChanged;
}

/**
 * @return the status
 */
public String getStatus() {
   return status;
}

/**
 * @param status the status to set
 */
public void setStatus(String status) {
   this.status = status;
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
 * @return the timezoneId
 */
public String getTimezoneId() {
   return timezoneId;
}

/**
 * @param timezoneId the timezoneId to set
 */
public void setTimezoneId(String timezoneId) {
   this.timezoneId = timezoneId;
}

/**
 * @return the userHash
 */
public String getUserHash() {
   return userHash;
}

/**
 * @param userHash the userHash to set
 */
public void setUserHash(String userHash) {
   this.userHash = userHash;
}

/**
 * @return the userName
 */
public String getUserName() {
   return userName;
}

/**
 * @param userName the userName to set
 */
public void setUserName(String userName) {
   this.userName = userName;
}

/**
 * @return the userPassword
 */
public String getUserPassword() {
   return userPassword;
}

/**
 * @param userPassword the userPassword to set
 */
public void setUserPassword(String userPassword) {
   this.userPassword = userPassword;
}

/**
 * @return the userPreferences
 */
public String getUserPreferences() {
   return userPreferences;
}

/**
 * @param userPreferences the userPreferences to set
 */
public void setUserPreferences(String userPreferences) {
   this.userPreferences = userPreferences;
}

/**
 * @return the userRole
 */
public int getUserRole() {
   return userRole;
}

/**
 * @param userRole the userRole to set
 */
public void setUserRole(int userRole) {
   this.userRole = userRole;
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
	  if ( this.getAddressState() == null || this.getAddressState().getStateID() <= 0 ) {
		 if ( DEBUG ) {
			System.err.println( "com.medlog.webservice.vo.PatientVO.isValid() -- Error: State is NULL " );
		 }
		 return false;
	  }
	  if ( this.getUserName().length() * this.getUserPassword().length() == 0 ) {
		 if ( DEBUG ) {
			System.err.println( "com.medlog.webservice.vo.PatientVO.isValid() -- Error: UserInfo is NULL " );
		 }
		 return false;
	  }
   } else if ( this.getPatientID() <= 0 ) {
	  if ( DEBUG ) {
		 System.err.println( "com.medlog.webservice.vo.PatientVO.isValid() -- Error: PatientID is NULL " );
	  }
	  return false;
   }
   return true;
}

@Override
public String toJSON() {
   Gson g = new GsonBuilder().serializeNulls().create();
   return g.toJson( this );
}

@Override
public String toTableRow() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}
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
   return PatientVO.create( vo.getPatientID(), vo.getUserName(), vo.getUserPassword(), vo.getUserHash(), vo.getFirstName(), vo.getLastName(), vo.getPhoneHome(), vo.getPhoneMobile(), vo.getEmail(), vo.getStatus(), vo.getAddressStreet(), vo.getAddressCity(), vo.getAddressState(), vo.getAddressCountry(), vo.getAddressPostalcode(), vo.getUserPreferences(), vo.getPwdLastChanged(), vo.getLang(), vo.getTimezoneId(), vo.getDateOfBirth(), vo.getDateJoined(), vo.getPicture(), vo.getMetaData(), vo.getUserRole(), vo.getDiaryList(), vo.getMedicationList(), vo.getPrimaryPhyssician(), vo.getHealthcareProviderList(), vo.getTagList() );
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
