package dataservice.stockdataservice.controldataservice;

import java.rmi.RemoteException;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public class StockControlDataService_stub implements StockControlDataService {
	public int addStockOverOrLow(StockOverOrLowPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("add stockOverOrLow receipt in file succeed!");
		return 0;
	}

	public int addStockError(StockErrorPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("add stockError receipt in file succeed!");
		return 0;
	}

}
