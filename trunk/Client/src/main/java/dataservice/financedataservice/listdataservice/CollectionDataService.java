package dataservice.financedataservice.listdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.CollectionPO;

public interface CollectionDataService extends Remote{
	public int createCollection (CollectionPO po);
	public ArrayList<CollectionPO> getCollection() ;
	public int getNum();
	public CollectionPO findByID(String id);
}
