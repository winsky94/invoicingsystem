package dataservice.salesdataservice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PurchasePO;
import po.PurchaseReturnPO;
import po.SalePO;
import po.SaleReturnPO;


public interface SalesDataService extends Remote{
	public void getSaleList() throws RemoteException;
	public int purchase(PurchasePO po) throws RemoteException;
	public int purchaseReturn(PurchaseReturnPO po) throws RemoteException;
	public int sale(SalePO po) throws RemoteException;
	public int saleReturn(SaleReturnPO po) throws RemoteException;
	public ArrayList<PurchasePO> getPurchase() throws RemoteException;
	public ArrayList<PurchaseReturnPO> getPurchaseReturn()throws RemoteException;
	public ArrayList<SalePO> getSale() throws RemoteException;
	public ArrayList<SaleReturnPO> getSaleReturn() throws RemoteException;
}
