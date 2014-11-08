package dataservice.stockdataservice.errordataservice;

import java.rmi.RemoteException;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public class StockErrorDataService_driver {

	public void drive(StockErrorDataService stockErrorDataService)
			throws RemoteException {
		StockOverOrLowPO stockOverOrLowPO = new StockOverOrLowPO("飞利浦日光灯",
				"SR01", 100, 99, -1);
		StockErrorPO stockErrorPO = new StockErrorPO("飞利浦日光灯", "SR01");
		stockErrorDataService.addStockOverOrLow(stockOverOrLowPO);
		stockErrorDataService.addStockError(stockErrorPO);
		stockErrorDataService.goodsOverIncome();
		stockErrorDataService.goodsLowCost();
	}

	public static void main(String[] args) throws RemoteException {
		// TODO 自动生成的方法存根
		StockErrorDataService_stub stockErrorDataService = new StockErrorDataService_stub();
		StockErrorDataService_driver driver = new StockErrorDataService_driver();
		driver.drive(stockErrorDataService);
	}

}
