<%-- 
    Document   : home
    Created on : Nov 3, 2016, 8:56:21 AM
    Author     : (c)2016 Guiding Technologies
--%>

<%@page import="com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis"%>
<%@page import="com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.medlog.webservice.vo.PatientVO" scope="session" />
<jsp:setProperty name="user" property="*"/>
<% 
if (user == null ||user.getPatientID() <= 0){
   response.sendRedirect( "login.html"); 
}
%>
<!DOCTYPE html>
<html>
    <head>
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
		%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="/resources/demos/style.css">
		<script src="scripts/jquery.min.js" type="text/javascript"></script>
		<script src="scripts/jqueryu.min.js" type="text/javascript"></script>
		
	
			
		<script>
			 $(function () {
				 $("#menu").menu();

				 $("#menu").menu({
					 select : function ( event, ui ) {

						 console.log(event);
						 console.log(ui);
					 }
				 });
			 });

		</script>
		<style>
			.ui-menu { width: 150px; }
			#menu a {text-decoration: none;}
		</style>
		  <script>
  $( function() {
    $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
    $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
  } );
  </script>
  <style>
  .ui-tabs-vertical { width: 55em; margin-left: 200px; }
  .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }
  .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
  .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
  .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; }
  .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;}
  #menu a {font-weight: bold;}
  </style>
    </head>
	
    <body>
	<div style="width:95%; float:left;height: 125px;"><div style="float:left;margin-left:165px;padding:80px 0 45px 40px;font-size:24pt;vertical-align: bottom;font-weight: bolder;font-family: verdana;">Welcome to MedLog</div><div style="float:right;margin-right:30%;"><img src="Logo.png" style="height:75%;width:75%;" alt="log"></div></div>	
	<div style="clear:both;"></div>
		<ul id="menu" style="float:left;">
			<li>
				<div><span class="ui-icon ui-icon-home"></span><a href="home.jsp">Medlog</a></div>
			</li>
			<li>
				<div><span class="ui-icon ui-icon-person"></span>Profile</div>
			<ul>
								<li>
									<div>	<a href="User.html">Register</a></div>
								</li></ul>
			</li>
			<li id="diary" data-url="">
				<div><span class="ui-icon ui-icon-contact"></span>Diary</div>
				
							<ul>
								<li>
									<div><span class="ui-icon "></span><a href="insertJournal.html">Add</a></div>
								</li>
								<li>
									<div><span class="ui-icon"></span>List</div>
								</li>
								<li>
									<div><span class="ui-icon"></span><a href="report-journal.html">Report</a></div>
								</li>
								<li>
									<div><span class="ui-icon"></span>Send</div>
								</li>
							</ul>
			</li>
			<li >
				<div><span class="ui-icon ui-icon-note"></span><a href="insertDietaryRestriction.html">Dietary Restrictions</a></div>
			</li>
			<li>
				<div><span class="ui-icon ui-icon-cart"></span><a href="HealthcareProvider.html">Health-care Providers</a></div>
			</li>
			<!--<li class="ui-state-disabled">-->
			<li>
				<div><span class="ui-icon ui-icon-script"></span><a href="HealthcareProvider.html">Medication</a></div>
			</li>
			<!--			<li>
							<div>Disabled</div>
							<ul>
								<li>
									<div><span class="ui-icon ui-icon-clipboard"></span>Doctor</div>
								</li>
								<li>
									<div><span class="ui-icon ui-icon-stop"></span>Stop</div>
								</li>
								<li>
									<div><span class="ui-icon ui-icon-play"></span>Play</div>
								</li>
								<li>
									<div><span class="ui-icon ui-icon-seek-end"></span>Next</div>
								</li>
							</ul>
						</li>
						<li>
							<div>Learn more about this menu</div>
						</li>-->
		</ul>
		
		<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Recently logged</a></li>
    <li><a href="#tabs-2">Current Meds</a></li>
    <li><a href="#tabs-3">Generate Reports</a></li>
  </ul>
  <div id="tabs-1">
    <h2>You logged .....</h2>
    <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
  </div>
  <div id="tabs-2">
    <h2>You have septum on file</h2>
    <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.</p>
  </div>
  <div id="tabs-3">
    <h2>Logs</h2>
    <ol><li> Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</li>
		<li>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. <li>Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque.</li> Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</li>
	</ol>
  </div>
</div>
 
		
<!--		<table>
			<t><td>
			
	
		
	</td><td></td></tr>
			<tr><td>
					</td></tr>	-->
<!--			<div class="summary--emotion">
            <h5 class="base--h5 summary--header">Emotion</h5>
            <div class="summary-emotion-graph bar-graph">
    
      <div class="bar-graph--row summary-emotion-graph--row">
        <div class="bar-graph--label-container summary-emotion-graph--label-container">
          <div class="bar-graph--label">
            <p class="base--p">
              Anger
            </p>
            
              <div class="bar-graph--tooltip">
                Likelihood of writer being perceived as angry. Low value indicates unlikely to be perceived as angry. High value indicates very likely to be perceived as angry. 
              </div>
              
          </div>
        </div>
        <div class="bar-graph--bar-container summary-emotion-graph--bar-container">
          <div class="bar-graph--bar">
            <div class="bar-graph--bar-value summary-emotion-graph--bar-value summary-emotion-graph--bar-value_Anger" style="width: 14.3%;"></div>
          </div>
        </div>
        <div class="summary-emotion-graph--percentage-label">
          0.14
          <br>
          <span class="summary-emotion-graph--percentage-label-likeliness">
            UNLIKELY
          </span>
        </div>
      </div>
      
      <div class="bar-graph--row summary-emotion-graph--row">
        <div class="bar-graph--label-container summary-emotion-graph--label-container">
          <div class="bar-graph--label">
            <p class="base--p">
              Disgust
            </p>
            
              <div class="bar-graph--tooltip">
                Likelihood of writer being perceived as disgusted. Low value, unlikely to be perceived as disgusted. High value, very likely to be perceived as disgusted.
              </div>
              
          </div>
        </div>
        <div class="bar-graph--bar-container summary-emotion-graph--bar-container">
          <div class="bar-graph--bar">
            <div class="bar-graph--bar-value summary-emotion-graph--bar-value summary-emotion-graph--bar-value_Disgust" style="width: 7.6%;"></div>
          </div>
        </div>
        <div class="summary-emotion-graph--percentage-label">
          0.08
          <br>
          <span class="summary-emotion-graph--percentage-label-likeliness">
            UNLIKELY
          </span>
        </div>
      </div>
      
      <div class="bar-graph--row summary-emotion-graph--row">
        <div class="bar-graph--label-container summary-emotion-graph--label-container">
          <div class="bar-graph--label">
            <p class="base--p">
              Fear
            </p>
            
              <div class="bar-graph--tooltip">
                Likelihood of writer being perceived as scared. Low value indicates unlikely to be perceived as fearful. High value, very likely to be perceived as scared.
              </div>
              
          </div>
        </div>
        <div class="bar-graph--bar-container summary-emotion-graph--bar-container">
          <div class="bar-graph--bar">
            <div class="bar-graph--bar-value summary-emotion-graph--bar-value summary-emotion-graph--bar-value_Fear" style="width: 8%;"></div>
          </div>
        </div>
        <div class="summary-emotion-graph--percentage-label">
          0.08
          <br>
          <span class="summary-emotion-graph--percentage-label-likeliness">
            UNLIKELY
          </span>
        </div>
      </div>
      
      <div class="bar-graph--row summary-emotion-graph--row">
        <div class="bar-graph--label-container summary-emotion-graph--label-container">
          <div class="bar-graph--label">
            <p class="base--p">
              Joy
            </p>
            
              <div class="bar-graph--tooltip">
                Likelihood of writer being perceived as happy. Low value, unlikely to be perceived as joyful. High value very likely to be perceived as happy.
              </div>
              
          </div>
        </div>
        <div class="bar-graph--bar-container summary-emotion-graph--bar-container">
          <div class="bar-graph--bar">
            <div class="bar-graph--bar-value summary-emotion-graph--bar-value summary-emotion-graph--bar-value_Joy" style="width: 61.4%;"></div>
          </div>
        </div>
        <div class="summary-emotion-graph--percentage-label">
          0.61
          <br>
          <span class="summary-emotion-graph--percentage-label-likeliness">
            LIKELY
          </span>
        </div>
      </div>
      
      <div class="bar-graph--row summary-emotion-graph--row">
        <div class="bar-graph--label-container summary-emotion-graph--label-container">
          <div class="bar-graph--label">
            <p class="base--p">
              Sadness
            </p>
            
              <div class="bar-graph--tooltip">
                Likelihood of writer being perceived as sad. Low value, unlikely to be perceived as sad. High value very likely to be perceived as sad.
              </div>
              
          </div>
        </div>
        <div class="bar-graph--bar-container summary-emotion-graph--bar-container">
          <div class="bar-graph--bar">
            <div class="bar-graph--bar-value summary-emotion-graph--bar-value summary-emotion-graph--bar-value_Sadness" style="width: 13.5%;"></div>
          </div>
        </div>
        <div class="summary-emotion-graph--percentage-label">
          0.14
          <br>
          <span class="summary-emotion-graph--percentage-label-likeliness">
            UNLIKELY
          </span>
        </div>
      </div>
      
  </div>
          </div>-->
    </body>
</html>
