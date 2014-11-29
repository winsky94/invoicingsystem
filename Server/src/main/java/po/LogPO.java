package po;

public class LogPO {
	private  String userID;
	private  String userName;
	private String info;
	private double addGrades;
	public LogPO(String userID, String userName, String info, double addGrades) {
		this.userID = userID;
		this.userName = userName;
		this.info = info;
		this.addGrades = addGrades;
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
