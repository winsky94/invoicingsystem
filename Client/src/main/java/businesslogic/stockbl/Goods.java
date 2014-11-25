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
	
	public Goods() throws Exception{
		System.setSecurityManager(new SecurityManager());
		String host="localhost:1099";
		String url="rmi://"+host+"/userService";
	
		service=(StockGoodsDataService)Naming.lookup(url);
	}
	
	public int addGoods(GoodsVO vo) {
		// TODO 自动生成的方法存根
		GoodsPO po=new GoodsPO(vo.getGoodsID(), vo.getName(), vo.getSize(), vo.getNumInStock(), vo.getNumInStock(), vo.getPurchasePrice(), vo.getPrice(), vo.getLastPurchasePrice(), vo.getLastPrice()); 
		
		return service.addGoods(po);
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

	
	public double getPrice() {
		return price;
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
}
