package businesslogicservice.userblservice;

import po.UserPO;
import vo.UserVO;

public interface UserBLService {
	public int login(String ID, String password);

	public int addUser(UserVO vo);

	public int deleteUser(String ID);

	public int modifyUser(UserVO vo);

	public UserVO showUser(String UserID);
}
