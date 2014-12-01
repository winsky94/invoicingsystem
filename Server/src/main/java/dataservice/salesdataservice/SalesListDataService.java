package dataservice.salesdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptPO;

public interface SalesListDataService {
	public void getSaleList() throws RemoteException;
	public ArrayList<ReceiptPO> makeSaleList() throws RemoteException;
}
