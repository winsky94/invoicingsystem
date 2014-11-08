package dataservice.stockdataservice.errordataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public interface StockErrorDataService extends Remote {

	public int addStockOverOrLow(StockOverOrLowPO po) throws RemoteException;

	public int addStockError(StockErrorPO po) throws RemoteException;

	// 商品报溢收入
	public double goodsOverIncome();

	// 商品报损支出
	public double goodsLowCost();
}
