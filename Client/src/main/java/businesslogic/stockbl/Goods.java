package businesslogic.stockbl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.GoodsPO;
import vo.GoodsVO;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService;

public class Goods implements StockGoodsBLService {
	String GoodsID;
	public String name;
	String size;
	int numInStock;
	int virtualnumInStock;
	double purchasePrice;
	double price;
	double lastPurchasePrice;
	double lastPrice;
	StockGoodsDataService service;

	public Goods() throws Exception {
		System.setSecurityManager(new SecurityManager());
		String host = "localhost:1099";
		String url = "rmi://" + host + "/userService";
		service = (StockGoodsDataService) Naming.lookup(url);
	}

	public int addGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		GoodsPO po = goodsVOToPO(vo);
		ArrayList<GoodsPO> list = showGoods();
		boolean isExist = false;

		// 遍历文件中是否存在该商品
		for (int i = 0; i < list.size(); i++) {
			if (po.getSize().equals(list.get(i).getSize())) {
				isExist = true;
				break;
			}
		}

		if (isExist) {
			return 4;// 商品已存在，无法添加商品
		} else {
			return service.addGoods(po);
		}
	}

	public int deleteGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		GoodsPO po = goodsVOToPO(vo);
		return service.deleteGoods(po);
	}

	public int modifyGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		GoodsPO po = goodsVOToPO(vo);
		return service.modifyGoods(po);
	}

	public ArrayList<GoodsPO> findGoods(String message) {
		// TODO 自动生成的方法存根
		return service.findGoods(message);
	}

	public ArrayList<GoodsPO> showGoods() {
		// TODO 自动生成的方法存根
		return service.showGoods();
	}

	public double getPrice() {
		return price;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public GoodsPO goodsVOToPO(GoodsVO vo) {
		GoodsPO po = new GoodsPO(vo.getGoodsID(), vo.getName(), vo.getSize(),
				vo.getNumInStock(), vo.getNumInStock(), vo.getPurchasePrice(),
				vo.getPrice(), vo.getLastPurchasePrice(), vo.getLastPrice(),
				vo.getGoodsClass());
		return po;
	}

}
