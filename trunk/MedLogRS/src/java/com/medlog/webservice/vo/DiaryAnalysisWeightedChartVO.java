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
public class DiaryAnalysisWeightedChartVO implements Serializable {

    private static final long serialVersionUID = 1013662728498658234L;

    /**
     * @return the agreeablenessBig5
     */
    public double getAgreeablenessBig5() {
        return agreeablenessBig5;
    }

    /**
     * @param agreeablenessBig5 the agreeablenessBig5 to set
     */
    public void setAgreeablenessBig5(double agreeablenessBig5) {
        this.agreeablenessBig5 = agreeablenessBig5;
    }

    /**
     * @return the analytical
     */
    public double getAnalytical() {
        return analytical;
    }

    /**
     * @param analytical the analytical to set
     */
    public void setAnalytical(double analytical) {
        this.analytical = analytical;
    }

    /**
     * @return the anger
     */
    public double getAnger() {
        return anger;
    }

    /**
     * @param anger the anger to set
     */
    public void setAnger(double anger) {
        this.anger = anger;
    }

    /**
     * @return the confident
     */
    public double getConfident() {
        return confident;
    }

    /**
     * @param confident the confident to set
     */
    public void setConfident(double confident) {
        this.confident = confident;
    }

    /**
     * @return the conscientiousnessBig5
     */
    public double getConscientiousnessBig5() {
        return conscientiousnessBig5;
    }

    /**
     * @param conscientiousnessBig5 the conscientiousnessBig5 to set
     */
    public void setConscientiousnessBig5(double conscientiousnessBig5) {
        this.conscientiousnessBig5 = conscientiousnessBig5;
    }

    /**
     * @return the disgust
     */
    public double getDisgust() {
        return disgust;
    }

    /**
     * @param disgust the disgust to set
     */
    public void setDisgust(double disgust) {
        this.disgust = disgust;
    }

    /**
     * @return the emotionalRangeBig5
     */
    public double getEmotionalRangeBig5() {
        return emotionalRangeBig5;
    }

    /**
     * @param emotionalRangeBig5 the emotionalRangeBig5 to set
     */
    public void setEmotionalRangeBig5(double emotionalRangeBig5) {
        this.emotionalRangeBig5 = emotionalRangeBig5;
    }

    /**
     * @return the extraversionBig5
     */
    public double getExtraversionBig5() {
        return extraversionBig5;
    }

    /**
     * @param extraversionBig5 the extraversionBig5 to set
     */
    public void setExtraversionBig5(double extraversionBig5) {
        this.extraversionBig5 = extraversionBig5;
    }

    /**
     * @return the fear
     */
    public double getFear() {
        return fear;
    }

    /**
     * @param fear the fear to set
     */
    public void setFear(double fear) {
        this.fear = fear;
    }

    /**
     * @return the joy
     */
    public double getJoy() {
        return joy;
    }

    /**
     * @param joy the joy to set
     */
    public void setJoy(double joy) {
        this.joy = joy;
    }

    /**
     * @return the opennessBig5
     */
    public double getOpennessBig5() {
        return opennessBig5;
    }

    /**
     * @param opennessBig5 the opennessBig5 to set
     */
    public void setOpennessBig5(double opennessBig5) {
        this.opennessBig5 = opennessBig5;
    }

    /**
     * @return the sadness
     */
    public double getSadness() {
        return sadness;
    }

    /**
     * @param sadness the sadness to set
     */
    public void setSadness(double sadness) {
        this.sadness = sadness;
    }

    /**
     * @return the tentative
     */
    public double getTentative() {
        return tentative;
    }

    /**
     * @param tentative the tentative to set
     */
    public void setTentative(double tentative) {
        this.tentative = tentative;
    }

    /**
     * @return the rowTotal
     */
    public double getRowTotal() {
        return rowTotal;
    }

    /**
     * @param rowTotal the rowTotal to set
     */
    public void setRowTotal(double rowTotal) {
        this.rowTotal = rowTotal;
    }

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

    public static DiaryAnalysisWeightedChartVO normalInstance(DiaryAnalysisVO in) {
        Builder b = DiaryAnalysisWeightedChartVO.builder();
        b.row(in.getRow()).rowTotal(in.getRowTotal());
        b.agreeablenessBig5(setVal(in.getAgreeablenessBig5(), in.getRowTotal()));
        b.analytical( setVal(in.getAnalytical(), in.getRowTotal()));
        b.anger(setVal(in.getAnger(), in.getRowTotal()));
        b.confident(setVal(in.getConfident(), in.getRowTotal()));
        b.conscientiousnessBig5(setVal(in.getConscientiousnessBig5(), in.getRowTotal()));;
        b.disgust(setVal(in.getDisgust(), in.getRowTotal()));
        b.emotionalRangeBig5(setVal(in.getEmotionalRangeBig5(), in.getRowTotal()));;
        b.extraversionBig5(setVal(in.getExtraversionBig5(), in.getRowTotal()));;
        b.fear(setVal(in.getFear(), in.getRowTotal()));
        b.joy(setVal(in.getJoy(), in.getRowTotal()));
        b.opennessBig5(setVal(in.getOpennessBig5(), in.getRowTotal()));
        b.sadness(setVal(in.getSadness(), in.getRowTotal()));
        b.tentative(setVal(in.getTentative(), in.getRowTotal()));
        return b.build();
    }

    private static double setVal(double val, double ttl) {
        return Math.ceil(val /  ttl );
    }

    public static class Builder {

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

        private Builder() {
        }

        public Builder agreeablenessBig5(final double value) {
            this.agreeablenessBig5 = value;
            return this;
        }

        public Builder analytical(final double value) {
            this.analytical = value;
            return this;
        }

        public Builder anger(final double value) {
            this.anger = value;
            return this;
        }

        public Builder confident(final double value) {
            this.confident = value;
            return this;
        }

        public Builder conscientiousnessBig5(final double value) {
            this.conscientiousnessBig5 = value;
            return this;
        }

        public Builder disgust(final double value) {
            this.disgust = value;
            return this;
        }

        public Builder emotionalRangeBig5(final double value) {
            this.emotionalRangeBig5 = value;
            return this;
        }

        public Builder extraversionBig5(final double value) {
            this.extraversionBig5 = value;
            return this;
        }

        public Builder fear(final double value) {
            this.fear = value;
            return this;
        }

        public Builder joy(final double value) {
            this.joy = value;
            return this;
        }

        public Builder opennessBig5(final double value) {
            this.opennessBig5 = value;
            return this;
        }

        public Builder sadness(final double value) {
            this.sadness = value;
            return this;
        }

        public Builder tentative(final double value) {
            this.tentative = value;
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

        public Builder row(final int value) {
            this.row = value;
            return this;
        }

        public DiaryAnalysisWeightedChartVO build() {
            return new com.medlog.webservice.vo.DiaryAnalysisWeightedChartVO(agreeablenessBig5, analytical, anger, confident, conscientiousnessBig5, disgust, emotionalRangeBig5, extraversionBig5, fear, joy, opennessBig5, sadness, tentative, rowTotal, mood, producivtiy, row);
        }
    }

    public static DiaryAnalysisWeightedChartVO.Builder builder() {
        return new DiaryAnalysisWeightedChartVO.Builder();
    }

    private DiaryAnalysisWeightedChartVO(final double agreeablenessBig5, final double analytical, final double anger, final double confident, final double conscientiousnessBig5, final double disgust, final double emotionalRangeBig5, final double extraversionBig5, final double fear, final double joy, final double opennessBig5, final double sadness, final double tentative, final double rowTotal, final int mood, final int producivtiy, final int row) {
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

}
