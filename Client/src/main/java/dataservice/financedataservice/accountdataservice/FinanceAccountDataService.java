package dataservice.financedataservice.accountdataservice;

import java.util.ArrayList;

import po.AccountPO;

public interface FinanceAccountDataService {
	public int addAccount(AccountPO po);
    public int deleteAccount(AccountPO po);
    public int modifyAccount(AccountPO po);
    public ArrayList<AccountPO> findAccount(String s);
}
