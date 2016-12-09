<%-- 
    Document   : report-journal-tone_raw
    Created on : Dec 9, 2016, 7:44:46 AM
    Author     : westy
--%>

<%@page import="com.medlog.webservice.rest.helpers.ServletHelpers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.medlog.webservice.vo.PatientVO" scope="session" />
<jsp:setProperty name="user" property="*"/> 
<%
    String data = "";
    String area = "";
    String tbl = "";
    ServletHelpers sh = new ServletHelpers(request, response);
    data = sh.getStrAttribute("diaryReportData", "[]");
    tbl = sh.getStrAttribute("diaryTbl", "");
    area = sh.getStrAttribute("diaryAreaData", "[]");

%>
<!DOCTYPE html>
<head>
    <title id='Description'>Chart2</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="description" content="" />

    <link rel="stylesheet" href="scripts/jqx/styles/jqx.base.css" type="text/css" />
    <link href="rstyle.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="scripts/jquery.min.js"></script>
    <!--    <script type="text/javascript" src="scripts/jqx/jqxcore.js"></script>
        <script type="text/javascript" src="scripts/jqx/jqxdata.js"></script>
        <script type="text/javascript" src="scripts/jqx/jqxdraw.js"></script>
        <script type="text/javascript" src="scripts/jqx/jqxchart.core.js"></script>
        <script type="text/javascript" src="scripts/jqx/jqxchart.rangeselector.js"></script>-->
    <script type="text/javascript" src="scripts/jqx/jqx-all.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

        var tonePhraseEx = [{tone:'sadness', text:'The Curse of Keen Eyes - 08.19.04 Why I am cursed with being the guy that always sees the saddest and most pathetic little snippets of other peoples & quot; lives?'},
                {tone:'tentative', text:'Songs like, um, &quot;Yankee Doodle&quot; or maybe &quot;Skip to my Lu.&quot; I&quot;m not sure if those were around then, though.'},
                {tone:'emotional_range_big5', text:'That guy knew how to party.'},
                {tone:'anger', text:'What an idiot I am!'},
                {tone:'disgust', text:'THE passenger train is just starting from Bologoe, the junction on the Petersburg-Moscow line.'},
                {tone:'confident', text:'I got it, of course.'},
                {tone:'fear', text:'Damn all this philosophy and psychology!&quot;The guard walks through the compartment.&quot;My'},
                {tone:'joy', text:'revoltingly happy,&quot; he says.'},
                {tone:'analytical', text:'But think of her! . . .'},
                {tone:'agreeableness_big5', text:'Tell that lady, then, that her husband is all right!&quot;Ivan'},
                {tone:'conscientiousness_big5', text:'When that time comes you should love like a house on fire, but you won&quot;t heed the dictates of nature, you keep waiting for something.'},
                {tone:'extraversion_big5', text:'dear fellow,&quot; the bridegroom addresses him, &quot;when you pass through the carriage No. 209 look out for a lady in a grey hat with a white bird and tell her I&quot;m here!&quot;&quot;Yes,'},
                {tone:'openness_big5', text:'And then something happens in your head and your heart, finer than you can read of in a fairy tale.'},
                {tone:'joy', text:'revoltingly happy,&quot; he says.'},
                {tone:'openness_big5', text:'And then something happens in your head and your heart, finer than you can read of in a fairy tale.'}];
        // prepare the data
//            var source =
//                    {
//                        datatype: "json",
//                        datafields: [
//                            {name: 'Date'},
//                            {name: 'Open'},
//                            {name: 'High'},
//                            {name: 'Low'},
//                            {name: 'Close'},
//                            {name: 'Volume'},
//                            {name: 'AdjClose'}
//                        ],
//                        url: '../sampledata/TSLA_stockprice.csv'
//                    };
//            var dataAdapter = new $.jqx.dataAdapter(source, {async: false, autoBind: true, loadError: function (xhr, status, error) {
//                    alert('Error loading "' + source.url + '" : ' + error);
//                }});
//            var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        var initTab1 = function(){
        var toolTipCustomFormatFn = function (value, itemIndex, serie, group, categoryValue, categoryAxis) {
        console.log(serie);
        console.log(group);
        console.log(categoryValue);
        return 'Mood: ' + source[itemIndex].mood + ",  " + serie.displayText + ": " + value;
        };
        // prepare jqxChart settings
        var source = <%=data%>;
        var settings = {
        title: "<%=user.getFirstName()%> Journal Log",
                description: "Using Tone Analysis",
                enableAnimations: true,
                showLegend: true,
                animationDuration: 1500,
                enableCrosshairs: true,
                padding: {left: 5, top: 5, right: 20, bottom: 5},
                colorScheme: 'scheme02',
                source: source,
                xAxis:
        {
//                            minValue: 175,
//                            maxValue: 550,
        dataField: 'row',
                flip: false,
                valuesOnTicks: true,
                rangeSelector: {
                serieType: 'area',
                        padding: {/*left: 0, right: 0,*/ top: 20, bottom: 0},
                        // Uncomment the line below to render the selector in a separate container
                        //renderTo: $('#selectorContainer'),
                        backgroundColor: 'white',
                        size: 110,
                        gridLines: {visible: false}
                }
        },
                seriesGroups:
        [
        {
        type: 'line',
                toolTipFormatFunction: toolTipCustomFormatFn,
                valueAxis:
        {
        flip: false,
                title: {text: 'Value<br><br>'}
        },
                series: [
                {dataField: 'agreeablenessBig5', displayText:'agreeableness', lineWidth: 1},
                {dataField: 'analytical', displayText:'analytical', lineWidth: 1},
                {dataField: 'anger', displayText:'anger', lineWidth: 1},
                {dataField: 'confident', displayText:'confident', lineWidth: 1},
                {dataField: 'conscientiousnessBig5', displayText:'conscientiousness', lineWidth: 1},
                {dataField: 'disgust', lineWidth: 1},
                {dataField: 'emotionalRangeBig5', displayText:'emo range', lineWidth: 1},
                {dataField: 'extraversionBig5', displayText:'extravert', lineWidth: 1},
                {dataField: 'fear', displayText:'fear', lineWidth: 1},
                {dataField: 'joy', displayText:'joy', lineWidth: 1},
                {dataField: 'opennessBig5', displayText:'open', lineWidth: 1},
                {dataField: 'sadness', displayText:'sad', lineWidth: 1},
                {dataField: 'tentative', displayText: 'tentative', lineWidth: 1},
//                                    {dataField: 'rowTotal', lineWidth: 1},
                {dataField: 'mood', lineWidth: 4}
//                                    {dataField: 'producivtiy', lineWidth: 1}
                ]
        }
        ]
        };
        $('#chartContainer').jqxChart(settings);
        }


        var areaData = <%=area%>;
        var initTab2 = function(){

        var settingsArea = {
        title: "Weighted Tone Analysis",
                description: "",
                enableAnimations: true,
                showLegend: true,
                padding: { left: 10, top: 5, right: 10, bottom: 5 },
                titlePadding: { left: 90, top: 0, right: 0, bottom: 10 },
                source: areaData,
                xAxis:
        {
//                    type: 'date',
//                    baseUnit: 'day',
//                    dataField: 'Date',
        valuesOnTicks: true,
                dataField: 'row',
                labels: {
//                        formatFunction: function (value) {
//                            return value.getDate();
//                        }
                },
                gridLines: { visible: false }
//                   , toolTipFormatFunction: function (value) {
//                        return value.getDate() + '-' + months[value.getMonth()] + '-' + value.getFullYear();
//                    }
        },
                valueAxis:
        {
        title: { text: 'Weighted Tone Scores ' },
                labels: { horizontalAlignment: 'right' }
        },
                colorScheme: 'scheme06',
                seriesGroups:
        [
        {
        type: 'stackedarea100',
                formatSettings: { sufix: '%', decimalPlaces: 0 },
                series: [
                {dataField: 'agreeablenessBig5', displayText:'agreeableness', lineWidth: 1},
                {dataField: 'analytical', displayText:'analytical', lineWidth: 1},
                {dataField: 'anger', displayText:'anger', lineWidth: 1},
                {dataField: 'confident', displayText:'confident', lineWidth: 1},
                {dataField: 'conscientiousnessBig5', displayText:'conscientiousness', lineWidth: 1},
                {dataField: 'disgust', lineWidth: 1},
                {dataField: 'emotionalRangeBig5', displayText:'emo range', lineWidth: 1},
                {dataField: 'extraversionBig5', displayText:'extravert', lineWidth: 1},
                {dataField: 'fear', displayText:'fear', lineWidth: 1},
                {dataField: 'joy', displayText:'joy', lineWidth: 1},
                {dataField: 'opennessBig5', displayText:'open', lineWidth: 1},
                {dataField: 'sadness', displayText:'sad', lineWidth: 1, labels:
                {
                visible: true,
                        backgroundColor: '#FEFEFE',
                        backgroundOpacity: 0.2,
                        borderColor: '#7FC4EF',
                        borderOpacity: 0.7,
                        padding: { left: 5, right: 5, top: 0, bottom: 0 }
                }},
                {dataField: 'tentative', displayText: 'tentative', lineWidth: 1}
                ]
        }
        ]
        };
        // setup the chart
        $('#areaContainer').jqxChart(settingsArea);
        };
        var initWidgets = function (tab) {
        switch (tab) {
        case 0:
                initTab1();
        break;
        case 1:
                initTab2();
        break;
        }
        }
        $('#jqxTabs').jqxTabs({ width: '90%', height: 660
//                , initTabContent: initWidgets 
                , selectionTracker: true
        });
        });
    </script>
</head>
<body class='default'>   <a href="home.jsp"><div id="header">
            <table style='width:95%'><tr><td style="width:85%">
                        <h1> Tone Report </h1>
                        <p> Welcome to MedLog. </p>
                    </td><td style="background-image: url(Logo.png); background-repeat: no-repeat;text-align: left;background-position-x: left;"></td></tr></table>
        </div></a>
    <!--    <div style="margin: 0 auto; width:97%;">
       
            
            <div style="margin: 10px 0;clear:both;"></div>
            <p></p>
           
        </div>-->
    <!--<p>
    
    </p>-->
    <div class="example-description">
        <br />
        <h2>Description</h2>
        <br />
        This is an example of JavaScript Chart Range Selector with Zooming.
    </div>

    <div id='jqxTabs'>
        <ul>
            <li style="margin-left: 30px;">
                <div style="height: 20px; margin-top: 5px;">
                    <div style="margin-left: 4px; vertical-align: middle; text-align: center; float: left;">
                        Line Series
                    </div>
                </div>
            </li>
            <li>
                <div style="height: 20px; margin-top: 5px;">
                    <div style="margin-left: 4px; vertical-align: middle; text-align: center; float: left;">
                        Weighted Area
                    </div>
                </div>
            </li>
            <li>
                <div style="height: 20px; margin-top: 5px;">
                    <div style="margin-left: 4px; vertical-align: middle; text-align: center; float: left;">
                        Under the hood
                    </div>
                </div>
            </li>
        </ul>
        <div style="overflow: hidden;">
            <div id='chartContainer' style="width:90%; height:600px;">
            </div>
            <!-- you can optionally render the selecor in this container -->
            <div id='selectorContainer' style="width:500px; height:100px;">
            </div>
            <!--  <div id='financialChart' style="width: 100%; height: 100%">
              </div>-->
        </div>
        <div style="overflow: hidden;">
            <div id='areaContainer' style="width:100%; height:600px;">
            </div>
        </div>
    </div>
    <%=tbl%>
</body>