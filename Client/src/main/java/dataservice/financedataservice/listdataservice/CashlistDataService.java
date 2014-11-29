package dataservice.financedataservice.listdataservice;

import java.rmi.Remote;

import po.CashlistPO;

public interface CashlistDataService extends Remote{
	public int createCashlist (CashlistPO po) ;
}
