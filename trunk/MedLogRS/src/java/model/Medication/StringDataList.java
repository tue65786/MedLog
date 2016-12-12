package model.Medication;

public class StringDataList {

    public StringData[] medicationList = null;
    public int listSize = 0;
    private int addIndex = 0;
    public String dbError = "";

    public StringDataList(int listSize) {
        this.listSize = listSize;
        this.medicationList = new StringData[listSize];
    }

    public boolean addItem(StringData item) {
        if (this.addIndex < this.listSize) {
            this.medicationList[addIndex] = item;
            this.addIndex++;
            return true;
        } else {
            System.out.println("***** StringDataList: Attempt to add item number "
                    + this.addIndex + " to medication list of size " + this.listSize);
            return false;
        }
    }
}
