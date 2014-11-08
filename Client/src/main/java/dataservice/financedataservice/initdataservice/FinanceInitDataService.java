package dataservice.financedataservice.initdataservice;

import po.BeginInfoPO;

public interface FinanceInitDataService {
	public int initInfo(BeginInfoPO po);
	public BeginInfoPO  getInfo(BeginInfoPO po);
}
