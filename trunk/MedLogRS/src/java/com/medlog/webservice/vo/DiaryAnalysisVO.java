/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import java.io.Serializable;

/**
 *
 * @author westy
 */
public class DiaryAnalysisVO implements Serializable {

    /**
     * @return the mood
     */
    public int getMood() {
        return mood;
    }

    /**
     * @param mood the mood to set
     */
    public void setMood(int mood) {
        this.mood = mood;
    }

    /**
     * @return the producivtiy
     */
    public int getProducivtiy() {
        return producivtiy;
    }

    /**
     * @param producivtiy the producivtiy to set
     */
    public void setProducivtiy(int producivtiy) {
        this.producivtiy = producivtiy;
    }
    private static final long serialVersionUID = 1L;
    private int diaryID;
    private double agreeablenessBig5;
    private double analytical;
    private double anger;
    private double confident;
    private double conscientiousnessBig5;
    private double disgust;
    private double emotionalRangeBig5;
    private double extraversionBig5;
    private double fear;
    private double joy;
    private double opennessBig5;
    private double sadness;
    private double tentative;
    private double rowTotal;
    private int mood;
    private int producivtiy;
    private int row;
    private double cat_emotion;
    private double cat_social;
    private double cat_language;

    public DiaryAnalysisVO() {
    }

    public DiaryAnalysisVO(int diaryID) {
        this.diaryID = diaryID;
    }

    public double getDiaryID() {
        return diaryID;
    }

    public void setDiaryID(int diaryID) {
        this.diaryID = diaryID;
    }

    public double getAgreeablenessBig5() {
        return agreeablenessBig5;
    }

    public void setAgreeablenessBig5(double agreeablenessBig5) {
        this.agreeablenessBig5 = agreeablenessBig5;
    }

    public double getAnalytical() {
        return analytical;
    }

    public void setAnalytical(double analytical) {
        this.analytical = analytical;
    }

    public double getAnger() {
        return anger;
    }

    public void setAnger(double anger) {
        this.anger = anger;
    }

    public double getConfident() {
        return confident;
    }

    public void setConfident(double confident) {
        this.confident = confident;
    }

    public double getConscientiousnessBig5() {
        return conscientiousnessBig5;
    }

    public void setConscientiousnessBig5(double conscientiousnessBig5) {
        this.conscientiousnessBig5 = conscientiousnessBig5;
    }

    public double getDisgust() {
        return disgust;
    }

    public void setDisgust(double disgust) {
        this.disgust = disgust;
    }

    public double getEmotionalRangeBig5() {
        return emotionalRangeBig5;
    }

    public void setEmotionalRangeBig5(double emotionalRangeBig5) {
        this.emotionalRangeBig5 = emotionalRangeBig5;
    }

    public double getExtraversionBig5() {
        return extraversionBig5;
    }

    public void setExtraversionBig5(double extraversionBig5) {
        this.extraversionBig5 = extraversionBig5;
    }

    public double getFear() {
        return fear;
    }

    public void setFear(double fear) {
        this.fear = fear;
    }

    public double getJoy() {
        return joy;
    }

    public void setJoy(double joy) {
        this.joy = joy;
    }

    public double getOpennessBig5() {
        return opennessBig5;
    }

    public void setOpennessBig5(double opennessBig5) {
        this.opennessBig5 = opennessBig5;
    }

    public double getSadness() {
        return sadness;
    }

    public void setSadness(double sadness) {
        this.sadness = sadness;
    }

    public double getTentative() {
        return tentative;
    }

    public void setTentative(double tentative) {
        this.tentative = tentative;
    }

    public double getRowTotal() {
        return rowTotal;
    }

    public void setRowTotal(double rowTotal) {
        this.rowTotal = rowTotal;
    }

    public static class Builder {

        private int diaryID;
        private double agreeablenessBig5;
        private double analytical;
        private double anger;
        private double confident;
        private double conscientiousnessBig5;
        private double disgust;
        private double emotionalRangeBig5;
        private double extraversionBig5;
        private double fear;
        private double joy;
        private double opennessBig5;
        private double sadness;
        private double tentative;
        private double rowTotal;
        private int mood;

        private int producivtiy;

        private Builder() {

        }

        public Builder keyValue(String key, final double value) {

            switch (key) {
                case "anger":
                    this.anger(value);
                    break;
                case "disgust":
                    this.disgust(value);
                    break;
                case "fear":
                    this.fear(value);
                    break;
                case "joy":
                    this.joy(value);
                    break;
                case "sadness":
                    this.sadness(value);
                    break;
                case "analytical":
                    this.analytical(value);
                    break;
                case "confident":
                    this.confident(value);
                    break;
                case "tentative":
                    this.tentative(value);
                    break;
                case "agreeableness_big5":
                    this.agreeablenessBig5(value);
                    break;
                case "conscientiousness_big5":
                    this.conscientiousnessBig5(value);
                    break;
                case "emotional_range_big5":
                    this.emotionalRangeBig5(value);
                    break;
                case "extraversion_big5":
                    this.extraversionBig5(value);
                    break;
                case "openness_big5":
                    this.opennessBig5(value);
                    break;
                case "mood":
                    this.mood((int)value);
                    break;
                default:
                    break;
            }
            return this;
        }

        public Builder diaryID(final int value) {
            this.diaryID = (value);
            return this;
        }

        public Builder agreeablenessBig5(final double value) {
            this.agreeablenessBig5 = updateVal(value);
            return this;
        }

        public Builder analytical(final double value) {
            this.analytical = updateVal(value);
            return this;
        }

        public Builder anger(final double value) {
            this.anger = updateVal(value);
            return this;
        }

        public Builder confident(final double value) {
            this.confident = updateVal(value);
            return this;
        }

        public Builder conscientiousnessBig5(final double value) {
            this.conscientiousnessBig5 = updateVal(value);
            return this;
        }

        public Builder disgust(final double value) {
            this.disgust = updateVal(value);
            return this;
        }

        public Builder emotionalRangeBig5(final double value) {
            this.emotionalRangeBig5 = updateVal(value);
            return this;
        }

        public Builder extraversionBig5(final double value) {
            this.extraversionBig5 = updateVal(value);
            return this;
        }

        public Builder fear(final double value) {
            this.fear = updateVal(value);
            return this;
        }

        public Builder joy(final double value) {
            this.joy = updateVal(value);
            return this;
        }

        public Builder opennessBig5(final double value) {
            this.opennessBig5 = updateVal(value);
            return this;
        }

        public Builder sadness(final double value) {
            this.sadness = updateVal(value);
            return this;
        }

        public Builder tentative(final double value) {
            this.tentative = updateVal(value);
            return this;
        }

        public Builder rowTotal(final double value) {
            this.rowTotal = value;
            return this;
        }

        public Builder mood(final int value) {
            this.mood = value;
            return this;
        }

        public Builder producivtiy(final int value) {
            this.producivtiy = value;
            return this;
        }

        private double updateVal(double value) {
            return value * 100.0;
        }

        private int updateVal(int value) {
            return value * 10;
        }

        public DiaryAnalysisVO build(int row) {
            return new com.medlog.webservice.vo.DiaryAnalysisVO(diaryID, agreeablenessBig5, analytical, anger, confident, conscientiousnessBig5, disgust, emotionalRangeBig5, extraversionBig5, fear, joy, opennessBig5, sadness, tentative, rowTotal, mood, producivtiy, row);
        }
    }

    public static DiaryAnalysisVO.Builder builder() {
        return new DiaryAnalysisVO.Builder();
    }

    private DiaryAnalysisVO(final int diaryID, final double agreeablenessBig5, final double analytical, final double anger, final double confident, final double conscientiousnessBig5, final double disgust, final double emotionalRangeBig5, final double extraversionBig5, final double fear, final double joy, final double opennessBig5, final double sadness, final double tentative, final double rowTotal, final int mood, final int producivtiy, int row) {
        this.diaryID = diaryID;
        this.agreeablenessBig5 = agreeablenessBig5;
        this.analytical = analytical;
        this.anger = anger;
        this.confident = confident;
        this.conscientiousnessBig5 = conscientiousnessBig5;
        this.disgust = disgust;
        this.emotionalRangeBig5 = emotionalRangeBig5;
        this.extraversionBig5 = extraversionBig5;
        this.fear = fear;
        this.joy = joy;
        this.opennessBig5 = opennessBig5;
        this.sadness = sadness;
        this.tentative = tentative;
        this.rowTotal = rowTotal;
        this.mood = mood;
        this.producivtiy = producivtiy;
        this.row = row;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

}
