package dataservice.financedataservice.listdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CollectionPO;

public interface CollectionDataService extends Remote{
	public int createCollection (CollectionPO po);
	public ArrayList<CollectionPO> getCollection() ;
	public int getNum() throws RemoteException;
}
