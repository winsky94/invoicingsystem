package dataservice.financedataservice.initdataservice;

import po.BeginInfoPO;

public class FinanceInitDataService_stub implements FinanceInitDataService{

	public int initInfo(BeginInfoPO po) {
		System.out.println("Initial stock success!");
		return 0;
	}

	public BeginInfoPO getInfo(BeginInfoPO po) {
		System.out.println("Show beginInformation success!");
		return new BeginInfoPO();
	}
}
