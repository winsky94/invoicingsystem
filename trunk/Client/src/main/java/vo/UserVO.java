package vo;

import businesslogic.userbl.UserType;

public class UserVO {
	private String name;
	private String ID;
	private String password;
	private UserType type;

	public UserVO(String name, String ID, String password, UserType type) {
		this.name = name;
		ID = ID;
		this.password = password;
		this.type=type;
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public String getPassword() {
		return password;
	}

	public UserType getJob() {
		return type;
	}
}
