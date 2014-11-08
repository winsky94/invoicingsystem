package businesslogicservice.stockblservice.errorblservice;

import vo.StockErrorVO;
import vo.StockOverOrLowVO;
import businesslogic.receiptbl.ReceiptType;

public class StockErrorBLService_driver {
	public void drive(StockErrorBLService_stub stockErrorBLService) {
		StockOverOrLowVO stockOverOrLowVO = new StockOverOrLowVO("飞利浦日光灯",
				"SR01", 100, 99, -1, "小赵,000001", ReceiptType.STOCKLOW, "",
				"00002");

		StockErrorVO stockErrorVO = new StockErrorVO("飞利浦日光灯", "SR01",
				"小赵,000001", ReceiptType.STOCKERROR, "", "00002");
		stockErrorBLService.addStockOverOrLow(stockOverOrLowVO);
		stockErrorBLService.addStockError(stockErrorVO);
		stockErrorBLService.goodsOverIncome();
		stockErrorBLService.goodsLowCost();
	}

	public static void main(String[] args) {
		StockErrorBLService_stub stockErrorBLService = new StockErrorBLService_stub();
		StockErrorBLService_driver driver = new StockErrorBLService_driver();
		driver.drive(stockErrorBLService);
	}
}
