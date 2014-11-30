package businesslogic.stockbl.stockManage;

import java.util.ArrayList;
import po.GoodsPO;
import vo.StockErrorVO;
import vo.StockOverOrLowVO;
import businesslogicservice.stockblservice.controlblservice.StockControlBLService;

public class StockControlController implements StockControlBLService {

	public int addStockOverOrLow(StockOverOrLowVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int addStockError(StockErrorVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	// 获得库存报溢收入
	public double getGoodsOverIncome() {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.getGoodsOverIncome();
	}

	// 获得库存报损支出
	public double getGoodsLowCost() {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.getGoodsLowCost();
	}

	public ArrayList<String> showStock(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.showStock(beginDate, endDate);

	}

	public ArrayList<GoodsPO> checkStock() {
		// TODO 自动生成的方法存根
		return null;
	}

	//销售检查库存是否充足
	public boolean isEnough(String ID, int num) {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.isEnough(ID, num);
	}

	public double getPrimeCostIncome() {
		// TODO 自动生成的方法存根
		return 0;
	}



	// 获得商品赠送支出
	public double getGiftCost() {
		// TODO 自动生成的方法存根
		StockManage manage=new StockManage();
		return manage.getGiftCost();
	}
}
