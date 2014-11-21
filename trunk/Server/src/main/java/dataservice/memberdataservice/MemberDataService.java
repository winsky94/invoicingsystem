package dataservice.memberdataservice;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.MemberPO;

public interface MemberDataService extends Remote{
	public int add(MemberPO po) throws RemoteException;
	public int delete(MemberPO po)throws RemoteException;
	public int modify(MemberPO po)throws RemoteException;
	public MemberPO find(String message)throws RemoteException;
}
