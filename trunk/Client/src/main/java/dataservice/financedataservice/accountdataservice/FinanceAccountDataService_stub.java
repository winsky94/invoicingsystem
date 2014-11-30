package dataservice.financedataservice.accountdataservice;

import java.util.ArrayList;

import po.AccountPO;

public class FinanceAccountDataService_stub implements FinanceAccountDataService{

	public int addAccount(AccountPO po) {
		System.out.println("Add account success!");
		return 0;
	}

	public int deleteAccount(AccountPO po) {
		System.out.println("Delete account success!");
		return 0;
	}

	public int modifyAccount(AccountPO po) {
		System.out.println("Modify account success!");
		return 0;
	}

	public ArrayList<AccountPO> findAccount(String s) {
		System.out.println("Find account success!");
		return new ArrayList<AccountPO>();
	}	
}
