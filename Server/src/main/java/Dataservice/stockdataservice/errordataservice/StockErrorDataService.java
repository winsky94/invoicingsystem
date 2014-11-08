package Dataservice.stockdataservice.errordataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public interface StockErrorDataService extends Remote {

	public int addStockOverOrLow(StockOverOrLowPO po) throws RemoteException;

	public int addStockError(StockErrorPO po) throws RemoteException;
}
