<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page language="java" import="com.medlog.webservice.util.MakeSelectTag" %>
<%@page language="java" import="com.medlog.webservice.sql.DbConnection" %>
<%@page language="java" import="com.medlog.webservice.vo.PatientVO" %>
<%@page language="java" import="model.Journal.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Journal Entry</title>
        <link rel="stylesheet" type="text/css" href="rstyle.css"/>
    </head>
    <body>
        <%
            // Declare all Strings and objects as they should be if it is first rendering
            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMessages = new StringData();
            String[] ratingOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            DbConnection dbc = new DbConnection();

            String journalID = request.getParameter("journalID");
            if ((journalID == null) || (journalID == "")) {
                System.out.println("error: no journal id");
                dbc.close();
                try {
                    response.sendRedirect("login.html");
                } catch (Exception e) {

                }
            }

            String userID = null;
            com.medlog.webservice.vo.PatientVO user = null;
            try {
                if (session.getAttribute("user") != null) {
                    user = (PatientVO) session.getAttribute("user");
                }
            } catch (Exception e) {
            }

            if (user != null) {
                userID = Integer.toString(user.getPatientID());
                System.out.println("Found user with ID " + userID);
            } else {
                dbc.close();
                try {
                    response.sendRedirect("login.html");
                } catch (Exception e) {
                }
            }
            if (!DbMods.secure(userID, journalID)) {
                dbc.close();
                try {
                    response.sendRedirect("login.html");
                } catch (Exception e) {
                }
            }else if (request.getParameter("title") != null) { // this is postback

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
                    DbMods.update(inputData, dbc, journalID, ratingOptions);// errorMessages will hold all validation messages
                    dbc.close();
                    response.sendRedirect("JournalList.html?id=1");
                } // if db connection is good
            } else {
                errorMessages.errorMessage = dbc.getError();
                if (errorMessages.errorMessage.length() == 0) { // is DB connection good?

                    // find the journal that has id = customerId (the id that was pulled from the URL)
                    // The returned inputData object will be used to populate all the text boxes.
                    inputData = Search.findById(dbc, journalID, ratingOptions);
                    if (inputData == null) {
                        errorMessages.errorMessage = "Programmer error: could not find item [" + journalID + "]";
                        // If the user clicked on a journal from the list page, that journal really 
                        // should be found in the database. But if there was URL tampering, perhaps 
                        // an invalid journal id might be in the URL.
                        inputData = new StringData(); // the UI references inputData, cannot be left null.
                    } else if (inputData.errorMessage.length() > 0) {
                        errorMessages.errorMessage = inputData.errorMessage;
                    }
                }
            }
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
                    <%=moodSelect%><br/><br/>
                    <label for="notesActivity">Activity Log<br/></label>

                    <textarea cols ="50" rows ="4" name="notesActivity" id="notesActivity" placeholder = "Enter what you have done, accomplishments, achievements, etc here"><%=inputData.notesActivity%></textarea><br/>
                    <%=productivitySelect%><br/>


                </fieldset>


                <!-- Submit & reset buttons-->
                <br/><!--<button type="submit">Submit entry</button>
                <button type="reset">Clear</button><br/><br/><br/><br/>-->
                <input type="submit" value="Submit"/>
            </form>
            <strong><%=errorMessages.errorMessage%></strong>
        </div>
    </body>
</html>
