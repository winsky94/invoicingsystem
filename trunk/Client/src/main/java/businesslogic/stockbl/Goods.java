package businesslogic.stockbl;

import java.util.ArrayList;

import po.GoodsPO;
import vo.GoodsVO;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;


public class Goods implements StockGoodsBLService{
	String GoodsID;
	String name;
	String size;
	int numInStock;
	int virtualnumInStock;
	double purchasePrice;
	double price;
	double lastPurchasePrice;
	double lastPrice;
	
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
	
}
