package businesslogic.stockbl.stockManage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsPO;
import po.StockOverOrLowPO;
import businesslogic.stockbl.GiftReceipt;
import businesslogic.stockbl.StockOverOrLowReceipt;
import businesslogic.stockbl.goods.Goods;
import dataservice.stockdataservice.controldataservice.StockControlDataService;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService;

public class StockManage {
	private String num;
	private ArrayList<StockOverOrLowReceipt> stockOverOrLowReceiptlist;
	private ArrayList<GiftReceipt> giftReceiptlist;
	private double goodsOverIncome;
	private double primeCostIncome;
	private double goodsLowCost;
	private double giftCost;
	private StockControlDataService service;
	private String host;
	private String url;

	public StockManage() {
		host = "localhost:1099";
		url = "rmi://" + host + "/userService";
		try {
			service = (StockControlDataService) Naming.lookup(url);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 库存调价
	public int changePrime(Goods good, Goods newGood) {
		primeCostIncome += (good.getPurchasePrice() - newGood
				.getPurchasePrice()) * newGood.getNumInStock();
		return 0;
	}

	// 检查库存是否充足满足销售需求
	public boolean isEnough(String id, int num) {
		StockGoodsDataService goodsService = null;
		try {
			goodsService = (StockGoodsDataService) Naming.lookup(url);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		ArrayList<GoodsPO> list = goodsService.findGoods(id);
		if (list.get(0).getVirtualNumInStock() < num) {
			return false;
		} else {
			return true;
		}
	}

	// 获得库存调价收入
	public double getPrimeCostIncome() {
		
		return primeCostIncome;
	}

	// 获得库存报溢收入
	public double getGoodsOverIncome() {
		ArrayList<StockOverOrLowPO> list=service.getStockOverOrLowPO();
		for(int i=0;i<list.size();i++){
			//if(list.get(i))  ??
		}
		return goodsOverIncome;
	}

	// 获得库存报损支出
	public double getGoodsLowCost() {
		return goodsLowCost;
	}

	// 获得商品赠送支出
	public double getGiftCost() {
		return giftCost;
	}
}
