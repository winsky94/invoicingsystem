package Dataservice.stockdataservice.controldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public interface StockControlDataService extends Remote {

	public int addStockOverOrLow(StockOverOrLowPO po) throws RemoteException;

	public int addStockError(StockErrorPO po) throws RemoteException;
}
