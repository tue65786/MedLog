<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page language="java" import="com.medlog.webservice.util.MakeSelectTag" %>
<%@page language="java" import="com.medlog.webservice.sql.DbConnection" %>
<%@page language="java" import="model.Journal.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Journal Entry</title>
        <link rel="stylesheet" type="text/css" href="rstyle.css"/>
        <script src="scripts/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/json2/20160511/json2.js" type="text/javascript"></script>
        <script src="scripts/utils.js" type="text/javascript"></script>
    </head>
    <body>
        <script language="Javascript" type="text/javascript">
            function security() {
                var userID;
                var currentUserFn = "./api/?res=p&fn=find";
                $.get(currentUserFn).done(function (currentUserData) {
                    if (typeof currentUserData === 'undefined') {
                        alert('undefined user data');
                        return null;
                    } else {
                        userID = currentUserData.patientID;
                        var url = "JournalSecurity_Web_API.jsp";
                        var journalID = $.getUrlVar("journalID");
                        journalID = parseInt(journalID);
                        //var journalID = getIDParamFromRequest();
                        url += "?user=" + userID;
                        url += "&journal=" + journalID;
                        //alert(url);
                        httpReq.open("GET", url);
                        httpReq.onreadystatechange = redirect;
                        httpReq.send(null);
                    }
                });
            }
            
            function redirect() {
                //alert('handling response - redirect');
                if (httpReq.readyState == 4 && httpReq.status == 200) {
                    //alert('inside if');
                    var response = httpReq.responseText;
                    //alert("response text is " + response);

                    // wrap the json in parentheses to avoid tripping over javascript ambiguity...
                    response = "(" + response + ")";
                    var obj = eval(response);
                    //alert(response);
                    //alert(obj);
                    if(obj == "ok"){
                        return;
                    }else if (obj == "redirect"){
                        window.location.href = "login.html";
                    }
                }
            }
            
            var httpReq;
            if (window.XMLHttpRequest) {
                httpReq = new XMLHttpRequest(); //For Firefox, Safari, Opera
            } else if (window.ActiveXObject) {
                httpReq = new ActiveXObject("Microsoft.XMLHTTP"); //For IE 5+
            } else {
                alert('ajax not supported');
            }

            security();
            //alert('securty function has run');
        </script>
        <%
            // Declare all Strings and objects as they should be if it is first rendering
            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMessages = new StringData();
            //String[] forSaleOptions = {"no", "yes"};
            String[] ratingOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            //String collSQL = "select collector_id, firstName, lastName from collector order by lastName";
            //String albumSQL = "select album_id, albumName, artistName, sortArtist, sortAlbum, releaseYear from album order by sortArtist, releaseYear, sortAlbum";

            DbConnection dbc = new DbConnection();

            String journalID = request.getParameter("journalID");
            if ((journalID == null) || (journalID == "")) {
                System.out.println("no journal id");
                dbc.close();
                try {
                    response.sendRedirect("login.html");
                } catch (Exception e) {

                }
            } else if (request.getParameter("title") != null) { // this is postback

                // package up Customer String data
                inputData.title = request.getParameter("title");
                inputData.notes = request.getParameter("notes");
                inputData.notesActivity = request.getParameter("notesActivity");
                inputData.mood = request.getParameter("mood");
                inputData.productivity = request.getParameter("productivity");
                inputData.createdDate = request.getParameter("createdDate");
                inputData.updatedDate = request.getParameter("updatedDate");
                inputData.id = request.getParameter("journalID");

                // Get db connection and make sure it worked.
                errorMessages.errorMessage = dbc.getError();
                if (errorMessages.errorMessage.length() == 0) { // DB connection is good
                    System.out.println("update method executing");
                    DbMods.update(inputData, dbc, journalID, ratingOptions);// errorMessages will hold all validation messags
                    if (errorMessages.errorMessage.length() == 0) { // this is the form level error message
                        // replace empty string with successful message
                        errorMessages.errorMessage = "Record successfully updated!";
                    }
                } // if db connection is good
            } else {
                errorMessages.errorMessage = dbc.getError();
                if (errorMessages.errorMessage.length() == 0) { // is DB connection good?

                    // find the journal that has id = customerId (the id that was pulled from the URL)
                    // The returned inputData object will be used to populate all the text boxes.
                    inputData = Search.findById(dbc, journalID, ratingOptions);
                    if (inputData == null) {
                        errorMessages.errorMessage = "Programmer error: could not find item [" + journalID + "]";
                        // If the user clicked on a customer from the list page, that customer really 
                        // should be found in the database. But if there was URL tampering, perhaps 
                        // an invalid customer id might be in the URL.
                        inputData = new StringData(); // the UI references inputData, cannot be left null.
                    } else if (inputData.errorMessage.length() > 0) {
                        errorMessages.errorMessage = inputData.errorMessage;
                    }
                }
            }
            //String collSelect = MakeSelectTag.makeSelect(dbc, "collectorInput", collSQL, inputData.collectorID, "Select Collector");
            //String albumSelect = MakeSelectTag.makeSelect(dbc, "albumInput", albumSQL, inputData.albumID, "Select Album");
            //String forSaleSelect = MakeSelectTag.makeEnumSelect("forSaleInput", inputData.forSale, forSaleOptions);
            String moodSelect = MakeSelectTag.makeEnumSelect("mood", inputData.mood, ratingOptions);
            String productivitySelect = MakeSelectTag.makeEnumSelect("productivity", inputData.productivity, ratingOptions);
            dbc.close();
        %>
        <div>
            <div id="header"><a href="home.jsp">
                    <table style='width:95%'><tr><td style="width:85%">
                                <h1> Update Journal Entry </h1>
                                <p> This is the page to update a journal entry </p>
                                <p></p>

                            </td><td style="background-image: url(Logo.png); background-repeat: no-repeat;text-align: left;background-position-x: left;"></td></tr></table>
                </a></div>

            <form action ="JournalUpdate.jsp" method="get" name="updateJournalForm" id="updateJournalForm">
                <input name="journalID" type="hidden" value="<%=inputData.id%>"/>
                <fieldset>
                    <legend>Dates</legend>

                    <label for="createdDate">Date Created:<br/></label>
                    <input name="createdDate" type="text" id="createdDate" value="<%=inputData.createdDate%>" readonly placeholder="yyyy-mm-dd"/><br/>
                    <label for="updatedDate">Date Updated:<br/></label>
                    <input name="updatedDate" type="text" id="updatedDate" value="<%=inputData.updatedDate%>" readonly placeholder="yyyy-mm-dd"/>


                    <br/>
                </fieldset>

                <fieldset>
                    <legend>Content</legend>

                    <label for="title">Title<br/></label>
                    <input name="title" type="text" id="title" value="<%=inputData.title%>" required=""/><br/><br/>
                    <label for="notes">Sentimental Diary<br/></label>
                    <textarea cols ="50" rows ="4" name="notes" id="notes" placeholder = "Enter how you are feeling here"><%=inputData.notes%></textarea><br/>
                    <!--<select id="mood" name='mood' required>
                        <option >Rate your mood</option>-->
                    <!-- Better way to accomplish? -->
                    <!--<option value='1'>1</option>
                    <option value='2'>2</option>
                    <option value='3'>3</option>
                    <option value='4'>4</option>
                    <option value='5'>5</option>
                    <option value='6'>6</option>
                    <option value='7'>7</option>
                    <option value='8'>8</option>
                    <option value='9'>9</option>
                    <option value='10'>10</option>
                </select>-->
                    <%=moodSelect%><br/><br/>
                    <label for="notesActivity">Activity Log<br/></label>

                    <textarea cols ="50" rows ="4" name="notesActivity" id="notesActivity" placeholder = "Enter what you have done, accomplishments, achievements, etc here"><%=inputData.notesActivity%></textarea><br/>
                    <!--<select id="productivity" name='productivity' required>
                        <option>Rate your productivity</option>

                        <option value='1'>1</option>
                        <option value='2'>2</option>
                        <option value='3'>3</option>
                        <option value='4'>4</option>
                        <option value='5'>5</option>
                        <option value='6'>6</option>
                        <option value='7'>7</option>
                        <option value='8'>8</option>
                        <option value='9'>9</option>
                        <option value='10'>10</option>
                    </select>-->
                    <%=productivitySelect%><br/>


                </fieldset>


                <!-- Submit & reset buttons-->
                <br/><!--<button type="submit">Submit entry</button>
                <button type="reset">Clear</button><br/><br/><br/><br/>-->
                <input type="submit" value="Submit"/>
            </form>
            <strong><%=errorMessages.errorMessage%></strong>
        </div>
        <!--<div id="loader1" style="display:none;">
            <div class="ui-widget-overlay ui-front"></div>
            <div id="InnerTableCellOverlay">
                <img alt="(loading)" src="images/loader.gif"/>
                <br/>
                <b style="color:black;font-size:2em;">&nbsp;&nbsp;Working, please wait...</b>
            </div>
        </div>
        <script>
                    $(document).ready(function () {
            $("#updateJournalForm").on("submit", function (event) {
            $("#loader1").show();
                    event.preventDefault();
                    var journalInfo = $("#updateJournalForm").serialize();
                    var theURL = "./api?res=d&fn=add&" + journalInfo;
                    //                    $("#formVisual").val("userInfo");
                    $.post(theURL)
                    .done(function (data) {
                    if (typeof data.id !== 'undefined' && data.id > 0) {
                    $("#id").val(data.id);
                            if (confirm('Journal Updated!')) {
                    redir('home.jsp');
                    }
                    }
                    console.log(data);
                            $("#loader1").hide();
                    }).fail(function (xhr, error, status) {//IF AJAX CALL FAILS!
            console.log(xhr);
                    $("#loader1").hide();
                    console.log(error);
            });
            });
            });
        </script>-->
    </body>
</html>
