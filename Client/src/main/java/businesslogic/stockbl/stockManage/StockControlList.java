package businesslogic.stockbl.stockManage;

import java.util.ArrayList;
import po.GoodsPO;
import vo.StockErrorVO;
import vo.StockOverOrLowVO;
import businesslogicservice.stockblservice.controlblservice.StockControlBLService;


public class StockControlList implements StockControlBLService{
	
	public int addStockOverOrLow(StockOverOrLowVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int addStockError(StockErrorVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public double getGoodsOverIncome() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public double getGoodsLowCost() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public ArrayList<GoodsPO> showStock(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<GoodsPO> checkStock() {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean isEnough(String ID, int num) {
		// TODO 自动生成的方法存根
		return false;
	}

	public double getPrimeCostIncome() {
		// TODO 自动生成的方法存根
		return 0;
	}

}
