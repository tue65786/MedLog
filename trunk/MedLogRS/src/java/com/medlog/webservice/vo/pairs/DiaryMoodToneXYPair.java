/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo.pairs;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.medlog.webservice.vo.DiaryAnalysisSummaryVO;
import java.io.Serializable;
import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Pair for Diary Mood Tone
 * @author westy
 */
public class DiaryMoodToneXYPair implements Serializable{

    private static final long serialVersionUID = -6631386217755122810L;

    /**
     * @return the x
     */
    public double[] getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    protected void setX(double[] x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double[] getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    protected void setY(double[] y) {
        this.y = y;
    }

    /**
     * @return the xl
     */
    protected ArrayList<Double> getXl() {
        return xl;
    }

    /**
     * @param xl the xl to set
     */
    protected void setXl(ArrayList<Double> xl) {
        this.xl = xl;
    }

    /**
     * @return the yl
     */
    protected ArrayList<Double> getYl() {
        return yl;
    }

    /**
     * @param yl the yl to set
     */
    protected void setYl(ArrayList<Double> yl) {
        this.yl = yl;
    }
/**
 * xAxis Points
 * @see DiaryAnalysisSummaryVO
 * @see ToneAnalysis
 */
    private double[] x;
    
/**
 * xAxis Points
 * @see DiaryAnalysisSummaryVO
 * @see ToneAnalysis
 */
    private double[] y;
    /**
     * List backed array;
     * @see #x
     */
    private ArrayList<Double> xl;
       /**
     * List backed array;
     * @see #y
     */
    private ArrayList<Double> yl;
/**
 * Constructs default pair
 */
    public DiaryMoodToneXYPair() {
        xl = new ArrayList<Double>();
        yl = new ArrayList<Double>();
    }

    public void addPoint(double x, double y) {
        getXl().add(x);
        getYl().add(y);
    }
/**
 * Process data to points
 * @return 
 */
    public boolean process() {
      try{
        Double[] xp = new Double[1];
        Double[] yp = new Double[1];
            getXl().toArray(xp);
            getYl().toArray(yp);
            setX(ArrayUtils.toPrimitive(xp));
            setY(ArrayUtils.toPrimitive(yp));
      }catch(Exception e){
          return false;
      }
      return true;
    }
}
