package businesslogic.stockbl;

import java.util.ArrayList;

import po.GoodsPO;
import vo.GoodsVO;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;

public class GoodsController implements StockGoodsBLService {
	MockGoods good = new MockGoods("00020001", "飞利浦日光灯", "SR01", 20, 200, 100);

	public int addGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int deleteGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int modifyGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public ArrayList<GoodsPO> findGoods(String message) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<GoodsPO> showGoods() {
		// TODO 自动生成的方法存根
		return null;
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
		if (good.numInStock >= num) {
			return true;
		} else {
			return false;
		}
	}

	public double PrimeCostIncome() {
		// TODO 自动生成的方法存根
		return 0;
	}

}
