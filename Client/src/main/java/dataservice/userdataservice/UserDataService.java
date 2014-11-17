package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import po.UserPO;

public interface UserDataService extends Remote {
	public int login(String ID, String password);

	public int add(UserPO po) ;

	public int delete(String ID) ;

	public int modify(UserPO po) ;

	public UserPO showUserInfo(String ID) ;
}
