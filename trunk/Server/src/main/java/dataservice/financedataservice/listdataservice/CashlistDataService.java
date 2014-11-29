package dataservice.financedataservice.listdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CashlistPO;

public interface CashlistDataService extends Remote{
	 public int createCashlist (CashlistPO po) throws RemoteException;
}
