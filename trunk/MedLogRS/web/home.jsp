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
		</style>
    </head>
    <body>

		<ul id="menu">
			<li>
				<div><span class="ui-icon ui-icon-disk"></span>Save</div>
			</li>
			<li>
				<div><span class="ui-icon ui-icon-zoomin"></span>Zoom In</div>
			</li>
			<li>
				<div><span class="ui-icon ui-icon-zoomout"></span>Zoom Out</div>
			</li>
			<li class="ui-state-disabled">
				<div><span class="ui-icon ui-icon-print"></span>Print...</div>
			</li>
			<li>
				<div>Playback</div>
				<ul>
					<li>
						<div><span class="ui-icon ui-icon-seek-start"></span>Prev</div>
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
			</li>
		</ul>
    </body>
</html>
