/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.services.tone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Behavior;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ConsumptionPreferences;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Trait;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;
import com.ibm.watson.developer_cloud.service.exception.RequestTooLargeException;
import com.ibm.watson.developer_cloud.service.exception.TooManyRequestsException;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.SentenceTone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;
import com.medlog.webservice.CONST.SETTINGS;
import com.medlog.webservice.sql.DbConnection;
import com.medlog.webservice.util.DbUtl;
import static com.medlog.webservice.util.StrUtl.toS;
import com.medlog.webservice.util.ToneAnalyzerExample;
import com.medlog.webservice.vo.DiaryVO;
import java.sql.BatchUpdateException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Watson DB Processor
 *
 * @author
 */
public class ToneProcessorFactory {

    /**
     *
     * @param dbc
     * @param vo
     * @return
     * @see PersonalityInsights
     * @see WatsonService
     * @see ToneAnalyzer
     * @see DiaryVO
     */
    public static String execute(DbConnection dbc, DiaryVO vo) {
        ToneAnalysis tone = null;
        Profile profile = null;
        try {
            ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);

            PersonalityInsights insights = new PersonalityInsights(PersonalityInsights.VERSION_DATE_2016_10_19, SETTINGS.WATSON_USER, SETTINGS.WATSON_PASS);
            service.setUsernameAndPassword(SETTINGS.WATSON_USER, SETTINGS.WATSON_PASS);
            String txtToProcess = new StringBuilder().append(vo.getTitle()).append(". ").append(vo.getNotes()).toString();
            ProfileOptions options = new ProfileOptions.Builder()
                    //    .contentItems(content.getContentItems())
                    .consumptionPreferences(true)
                    .rawScores(true)
                    .text(txtToProcess)
                    .build();
            profile = insights.getProfile(options).execute();

            List<Behavior> b = profile.getBehavior();
            List<ConsumptionPreferences> cp = profile.getConsumptionPreferences();
            List<Trait> prof = profile.getNeeds();
            List<Trait> person = profile.getPersonality();
            List<Trait> val = profile.getValues();
            profile.getWarnings();

            tone = service.getTone(txtToProcess, null).execute();
            System.out.println("com.medlog.webservice.services.tone.ToneProcessorFactory.execute()" + tone);
            processTone(dbc, tone, vo.getId());
        } catch (UnauthorizedException | TooManyRequestsException | RequestTooLargeException | BadRequestException e) {
            e.printStackTrace();
        } catch (RuntimeException ee) {
            ee.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toS(new GsonBuilder().setPrettyPrinting().setLenient().create().toJson(ToneCategory.builder().profile(profile).tone(tone).build()),tone == null ? "" :tone.toString() + "\n"+ profile.toString());
                
        

    }

    private static ArrayList<Integer> processTone(DbConnection dbc, ToneAnalysis tone, int diaryID) {
        CallableStatement cs = null;
        String cat_id = "";
        ArrayList<Integer> results = new ArrayList<Integer>();
        try {
            //category , tone , sentance,score,text
            List<com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory> to = tone.getDocumentTone().getTones();
            Connection conn = dbc.getConnnection();

            cs = conn.prepareCall(new StringBuilder().append("{call spDiaryTextScoreInsert(").append(diaryID).append(",?,?,?,?,?)}").toString());
            conn.setAutoCommit(false);
            cs.setInt(3, 0);
            cs.setNull(5, java.sql.Types.NVARCHAR);// cat_id);

            for (com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory docTC : to) {
                cat_id = docTC.getId();
                cs.setString(1, cat_id);
                for (ToneScore s : docTC.getTones()) {
                    cs.setString(2, s.getId());
                    cs.setDouble(4, s.getScore());
                    cs.addBatch();
                }
//                int[] docRes = cs.executeBatch();
//                List l = Arrays.asList(docRes);
//                results.addAll(l);

//                cs.clearBatch();
//                System.out.println("com.medlog.webservice.util.ToneAnalyzerExample.processTone() result --- " + ArrayUtils.toString(docRes));
            }
            System.out.println("com.medlog.webservice.util.ToneAnalyzerExample.processTone() Process " + tone.getSentencesTone().size() + " sentances.");
            for (SentenceTone sentT : tone.getSentencesTone()) {
                to = sentT.getTones();
                cs.setInt(3, sentT.getId());
                cs.setString(5, toS(sentT.getText()).trim());
                for (com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory docTC : to) {
                    cat_id = docTC.getId();
                    cs.setString(1, cat_id);
                    int[] sentRes = null;
                    try {
                        for (ToneScore s : docTC.getTones()) {
                            cs.setString(2, s.getId());
                            cs.setDouble(4, s.getScore());
                            cs.addBatch();
                        }
                        sentRes = cs.executeBatch();
                        List l = Arrays.asList(sentRes);
                        results.addAll(l);
                    } catch (SQLException s) {
                        System.err.println("com.medlog.webservice.services.tone.ToneProcessorFactory.processTone(loop)" + DbUtl.printJDBCExceptionMsg(s));
                    }
                    conn.setAutoCommit(true);
                    cs.clearBatch();
                    System.out.println("com.medlog.webservice.util.ToneAnalyzerExample.processTone() result["
                            + sentT.getId() + "] " + ArrayUtils.toString(sentRes));
                }
            }
        } catch (BatchUpdateException ex) {
            Logger.getLogger(ToneAnalyzerExample.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("com.medlog.webservice.services.tone.ToneProcessorFactory.processTone(batch)" + DbUtl.printBatchUpdateException(ex));

        } catch (SQLTimeoutException ex) {

            Logger.getLogger(ToneAnalyzerExample.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(ToneAnalyzerExample.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("com.medlog.webservice.services.tone.ToneProcessorFactory.processTone(meth)" + DbUtl.printJDBCExceptionMsg(ex));

        } finally {
            DbUtl.close(cs);
        }
        return results;
    }
}
