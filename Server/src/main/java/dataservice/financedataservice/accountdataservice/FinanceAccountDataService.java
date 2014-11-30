package dataservice.financedataservice.accountdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.AccountPO;

public interface FinanceAccountDataService  extends Remote{
	public int addAccount(AccountPO po);
    public int deleteAccount(AccountPO po);
    public int modifyAccount(AccountPO po);
    public ArrayList<AccountPO> findAccount(String s);
}
