package businesslogic.stockbl.goods;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsPO;
import businesslogic.stockbl.goodsClass.GoodsClassManage;
import businesslogic.stockbl.stockManage.StockManageController;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService;

public class Goods {
	private String goodsID;
	private String name;
	private String size;
	private String gc;
	private int numInStock;
	private int virtualnumInStock;
	private double purchasePrice;
	private double price;
	private double lastPurchasePrice;
	private double lastPrice;
	private StockGoodsDataService service;

	public Goods() {
		// System.setSecurityManager(new SecurityManager());
		String host = "localhost:1099";
		String url = "rmi://" + host + "/goodsService";
		try {
			service = (StockGoodsDataService) Naming.lookup(url);
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

	public Goods(String name, String size, String gc, int numInStock,
			double purchasePrice, double price, double latPurchasePrice,
			double lastPrice) {
		this();
		this.name = name;
		this.size = size;
		this.gc = gc;
		this.numInStock = numInStock;
		this.virtualnumInStock = numInStock;
		this.price = price;
		this.purchasePrice = purchasePrice;
		this.lastPrice = lastPrice;
		this.lastPurchasePrice = latPurchasePrice;
	}

	public int addGoods() {
		ArrayList<GoodsPO> list = showGoods();
		boolean isExist = false;

		// 遍历文件中是否存在该商品
		for (int i = 0; i < list.size(); i++) {
			if (goodsID.equals(list.get(i).getGoodsID())) {
				isExist = true;
				break;
			}
		}

		if (isExist) {
			return 4;// 商品已存在，无法添加商品
		} else {
			GoodsClassManage gClassManage = new GoodsClassManage();
			String maxID = service.getMaxID();
			int tp = Integer.parseInt(maxID);
			String ID = String.valueOf(tp + 1);
			goodsID = gClassManage.getID(gc) + "-" + size + "-" + ID;
			GoodsPO po = new GoodsPO(goodsID, name, size, numInStock,
					virtualnumInStock, purchasePrice, price, lastPurchasePrice,
					lastPrice, gc);
			return service.addGoods(po);
		}
	}

	public int deleteGoods(String id) {
		GoodsPO po = new GoodsPO(goodsID, name, size, numInStock,
				virtualnumInStock, purchasePrice, price, lastPurchasePrice,
				lastPrice, gc);
		return service.deleteGoods(po);
	}

	public int modifyGoods(String id) {
		GoodsPO oldPO = findGoods(id).get(0);
		GoodsPO po = new GoodsPO(id, name, size, numInStock, virtualnumInStock,
				purchasePrice, price, lastPurchasePrice, lastPrice, gc);
		if (oldPO.getPurchasePrice() != po.getPurchasePrice()) {
			StockManageController manage = new StockManageController();
			Goods good = new Goods(oldPO.getName(), oldPO.getSize(),
					oldPO.getGoodsClassName(), oldPO.getNumInStock(),
					oldPO.getPurchasePrice(), oldPO.getPrice(),
					oldPO.getLastPurchasePrice(), oldPO.getLastPrice());
			Goods newGood = new Goods(po.getName(), po.getSize(),
					po.getGoodsClassName(), po.getNumInStock(),
					po.getPurchasePrice(), po.getPrice(),
					po.getLastPurchasePrice(), po.getLastPrice());
			manage.changePrime(good, newGood);
		}
		return service.modifyGoods(po);
	}

	public ArrayList<GoodsPO> findGoods(String message) {
		return service.findGoods(message);
	}

	public ArrayList<GoodsPO> showGoods() {
		return service.showGoods();
	}


	public String getGoodsID() {
		return goodsID;
	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public String getGc() {
		return gc;
	}

	public int getNumInStock() {
		return numInStock;
	}

	public int getVirtualnumInStock() {
		return virtualnumInStock;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public double getPrice() {
		return price;
	}

	public double getLastPurchasePrice() {
		return lastPurchasePrice;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	public void setVirtualnumInStock(int virtualnumInStock) {
		this.virtualnumInStock = virtualnumInStock;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setLastPurchasePrice(double lastPurchasePrice) {
		this.lastPurchasePrice = lastPurchasePrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

}
