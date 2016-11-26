/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.util;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.SentenceTone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;
import com.medlog.webservice.sql.DbConnection;
import static com.medlog.webservice.util.StrUtl.toS;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.catalina.tribes.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author westy
 */
public class ToneAnalyzerExample {

    public static void main(String[] args) {
        ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
        service.setUsernameAndPassword("d2f6715f-5baf-4420-bd22-a9a87854c7b1", "oOxW06RaXCCE");

        String text = "I know the times are difficult! Our sales have been "
                + "disappointing for the past three quarters for our data analytics "
                + "product suite. We have a competitive data analytics product "
                + "suite in the industry. But we need to do our job selling it! "
                + "We need to acknowledge and fix our sales challenges. "
                + "We can’t blame the economy for our lack of execution! " + "We are missing critical sales opportunities. "
                + "Our product is in no way inferior to the competitor products. "
                + "Our clients are hungry for analytical tools to improve their "
                + "business outcomes. Economy has nothing to do with it.";

        // Call the service and get the tone
        ToneAnalysis tone = service.getTone(text, null).execute();
        List<ToneCategory> to = tone.getDocumentTone().getTones();
        String cat_id = "";
        for (ToneCategory c : to) {
            cat_id = c.getId();
            for (ToneScore s : c.getTones()) {

            }

        }
    
        System.out.println(tone);

    }

    public static void processTone(DbConnection dbc, ToneAnalysis tone, int diaryID) {
        CallableStatement cs = null;
        String cat_id = "";
        try {
            //category , tone , sentance,score,text
            List<ToneCategory> to = tone.getDocumentTone().getTones();
            Connection conn = dbc.getConnnection();

            conn.prepareCall(new StringBuilder().append("{call spDiaryTextScoreInsert(").append(diaryID).append(",?,?,?,?,?)}").toString());
            conn.setAutoCommit(false);
            cs.setInt(3, 0);
            cs.setNull(5, java.sql.Types.NVARCHAR);// cat_id);

            for (ToneCategory docTC : to) {
                cat_id = docTC.getId();
                cs.setString(1, cat_id);
                for (ToneScore s : docTC.getTones()) {
                    cs.setString(2, s.getId());
                    cs.setDouble(4, s.getScore());
                    cs.addBatch();
                }
                int[] docRes = cs.executeBatch();
                 cs.clearBatch();
                System.out.println("com.medlog.webservice.util.ToneAnalyzerExample.processTone() result --- " + ArrayUtils.toString(docRes));
            }
            System.out.println("com.medlog.webservice.util.ToneAnalyzerExample.processTone() Process " + tone.getSentencesTone().size() + " sentances.");
            for (SentenceTone sentT : tone.getSentencesTone()) {
                to = sentT.getTones();
                cs.setInt(3, sentT.getId());
                cs.setString(5, toS(sentT.getText()).trim());
                for (ToneCategory docTC : to) {
                    cat_id = docTC.getId();
                    cs.setString(1, cat_id);
                    for (ToneScore s : docTC.getTones()) {
                        cs.setString(2, s.getId());
                        cs.setDouble(4, s.getScore());
                        cs.addBatch();
                    }
                    int[] docRes = cs.executeBatch();
                    cs.clearBatch();
                    System.out.println("com.medlog.webservice.util.ToneAnalyzerExample.processTone() result["+sentT.getId()+"] " + ArrayUtils.toString(docRes));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ToneAnalyzerExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
