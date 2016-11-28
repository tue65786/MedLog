<%@page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" import="com.medlog.webservice.sql.DbConnection" %>
<%@page language="java" import="com.medlog.webservice.util.JSON" %>
<%@page language="java" import="model.Journal.StringData" %>
<%@page language="java" import="view.WebJournalView" %>

<%
    StringData journalData = new StringData();
    DbConnection dbc = new DbConnection();

    String user = request.getParameter("user");
    String journal = request.getParameter("journal");

    System.out.println("jsp page ready to search for item with journalID " + journal);
    journalData = view.WebJournalView.getJournal(journal, dbc);
    System.out.println("logged in user ID = " + journalData.patientID);
    if (journalData.patientID.compareTo(user) == 0) {
        dbc.close();
        out.print(JSON.toJson("ok"));
    } else {
        dbc.close();
        System.out.println("user and journal do not match - this journal belongs to another user");
        out.print(JSON.toJson("redirect"));
        /*try {
            response.sendRedirect("login.html");
        } catch (Exception e) {

        }*/
    }
%>   