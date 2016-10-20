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
public class PharmaRxOtcVO  implements Serializable, IEntityBase<PharmaRxOtcVO> {

   private static final long serialVersionUID = -2491778335415876824L;

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
public Integer pharmID;
public MedTypeVO medType;
public String rxcui;
public String genericRxcui;
public String tty;
public String fullName;
public String rxnDoseForm;
public String fullGenericName;
public String brandName;
public String displayName;
public String route;
public String newDoseForm;
public String strength;
public String suppressFor;
public String displayNameSynonym;
public String isRetired;
public String sxdgRxcui;
public String sxdgTty;
public String sxdgName;
public String psn;
public List<MedicationVO> medicationList;
   private static final Logger LOG = Logger.getLogger( PharmaRxOtcVO.class.getName() );

}
