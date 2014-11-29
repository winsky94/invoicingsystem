package dataservice.financedataservice.listdataservice;

import java.rmi.Remote;

import po.CollectionPO;

public interface CollectionDataService extends Remote{
	public int createCollection (CollectionPO po);
}
