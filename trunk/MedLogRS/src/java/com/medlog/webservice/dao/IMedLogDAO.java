/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.dao;

import com.medlog.webservice.sql.*;
import com.medlog.webservice.vo.*;
import java.util.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public interface IMedLogDAO {

/**
 * Return all states
 *
 * @return
 */
public ArrayList<StateVO> findAllStates();

/**
 * Return states by keyword
 *
    * @param keyword Abbr or full state name.
 * @return
 */
public ArrayList<StateVO> findStatesByKeyword(String keyword);

/**
 *
 * @param _username
 * @param _password
 * @return
 */
public PatientVO findPatientByPatientNameAndPassword(String _username, String _password);

/**
 *
 * @param _username
 * @return
 */
public PatientVO findPatientByName(String _username);

/**
 * Retrieves all users
 *
 * @return
 */
public ArrayList<PatientVO> getPatients();

/**
 * Find user by user ID
 *
 * @param _id
 * @return
 */
public PatientVO findPatientByID(int _id);

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
 * Update existing patient
 *
 * @param _vo PatientVO to update. Nulls are ignored
 * @return success
 */
public boolean updatePatient(PatientVO _vo);

public int createDiary(DiaryVO _vo);

/**
 * Update existing diary
 *
 * @param _vo DiaryVO to update. Nulls are ignored
 * @return success
 */
public int updateDiary(DiaryVO _vo);

/**
 * Find diary by diary ID
 *
 * @param _id
 * @return
 */
public int findDiaryByID(int _id);

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
 * Find diary entries by patient and keyword
 *
 * @param _vo
 * @param keyword
 * @return
 */
public ArrayList<DiaryVO> findDiaryByKeyword(String keyword);

/**
 * Find diary entries by patient and tag
 *
 * @param _vo
 * @param _tag
 * @return
 */
public ArrayList<DiaryVO> findDiaryByTag(TagVO _tag);

public DbConnection getDB();

public PatientVO getCurrentUser();
}
