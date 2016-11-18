package model.Journal;

public class StringDataList {

    public StringData[] journalList = null;
    public int listSize = 0;
    private int addIndex = 0;
    public String dbError = "";

    public StringDataList(int listSize) {
        this.listSize = listSize;
        this.journalList = new StringData[listSize];
    }

    public boolean addItem(StringData item) {
        if (this.addIndex < this.listSize) {
            this.journalList[addIndex] = item;
            this.addIndex++;
            return true;
        } else {
            System.out.println("***** StringDataList: Attempt to add item number " +
                    this.addIndex + " to journal list of size " + this.listSize);
            return false;
        }
    }
}