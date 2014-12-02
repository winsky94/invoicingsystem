package businesslogicservice.stockblservice.controlblservice;

import vo.StockErrorVO;
import vo.StockOverOrLowVO;
import businesslogic.receiptbl.ReceiptType;

public class StockControlBLService_driver {
	public void drive(StockControlBLService_stub stockControlBLService) {
		StockOverOrLowVO stockOverOrLowVO = new StockOverOrLowVO("飞利浦日光灯",
				"SR01", 100, 99, "小赵,000001", ReceiptType.STOCKLOW, "");

		StockErrorVO stockErrorVO = new StockErrorVO("飞利浦日光灯", "SR01",
				"小赵,000001", ReceiptType.STOCKERROR, "", "00002");
		stockControlBLService.addStockOverOrLow(stockOverOrLowVO);
		stockControlBLService.addStockError(stockErrorVO);
		stockControlBLService.getGoodsOverIncome();
		stockControlBLService.getGoodsLowCost();
		stockControlBLService.showStock("", "");
		stockControlBLService.checkStock();
		stockControlBLService.isEnough("00001", 10);
		stockControlBLService.getPrimeCostIncome();
	}

	public static void main(String[] args) {
		StockControlBLService_stub stockControlBLService = new StockControlBLService_stub();
		StockControlBLService_driver driver = new StockControlBLService_driver();
		driver.drive(stockControlBLService);
	}
}
