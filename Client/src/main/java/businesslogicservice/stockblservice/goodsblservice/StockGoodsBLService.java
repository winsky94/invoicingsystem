package businesslogicservice.stockblservice.goodsblservice;

import java.util.ArrayList;

import po.GoodsPO;
import vo.GoodsVO;

public interface StockGoodsBLService {
	public int addGoods(GoodsVO vo);

	public int deleteGoods(GoodsVO vo);

	public int modifyGoods(GoodsVO vo);

	public ArrayList<GoodsPO> findGoods(String message);

	public ArrayList<GoodsVO> showGoods();

	public ArrayList<GoodsVO> showGoodsByClass(String className);
	
	public String getMaxID();
}
