package businesslogicservice.stockblservice.errorblservice;

import businesslogic.receiptbl.ReceiptType;
import vo.StockErrorVO;
import vo.StockOverOrLowVO;
import vo.UserVO;

public class StockErrorBLService_driver {
	public void drive(StockErrorBLService_stub stockErrorBLService) {
		UserVO userVO = new UserVO("小赵", "00001", "123456", "库存管理员");
		StockOverOrLowVO stockOverOrLowVO = new StockOverOrLowVO("飞利浦日光灯",
				"SR01", 100, 99, -1, userVO, ReceiptType.STOCKLOW, "", "00002");

		StockErrorVO stockErrorVO = new StockErrorVO("飞利浦日光灯", "SR01", userVO,
				ReceiptType.STOCKERROR, "", "00002");
		stockErrorBLService.addStockOverOrLow(stockOverOrLowVO);
		stockErrorBLService.addStockError(stockErrorVO);
	}

	public static void main(String[] args) {
		StockErrorBLService_stub stockErrorBLService = new StockErrorBLService_stub();
		StockErrorBLService_driver driver = new StockErrorBLService_driver();
		driver.drive(stockErrorBLService);
	}
}
