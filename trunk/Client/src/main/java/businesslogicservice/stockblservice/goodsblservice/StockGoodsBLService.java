package businesslogicservice.stockblservice.goodsblservice;

import java.util.ArrayList;

import po.GoodsPO;
import vo.GoodsVO;

public interface StockGoodsBLService {
	public int addGoods(GoodsVO vo);

	public int deleteGoods(GoodsVO vo);

	public int modifyGoods(GoodsVO vo);

	public ArrayList<GoodsPO> findGoods(String message);

	public ArrayList<GoodsPO> showGoods();
	
	public ArrayList<GoodsPO> showStock(String beginDate, String endDate);

	public ArrayList<GoodsPO> checkStock();
}
