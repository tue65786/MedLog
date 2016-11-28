package model.Journal;

public class StringData {
    public String id = "";
    public String title = "";
    public String notes = "";
    public String notesActivity = "";
    public String createdDate = "";
    public String updatedDate = "";
    public String mood = "";
    public String productivity = "";
    public String patientID = "";
    public String errorMessage = "";
    
    public int getCharacterCount() {
        String s = this.id + this.title + this.notes + this.notesActivity + this.createdDate +
                this.updatedDate + this.mood + this.productivity + this. patientID;
        return s.length();
    }
    
    public String toString(){
        return "Journal ID:" + this.id +
                ", Title:" + this.title+
                ", Sentimental Journal:" + this.notes+
                ", Activity Journal:" + this.notesActivity+
                ", Date Created:" + this.createdDate+
                ", Date Updated:" + this.updatedDate+
                ", Mood Rating:" + this.mood+
                ", Productivity Rating:" + this.productivity+
                ", Patient ID:" + this.patientID+
                ", Error Message:" + this.errorMessage;
    }
}
