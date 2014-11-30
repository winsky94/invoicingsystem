package dataservice.financedataservice.listdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ReceiptPO;

public interface RedExtrusionDataService extends Remote{
	public int createRedExtrusion(ReceiptPO po) throws RemoteException;
    public ReceiptPO createRedExtrusionAndCopy(ReceiptPO po) throws RemoteException;
}
