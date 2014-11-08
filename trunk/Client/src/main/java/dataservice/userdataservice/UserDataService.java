package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import po.UserPO;

public interface UserDataService extends Remote {
	public int login(String ID, String password);

	public int add(UserPO po) throws RemoteException;

	public int delete(UserPO po) throws RemoteException;

	public int modify(UserPO po) throws RemoteException;

	public UserPO showUserInfo(String ID) throws RemoteException;
}
