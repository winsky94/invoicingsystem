package businesslogicservice.financeblservice.initblservice;

import vo.BeginInfoVO;

public interface FinanceInitBLService {
	public int initInfo(BeginInfoVO vo);
	public BeginInfoVO getInfo(String time);
}
