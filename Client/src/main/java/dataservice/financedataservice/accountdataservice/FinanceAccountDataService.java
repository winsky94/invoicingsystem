package dataservice.financedataservice.accountdataservice;

import po.AccountPO;

public interface FinanceAccountDataService {
	public int addAccount(AccountPO po);
    public int deleteAccount(AccountPO po);
    public int modifyAccount(AccountPO po);
    public AccountPO findAccount(String s);
}
