package businesslogicservice.stockblservice.errorblservice;

import vo.StockErrorVO;
import vo.StockOverOrLowVO;

public interface StockErrorBLService {
	public int addStockOverOrLow(StockOverOrLowVO vo);

	public int addStockError(StockErrorVO vo);

	// 商品报溢收入
	public double goodsOverIncome();

	// 商品报损支出
	public double goodsLowCost();
}
