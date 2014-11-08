package businesslogicservice.financeblservice.initblservice;

import vo.BeginInfoVO;

public class FinanceInitBLService_stub implements FinanceInitBLService{

	public int initInfo(BeginInfoVO vo) {
		System.out.println("Initial stock success!");
		return 0;
	}


	public BeginInfoVO getInfo(String time) {
		System.out.println("Show beginInformation success!");
		return new BeginInfoVO();
	}
}
