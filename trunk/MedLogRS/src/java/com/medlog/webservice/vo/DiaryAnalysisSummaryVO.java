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
    private double[] guesses = new double[2];
    private DiaryAnalysisVO currentDiary;
    private HashMap<String, Integer> toneMap;
    private ArrayList<ToneKeyValuePair> toneList;
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
    private double[] lineEq = new double[3];
    private double[] fiveSummary = new double[5];
    private final int SLOPE = 0;
    private final int YINT = 1;
    private final int R = 0;

    private int[] LINE_EQ_PART = {SLOPE, YINT, R};

    public DiaryAnalysisSummaryVO() {
        toneCurrentAvgX = .399;
    }

    private void doBefore(int size) {
        setToneMap(new HashMap<String, Integer>());
        setCorr(new double[14]);
        setxAxisGuess(new double[size]);
        setrSquared(new double[14]);
        setCorrRanked(new double[14]);
        setAgreeablenessBig5(new double[size]);
        setAnalytical(new double[size]);
        setAnger(new double[size]);
        setConfident(new double[size]);
        setConscientiousnessBig5(new double[size]);
        setDisgust(new double[size]);
        setEmotionalRangeBig5(new double[size]);
        setExtraversionBig5(new double[size]);
        setFear(new double[size]);
        setJoy(new double[size]);
        setOpennessBig5(new double[size]);
        setSadness(new double[size]);
        setTentative(new double[size]);
        setMood(new double[size]);
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
            if (i == 0 || getCurrentDiary() == null || vo.getDiaryID() > getCurrentDiary().getDiaryID()) {
                setCurrentDiary(vo);
            }
            getAgreeablenessBig5()[i] = vo.getAgreeablenessBig5();
            getAnalytical()[i] = vo.getAnalytical();
            getAnger()[i] = vo.getAnger();
            getConfident()[i] = vo.getConfident();
            getConscientiousnessBig5()[i] = vo.getConscientiousnessBig5();
            getDisgust()[i] = vo.getDisgust();
            getEmotionalRangeBig5()[i] = vo.getEmotionalRangeBig5();
            getExtraversionBig5()[i] = vo.getExtraversionBig5();
            getFear()[i] = vo.getFear();
            getJoy()[i] = vo.getJoy();
            getOpennessBig5()[i] = vo.getOpennessBig5();
            getSadness()[i] = vo.getSadness();
            getTentative()[i] = vo.getTentative();
            getMood()[i] = vo.getMood();
        }
    }

    private void populateCorrelation() {
        SpearmansCorrelation c = new SpearmansCorrelation();

        getCorr()[IDX_MOOD] = c.correlation(getMood(), getMood());
        getCorr()[IDX_AGREEABLENESS_BIG5] = c.correlation(getMood(), getAgreeablenessBig5());
        getCorr()[IDX_MOOD] = c.correlation(getMood(), getMood());
        getCorr()[IDX_AGREEABLENESS_BIG5] = c.correlation(getMood(), getAgreeablenessBig5());
        getCorr()[IDX_ANALYTICAL] = c.correlation(getMood(), getAnalytical());
        getCorr()[IDX_ANGER] = c.correlation(getMood(), getAnger());
        getCorr()[IDX_CONFIDENT] = c.correlation(getMood(), getConfident());
        getCorr()[IDX_CONSCIENTIOUSNESS_BIG5] = c.correlation(getMood(), getConscientiousnessBig5());
        getCorr()[IDX_DISGUST] = c.correlation(getMood(), getDisgust());
        getCorr()[IDX_EMOTIONALRANGE_BIG5] = c.correlation(getMood(), getEmotionalRangeBig5());
        getCorr()[IDX_EXTRAVERSION_BIG5] = c.correlation(getMood(), getExtraversionBig5());
        getCorr()[IDX_FEAR] = c.correlation(getMood(), getFear());
        getCorr()[IDX_JOY] = c.correlation(getMood(), getJoy());
        getCorr()[IDX_OPENNESS_BIG5] = c.correlation(getMood(), getOpennessBig5());
        getCorr()[IDX_SADNESS] = c.correlation(getMood(), getSadness());
        getCorr()[IDX_TENTATIVE] = c.correlation(getMood(), getTentative());
        double corrTemp;
        for (int k = 0; k < getCorr().length; k++) {
            corrTemp = Math.pow(getCorr()[k], 2);
            if (StrUtl.matchOR(k, IDX_ANGER, IDX_DISGUST, IDX_FEAR, IDX_SADNESS)) {
                corrTemp = .99 - corrTemp;
            }
            getrSquared()[k] = corrTemp;
        }
        double q3 = org.apache.commons.math3.stat.StatUtils.percentile(getrSquared(), .75);

        double q1 = org.apache.commons.math3.stat.StatUtils.percentile(getrSquared(), .25);
        double var = StatUtils.variance(getrSquared());
        System.out.println("q1" + q1);
        System.out.println("q3" + q3);
        System.out.println("var" + var);
        double max = StatUtils.max(getrSquared());

        double min = StatUtils.max(getrSquared());

        setSum(StatUtils.sum(getrSquared()) - 1.0);
        System.out.println("sum" + getSum());
        for (int j = 1; j < 14; j++) {
            getCorrRanked()[j] = getrSquared()[j] / getSum();
        }
        System.out.println("pmf sum" + StatUtils.sum(getCorrRanked()));
        double[] cRCopy = ArrayUtils.clone(getCorrRanked());
        Arrays.sort(cRCopy);
        ArrayUtils.reverse(cRCopy);
        setToneList(new ArrayList<ToneKeyValuePair>());
        for (int j = 1; j < 14; j++) {
            ArrayUtils.indexOf(cRCopy, getCorrRanked()[j]);
            ToneKeyValuePair t = ToneKeyValuePair.builder().key(CORR_STR[j]).value(getrSquared()[j]).weightedValue(getCorrRanked()[j]).rank(ArrayUtils.indexOf(cRCopy, getCorrRanked()[j])).build();
            getToneList().add(ToneKeyValuePair.builder().key(CORR_STR[j]).value(getrSquared()[j]).weightedValue(getCorrRanked()[j]).rank(ArrayUtils.indexOf(cRCopy, getCorrRanked()[j]) + 1).build());
//            corrRanked[j] = rSquared[j] / sum;
        }

        double guess = 0;

        for (ToneKeyValuePair t : getToneList()) {
            guess += (t.getWeightedValue() * 10 * getValFromKeyPct(t.getKey()));//t.getWeightedValue());

            System.out.println(t.toString());
            System.out.println("com.medlog.webservice.vo.DiaryAnalysisSummaryVO.populateCorrelation() Guess with " + t.getRank() + "== " + guess);
        }
        SimpleRegression sg = new SimpleRegression(false);
        populateLineGuessPoints(sg);

        getGuesses()[1] = sg.predict(getToneCurrentAvgX());
        System.out.println("\n\n\ncom.medlog.webservice.vo.DiaryAnalysisSummaryVO.populateCorrelation() GUESS === >");

        System.out.printf("Weighted (history) Guess ------> %.3f%n", (guess));
        System.out.printf("Best fit line Guess -----------> %.3f%n", sg.predict(getToneCurrentAvgX()));
        guess /= 10;
        guess = Math.round(guess);
        System.out.printf("Weighted (history) Guess adj.-----> %.3f%n", (guess));
        System.out.println("-------------------------------------------\n");
        getGuesses()[0] = guess;
        getLineEq()[SLOPE] = sg.getSlope();
        getLineEq()[YINT] = sg.getIntercept();
        getLineEq()[R] = sg.getRSquare();
        double[] norm = StatUtils.normalize(getCorrRanked());
        
        if (DEBUG) {
            System.out.println("com.medlog.webservice.vo.DiaryAnalysisSummaryVO.populateCorrelation()" + Arrays.toString(norm));
        }
        getFiveSummary()[0] = StatUtils.min(norm);
        getFiveSummary()[1] = StatUtils.percentile(norm, 25);

        getFiveSummary()[2] = StatUtils.percentile(norm, 50);

        getFiveSummary()[3] = StatUtils.percentile(norm, 75);

        getFiveSummary()[4] = StatUtils.max(norm);

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
        setHtml("<table id='tblWeightedData'><thead><tr><th>Name</th><th>Rank</th><th>Weight</th><th>Value</th></tr></thead><tbody>");
        System.out.println("ID.........................\t\tR^2\t\t\tRank");
        Collections.sort(getToneList());
        for (int i = 0; i < getCorr().length; i++) {
            if (i < getCorr().length - 1) {
                setHtml(getHtml() + getToneList().get(i).toHTML());
            }
//        "<td>"+CORR_STR[i].replace(".", "") + "</td><td>"+corr[i]*corr[i]+"</td><td>"+corrRanked[i];
            System.out.print(CORR_STR[i] + "\t=\t");

//           System.out.print(corr[i]);
            System.out.print(getCorr()[i] * getCorr()[i]);
            if (i > 0) {
                System.out.print("\t" + getCorrRanked()[i] + "\n");
            } else {
                System.out.println();
            }
        }
        setHtml(getHtml() + "</tbody></table><table><tr><td colspan='4'><b>Total Weight: 0.9999994</b><br/>IQR:____</td></tr></table><h3>Guesses</h3><ol><li><b>Sample</b> : " + String.format("%.2f", getGuesses()[0]) + "</li><li><b>Model</b> : " + String.format("%.2f", getGuesses()[1]) + "</li></ol><a href='report-journal-tone_raw.jsp' title='Report'>Learn more...</a>");

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
            System.out.println("com.medlog.webservice.vo.DiaryAnalysisSummaryVO.getValFromKeyPct()" + val + " / " + getCurrentDiary().rowTotal);
        }
        return val / getCurrentDiary().getRowTotal();
    }

    /**
     * Retrieve current diary value by KEY
     *
     * @param key ref {@linkplain #CORR_STR}
     * @return
     */
    private double getValFromKey(String key) {
        key = sanitizeKey(key);
        if (DEBUG) {
            System.out.println("com.medlog.webservice.vo.DiaryAnalysisSummaryVO.getIDXFromName(KEY)" + key);
        }
        switch (key) {
            case "anger":
                return getCurrentDiary().anger;

            case "disgust":
                return getCurrentDiary().disgust;
//                break;
            case "fear":
                return getCurrentDiary().fear;
//                break;
            case "joy":
                return getCurrentDiary().joy;

            case "sadness":
                return getCurrentDiary().sadness;
//                break;
            case "analytical":
                return getCurrentDiary().analytical;
//                break;
            case "confident":
                return getCurrentDiary().confident;
//                break;
            case "tentative":
                return getCurrentDiary().tentative;
//                break;
            case "agreeableness_big5":
            case "agreeableness":
                return getCurrentDiary().agreeablenessBig5;
//                break;
            case "conscientiousness_big5":
            case "conscientiousness":
                return getCurrentDiary().conscientiousnessBig5;
//                break;
            case "emotional_range_big5":
            case "emotionalrange":
                return getCurrentDiary().emotionalRangeBig5;
//                break;
            case "extraversion_big5":
            case "extraversion":
                return getCurrentDiary().extraversionBig5;
//                break;
            case "openness_big5":
            case "openness":
                return getCurrentDiary().opennessBig5;
//                break;
            case "mood":
                return (int) getCurrentDiary().getMood();
//                break;
            default:
                return Double.MIN_VALUE;
        }
    }

    public static String sanitizeKey(String key) {
        key = StrUtl.toS(key).replace("IDX_", "").replace(("."), "").replace("BIG5", "").replace("_", "").replace(" ", "").toLowerCase();
        return key;
    }

    /**
     * @return the guesses
     */
    public double[] getGuesses() {
        return guesses;
    }

    /**
     * @param guesses the guesses to set
     */
    public void setGuesses(double[] guesses) {
        this.guesses = guesses;
    }

    /**
     * @return the currentDiary
     */
    public DiaryAnalysisVO getCurrentDiary() {
        return currentDiary;
    }

    /**
     * @param currentDiary the currentDiary to set
     */
    public void setCurrentDiary(DiaryAnalysisVO currentDiary) {
        this.currentDiary = currentDiary;
    }

    /**
     * @return the toneMap
     */
    public HashMap<String, Integer> getToneMap() {
        return toneMap;
    }

    /**
     * @param toneMap the toneMap to set
     */
    public void setToneMap(HashMap<String, Integer> toneMap) {
        this.toneMap = toneMap;
    }

    /**
     * @return the toneList
     */
    public ArrayList<ToneKeyValuePair> getToneList() {
        return toneList;
    }

    /**
     * @param toneList the toneList to set
     */
    public void setToneList(ArrayList<ToneKeyValuePair> toneList) {
        this.toneList = toneList;
    }

    /**
     * @return the sum
     */
    public double getSum() {
        return sum;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(double sum) {
        this.sum = sum;
    }

    /**
     * @return the agreeablenessBig5
     */
    public double[] getAgreeablenessBig5() {
        return agreeablenessBig5;
    }

    /**
     * @param agreeablenessBig5 the agreeablenessBig5 to set
     */
    public void setAgreeablenessBig5(double[] agreeablenessBig5) {
        this.agreeablenessBig5 = agreeablenessBig5;
    }

    /**
     * @return the analytical
     */
    public double[] getAnalytical() {
        return analytical;
    }

    /**
     * @param analytical the analytical to set
     */
    public void setAnalytical(double[] analytical) {
        this.analytical = analytical;
    }

    /**
     * @return the anger
     */
    public double[] getAnger() {
        return anger;
    }

    /**
     * @param anger the anger to set
     */
    public void setAnger(double[] anger) {
        this.anger = anger;
    }

    /**
     * @return the confident
     */
    public double[] getConfident() {
        return confident;
    }

    /**
     * @param confident the confident to set
     */
    public void setConfident(double[] confident) {
        this.confident = confident;
    }

    /**
     * @return the conscientiousnessBig5
     */
    public double[] getConscientiousnessBig5() {
        return conscientiousnessBig5;
    }

    /**
     * @param conscientiousnessBig5 the conscientiousnessBig5 to set
     */
    public void setConscientiousnessBig5(double[] conscientiousnessBig5) {
        this.conscientiousnessBig5 = conscientiousnessBig5;
    }

    /**
     * @return the disgust
     */
    public double[] getDisgust() {
        return disgust;
    }

    /**
     * @param disgust the disgust to set
     */
    public void setDisgust(double[] disgust) {
        this.disgust = disgust;
    }

    /**
     * @return the emotionalRangeBig5
     */
    public double[] getEmotionalRangeBig5() {
        return emotionalRangeBig5;
    }

    /**
     * @param emotionalRangeBig5 the emotionalRangeBig5 to set
     */
    public void setEmotionalRangeBig5(double[] emotionalRangeBig5) {
        this.emotionalRangeBig5 = emotionalRangeBig5;
    }

    /**
     * @return the extraversionBig5
     */
    public double[] getExtraversionBig5() {
        return extraversionBig5;
    }

    /**
     * @param extraversionBig5 the extraversionBig5 to set
     */
    public void setExtraversionBig5(double[] extraversionBig5) {
        this.extraversionBig5 = extraversionBig5;
    }

    /**
     * @return the fear
     */
    public double[] getFear() {
        return fear;
    }

    /**
     * @param fear the fear to set
     */
    public void setFear(double[] fear) {
        this.fear = fear;
    }

    /**
     * @return the joy
     */
    public double[] getJoy() {
        return joy;
    }

    /**
     * @param joy the joy to set
     */
    public void setJoy(double[] joy) {
        this.joy = joy;
    }

    /**
     * @return the opennessBig5
     */
    public double[] getOpennessBig5() {
        return opennessBig5;
    }

    /**
     * @param opennessBig5 the opennessBig5 to set
     */
    public void setOpennessBig5(double[] opennessBig5) {
        this.opennessBig5 = opennessBig5;
    }

    /**
     * @return the sadness
     */
    public double[] getSadness() {
        return sadness;
    }

    /**
     * @param sadness the sadness to set
     */
    public void setSadness(double[] sadness) {
        this.sadness = sadness;
    }

    /**
     * @return the tentative
     */
    public double[] getTentative() {
        return tentative;
    }

    /**
     * @param tentative the tentative to set
     */
    public void setTentative(double[] tentative) {
        this.tentative = tentative;
    }

    /**
     * @return the mood
     */
    public double[] getMood() {
        return mood;
    }

    /**
     * @param mood the mood to set
     */
    public void setMood(double[] mood) {
        this.mood = mood;
    }

    /**
     * @return the corr
     */
    public double[] getCorr() {
        return corr;
    }

    /**
     * @param corr the corr to set
     */
    public void setCorr(double[] corr) {
        this.corr = corr;
    }

    /**
     * @return the corrRanked
     */
    public double[] getCorrRanked() {
        return corrRanked;
    }

    /**
     * @param corrRanked the corrRanked to set
     */
    public void setCorrRanked(double[] corrRanked) {
        this.corrRanked = corrRanked;
    }

    /**
     * @return the rSquared
     */
    public double[] getrSquared() {
        return rSquared;
    }

    /**
     * @param rSquared the rSquared to set
     */
    public void setrSquared(double[] rSquared) {
        this.rSquared = rSquared;
    }

    /**
     * @return the xAxisGuess
     */
    public double[] getxAxisGuess() {
        return xAxisGuess;
    }

    /**
     * @param xAxisGuess the xAxisGuess to set
     */
    public void setxAxisGuess(double[] xAxisGuess) {
        this.xAxisGuess = xAxisGuess;
    }

    /**
     * @return the toneCurrentAvgX
     */
    public double getToneCurrentAvgX() {
        return toneCurrentAvgX;
    }

    /**
     * @param toneCurrentAvgX the toneCurrentAvgX to set
     */
    public void setToneCurrentAvgX(double toneCurrentAvgX) {
        this.toneCurrentAvgX = toneCurrentAvgX;
    }

    /**
     * @return the lineEq
     */
    public double[] getLineEq() {
        return lineEq;
    }

    /**
     * @param lineEq the lineEq to set
     */
    public void setLineEq(double[] lineEq) {
        this.lineEq = lineEq;
    }

    /**
     * @return the fiveSummary
     */
    public double[] getFiveSummary() {
        return fiveSummary;
    }

    /**
     * @param fiveSummary the fiveSummary to set
     */
    public void setFiveSummary(double[] fiveSummary) {
        this.fiveSummary = fiveSummary;
    }
}
