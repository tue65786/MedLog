/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import static com.medlog.webservice.CONST.SETTINGS.DEBUG;
import com.medlog.webservice.util.StrUtl;
import com.medlog.webservice.vo.pairs.ToneKeyValuePair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.apache.commons.math3.stat.regression.ModelSpecificationException;
import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 *
 * @author westy
 */
public class DiaryAnalysisSummaryVO {

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
    public static final String[] CORR_STR = {
        "IDX_MOOD ...................",
        "IDX_AGREEABLENESS_BIG5 .....",
        "IDX_ANALYTICAL ............",
        "IDX_ANGER .................",
        "IDX_CONFIDENT .............",
        "IDX_CONSCIENTIOUSNESS_BIG5 .",
        "IDX_DISGUST ................",
        "IDX_EMOTIONALRANGE_BIG5 ....",
        "IDX_EXTRAVERSION_BIG5 ......",
        "IDX_FEAR ...................",
        "IDX_JOY ....................",
        "IDX_OPENNESS_BIG5 ..........",
        "IDX_SADNESS ................",
        "IDX_TENTATIVE .............."};
    public double[] guesses = new double[2];
    private DiaryAnalysisVO currentDiary;
    private HashMap<String, Integer> toneMap;
    ArrayList<ToneKeyValuePair> toneList;
    private double sum = 0;
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
    private double[] corr;
    private double[] corrRanked;
    private double[] rSquared;
    private double[] xAxisGuess;
    private String html = "";
    private double toneCurrentAvgX;
    public double[] lineEq = new double[3];
    public double[] fiveSummary = new double[5];
    private final int SLOPE = 0;
    private final int YINT = 1;
    private final int R = 0;

    private int[] LINE_EQ_PART = {SLOPE, YINT, R};

    public DiaryAnalysisSummaryVO() {
        toneCurrentAvgX = .399;
    }

    private void doBefore(int size) {
        toneMap = new HashMap<String, Integer>();
        corr = new double[14];
        xAxisGuess = new double[size];
        rSquared = new double[14];
        corrRanked = new double[14];
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
            if (i == 0 || currentDiary == null || vo.getDiaryID() > currentDiary.getDiaryID()) {
                currentDiary = vo;
            }
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
        double corrTemp;
        for (int k = 0; k < corr.length; k++) {
            corrTemp = Math.pow(corr[k], 2);
            if (StrUtl.matchOR(k, IDX_ANGER, IDX_DISGUST, IDX_FEAR, IDX_SADNESS)) {
                corrTemp = .99 - corrTemp;
            }
            rSquared[k] = corrTemp;
        }
        double q3 = org.apache.commons.math3.stat.StatUtils.percentile(rSquared, .75);

        double q1 = org.apache.commons.math3.stat.StatUtils.percentile(rSquared, .25);
        double var = StatUtils.variance(rSquared);
        System.out.println("q1" + q1);
        System.out.println("q3" + q3);
        System.out.println("var" + var);
        double max = StatUtils.max(rSquared);

        double min = StatUtils.max(rSquared);

        sum = StatUtils.sum(rSquared) - 1.0;
        System.out.println("sum" + sum);
        for (int j = 1; j < 14; j++) {
            corrRanked[j] = rSquared[j] / sum;
        }
        System.out.println("pmf sum" + StatUtils.sum(corrRanked));
        double[] cRCopy = ArrayUtils.clone(corrRanked);
        Arrays.sort(cRCopy);
        ArrayUtils.reverse(cRCopy);
        toneList = new ArrayList<>();
        for (int j = 1; j < 14; j++) {
            ArrayUtils.indexOf(cRCopy, corrRanked[j]);
            ToneKeyValuePair t = ToneKeyValuePair.builder().key(CORR_STR[j]).value(rSquared[j]).weightedValue(corrRanked[j]).rank(ArrayUtils.indexOf(cRCopy, corrRanked[j])).build();
            toneList.add(ToneKeyValuePair.builder().key(CORR_STR[j]).value(rSquared[j]).weightedValue(corrRanked[j]).rank(ArrayUtils.indexOf(cRCopy, corrRanked[j]) + 1).build());
//            corrRanked[j] = rSquared[j] / sum;
        }

        double guess = 0;

        for (ToneKeyValuePair t : toneList) {
            guess += (t.getWeightedValue() * 10 * getValFromKeyPct(t.getKey()));//t.getWeightedValue());

            System.out.println(t.toString());
            System.out.println("com.medlog.webservice.vo.DiaryAnalysisSummaryVO.populateCorrelation() Guess with " + t.getRank() + "== " + guess);
        }
        SimpleRegression sg = new SimpleRegression(false);
        populateLineGuessPoints(sg);

        guesses[1] = sg.predict(toneCurrentAvgX);
        System.out.println("\n\n\ncom.medlog.webservice.vo.DiaryAnalysisSummaryVO.populateCorrelation() GUESS === >");

        System.out.printf("Weighted (history) Guess ------> %.3f%n", (guess));
        System.out.printf("Best fit line Guess -----------> %.3f%n", sg.predict(toneCurrentAvgX));
        guess /= 10;
        guess = Math.round(guess);
        System.out.printf("Weighted (history) Guess adj.-----> %.3f%n", (guess));
        System.out.println("-------------------------------------------\n");
        guesses[0] = guess;
        lineEq[SLOPE] = sg.getSlope();
        lineEq[YINT] = sg.getIntercept();
        lineEq[R] = sg.getRSquare();
        double[] norm = StatUtils.normalize(corrRanked);
        fiveSummary[0] = StatUtils.min(norm);
        fiveSummary[1] = StatUtils.percentile(norm, 25);

        fiveSummary[2] = StatUtils.percentile(norm, 50);

        fiveSummary[3] = StatUtils.percentile(norm, 75);

        fiveSummary[4] = StatUtils.max(norm);

    }
// <editor-fold defaultstate="collapsed" desc="Helpers.">

    private void populateLineGuessPoints(SimpleRegression sg) throws ModelSpecificationException {
        sg.addData(new double[][]{
            {0.5322920416, 3},
            {0.4385508333, 8},
            {0.3922372962, 9},
            {0.4846032539, 7},
            {0.4941322222, 7},
            {0.2621152000, 8},
            {0.7150910000, 5},
            {0.5197160000, 5},
            {0.4462330000, 5},
            {0.7522432500, 10},
            {0.2843740000, 1},
            {0.3227760000, 4},
            {0.6565395000, 8},
            {0.4388810000, 10}

        });
    }
// </editor-fold>

    private void printCorr() {
        setHtml("<table><tr><th>Name</th><th>Rank</th><th>Weight</th><th>Value</th></tr>");
        System.out.println("ID.........................\t\tR^2\t\t\tRank");
        Collections.sort(toneList);
        for (int i = 0; i < corr.length; i++) {
            if (i < corr.length - 1) {
                setHtml(getHtml() + toneList.get(i).toHTML());
            }
//        "<td>"+CORR_STR[i].replace(".", "") + "</td><td>"+corr[i]*corr[i]+"</td><td>"+corrRanked[i];
            System.out.print(CORR_STR[i] + "\t=\t");

//           System.out.print(corr[i]);
            System.out.print(corr[i] * corr[i]);
            if (i > 0) {
                System.out.print("\t" + corrRanked[i] + "\n");
            } else {
                System.out.println();
            }
        }
        setHtml(getHtml() + "<tr><td colspan='4'><b>Total Weight: 0.9999994</b><br/>IQR:.0041</td></tr></table><h3>Guesses</h3><ol><li><b>Sample</b> : " + String.format("%.2f%%", guesses[0]) + "</li><li><b>Model</b> : " + String.format("%.2f%%", guesses[1]) + "</li></ol><a href='report-journal-tone_raw.jsp' title='Report'>Learn more...</a>");

        System.out.println("\n\n" + html + "\n\n");
    }

    /**
     * @return the html
     */
    public String getHtml() {
        return html;
    }

    /**
     * @param html the html to set
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * Retrieve current diary value by KEY as Percent
     *
     * @param key
     * @return
     * @see #getValFromKey(java.lang.String)
     */
    private double getValFromKeyPct(String key) {
        double val = getValFromKey(key);
        if (DEBUG) {
            System.out.println("com.medlog.webservice.vo.DiaryAnalysisSummaryVO.getValFromKeyPct()" + val + " / " + currentDiary.rowTotal);
        }
        return val / currentDiary.getRowTotal();
    }

    /**
     * Retrieve current diary value by KEY
     *
     * @param key ref {@linkplain #CORR_STR}
     * @return
     */
    private double getValFromKey(String key) {
        key = StrUtl.toS(key).replace("IDX_", "").replace(("."), "").replace("BIG5", "").replace("_", "").replace(" ", "").toLowerCase();
        if (DEBUG) {
            System.out.println("com.medlog.webservice.vo.DiaryAnalysisSummaryVO.getIDXFromName(KEY)" + key);
        }
        switch (key) {
            case "anger":
                return currentDiary.anger;

            case "disgust":
                return currentDiary.disgust;
//                break;
            case "fear":
                return currentDiary.fear;
//                break;
            case "joy":
                return currentDiary.joy;

            case "sadness":
                return currentDiary.sadness;
//                break;
            case "analytical":
                return currentDiary.analytical;
//                break;
            case "confident":
                return currentDiary.confident;
//                break;
            case "tentative":
                return currentDiary.tentative;
//                break;
            case "agreeableness_big5":
            case "agreeableness":
                return currentDiary.agreeablenessBig5;
//                break;
            case "conscientiousness_big5":
            case "conscientiousness":
                return currentDiary.conscientiousnessBig5;
//                break;
            case "emotional_range_big5":
            case "emotionalrange":
                return currentDiary.emotionalRangeBig5;
//                break;
            case "extraversion_big5":
            case "extraversion":
                return currentDiary.extraversionBig5;
//                break;
            case "openness_big5":
            case "openness":
                return currentDiary.opennessBig5;
//                break;
            case "mood":
                return (int) currentDiary.getMood();
//                break;
            default:
                return Double.MIN_VALUE;
        }
    }
}
