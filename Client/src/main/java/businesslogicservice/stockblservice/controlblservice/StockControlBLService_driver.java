package businesslogicservice.stockblservice.controlblservice;

import vo.StockErrorVO;
import vo.StockOverOrLowVO;
import businesslogic.receiptbl.ReceiptType;

public class StockControlBLService_driver {
	public void drive(StockControlBLService_stub stockErrorBLService) {
		StockOverOrLowVO stockOverOrLowVO = new StockOverOrLowVO("飞利浦日光灯",
				"SR01", 100, 99, "小赵,000001", ReceiptType.STOCKLOW, "",
				"00002");

		StockErrorVO stockErrorVO = new StockErrorVO("飞利浦日光灯", "SR01",
				"小赵,000001", ReceiptType.STOCKERROR, "", "00002");
		stockErrorBLService.addStockOverOrLow(stockOverOrLowVO);
		stockErrorBLService.addStockError(stockErrorVO);
		stockErrorBLService.goodsOverIncome();
		stockErrorBLService.goodsLowCost();
	}

	public static void main(String[] args) {
		StockControlBLService_stub stockErrorBLService = new StockControlBLService_stub();
		StockControlBLService_driver driver = new StockControlBLService_driver();
		driver.drive(stockErrorBLService);
	}
}
