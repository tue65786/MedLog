package view;

// classes imported from java.sql.*
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// classes in my project
import com.medlog.webservice.sql.DbConnection;
import com.medlog.webservice.util.FormatUtils;
import model.Medication.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebMedicationView {

    /* This method returns a HTML table displaying all the records of the web_user table. 
     * cssClassForResultSetTable: the name of a CSS style that will be applied to the HTML table.
     *   (This style should be defined in the JSP page (header or style sheet referenced by the page).
     * dbc: an open database connection.
     */
    
    private static StringData dbRowToStringData(ResultSet results) {

        StringData sd = new StringData();

        try {  
            sd.medicationID = FormatUtils.formatInteger(results.getObject("MedicationID"));
            sd.dosage = FormatUtils.formatString(results.getObject("Dosage"));
            sd.startDate = FormatUtils.formatDate(results.getObject("StartDate"));
            sd.endDate = FormatUtils.formatDate(results.getObject("EndDate"));
            sd.patientID = FormatUtils.formatInteger(results.getObject("PatientID"));
            sd.pharmID = FormatUtils.formatString(results.getObject("DISPLAY_NAME"));
            sd.physicianID = FormatUtils.formatString(results.getObject("lastname")) + ", " + FormatUtils.formatString(results.getObject("firstname"));
            
        } catch (Exception e) {
            sd.errorMessage = "Error in WebMedicationView.dbRowToStringData: " + e.getMessage();
        }
        return sd;
    }

    public static StringDataList getMedicationList(String user, DbConnection dbc) {

        StringDataList medicationList = new StringDataList(0);
        System.out.println("getMedicationList searching for items with patientID " + user);

        try {

            // Get the count of entries that will be in the JSON list of entries
            String sql = "SELECT count(*) as numItems FROM Patient, Medication WHERE Patient.PatientID = Medication.PatientID";
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
                medicationList = new StringDataList(num);
                System.out.println("***** num items is " + num);
            }

            // Now add each item to the journal list
            sql = "SELECT Medication.MedicationID, Patient.PatientID, DISPLAY_NAME, Dosage, StartDate, EndDate, HealthcareProvider.lastname, HealthcareProvider.firstname FROM Patient, Medication, HealthcareProvider, Pharma_RX_OTC WHERE Patient.PatientID = Medication.PatientID AND Medication.PharmID = Pharma_RX_OTC.PharmID AND Medication.PhysicianID = HealthcareProvider.PhysicianID";
            if ((user.length() != 0) && !user.equals("0")) {
                sql += " AND Patient.PatientID = ?";
            }
            sql += " ORDER BY DISPLAY_NAME";
            
            stmt = dbc.getConnnection().prepareStatement(sql);
            
            count = 1;
            if ((user.length() != 0) && !user.equals("0")) {
                stmt.setString(count, user);
                count++;
            }
            results = stmt.executeQuery();

            StringData medicine = null;
            while (results.next()) {
                medicine = dbRowToStringData(results);
                medicationList.addItem(medicine);
            }
            results.close();
            stmt.close();
        } catch (Exception e) {
            medicationList.dbError = e.getMessage();
        }
        return medicationList;
    }
    
    /*public static StringData getMedication(String medicationID, DbConnection dbc) {

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
    }*/
}
