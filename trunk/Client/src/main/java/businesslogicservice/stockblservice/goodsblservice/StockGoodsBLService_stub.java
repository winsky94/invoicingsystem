package businesslogicservice.stockblservice.goodsblservice;

import java.util.ArrayList;

import po.GoodsPO;
import vo.GoodsVO;

public class StockGoodsBLService_stub implements StockGoodsBLService {

	public int addGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("add goods succeed!");
		return 0;
	}

	public int deleteGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("delete goods succeed!");
		return 0;
	}

	public int modifyGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("modify goods succeed!");
		return 0;
	}

	public ArrayList<GoodsPO> findGoods(String message) {
		// TODO 自动生成的方法存根
		System.out.println("find goods succeed!");
		return null;
	}

	public ArrayList<GoodsPO> showStock(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		System.out.println("show stock succeed!");
		return new ArrayList<GoodsPO>();
	}

	public ArrayList<GoodsPO> checkStock() {
		// TODO 自动生成的方法存根
		System.out.println("check stock succeed!");
		return new ArrayList<GoodsPO>();
	}

	public ArrayList<GoodsPO> showGoods() {
		// TODO 自动生成的方法存根
		System.out.print("show goods succeed!");
		return null;
	}
}
