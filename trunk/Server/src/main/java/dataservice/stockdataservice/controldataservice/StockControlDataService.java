package dataservice.stockdataservice.controldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public interface StockControlDataService extends Remote {

	public int addStockOverOrLow(StockOverOrLowPO po) throws RemoteException;

	public int addStockError(StockErrorPO po) throws RemoteException;

	// 获得所有库存报溢报损单
	public ArrayList<StockOverOrLowPO> getStockOverOrLowPO()
			throws RemoteException;

	// 获得所有库存报警单
	public ArrayList<StockErrorPO> getStockErrorPO() throws RemoteException;

	// 记录库存调价收入
	public int recordPrimeCostIncome(String primeCostIncome)
			throws RemoteException;

	// 获得库存调价收入
	public ArrayList<String> getPrimeCostIncome() throws RemoteException;

	public String getMaxID() throws RemoteException;

	public String getErrorMaxID() throws RemoteException;

	public StockOverOrLowPO findByID(String id) throws RemoteException;
}