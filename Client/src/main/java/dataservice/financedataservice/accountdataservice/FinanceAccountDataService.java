package dataservice.financedataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;

public interface FinanceAccountDataService {
	public int addAccount(AccountPO po) throws RemoteException;
    public int deleteAccount(AccountPO po) throws RemoteException;
    public int modifyAccount(AccountPO po,String name) throws RemoteException;
    public ArrayList<AccountPO> findAccount(String s) throws RemoteException;
    public ArrayList<AccountPO> showAll() throws RemoteException;
}
