/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.services.tone;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author westy
 */
@Entity
@Table(name = "vwDiaryStats")
@NamedQueries({
    @NamedQuery(name = "VwDiaryStatsVO.findAll", query = "SELECT v FROM VwDiaryStatsVO v")})
public class VwDiaryStatsVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "DiaryID")
    private int diaryID;
    @Column(name = "patientID")
    private Integer patientID;
    @Basic(optional = false)
    @Column(name = "category_id")
    private String categoryId;
    @Basic(optional = false)
    @Column(name = "tone_id")
    private String toneId;
    @Basic(optional = false)
    @Column(name = "sentence_id")
    private int sentenceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "score")
    private BigDecimal score;
    @Column(name = "text")
    private String text;
    @Column(name = "productivity")
    private Integer productivity;
    @Column(name = "mood")
    private Integer mood;

    public VwDiaryStatsVO() {
    }

    public int getDiaryID() {
        return diaryID;
    }

    public void setDiaryID(int diaryID) {
        this.diaryID = diaryID;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getToneId() {
        return toneId;
    }

    public void setToneId(String toneId) {
        this.toneId = toneId;
    }

    public int getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getProductivity() {
        return productivity;
    }

    public void setProductivity(Integer productivity) {
        this.productivity = productivity;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }
    
}
