package dataservice.financedataservice.listdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CollectionPO;

public class CollectionDataService_stub implements CollectionDataService{
	public int createCollection(CollectionPO po) {
		System.out.println("Create collection success!");
		return 0;
	}

	public ArrayList<CollectionPO> getCollection() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
}
