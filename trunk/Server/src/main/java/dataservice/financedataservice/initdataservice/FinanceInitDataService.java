package dataservice.financedataservice.initdataservice;

import po.BeginInfoPO;
import java.rmi.Remote;

public interface FinanceInitDataService extends Remote{
	public int initInfo(String time,BeginInfoPO po);
	public BeginInfoPO getInfo(String time);
}
