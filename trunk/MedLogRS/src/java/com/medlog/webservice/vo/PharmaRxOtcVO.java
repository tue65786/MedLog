/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import static com.medlog.webservice.CONST.API_ACTIONS.*;
import com.medlog.webservice.util.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class PharmaRxOtcVO implements Serializable, IEntityBase<PharmaRxOtcVO> {

private static final Logger LOG = Logger.getLogger( PharmaRxOtcVO.class.getName() );

private static final long serialVersionUID = -2491778335415876824L;

private PharmaRxOtcVO(final int pharmID, final MedTypeVO medType, final String rxcui, final String genericRxcui, final String tty, final String fullName, final String rxnDoseForm, final String fullGenericName, final String brandName, final String displayName, final String route, final String newDoseForm, final String strength, final String suppressFor, final String displayNameSynonym, final String isRetired, final String sxdgRxcui, final String sxdgTty, final String sxdgName, final String psn, final List<MedicationVO> medicationList) {
   this.pharmID = pharmID;
   this.medType = medType;
   this.rxcui = rxcui;
   this.genericRxcui = genericRxcui;
   this.tty = tty;
   this.fullName = fullName;
   this.rxnDoseForm = rxnDoseForm;
   this.fullGenericName = fullGenericName;
   this.brandName = brandName;
   this.displayName = displayName;
   this.route = route;
   this.newDoseForm = newDoseForm;
   this.strength = strength;
   this.suppressFor = suppressFor;
   this.displayNameSynonym = displayNameSynonym;
   this.isRetired = isRetired;
   this.sxdgRxcui = sxdgRxcui;
   this.sxdgTty = sxdgTty;
   this.sxdgName = sxdgName;
   this.psn = psn;
   this.medicationList = medicationList;
}

public static PharmaRxOtcVO.Builder builder() {
   return new PharmaRxOtcVO.Builder();
}

   public static PharmaRxOtcVO create(final int pharmID, final MedTypeVO medType, final String rxcui, final String genericRxcui, final String tty, final String fullName, final String rxnDoseForm, final String fullGenericName, final String brandName, final String displayName, final String route, final String newDoseForm, final String strength, final String suppressFor, final String displayNameSynonym, final String isRetired, final String sxdgRxcui, final String sxdgTty, final String sxdgName, final String psn, final List<MedicationVO> medicationList) {
	  return new PharmaRxOtcVO( pharmID, medType, rxcui, genericRxcui, tty, fullName, rxnDoseForm, fullGenericName, brandName, displayName, route, newDoseForm, strength, suppressFor, displayNameSynonym, isRetired, sxdgRxcui, sxdgTty, sxdgName, psn, medicationList );
   }

@Override
public boolean isValid() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean isValid(PharmaRxOtcVO _vo) {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean isValid(int _ACTION) {
   if ( _ACTION == INSERT ) {
	  if ( this.medType == null || this.medType.medTypeID == null ) {
		 this.medType = MedTypeVO.GET_OTC();
	  }
	  if ( this.displayName.isEmpty() || this.strength.isEmpty() ) {
		 return false;

	  }

   } else {
	  return this.pharmID > 0;
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

public String brandName;
/**
 * Required Field
 */
public String displayName;
public String displayNameSynonym;
public String fullGenericName;
public String fullName;
public String genericRxcui;
public String isRetired;
/**
 * Required Field
 * Default value: {@linkplain MedTypeVO#GET_OTC()}
 * 
 */
public MedTypeVO medType;

public String newDoseForm;
public int pharmID;
public String psn;
public String route;
public String rxcui;
public String rxnDoseForm;
/**
 * Required Field
 */
public String strength;
public String suppressFor;
public String sxdgName;
public String sxdgRxcui;
public String sxdgTty;
public String tty;
public List<MedicationVO> medicationList;

public static class Builder {

private int pharmID;
private MedTypeVO medType = MedTypeVO.GET_OTC();
private String rxcui;
private String genericRxcui;
private String tty;  // BR - BRAND, GE- Generic
private String fullName;
private String rxnDoseForm;
private String fullGenericName;
private String brandName;
private String displayName; // Required

private String route;
private String newDoseForm;
private String strength; // Required
private String suppressFor;
private String displayNameSynonym;
private String isRetired;
private String sxdgRxcui;
private String sxdgTty;
private String sxdgName;
private String psn;
private List<MedicationVO> medicationList;

private Builder() {
}

public Builder pharmID(final int value) {
   this.pharmID = value;
   return this;
}

public Builder medType(final MedTypeVO value) {
   this.medType = value;
   return this;
}

public Builder rxcui(final String value) {
   this.rxcui = value;
   return this;
}

public Builder genericRxcui(final String value) {
   this.genericRxcui = value;
   return this;
}

public Builder tty(final String value) {
   this.tty = value;
   return this;
}

public Builder fullName(final String value) {
   this.fullName = value;
   return this;
}

public Builder rxnDoseForm(final String value) {
   this.rxnDoseForm = value;
   return this;
}

public Builder fullGenericName(final String value) {
   this.fullGenericName = value;
   return this;
}

public Builder brandName(final String value) {
   this.brandName = value;
   return this;
}

public Builder displayName(final String value) {
   this.displayName = value;
   return this;
}

public Builder route(final String value) {
   this.route = value;
   return this;
}

public Builder newDoseForm(final String value) {
   this.newDoseForm = value;
   return this;
}

public Builder strength(final String value) {
   this.strength = value;
   return this;
}

public Builder suppressFor(final String value) {
   this.suppressFor = value;
   return this;
}

public Builder displayNameSynonym(final String value) {
   this.displayNameSynonym = value;
   return this;
}

public Builder isRetired(final String value) {
   this.isRetired = value;
   return this;
}

public Builder sxdgRxcui(final String value) {
   this.sxdgRxcui = value;
   return this;
}

public Builder sxdgTty(final String value) {
   this.sxdgTty = value;
   return this;
}

public Builder sxdgName(final String value) {
   this.sxdgName = value;
   return this;
}

public Builder psn(final String value) {
   this.psn = value;
   return this;
}

public Builder medicationList(final List<MedicationVO> value) {
   this.medicationList = value;
   return this;
}

public PharmaRxOtcVO build() {
   PharmaRxOtcVO ret = PharmaRxOtcVO.create( pharmID, medType, rxcui, genericRxcui, tty, fullName, rxnDoseForm, fullGenericName, brandName, displayName, route, newDoseForm, StrUtl.toS( strength, "prn" ), suppressFor, displayNameSynonym, isRetired, sxdgRxcui, sxdgTty, sxdgName, psn, medicationList );
   return ret;

}
}

}
