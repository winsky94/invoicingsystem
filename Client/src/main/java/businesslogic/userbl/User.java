package businesslogic.userbl;

import po.UserPO;
import vo.UserVO;
import businesslogicservice.userblservice.UserBLService;

public class User implements UserBLService{
	String name;
	String ID;
	String password;
	String job;
	
	public int login(String ID, String password) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int addUser(UserVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int deleteUser(UserVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int modifyUser(UserVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public UserPO showUser(String UserID) {
		// TODO 自动生成的方法存根
		return null;
	}

}
