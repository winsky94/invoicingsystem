package dataservice.financedataservice.initdataservice;

import java.util.ArrayList;

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

	@Override
	public int initInfo(String time, BeginInfoPO po) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BeginInfoPO getInfo(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BeginInfoPO> showAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
