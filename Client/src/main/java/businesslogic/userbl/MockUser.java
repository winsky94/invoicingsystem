package businesslogic.userbl;

public class MockUser {
	String name;
	String ID;
	String password;
	String job;

	public MockUser(String name, String iD, String password, String job) {
		this.name = name;
		ID = iD;
		this.password = password;
		this.job = job;
	}
	
	public String getName(String name){
		return name;
	}
}
