package dataservice.stockdataservice.errordataservice;

import java.rmi.RemoteException;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public class StockErrorDataService_stub implements StockErrorDataService {
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

	public double goodsOverIncome() {
		// TODO 自动生成的方法存根
		System.out.println("return goods over income in file succeed!");
		return 0;
	}

	public double goodsLowCost() {
		// TODO 自动生成的方法存根
		System.out.println("return goods low cost in file succeed!");
		return 0;
	}

}
