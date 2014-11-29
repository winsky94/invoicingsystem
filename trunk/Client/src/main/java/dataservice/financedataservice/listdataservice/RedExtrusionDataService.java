package dataservice.financedataservice.listdataservice;

import java.rmi.Remote;

import po.ReceiptPO;

public interface RedExtrusionDataService extends Remote{
	public int createRedExtrusion(ReceiptPO vo);
    public int createRedExtrusionAndCopy(ReceiptPO vo);
}
