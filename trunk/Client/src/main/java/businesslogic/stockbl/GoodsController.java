package businesslogic.stockbl;

import java.util.ArrayList;

import po.GoodsPO;
import vo.GoodsVO;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;

public class GoodsController implements StockGoodsBLService {
	Goods goodsController;

	public GoodsController() throws Exception {
		goodsController = new Goods();
	}

	public int addGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		return goodsController.addGoods(vo);
	}

	public int deleteGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		return goodsController.deleteGoods(vo);
	}

	public int modifyGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		return goodsController.modifyGoods(vo);
	}

	public ArrayList<GoodsPO> findGoods(String message) {
		// TODO 自动生成的方法存根
		return goodsController.findGoods(message);
	}

	public ArrayList<GoodsPO> showGoods() {
		// TODO 自动生成的方法存根
		return goodsController.showGoods();
	}

}
