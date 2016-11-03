/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.dao;

import com.medlog.webservice.CONST.*;
import com.medlog.webservice.sql.*;
import com.medlog.webservice.vo.*;
import java.util.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public interface IMedLogDAO {
/**
 * Assigns medication to current user
 *
    * @param _vo Join Med
	* SQL SP - {@linkplain DB_STRINGS#SP_PATIENT_MEDICATION}
 * @return newID
 * @see DB_STRINGS#SP_PATIENT_MEDICATION
 * 
 */
public int assignMedication(MedicationVO _vo);
public int createDiary(DiaryVO _vo);
/**
 * Add new patient
 *
    * @param _vo
 * @param vo
 * @return inserted ID
 */
public int createHealthcareProviderVO(HealthcareProviderVO _vo);
/**
 * Add new patient
 *
 * @param vo
 * @return inserted ID
 */
public int createPatient(PatientVO vo);
/**
 * Deletes a Patient
 *
 * @param _vo
 * @return success
 */
public boolean deletePatient(PatientVO _vo);

/**
 * Return all states
 *
 * @return
 */
public ArrayList<StateVO> findAllStates();
/**
 * Find diary by diary ID
 *
 * @param _id
 * @return
 */
public DiaryVO findDiaryByID(int _id);
/**
 * Find diary entries by patient and keyword
 *
 * @param _vo
 * @param keyword
 * @return
 */
public ArrayList<DiaryVO> findDiaryByKeyword(String keyword);
/**
 * Find diary entries by PatientVO
 *
 * @param _vo Patient
 * @return
 * @see PatientVO
 * @see DiaryVO
 */
public ArrayList<DiaryVO> findDiaryByPatient();
/**
 * Find diary entries by patient and tag
 *
 * @param _vo
 * @param _tag
 * @return
 */
public ArrayList<DiaryVO> findDiaryByTag(TagVO _tag);
/**
 * Find user by HealthcareProviderVO ID
 *
 * @param _id
 * @return {@linkplain HealthcareProviderVO} single
 */
public HealthcareProviderVO findHealthcareProviderID(int _id);


/**
 * Retrieves all {@linkplain HealthcareProviderVO} in database.
 *
 * @return All providers.
 */
public ArrayList<HealthcareProviderVO> findHealthcareProviders();
/**
 * Retrieves all HealthcareProviderVO by Keyword
 *
 * @param keyword      Search key.
 * @param onlyAssigned Limit list to those assigned to user.
 * @return List of matched {@linkplain HealthcareProviderVO}
 */
public ArrayList<HealthcareProviderVO> findHealthcareProvidersByKeyword(String keyword, boolean onlyAssigned);

/**
 * Retrieves all providers for current {@linkplain PatientVO user}
 *
 * @return Assigned {@linkplain HealthcareProviderVO}
 */
public ArrayList<HealthcareProviderVO> findHealthcareProvidersByStudent();
/**
 * Find user by user ID
 *
 * @param _id
 * @return
 */
public PatientVO findPatientByID(int _id);
/**
 *
 * @param _username
 * @return
 */
public PatientVO findPatientByName(String _username);
/**
 *
 * @param _username
 * @param _password
 * @return
 */
public PatientVO findPatientByPatientNameAndPassword(String _username, String _password);
/**
 * Return states by keyword
 *
 * @param keyword Abbr or full state name.
 * @return
 */
public ArrayList<StateVO> findStatesByKeyword(String keyword);
public PatientVO getCurrentUser();
public DbConnection getDB();
/**
 * Retrieves all users
 *
 * @return
 */
public ArrayList<PatientVO> getPatients();

/**
 * Unassign medication to current user
 *
 * @return success
 * @see DB_STRINGS#SP_PATIENT_MEDICATION
 */
public boolean unassignMedication(MedicationVO _vo);


/**
 * Update existing diary
 *
 * @param _vo DiaryVO to update. Nulls are ignored
 * @return success
 */
public int updateDiary(DiaryVO _vo);
/**
 * Update HealthcareProvider
 *
 * @param _vo
 * @return success
 * @see HealthcareProviderVO
 */
public boolean updateHealthcareProviderVO(HealthcareProviderVO _vo);
/**
 * Update existing patient
 *
 * @param _vo PatientVO to update. Nulls are ignored
 * @return success
 */
public boolean updatePatient(PatientVO _vo);

public int syncMedication(ArrayList<MedicationVO> _voList);
public int syncDiary(ArrayList<DiaryVO> _voList);

public int createPharmaRxOtcVO(PharmaRxOtcVO _vo);
public boolean updatePharmaRxOtcVO(PharmaRxOtcVO _vo);
public PharmaRxOtcVO findPharmaRxOtcVO(boolean onlyAssigned);
public PharmaRxOtcVO findPharmaRxOtcVOByID(int _id);
public ArrayList<PharmaRxOtcVO> findPharmaRxOtcVOByKeword(String _keyword,boolean onlyAssigned);
public ArrayList<PharmaRxOtcVO> findPharmaRxOtcVOByKeword(String _keyword,int pageNumber, int pageSize, boolean onlyAssigned);

/**
 * Returns list of all instructions
 * @return  ArrayList
 * //spSigSelect
 */
public ArrayList<SigVO> findAllSigs();
public Map<Integer,SigVO> findAllSigsMap();
public Map<Integer,MedTypeVO> findAllMedTypesMap();








}
