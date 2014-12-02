package businesslogicservice.financeblservice.accountblservice;

import java.util.ArrayList;

import vo.AccountVO;

public interface FinanceAccountBLService {
	public int addAccount(AccountVO vo);
    public int deleteAccount(AccountVO vo);
    public int modifyAccount(AccountVO vo);
    public AccountVO findAccount(String s);
    public ArrayList<AccountVO> showAll();
}
