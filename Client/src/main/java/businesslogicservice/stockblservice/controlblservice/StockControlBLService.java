package businesslogicservice.stockblservice.controlblservice;

import java.util.ArrayList;

import po.GoodsPO;
import vo.StockErrorVO;
import vo.StockOverOrLowVO;

public interface StockControlBLService {
	public int addStockOverOrLow(StockOverOrLowVO vo);

	public int addStockError(StockErrorVO vo);

	// 商品报溢收入
	public double getGoodsOverIncome();

	// 商品报损支出
	public double getGoodsLowCost();
	
	public ArrayList<GoodsPO> showStock(String beginDate, String endDate);

	public ArrayList<GoodsPO> checkStock();

	public boolean isEnough(String ID, int num);

	// 商品调价收入
	public double getPrimeCostIncome();
}
