package model.Journal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.medlog.webservice.sql.DbConnection;
import com.medlog.webservice.util.FormatUtils;

public class Search {

    public static StringData findById(DbConnection dbc, String id, String[] ratingOptions) {

        StringData foundItem = new StringData(); // default constructor sets all fields to "" (empty string)
        if (id == null) {
            foundItem.errorMessage = "cannot search for item with null journal id";
            System.out.println("**** Error in model.Journal.Search.FindById: " + foundItem.errorMessage);
            return foundItem;
        }

        PreparedStatement stmt = null;
        ResultSet results = null;
        try {

            String sql = "select Id, Title, Notes, NotesActivity, ratingMood, ratingProductivity, createdDate, updatedDate "
                    + "from Diary WHERE Id=?";

            stmt = dbc.getConnnection().prepareStatement(sql);

            // this puts the user's input (from variable emailAddress)
            // into the 1st question mark of the sql statement above.
            stmt.setString(1, id);

            results = stmt.executeQuery();
            //System.out.println("*** query executed");

            if (results.next()) {
                //System.out.println("*** record selected");
                foundItem.id = id; // id is the item id we searched for
                foundItem.title = FormatUtils.objectToString(results.getObject("Title"));
                foundItem.notes = FormatUtils.objectToString(results.getObject("Notes"));
                foundItem.notesActivity = FormatUtils.objectToString(results.getObject("NotesActivity"));
                foundItem.mood = FormatUtils.objectToString(results.getObject("ratingMood"));
                for (int i = 0; i < ratingOptions.length; i++) {
                    if (foundItem.mood.compareTo(ratingOptions[i]) == 0) {
                        i++;
                        foundItem.mood = "" + i;
                        i = ratingOptions.length;
                    }
                }
                foundItem.productivity = FormatUtils.objectToString(results.getObject("ratingProductivity"));
                for (int i = 0; i < ratingOptions.length; i++) {
                    if (foundItem.productivity.compareTo(ratingOptions[i]) == 0) {
                        i++;
                        foundItem.productivity = "" + i;
                        i = ratingOptions.length;
                    }
                }
                foundItem.createdDate = FormatUtils.formatDate(results.getObject("createdDate"));
                foundItem.updatedDate = FormatUtils.formatDate(results.getObject("updatedDate"));
                //System.out.println("*** fields extracted from result set");
                results.close();
                stmt.close();
                return foundItem;
            } else {
                return null; // means item not found with given credentials.
            }
        } catch (Exception e) {
            foundItem.errorMessage = "Exception thrown in model.inCollection.Search.findById(): " + e.getMessage();
            System.out.println("**** " + foundItem.errorMessage);
            return foundItem;
        }
    }
}
