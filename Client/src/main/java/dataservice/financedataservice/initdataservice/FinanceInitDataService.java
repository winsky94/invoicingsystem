package dataservice.financedataservice.initdataservice;

import po.BeginInfoPO;

public interface FinanceInitDataService {
	public int initInfo(String time,BeginInfoPO po);
	public BeginInfoPO getInfo(String time);
}
