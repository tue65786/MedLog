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
public class PharmaRxOtcVO  implements Serializable, IEntityBase<PharmaRxOtcVO> {
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

}
