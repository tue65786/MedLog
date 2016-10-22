/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import com.medlog.webservice.CONST.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class PatientVO implements Serializable, IEntityBase<PatientVO> {

private static final long serialVersionUID = 7503965982970314783L;

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
    * @param _ACTION {@linkplain API_ACTIONS#INSERT} does not validate ID.
    * @return
    */
   @Override
   public boolean isValid(int _ACTION) {
	  //Validate stateID!
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
