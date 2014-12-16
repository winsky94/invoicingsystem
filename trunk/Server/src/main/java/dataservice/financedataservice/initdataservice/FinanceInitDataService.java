package dataservice.financedataservice.initdataservice;

import po.BeginInfoPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FinanceInitDataService extends Remote{
	public int initInfo(String time,BeginInfoPO po) throws RemoteException;
	public BeginInfoPO getInfo(String time) throws RemoteException;
	public String getCurrentTime() throws RemoteException;
}
