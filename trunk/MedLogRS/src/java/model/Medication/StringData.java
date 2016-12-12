package model.Medication;

public class StringData {
    public String medicationID = "";
    public String dosage = "";
    public String startDate = "";
    public String endDate = "";
    public String patientID = "";
    public String pharmID = "";
    public String physicianID= "";
    public String errorMessage = "";
    
    public int getCharacterCount() {
        String s = this.medicationID + this.dosage + this.startDate + this.endDate + this.patientID + this.pharmID +
                this.physicianID;
        return s.length();
    }
    
    public String toString(){
        return "Medication ID:" + this.medicationID +
                "Dosage:" + this.dosage + 
                ", Start Date:" + this.startDate+
                ", End Date:" + this.endDate+
                ", Patient ID:" + this.patientID+
                ", MedList(Pharm) ID (or possibly, med. name):" + this.pharmID+
                ", Physician ID (or possibly name):" + this.physicianID+
                ", Error Message:" + this.errorMessage;
    }
}
