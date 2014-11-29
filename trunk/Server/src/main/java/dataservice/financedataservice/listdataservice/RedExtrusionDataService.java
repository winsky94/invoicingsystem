package dataservice.financedataservice.listdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ReceiptPO;

public interface RedExtrusionDataService extends Remote{
	public int createRedExtrusion(ReceiptPO vo) throws RemoteException;
    public int createRedExtrusionAndCopy(ReceiptPO vo) throws RemoteException;
}
