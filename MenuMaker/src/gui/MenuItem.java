package gui;

public class MenuItem {
	private int dayOptionIndex;
	private String recName;
	private String recDesc;
	private int recID;
		
	public void setDayOptionIndex(int curIndex) {
		dayOptionIndex = curIndex;
		
	}
	public void setRecName(String curName) {
		recName = curName;
	}
	
	public void setRecDesc(String curDesc) {
		recDesc = curDesc;
	}
	
	public void setRecID(int curID) {
		recID = curID;
	}
		
	public int getDayOptionIndex() {
		return dayOptionIndex;
		
	}
	public String getRecName() {
		return recName;
	}
	
	public String getRecDesc() {
		return recDesc;
	}
		
	public int getRecID() {
		return recID;
	}
}