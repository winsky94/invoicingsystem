package dataservice.userdataservice;

import java.rmi.*;

import po.*;

public interface UserDataService extends Remote {
	public String Find(String ID) throws RemoteException;
	public int add(UserPO po) throws RemoteException;

	public int delete(UserPO po) throws RemoteException;

	public int modify(UserPO po) throws RemoteException;

	public UserPO showUserInfo(String ID) throws RemoteException;
}
