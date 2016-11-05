<%-- 
    Document   : home
    Created on : Nov 3, 2016, 8:56:21 AM
    Author     : (c)2016 Guiding Technologies
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="/resources/demos/style.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
    </head>
    <body>

		<ul id="menu">
			<li>
				<div><span class="ui-icon ui-icon-home"></span><a href="home.jsp">Medlog</a></div>
			</li>
			<li>
				<div><span class="ui-icon ui-icon-person"></span>Profile</div>
			</li>
			<li id="diary" data-url="">
				<div><span class="ui-icon ui-icon-contact"></span>Diary</div>
			</li><li id="diary">
				<div><span class="ui-icon ui-icon-note"></span><a href="insertJournal.html">Diary</a></div>
			</li>
			<li>
				<div><span class="ui-icon ui-icon-cart"></span><a href="HealthcareProvider.htm">Healthcare</a></div>
			</li>
			
			<li>
				<div><span class="ui-icon ui-icon-comment"></span></div>
			</li>
			<li class="ui-state-disabled">
				<div><span class="ui-icon ui-icon-script"></span>Medication</div>
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
    </body>
</html>
