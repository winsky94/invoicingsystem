package businesslogicservice.userblservice;

import po.UserPO;
import vo.UserVO;

public class UserBLService_stub implements UserBLService {

	public int login(String ID, String password) {
		// TODO 自动生成的方法存根
		System.out.println("Login succeed!");
		return 0;
	}

	public int addUser(UserVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("Add user succeed!");
		return 0;
	}

	public int deleteUser(UserVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("delete user succeed!");
		return 0;
	}

	public int modifyUser(UserVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("Modify user succeed!");
		return 0;
	}

	public UserPO showUser(String UserID) {
		// TODO 自动生成的方法存根
		System.out.println("Show users succeed!");
		return new UserPO("小赵", "00001", "123456", "库存管理员");
	}
}
