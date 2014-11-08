package businesslogicservice.stockblservice.errorblservice;

import vo.StockErrorVO;
import vo.StockOverOrLowVO;

public interface StockErrorBLService {
	public int addStockOverOrLow(StockOverOrLowVO vo);

	public int addStockError(StockErrorVO vo);
	
}
