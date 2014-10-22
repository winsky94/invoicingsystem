package vo;

public class UserVO {
	String name;
	String ID;
	String password;
	String job;

	public UserVO(String name, String iD, String password, String job) {
		this.name = name;
		ID = iD;
		this.password = password;
		this.job = job;
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

	public String getJob() {
		return job;
	}
}
