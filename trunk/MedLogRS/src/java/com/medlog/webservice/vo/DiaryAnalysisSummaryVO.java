/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import java.util.ArrayList;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

/**
 *
 * @author westy
 */
public class DiaryAnalysisSummaryVO {

    private double[] agreeablenessBig5;
    private double[] analytical;
    private double[] anger;
    private double[] confident;
    private double[] conscientiousnessBig5;
    private double[] disgust;
    private double[] emotionalRangeBig5;
    private double[] extraversionBig5;
    private double[] fear;
    private double[] joy;
    private double[] opennessBig5;
    private double[] sadness;
    private double[] tentative;
    private double[] mood;
    public static final int IDX_MOOD = 0;
    public static final int IDX_AGREEABLENESS_BIG5 = 1;
    public static final int IDX_ANALYTICAL = 2;
    public static final int IDX_ANGER = 3;
    public static final int IDX_CONFIDENT = 4;
    public static final int IDX_CONSCIENTIOUSNESS_BIG5 = 5;
    public static final int IDX_DISGUST = 6;
    public static final int IDX_EMOTIONALRANGE_BIG5 = 7;
    public static final int IDX_EXTRAVERSION_BIG5 = 8;
    public static final int IDX_FEAR = 9;
    public static final int IDX_JOY = 10;
    public static final int IDX_OPENNESS_BIG5 = 11;
    public static final int IDX_SADNESS = 12;
    public static final int IDX_TENTATIVE = 13;
    private double[] corr;
public static final String[] CORR_STR = {"[IDX_MOOD]",
"IDX_AGREEABLENESS_BIG5",
"IDX_ANALYTICAL",
"IDX_ANGER",
"IDX_CONFIDENT",
"IDX_CONSCIENTIOUSNESS_BIG5",
"IDX_DISGUST",
"IDX_EMOTIONALRANGE_BIG5",
"IDX_EXTRAVERSION_BIG5",
"IDX_FEAR",
"IDX_JOY",
"IDX_OPENNESS_BIG5",
"IDX_SADNESS",
"IDX_TENTATIVE"};
    private void doBefore(int size) {
        corr = new double[14];
        agreeablenessBig5 = new double[size];
        analytical = new double[size];
        anger = new double[size];
        confident = new double[size];
        conscientiousnessBig5 = new double[size];
        disgust = new double[size];
        emotionalRangeBig5 = new double[size];
        extraversionBig5 = new double[size];
        fear = new double[size];
        joy = new double[size];
        opennessBig5 = new double[size];
        sadness = new double[size];
        tentative = new double[size];
        mood = new double[size];
    }

    public void runIt(ArrayList<DiaryAnalysisVO> vl) {
        doBefore(vl.size());
        populateScores(vl);
        populateCorrelation();
        printCorr();

    }

    private void populateScores(ArrayList<DiaryAnalysisVO> vl) {
        for (int i = 0; i < vl.size(); i++) {
            DiaryAnalysisVO vo = vl.get(i);
            agreeablenessBig5[i] = vo.getAgreeablenessBig5();
            analytical[i] = vo.getAnalytical();
            anger[i] = vo.getAnger();
            confident[i] = vo.getConfident();
            conscientiousnessBig5[i] = vo.getConscientiousnessBig5();
            disgust[i] = vo.getDisgust();
            emotionalRangeBig5[i] = vo.getEmotionalRangeBig5();
            extraversionBig5[i] = vo.getExtraversionBig5();
            fear[i] = vo.getFear();
            joy[i] = vo.getJoy();
            opennessBig5[i] = vo.getOpennessBig5();
            sadness[i] = vo.getSadness();
            tentative[i] = vo.getTentative();
            mood[i] = vo.getMood();
        }
    }

    private void populateCorrelation() {
        SpearmansCorrelation c = new SpearmansCorrelation();
        
        corr[IDX_MOOD] = c.correlation(mood, mood);
        corr[IDX_AGREEABLENESS_BIG5] = c.correlation(mood, agreeablenessBig5);
        corr[IDX_MOOD] = c.correlation(mood, mood);
        corr[IDX_AGREEABLENESS_BIG5] = c.correlation(mood, agreeablenessBig5);
        corr[IDX_ANALYTICAL] = c.correlation(mood, analytical);
        corr[IDX_ANGER] = c.correlation(mood, anger);
        corr[IDX_CONFIDENT] = c.correlation(mood, confident);
        corr[IDX_CONSCIENTIOUSNESS_BIG5] = c.correlation(mood, conscientiousnessBig5);
        corr[IDX_DISGUST] = c.correlation(mood, disgust);
        corr[IDX_EMOTIONALRANGE_BIG5] = c.correlation(mood, emotionalRangeBig5);
        corr[IDX_EXTRAVERSION_BIG5] = c.correlation(mood, extraversionBig5);
        corr[IDX_FEAR] = c.correlation(mood, fear);
        corr[IDX_JOY] = c.correlation(mood, joy);
        corr[IDX_OPENNESS_BIG5] = c.correlation(mood, opennessBig5);
        corr[IDX_SADNESS] = c.correlation(mood, sadness);
        corr[IDX_TENTATIVE] = c.correlation(mood, tentative);
        
    }
    
    private void printCorr(){
       for (int i=0;i<corr.length;i++){
           System.out.print(CORR_STR[i] + "\t=\t");
//           System.out.print(corr[i]);
           System.out.println(corr[i]*corr[i]);
           System.out.println("-----------------");
           
       }
    }

}
