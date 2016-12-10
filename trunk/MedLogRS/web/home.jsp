<%-- 
    Document   : home
    Created on : Nov 3, 2016, 8:56:21 AM
    Author     : (c)2016 Guiding Technologies
--%>
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
    int logins = 0;
    try {
        logins = (int) application.getAttribute("activeLogins");
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
                diaryEntires = diary.size() + " recent entries. Last entry was " + diary.get(diary.size() - 1).getCreatedDate().toString() + ".  <ul><li>Mood is looking up!</li><li>Work on productivity.</li></ul> <br/> Don't forget to keep your journal up to date.";
                try {
                    ArrayList<DiaryAnalysisVO> vl = dao.findDiaryCrossTab(user.getPatientID());
                    DiaryAnalysisSummaryVO instance = new DiaryAnalysisSummaryVO();
                    instance.runIt(vl);
                    ArrayList<DiaryAnalysisWeightedChartVO> areaData = new ArrayList<>();
                    diaryStat = instance.getHtml();
                    for (DiaryAnalysisVO dv : vl) {
                        areaData.add(DiaryAnalysisWeightedChartVO.normalInstance(dv));
                    }
                    session.setAttribute("fiveNumber", Arrays.toString(instance.fiveSummary));
                    session.setAttribute("diaryEq", "y = " + String.format("%.2f", instance.lineEq[0]) + "x" + " + " + instance.lineEq[1] + " R²= " + instance.lineEq[2] + .001);
                    Gson g = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
                    String gson = g.toJson(vl);
                    String areaDataString = g.toJson(areaData);
//                    System.out.println(gson);
                    session.setAttribute("diaryReportData", gson);
                    session.setAttribute("diaryAreaData", areaDataString);
//                    System.out.println("home.jsp() " + areaDataString);
                    session.setAttribute("diaryTbl", diaryStat);
                } catch (Exception e) {

                }
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
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="scripts/jquery.min.js" type="text/javascript"></script>
        <script src="scripts/jqueryu.min.js" type="text/javascript"></script>

        <style>
            .ui-menu { width: 150px; }
            #menu a {text-decoration: none;}
            .ui-tabs-vertical { width: 80%; margin-left: 200px; }
            .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }
            .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important;
                                                border-right-width: 0 !important; margin: 0 -1px .2em 0;border-radius: 3px; }
            .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
            .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; }
            .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right;
                                               width: 66%;}
            #menu a {font-weight: bold;}
            footer {text-align: center; margin:0 auto;border-top:2px #0074c7 solid;}
        </style>
        <script type="text/javascript">
            $(function () {
                $("#menu").menu();
                $("#menu").menu({
                    select: function (event, ui) {
                      
                        try {
                            top.location.href = ui.item[0].children[0].children[0].href;
                        } catch (e) {
                            console.log(e);
                            return false;
                        }
                    }
                });

                $("#tabs").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
                $("#tabs li").removeClass("ui-corner-top").addClass("ui-corner-left");
                $("#logout").click(function () {
                    $.post('./api?fn=logout').done(function (  ) {
                        top.location.href = 'login.html';
                    });
                });


            });
        </script>

    </head>

    <body <%=onload%>>
        <div style="width:95%; float:left;height: 125px;"><div style="float:left;margin-left:165px;padding:80px 0 45px 40px;font-size:24pt;vertical-align: bottom;font-weight: bolder;font-family: verdana;">Welcome <%=name%></div><div style="float:right;margin-right:30%;"><img src="Logo.png" style="height:75%;width:75%;" alt="log"></div></div>	
        <div style="clear:both;"></div>
        <ul id="menu" style="float:left;">
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

        <div id="tabs">
            <ul>
                <li><a href="#tabs-1">Recently logged</a></li>
                <li><a href="#tabs-2">Current Meds</a></li>
                <li><a href="#tabs-3">Generate Reports</a></li>
            </ul>
            <div id="tabs-1">
                <h2>You logged .....</h2>

                <p><%=diaryEntires%></p> 
                <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
            </div>
            <div id="tabs-2">
                <h2>You have septum on file</h2>
                <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.</p>
            </div>
            <div id="tabs-3">
                <h2>Last Entry Data</h2>
                <div style="margin:10px;padding:5px;">
                    todo: addd last entry!!
                    <%=diaryStat%></div>
            </div>
        </div><footer>Users online (<%=logins%>)</footer>
    </body></html>