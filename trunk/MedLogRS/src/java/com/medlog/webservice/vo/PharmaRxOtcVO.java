/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import static com.medlog.webservice.CONST.API_ACTIONS.*;
import com.medlog.webservice.annotations.*;
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

/**
 * @return the brandName
 */
public String getBrandName() {
   return brandName;
}

/**
 * @param brandName the brandName to set
 */
public void setBrandName(String brandName) {
   this.brandName = brandName;
}

/**
 * Required Field
 *
 * @return the displayName
 */
public String getDisplayName() {
   return displayName;
}

/**
 * Required Field
 *
 * @param displayName the displayName to set
 */
public void setDisplayName(String displayName) {
   this.displayName = displayName;
}

/**
 * @return the displayNameSynonym
 */
public String getDisplayNameSynonym() {
   return displayNameSynonym;
}

/**
 * @param displayNameSynonym the displayNameSynonym to set
 */
public void setDisplayNameSynonym(String displayNameSynonym) {
   this.displayNameSynonym = displayNameSynonym;
}

/**
 * @return the fullGenericName
 */
public String getFullGenericName() {
   return fullGenericName;
}

/**
 * @param fullGenericName the fullGenericName to set
 */
public void setFullGenericName(String fullGenericName) {
   this.fullGenericName = fullGenericName;
}

/**
 * @return the fullName
 */
public String getFullName() {
   return StrUtl.toS( fullName );
}

/**
 * @param fullName the fullName to set
 */
public void setFullName(String fullName) {
   this.fullName = fullName;
}

/**
 * @return the genericRxcui
 */
public String getGenericRxcui() {
   return genericRxcui;
}

/**
 * @param genericRxcui the genericRxcui to set
 */
public void setGenericRxcui(String genericRxcui) {
   this.genericRxcui = genericRxcui;
}

/**
 * @return the isRetired
 */
public String getIsRetired() {
   return isRetired;
}

/**
 * @param isRetired the isRetired to set
 */
public void setIsRetired(String isRetired) {
   this.isRetired = isRetired;
}

/**
 * Required Field
 * Default value: {@linkplain MedTypeVO#GET_OTC()}
 *
 * @return the medType
 */
public MedTypeVO getMedType() {
   return medType;
}

/**
 * Required Field
 * Default value: {@linkplain MedTypeVO#GET_OTC()}
 *
 * @param medType the medType to set
 */
public void setMedType(MedTypeVO medType) {
   this.medType = medType;
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
   this.medicationList = medicationList;
}

/**
 * @return the newDoseForm
 */
public String getNewDoseForm() {
   return newDoseForm;
}

/**
 * @param newDoseForm the newDoseForm to set
 */
public void setNewDoseForm(String newDoseForm) {
   this.newDoseForm = newDoseForm;
}

/**
 * @return the pharmID
 */
public int getPharmID() {
   return pharmID;
}

/**
 * @param pharmID the pharmID to set
 */
public void setPharmID(int pharmID) {
   this.pharmID = pharmID;
}

/**
 * @return the psn
 */
public String getPsn() {
   return psn;
}

/**
 * @param psn the psn to set
 */
public void setPsn(String psn) {
   this.psn = psn;
}

/**
 * @return the route
 */
public String getRoute() {
   return route;
}

/**
 * @param route the route to set
 */
public void setRoute(String route) {
   this.route = route;
}

/**
 * @return the rxcui
 */
public String getRxcui() {
   return rxcui;
}

/**
 * @param rxcui the rxcui to set
 */
public void setRxcui(String rxcui) {
   this.rxcui = rxcui;
}

/**
 * @return the rxnDoseForm
 */
public String getRxnDoseForm() {
   return rxnDoseForm;
}

/**
 * @param rxnDoseForm the rxnDoseForm to set
 */
public void setRxnDoseForm(String rxnDoseForm) {
   this.rxnDoseForm = rxnDoseForm;
}

/**
 * Required Field
 *
 * @return the strength
 */
public String getStrength() {
   return StrUtl.toS( strength );
}

/**
 * Required Field
 *
 * @param strength the strength to set
 */
public void setStrength(String strength) {
   this.strength = strength;
}

/**
 * @return the suppressFor
 */
public String getSuppressFor() {
   return suppressFor;
}

/**
 * @param suppressFor the suppressFor to set
 */
public void setSuppressFor(String suppressFor) {
   this.suppressFor = suppressFor;
}

/**
 * @return the sxdgName
 */
public String getSxdgName() {
   return sxdgName;
}

/**
 * @param sxdgName the sxdgName to set
 */
public void setSxdgName(String sxdgName) {
   this.sxdgName = sxdgName;
}

/**
 * @return the sxdgRxcui
 */
public String getSxdgRxcui() {
   return sxdgRxcui;
}

/**
 * @param sxdgRxcui the sxdgRxcui to set
 */
public void setSxdgRxcui(String sxdgRxcui) {
   this.sxdgRxcui = sxdgRxcui;
}

/**
 * @return the sxdgTty
 */
public String getSxdgTty() {
   return sxdgTty;
}

/**
 * @param sxdgTty the sxdgTty to set
 */
public void setSxdgTty(String sxdgTty) {
   this.sxdgTty = sxdgTty;
}

/**
 * @return the tty
 */
public String getTty() {
   return tty;
}

/**
 * @param tty the tty to set
 */
public void setTty(String tty) {
   this.tty = tty;
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
	  if ( this.getMedType() == null || this.getMedType().medTypeID == null ) {
		 this.setMedType( MedTypeVO.GET_OTC() );
	  }
	  if ( this.getFullName().isEmpty() || this.getStrength().isEmpty() ) {
		 return false;

	  }

   } else {
	  return this.getPharmID() > 0;
   }
   return true;
}

@Override
public String toJSON() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public String toTableRow() {
   return "";
}
@FormNameValueAndType(canOmitFromForm = true)
private String brandName;
/**
 * Required Field
 */
@FormNameValueAndType(canOmitFromForm = true)
private String displayName;
@FormNameValueAndType(canOmitFromForm = true)
private String displayNameSynonym;
@FormNameValueAndType(canOmitFromForm = true)
private String fullGenericName;
@FormNameValueAndType(formFieldType = "text", isName = true, canOmitFromForm = false)
private String fullName;
@FormNameValueAndType(canOmitFromForm = true)
private String genericRxcui;
@FormNameValueAndType(canOmitFromForm = true)
private String isRetired;
/**
 * Required Field
 * Default value: {@linkplain MedTypeVO#GET_OTC()}
 *
 */
private MedTypeVO medType;
@FormNameValueAndType(canOmitFromForm = true)
private String newDoseForm;
@FormNameValueAndType(formFieldType = "hidden", isPK = true)
private int pharmID;
@FormNameValueAndType(canOmitFromForm = true)
private String psn;
@FormNameValueAndType(canOmitFromForm = true)
private String route;
@FormNameValueAndType(canOmitFromForm = true)
private String rxcui;



@FormNameValueAndType(canOmitFromForm = true)
private String rxnDoseForm;
/**
 * Required Field
 */
private String strength;
@FormNameValueAndType(canOmitFromForm = true)
private String suppressFor;
@FormNameValueAndType(canOmitFromForm = true)
private String sxdgName;
@FormNameValueAndType(canOmitFromForm = true)
private String sxdgRxcui;
@FormNameValueAndType(canOmitFromForm = true)
private String sxdgTty;
@FormNameValueAndType(canOmitFromForm = true, validLookups = { "SCD", "SBD" })
private String tty;
private List<MedicationVO> medicationList;

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
