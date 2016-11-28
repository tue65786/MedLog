package view;

// classes imported from java.sql.*
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// classes in my project
import com.medlog.webservice.sql.DbConnection;
import com.medlog.webservice.util.FormatUtils;
import model.Journal.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebJournalView {

    /* This method returns a HTML table displaying all the records of the web_user table. 
     * cssClassForResultSetTable: the name of a CSS style that will be applied to the HTML table.
     *   (This style should be defined in the JSP page (header or style sheet referenced by the page).
     * dbc: an open database connection.
     */
    
    private static StringData dbRowToStringData(ResultSet results) {

        StringData sd = new StringData();

        try {  
            sd.id = FormatUtils.formatInteger(results.getObject("Id"));
            sd.title = FormatUtils.formatString(results.getObject("Title"));
            sd.notes = FormatUtils.formatString(results.getObject("Notes"));
            sd.notesActivity = FormatUtils.formatString(results.getObject("NotesActivity"));
            sd.createdDate = FormatUtils.formatDate(results.getObject("createdDate"));
            sd.updatedDate = FormatUtils.formatDate(results.getObject("updatedDate"));
            sd.mood = FormatUtils.formatInteger(results.getObject("ratingMood"));
            sd.productivity = FormatUtils.formatInteger(results.getObject("ratingProductivity"));
            sd.patientID = FormatUtils.formatInteger(results.getObject("PatientID"));
        } catch (Exception e) {
            sd.errorMessage = "Error in WebJournalView.dbRowToStringData: " + e.getMessage();
        }
        return sd;
    }

    public static StringDataList getJournalList(String user, DbConnection dbc) {

        StringDataList journalList = new StringDataList(0);
        System.out.println("getJournalList searching for items with patientID " + user);

        try {

            // Get the count of entries that will be in the JSON list of entries
            String sql = "SELECT count(*) as numItems FROM Patient, Diary WHERE Patient.PatientID = Diary.PatientID";
            if (!user.equals("0")) {
                sql += " AND Patient.PatientID = ?";
            }
            
            PreparedStatement stmt = dbc.getConnnection().prepareStatement(sql);
            
            int count = 1;
            if (!user.equals("0")) {
                stmt.setString(count, user);
                count++;
            }
            
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                int num = results.getInt("numItems");
                journalList = new StringDataList(num);
                System.out.println("***** num items is " + num);
            }

            // Now add each item to the journal list
            sql = "SELECT Id, Title, Notes, NotesActivity, createdDate, updatedDate, ratingMood, ratingProductivity FROM Patient, Diary WHERE Patient.PatientID = Diary.PatientID";
            if ((user.length() != 0) && !user.equals("0")) {
                sql += " AND Patient.PatientID = ?";
            }
            sql += " ORDER BY createdDate, Title";
            
            stmt = dbc.getConnnection().prepareStatement(sql);
            
            count = 1;
            if ((user.length() != 0) && !user.equals("0")) {
                stmt.setString(count, user);
                count++;
            }
            results = stmt.executeQuery();

            StringData journal = null;
            while (results.next()) {
                journal = dbRowToStringData(results);
                journalList.addItem(journal);
            }
            results.close();
            stmt.close();
        } catch (Exception e) {
            journalList.dbError = e.getMessage();
        }
        return journalList;
    }
    
    public static StringData getJournal(String journalID, DbConnection dbc) {

        StringData journal = new StringData();
        System.out.println("getJournal searching for item with journalID " + journalID);

        try {

            // Get journal data
            String sql = "SELECT Id, Title, Notes, NotesActivity, createdDate, updatedDate, ratingMood, ratingProductivity, PatientID FROM Diary WHERE Diary.Id = ?";
            
            PreparedStatement stmt = dbc.getConnnection().prepareStatement(sql);
            
            stmt.setString(1, journalID);
            ResultSet results = stmt.executeQuery();

            journal = null;
            if(results.next()) {
                journal = dbRowToStringData(results);
            }
            results.close();
            stmt.close();
        } catch (Exception e) {
            
        }
        return journal;
    }
}
