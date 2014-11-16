package dataservice.stockdataservice.controldataservice;

import java.rmi.RemoteException;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public class StockControlDataService_driver {

	public void drive(StockControlDataService stockControlDataService)
			throws RemoteException {
		StockOverOrLowPO stockOverOrLowPO = new StockOverOrLowPO("飞利浦日光灯",
				"SR01", 100, 99);
		StockErrorPO stockErrorPO = new StockErrorPO("飞利浦日光灯", "SR01");
		stockControlDataService.addStockOverOrLow(stockOverOrLowPO);
		stockControlDataService.addStockError(stockErrorPO);
		stockControlDataService.goodsOverIncome();
		stockControlDataService.goodsLowCost();
		stockControlDataService.showStock("2014年10月1日", "2014年10月17日");

		stockControlDataService.checkStock();
		stockControlDataService.isEnough("00001",10);
		stockControlDataService.PrimeCostIncome();
	}

	public static void main(String[] args) throws RemoteException {
		// TODO 自动生成的方法存根
		StockControlDataService_stub stockControlDataService = new StockControlDataService_stub();
		StockControlDataService_driver driver = new StockControlDataService_driver();
		driver.drive(stockControlDataService);
	}

}
