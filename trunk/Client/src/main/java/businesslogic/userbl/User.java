package businesslogic.userbl;

import java.rmi.Naming;
import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import po.UserPO;
import vo.UserVO;
import ServerRMI.localinter;
import businesslogicservice.userblservice.UserBLService;

public class User implements UserBLService{
	private String name;
	private String ID;
	private String password;
	private UserType type;
	private UserDataService service;
	public User(){
		String host="8080";
		String url="rmi://"+host+"/localService";
		service=(UserDataService)Naming.lookup(url);
	}
	
	
	
	public int login(String ID, String password) {
		// TODO 自动生成的方法存根
		return service.login(ID, password);
	}

	public int addUser(UserVO vo)   {
		// TODO 自动生成的方法存根
		UserPO po=new UserPO(vo.getName(),vo.getID(),vo.getPassword(),
				   vo.getJob());
		
		return service.add(po);
	}

	public int deleteUser(String ID) {
		// TODO 自动生成的方法存根
		return service.delete(ID);
	}

	public int modifyUser(UserVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public UserVO showUser(String UserID) {
		// TODO 自动生成的方法存根
		UserPO po=service.showUserInfo(UserID);
		UserVO vo=new UserVO(po.getName()
		return null;
	}

	
}
