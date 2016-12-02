package model.Journal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.medlog.webservice.sql.DbConnection;
import com.medlog.webservice.util.PrepStatement;
import com.medlog.webservice.util.ValidationUtils;
import view.WebJournalView;

public class DbMods {

    private static StringData validate(StringData inputData) {

        StringData errorMessages = new StringData();

        // Validation
        /*errorMessages.mediaFormat = ValidationUtils.stringValidationMsg(inputData.mediaFormat, 30, false);
        errorMessages.mediaCondition = ValidationUtils.stringValidationMsg(inputData.mediaCondition, 45, false);
        errorMessages.askingPrice = ValidationUtils.decimalValidationMsg(inputData.askingPrice, false);
        errorMessages.comments = ValidationUtils.stringValidationMsg(inputData.comments, 500, false);*/
        return errorMessages;
    } // validate 

    public static void update(StringData inputData, DbConnection dbc, String id, String[] ratingOptions) {

        /*StringData errorMessages = new StringData();
        errorMessages = validate(inputData);
        if (errorMessages.getCharacterCount() > 0) {  // at least one field has an error, don't go any further.
            errorMessages.errorMessage = "Please try again";
            return errorMessages;

        } else {*/ // all fields passed validation
        // Start preparing SQL statement
        String sql = "UPDATE Diary SET Title=?, Notes=?, NotesActivity=?, ratingMood=?, ratingProductivity=? " //add dateUpdated
                + "WHERE Id=?";

        PrepStatement stmt = new PrepStatement(dbc, sql);

        // Encode string values into the prepared statement (wrapper class).
        stmt.setString(1, inputData.title);
        stmt.setString(2, inputData.notes);
        stmt.setString(3, inputData.notesActivity);
        String temp = inputData.mood;
        for (int i = 0; i < ratingOptions.length; i++) {
            if (inputData.mood.compareTo(ratingOptions[i]) == 0) {
                i++;
                inputData.mood = "" + i;
                i = ratingOptions.length;
            }
        }
        stmt.setString(4, inputData.mood);
        inputData.mood = temp;
        temp = inputData.productivity;
        for (int i = 0; i < ratingOptions.length; i++) {
            if (inputData.productivity.compareTo(ratingOptions[i]) == 0) {
                i++;
                inputData.productivity = "" + i;
                i = ratingOptions.length;
            }
        }
        stmt.setString(5, inputData.productivity);
        stmt.setInt(6, ValidationUtils.integerConversion(id));

        // here the SQL statement is actually executed
        System.out.println("executing update");
        int numRows = stmt.executeUpdate();

        // This will return empty string if all went well, else all error messages.
        /*errorMessages.errorMessage = stmt.getErrorMessage();
        if (errorMessages.errorMessage.length() == 0) {
            if (numRows == 1) {
                errorMessages.errorMessage = ""; // This means SUCCESS. Let the JSP page decide how to tell this to the user.
            } else {
                // probably never get here unless you forgot your WHERE clause and did a bulk sql update.
                errorMessages.errorMessage = numRows + " records were inserted when exactly 1 was expected.";
            }
        }*/
        //return errorMessages;
    }

    public static boolean secure(String user, String journal) {
        if((user == null) || (user == "") || (journal == null) || (journal == "")){
            System.out.println("problem retrieving user/journal ID - either null or empty string");
            return false;
        }
        
        StringData journalData = new StringData();
        DbConnection dbc = new DbConnection();

        System.out.println("jsp page ready to search for item with journalID " + journal);
        journalData = view.WebJournalView.getJournal(journal, dbc);
        System.out.println("logged in user ID = " + journalData.patientID);
        if (journalData.patientID.compareTo(user) == 0) {
            dbc.close();
            return true;
        } else {
            dbc.close();
            System.out.println("user and journal do not match - this journal belongs to another user");
            return false;
        }
    }
}
