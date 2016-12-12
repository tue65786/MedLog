<%-- 
    Document   : home
    Created on : Nov 3, 2016, 8:56:21 AM
    Author     : (c)2016 Guiding Technologies
--%>
<%@page import="com.medlog.webservice.vo.MedicationVO"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.medlog.webservice.vo.DiaryAnalysisWeightedChartVO"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.medlog.webservice.vo.DiaryAnalysisSummaryVO"%>
<%@page import="com.medlog.webservice.vo.DiaryAnalysisVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.medlog.webservice.vo.DiaryVO"%>
<%@page import="com.medlog.webservice.dao.MedLogDAO"%>
<%@page import="com.medlog.webservice.sql.DbConnection"%>
<%@page import="com.medlog.webservice.util.StrUtl"%>
<%@page import="com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis"%>
<%@page import="com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.medlog.webservice.vo.PatientVO" scope="session" />
<jsp:setProperty name="user" property="*"/>
<%
    String name = "";
    String onload = "";
    String diaryEntires = "";
    String diaryStat = "";
    ArrayList<MedicationVO> meds = null;
    String medString = "";
    String tonePair = "";
    int logins = 0;
    try {
        if (application != null && application.getAttribute("activeLogins") != null) {
            logins = (Integer) application.getAttribute("activeLogins");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    DbConnection db = new DbConnection();
    if (user == null || user.getPatientID() <= 0) {
        try {
            response.sendRedirect("login.html");
        } catch (Exception e) {
            onload = " onload=\"top.location.href='login.html'\" ";
        }
    } else {
        try {
            name = StrUtl.coalesce(user.getFirstName(), user.getLastName(), user.getUserName(), "");
            if (!name.isEmpty()) {
                name = " back " + name;

            }
//	  DbConnection db = new DbConnection();
            MedLogDAO dao = new MedLogDAO(db, user);
            ArrayList<DiaryVO> diary = dao.findDiaryByPatient();
            if (diary != null && !diary.isEmpty()) {
                diaryEntires = diary.size() + " recent entries. Last entry was " + diary.get(diary.size() - 1).getCreatedDate().toString() + ".  <ul style='width: 30%;font-size: 90%;border: 2px solid;border-radius: 4px;padding-right: 4px;line-height: 1.2em;'><li id='liA'></li><br/><li id='liB'></li></ul> <br/> Don't forget to keep your journal up to date.";
                try {
                    ArrayList<DiaryAnalysisVO> vl = dao.findDiaryCrossTab(user.getPatientID());
                    DiaryAnalysisSummaryVO instance = new DiaryAnalysisSummaryVO();
                    instance.runIt(vl);
                    ArrayList<DiaryAnalysisWeightedChartVO> areaData = new ArrayList<DiaryAnalysisWeightedChartVO>();
                    diaryStat = instance.getHtml();
                    for (DiaryAnalysisVO dv : vl) {
                        areaData.add(DiaryAnalysisWeightedChartVO.normalInstance(dv));
                    }
                    session.setAttribute("CURRENTDIARY", instance.getCurrentDiary().toHTML());
                    session.setAttribute("CURRENTDIARYCSV", instance.getCurrentDiary().toCSV());
//                    instance.getCurrentDiary().setRowTotal(instance.getCurrentDiary().getRowTotal() * 10);
                    DiaryAnalysisWeightedChartVO thisChart = DiaryAnalysisWeightedChartVO.normalInstance(instance.getCurrentDiary());
                    session.setAttribute("observedData", " Actual: " + instance.getCurrentDiary().getMood() + "  (RefID #" + (int) instance.getCurrentDiary().getDiaryID() + ")");
                    session.setAttribute("CURRENTDIARYCSV", thisChart.toCSV());
                    session.setAttribute("fiveNumber", Arrays.toString(instance.getFiveSummary()));
                    session.setAttribute("diaryEq", "y = " + String.format("%.2f", instance.getLineEq()[0]) + "x" + " + " + instance.getLineEq()[1] + " R²= " + instance.getLineEq()[2] + .001);
                    Gson g = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
                    String gson = g.toJson(vl);
                    tonePair = g.toJson(instance.getToneList());
                    String areaDataString = g.toJson(areaData);
//                    System.out.println(gson);
                    session.setAttribute("diaryReportData", gson);
                    session.setAttribute("diaryAreaData", areaDataString);
//                    System.out.println("home.jsp() " + areaDataString);
                    session.setAttribute("diaryTbl", diaryStat);
                } catch (Exception e) {

                }
            }
            meds = dao.findMedicationByPatient();
            if (meds != null && !meds.isEmpty()) {
                medString = "<table>";
                for (MedicationVO med : meds) {
                    medString += "<tr style='border:1px solid blue;'><td style='border:1px solid blue;'>" + med.getPharmID().getFullName() + "</td><td style='border:1px solid blue;'>"
                            + StrUtl.toS(med.getPhysicianID().getLastName() + ", " + med.getPhysicianID().getFirstName(), "Dr. Evil")
                            + "</td></tr>";
                }
                medString += "</table>";
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }
    db.close();
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <%
//		   ToneAnalyzer service = new ToneAnalyzer( ToneAnalyzer.VERSION_DATE_2016_05_19 );
//		   service.setEndPoint( "https://gateway.watsonplatform.net/tone-analyzer/api");
//		   service.setUsernameAndPassword( "iG3q4VeDckSF", "976f48de-3802-431a-bab4-d75b592abe44" );
//
//		   String text = "I know the times are difficult! Our sales have been "
//						 + "disappointing for the past three quarters for our data analytics "
//						 + "product suite. We have a competitive data analytics product "
//						 + "suite in the industry. But we need to do our job selling it! "
//						 + "We need to acknowledge and fix our sales challenges. "
//						 + "We can’t blame the economy for our lack of execution! " + "We are missing critical sales opportunities. "
//						 + "Our product is in no way inferior to the competitor products. "
//						 + "Our clients are hungry for analytical tools to improve their "
//						 + "business outcomes. Economy has nothing to do with it.";
//
//		   // Call the service and get the tone
//		   ToneAnalysis tone = service.getTone( text, null ).execute();
//		   System.out.println( tone );
//TODO 1. Logout DONE
//TODO 2. Update homepage data.
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MedLog</title>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <!--<link rel="stylesheet" href="style.css">-->
        <!--<link href="scripts/jqui/jquery-ui.css" rel="stylesheet" type="text/css"/>-->
        <link href="scripts/jqx/styles/jqx.base.css" rel="stylesheet" type="text/css"/>
        <link href="scripts/jqx/styles/jqx.fresh.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/jquery.min.js" type="text/javascript"></script>
        <script src="scripts/jqueryu.min.js" type="text/javascript"></script>
        <script src="scripts/jqx/jqxcore.js" type="text/javascript"></script>
        <script src="scripts/jqx/jqxscrollbar.js" type="text/javascript"></script>
        <script src="scripts/jqx/jqxlistbox.js" type="text/javascript"></script>
        <script src="scripts/jqx/jqxbuttons.js" type="text/javascript"></script>
        <script src="scripts/jqx/jqxdropdownlist.js" type="text/javascript"></script>
        <script src="scripts/jqx/jqxgauge-all.js?v1=1" type="text/javascript"></script>
        <style>
            #gaugeValue {
                background-image: -webkit-gradient(linear, 50% 0%, 50% 100%, color-stop(0%, #fafafa), color-stop(100%, #f3f3f3));
                background-image: -webkit-linear-gradient(#fafafa, #f3f3f3);
                background-image: -moz-linear-gradient(#fafafa, #f3f3f3);
                background-image: -o-linear-gradient(#fafafa, #f3f3f3);
                background-image: -ms-linear-gradient(#fafafa, #f3f3f3);
                background-image: linear-gradient(#fafafa, #f3f3f3);
                -webkit-border-radius: 3px;
                -moz-border-radius: 3px;
                -ms-border-radius: 3px;
                -o-border-radius: 3px;
                border-radius: 3px;
                -webkit-box-shadow: 0 0 50px rgba(0, 0, 0, 0.2);
                -moz-box-shadow: 0 0 50px rgba(0, 0, 0, 0.2);
                box-shadow: 0 0 50px rgba(0, 0, 0, 0.2);
                padding: 10px;

            }
            .ui-menu { width: 150px; }
            #menu a {text-decoration: none;}
            /*            .ui-tabs-vertical { width: 80%; margin-left: 200px; }
                        .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }
                        .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important;
                                                            border-right-width: 0 !important; margin: 0 -1px .2em 0;border-radius: 3px; }
                        .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
                        .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; }
                        .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right;
                                                           width: 66%;}*/
            #menu a {font-weight: bold;}
            footer {text-align: center; margin:0 auto;border-top:2px #0074c7 solid;}
        </style>
        <script type="text/javascript">
            $(function () {
                $("#menu").menu();
                $("#menu").menu({
                    select: function (event, ui) {

                        try {
                            var hr = ui.item[0].children[0].children[1].href;
                            if (typeof hr !== 'undefined') {
                                top.location.href = hr;

                            }
                            console.log(ui);
                        } catch (e) {
                            console.log(e);
                            return false;
                        }
                    }
                });

                $("#tabs").tabs({heightStyle: "auto"});//.addClass("ui-tabs-vertical ui-helper-clearfix");
//                $("#tabs li").removeClass("ui-corner-top").addClass("ui-corner-left");
                $("#logout").click(function () {
                    $.post('./api?fn=logout').done(function (  ) {
                        top.location.href = 'login.html';
                    });
                });

                var ddlData = <%=tonePair%>;
                console.log(ddlData);console.log("ddlData");
                var dropdownSource = _.pluck(ddlData, 'shortKey');
                $("#jqxDropDownList").jqxDropDownList({source: dropdownSource
                    , selectedIndex: 0, width: '300px', height: '45px'});
                try {
                    console.log(dropdownSource);
                } catch (e) {
                    console.log(e);
                }
                $('#gaugeContainer').jqxGauge({ranges: gr,
                    ticksMinor: ticks[0], ticksMajor: ticks[1],
                    value: 60,
                    max: 100,
                    radius: 125,
                    border: {visible: false},
                    animationDuration: 1200, labels: lbl
                });
                $('#jqxDropDownList').on('select', function (event) {
                    var args = event.args;
                    var item = $('#jqxDropDownList').jqxDropDownList('getItem', args.index);
                    if (item != null) {
                        var tO = new ToneClass(ddlData[args.index]);
                        console.log(tO);
                        $("li").removeClass("ui-state-highlight");
                        $("#"+tO.category()+"").addClass("ui-state-highlight");
                        $("#liA").empty().html("<b>Rank</b>: <span style='background-color:yellow'>"+tO.tone.rank + "</span> ("+tO.scoredText()+")");
                        $("#liB").empty().html("<b/>Desciption</b>: " + tO.toneTexts.desc);
                        $('#gaugeContainer').val(tO.gaugeValue);
//                        $('#Events').jqxPanel('prepend', '<div style="margin-top: 5px;">Selected: ' + item.label + '</div>');
                    }
                });

                $('#gaugeContainer').on('valueChanging', function (e) {
                    $('#gaugeValue').text(Math.round(e.args.value) + ' %');
                });
                function getToneTexts(id, score) {
                    if (score < .5) {

                    } else if (score < .75) {

                    } else {

                    }
                }

            });
        </script>

    </head>

    <body <%=onload%>>

        <div style="width:39%; float:left;height: 105px;">
            <div style="float:left;pading-left:5px;margin-left:17px;margin-right:0%;">
                <img src="Logo.png" style="height:60%;width:60%;" alt="log">
            </div><div style="margin-left:125px;padding:38px 0px 0px 3px;font-size:24pt;vertical-align: middle;font-weight: bolder;font-family: verdana;">
                Welcome <%=name%></div></div>


        <!--        <div style="width:95%; float:left;height: 125px;">
                    <div style="float:left;margin-left:165px;padding:80px 0 45px 40px;font-size:24pt;vertical-align: bottom;font-weight: bolder;font-family: verdana;">
                        Welcome </div><div style="float:right;margin-right:30%;">
                        <img src="Logo.png" style="height:75%;width:75%;" alt="log">
                    </div></div>	-->
        <div style="clear:both;"></div>
        <table style="width:99%;"><tr><td style="width:165px;vertical-align: top;">
                    <ul id="menu" style="">
                        <li>
                            <div><span class="ui-icon ui-icon-home"></span><a href="home.jsp">Medlog</a></div>
                        </li>
                        <li>
                            <div><span class="ui-icon ui-icon-person"></span><a href="User.html?id=<%=user.getPatientID()%>">Your account</a></div>
                            <ul><li><div>	<a href="User.html">Register</a></div></li><li><div>	<a href="#" id="logout">Logout</a></div></li></ul>
                        </li>
                        <li id="diary" data-url="">
                            <div><span class="ui-icon ui-icon-contact"></span>Diary</div>
                            <ul>
                                <li>
                                    <div><a  href="Journal.html"><span class="ui-icon "></span>Add</a></div>
                                </li>
                                <li>
                                    <div><span class="ui-icon"></span><a href="JournalList.html?id=1">List</a></div>
                                </li>
                                <li>
                                    <div><a href="report-journal.html"><span class="ui-icon"></span>Report</a></div>
                                </li>
                                <li>
                                    <div><span class="ui-icon"></span>Send</div>
                                </li>
                            </ul>
                        </li>
                        <li >
                            <div><span class="ui-icon ui-icon-note"></span><a href="DietaryRestriction.html">Dietary Restrictions</a></div>
                        </li>
                        <li>
                            <div><span class="ui-icon ui-icon-cart"></span>Health-care Providers</div>
                            <ul>
                                <li>
                                    <div><span class="ui-icon "></span><a href="HealthcareProviderList.html">List</a></div>
                                </li>
                                <li>
                                    <div><span class="ui-icon "></span><a href="HealthcareProvider.html">Add</a></div>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <div><span class="ui-icon ui-icon-script"></span>Medication</div>
                            <ul>
                                <li>
                                    <div><span class="ui-icon "></span><a href="Medication.html">Add</a></div>
                                </li>
                                <li>
                                    <div><span class="ui-icon "></span><a href="PharmaRXOTC.html">Drug</a></div>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </td><td style="vertical-align: top;">
                    <div id="tabs">
                        <ul>
                            <li><a href="#tabs-1">Recently logged</a></li>
                            <li><a href="#tabs-2">Current Meds</a></li>
                            <li><a href="#tabs-3">Generate Reports</a></li>
                        </ul>
                        <div id="tabs-1">
                            <h2>You logged .....</h2>

                            <p><%=diaryEntires%></p> 
                            <h2>Approach to tone analysis</h2>
                            <p><span title='© 2016 IBM'>The Tone Analyzer service</span> computes language tones with linguistic analysis 
                                that studies the correlation between various tones and linguistic features in 
                                written text. The following list describes the service's approach to computing a 
                                scorecard of language tones:</p>
                            <ul>
                                <li id="emotional"><strong>Emotional tone</strong> is derived from our work on Emotion 
                                    Analysis, which is an ensemble framework to infer emotions from a given 
                                    text. To derive emotion scores from text, we use a stacked 
                                    generalization-based ensemble framework. Stacked generalization is a general 
                                    method of using a high-level model to combine lower-level models to achieve 
                                    greater predictive accuracy. Features such as n-grams (unigrams, bigrams and 
                                    trigrams), punctuation, emoticons, curse words, greeting words (such as 
                                    hello, hi, and thanks), and sentiment polarity are fed into state-of-the 
                                    machine learning algorithms to classify emotion categories.</li>
                                <li id="social"><strong>Social tone</strong> consists of the Big Five personality 
                                    characteristics of openness, agreeableness, and conscientiousness. For more 
                                    information about these Big Five characteristics, see the description of the
                                    <a target="_blank" href="http://www.ibm.com/watson/developercloud/doc/personality-insights/models.shtml">
                                        personality models</a> from the Personality Insights service.</li>
                                <li id="language"><strong>Language tone</strong> is calculated from the linguistic 
                                    analysis based on learned features.</li>
                            </ul>
                            <sub>Tone Analysis / Watson are IP of IBM (Fair Use / <a href="http://www.ibm.com/ibm/licensing/">Legal</a>)</sub>
                            <div id="jqxDropDownList"  style="float: right;
                                 margin-top: -400px;
                                 margin-left: 600px;
                                 width: 300px;
                                 height: 45px;"></div>
                            <div style="float: left;width: 340px; height: 340px;margin-top: -548px;margin-left: 424px;" id="gaugeContainer"></div>
                            <div id="gaugeValue" style=" position: absolute;
                                 margin-top: -378px;
                                 margin-left: 503px;

                                 font-family: Sans-Serif;
                                 text-align: center;
                                 font-size: 17px;
                                 width: 70px;"></div>

                        </div>
                        <div id="tabs-2">
                            <h2>You have septum on file</h2>
                            <%=medString%>
                        </div>
                        <div id="tabs-3">
                            <h2>Last Entry Data</h2>
                            <div style="margin:10px;padding:5px;">
                                todo: addd last entry!!
                                <%=diaryStat%></div>
                        </div>
                    </div></td><td style="width:100px;vertical-align: top;"></td></tr></table><footer>Users online (<%=logins%>)</footer>
    </body></html>