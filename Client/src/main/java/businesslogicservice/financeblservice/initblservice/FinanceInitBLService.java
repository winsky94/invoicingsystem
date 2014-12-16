package businesslogicservice.financeblservice.initblservice;

import vo.BeginInfoVO;

public interface FinanceInitBLService {
	public int initInfo(String time,BeginInfoVO po);
	public BeginInfoVO getInfo(String time);
	public String getCurrentTime();
}
