package po;

import java.io.Serializable;

import businesslogic.userbl.UserType;

public class UserPO implements Serializable {
	private String name;
	private String ID;
	private String password;
	private UserType type;

	public UserPO(String name, String iD, String password, UserType type) {
		this.name = name;
		ID = iD;
		this.password = password;
		this.type=type;
	}

	public String getName() {
		return name;
	}

	/*public void setName(String name) {
		this.name = name;
	}*/

	public String getID() {
		return ID;
	}

	/*public void setID(String iD) {
		ID = iD;
	}*/

	public String getPassword() {
		return password;
	}

	/*public void setPassword(String password) {
		this.password = password;
	}*/

	public UserType getJob() {
		return type;
	}

	/*public void setJob(UserType type) {
		this.type = type;
	}*/

}
