package businesslogicservice.stockblservice.errorblservice;

import vo.*;

public interface StockErrorBLService {
	public int addStockOverOrLow(StockOverOrLowVO vo);

	public int addStockError(StockErrorVO vo);
}
