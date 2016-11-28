<%@page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page language="java" import="com.medlog.webservice.sql.DbConnection" %>
<%@page language="java" import="com.medlog.webservice.util.JSON" %>
<%@page language="java" import="model.Journal.StringDataList" %>
<%@page language="java" import="view.WebJournalView" %>

<%
    StringDataList journalList = new StringDataList(0); // Empty list with no db error.
    
    DbConnection dbc = new DbConnection();
    
    //journalList.dbError = dbc.getErr(); // returns "" if connection is good, else db error msg.
    
    //if (collectionList.dbError.length() == 0) { // got open connection
        
        String user = request.getParameter("userInput");

        System.out.println("jsp page ready to search for items with patientID " + user);
        journalList = view.WebJournalView.getJournalList(user, dbc);
    //} 
    
    // PREVENT DB connection leaks:
    dbc.close(); // EVERY code path that opens a db connection, must also close it.

    out.print(JSON.toJson(journalList));
%>