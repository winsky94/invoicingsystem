package po;

import java.util.Date;

public class LogPO {
	private Date date;
	private  String userID;
	private  String userName;
	private String info;
	private double addGrades;
	
	public LogPO(Date date,String userID, String userName, String info, double addGrades) {
		this.date=date;
		this.userID = userID;
		this.userName = userName;
		this.info = info;
		this.addGrades = addGrades;
	}
	public Date getDate() {
		return date;
	}
	public String getUserID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}
	public String getInfo() {
		return info;
	}
	public double getAddGrades() {
		return addGrades;
	}
}