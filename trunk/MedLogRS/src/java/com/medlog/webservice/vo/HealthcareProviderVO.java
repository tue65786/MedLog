/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import java.io.*;
import java.util.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class HealthcareProviderVO implements Serializable, IEntityBase<HealthcareProviderVO> {

   private static final long serialVersionUID = -6426975328081170068L;

   @Override
   public boolean isValid() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public boolean isValid(HealthcareProviderVO _vo) {
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

public String pathientLogCommunicationPreference;

public String addressStreet;

public String addressCity;

public String addressZip;

public List<PatientVO> patientList;

public StateVO addressStateID;
}
