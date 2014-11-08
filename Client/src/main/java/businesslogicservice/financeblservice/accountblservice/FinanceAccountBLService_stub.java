package businesslogicservice.financeblservice.accountblservice;

import vo.AccountVO;

public class FinanceAccountBLService_stub implements FinanceAccountBLService{

	public int addAccount(AccountVO vo) {	
		System.out.println("Add Account Success!");
		return 0;
	}

	public int deleteAccount(AccountVO vo) {
		System.out.println("Delete Account Success!");
		return 0;
	}

	public int modifyAccount(AccountVO vo) {
		System.out.println("Modify account success!");		
		return 0;
	}

	public AccountVO findAccount(String s) {
		System.out.println("Find account success!");
		return new AccountVO();
	}
}
