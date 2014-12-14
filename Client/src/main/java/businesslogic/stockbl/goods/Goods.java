package businesslogic.stockbl.goods;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import po.GoodsPO;
import vo.CommodityVO;
import vo.GiftVO;
import vo.GoodsVO;
import vo.PurchaseVO;
import vo.SaleVO;
import businesslogic.salesbl.SalesController;
import businesslogic.stockbl.gift.GiftController;
import businesslogic.stockbl.goodsClass.GoodsClassController;
import businesslogic.stockbl.goodsClass.GoodsClassManage;
import businesslogic.stockbl.stockManage.StockManage;
import businesslogicservice.salesblservice.PurchaseBLService;
import businesslogicservice.salesblservice.SalesBLService;
import businesslogicservice.stockblservice.giftblservice.GiftBLService;
import businesslogicservice.stockblservice.goodsclassblservice.StockGoodsClassBLService;
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
	private String manufactoryDate;
	private int minNumInStock;
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

	public Goods(String goodsID, String name, String size, String gc,
			int numInStock, double purchasePrice, double price,
			double latPurchasePrice, double lastPrice, String manufactoryDate,
			int minNumInStock) {
		this();
		this.goodsID = goodsID;
		this.name = name;
		this.size = size;
		this.gc = gc;
		this.numInStock = numInStock;
		this.virtualnumInStock = numInStock;
		this.price = price;
		this.purchasePrice = purchasePrice;
		this.lastPrice = lastPrice;
		this.lastPurchasePrice = latPurchasePrice;
		this.manufactoryDate = manufactoryDate;
		this.minNumInStock = minNumInStock;
	}

	public int addGoods() {
		ArrayList<GoodsPO> list = service.showGoods();
		boolean isExist = false;

		// 遍历文件中是否存在该商品
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())
					&& size.equals(list.get(i).getSize())) {
				isExist = true;
				break;
			}
		}

		if (isExist) {
			return 4;// 商品已存在，无法添加商品
		} else {
			String ID = "";
			NumberFormat nf = new DecimalFormat("0000");
			GoodsClassManage gClassManage = new GoodsClassManage();
			String maxID = service.getMaxID();
			if (maxID == null) {
				ID = "0000";
			} else {
				int tp = Integer.parseInt(maxID);
				ID = nf.format(tp + 1);
			}
			goodsID = gClassManage.getID(gc) + "-" + size + "-" + ID;
			GoodsPO po = new GoodsPO(goodsID, name, size, numInStock,
					virtualnumInStock, purchasePrice, price, lastPurchasePrice,
					lastPrice, gc, manufactoryDate, minNumInStock);
			return service.addGoods(po);
		}
	}

	public int deleteGoods(String id) {
		int result = -1;
		boolean isOperate = false;
		try {
			PurchaseBLService purchaseController = new SalesController();
			ArrayList<PurchaseVO> pList = purchaseController.showPurchase();
			SalesBLService saleController = new SalesController();
			ArrayList<SaleVO> sList = saleController.showSale();
			GiftBLService giftController = new GiftController();
			ArrayList<GiftVO> gList = giftController.getGiftList();
			// 检测是否进货过
			if (pList != null) {
				for (int i = 0; i < pList.size(); i++) {
					PurchaseVO vo = pList.get(i);
					ArrayList<CommodityVO> cList = vo.getPurchaseList();
					for (int j = 0; j < cList.size(); j++) {
						if (cList.get(j).getID().equals(id)) {
							isOperate = true;
							result = 91;
							break;
						}
					}

					if (isOperate == true) {
						break;
					}
				}
			}

			// 检测是否被销售过
			if (isOperate == false) {
				if (sList != null) {
					for (int i = 0; i < sList.size(); i++) {
						SaleVO vo = sList.get(i);
						ArrayList<CommodityVO> cList = vo.getSalesList();
						for (int j = 0; j < cList.size(); j++) {
							if (cList.get(j).getID().equals(id)) {
								isOperate = true;
								result = 92;
								break;
							}
						}

						if (isOperate == true) {
							break;
						}
					}
				}
			}

			// 检测是否被库存赠送过
			if (isOperate == false) {
				if (gList != null) {
					for (int i = 0; i < gList.size(); i++) {
						GiftVO vo = gList.get(i);
						ArrayList<CommodityVO> cList = vo.getGiftList();
						for (int j = 0; j < cList.size(); j++) {
							if (cList.get(j).getID().equals(id)) {
								isOperate = true;
								result = 93;
								break;
							}
						}

						if (isOperate == true) {
							break;
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if (isOperate == false) {
			GoodsPO po = new GoodsPO(goodsID, name, size, numInStock,
					virtualnumInStock, purchasePrice, price, lastPurchasePrice,
					lastPrice, gc, manufactoryDate, minNumInStock);
			result = service.deleteGoods(po);
		}
		return result;
	}

	public int modifyGoods(String id) {
		GoodsPO oldPO = service.findGoods(id).get(0);
		GoodsPO po = new GoodsPO(id, name, size, numInStock, virtualnumInStock,
				purchasePrice, price, lastPurchasePrice, lastPrice, gc,
				manufactoryDate, minNumInStock);
		if (oldPO.getPurchasePrice() != po.getPurchasePrice()) {
			StockManage manage = new StockManage();
			Goods good = new Goods(oldPO.getGoodsID(), oldPO.getName(),
					oldPO.getSize(), oldPO.getGoodsClassName(),
					oldPO.getNumInStock(), oldPO.getPurchasePrice(),
					oldPO.getPrice(), oldPO.getLastPurchasePrice(),
					oldPO.getLastPrice(), oldPO.getManufactureDate(),
					oldPO.getMinNumInStock());
			Goods newGood = new Goods(po.getGoodsID(), po.getName(),
					po.getSize(), po.getGoodsClassName(), po.getNumInStock(),
					po.getPurchasePrice(), po.getPrice(),
					po.getLastPurchasePrice(), po.getLastPrice(),
					po.getManufactureDate(), po.getMinNumInStock());
			manage.changePrime(good, newGood);
		}
		return service.modifyGoods(po);
	}

	public ArrayList<GoodsVO> findGoods(String message) {
		ArrayList<GoodsVO> result = new ArrayList<GoodsVO>();
		if (message != null) {
			ArrayList<GoodsPO> list = service.findGoods(message);
			for (int i = 0; i < list.size(); i++) {
				GoodsPO po = list.get(i);
				GoodsVO vo = new GoodsVO(po.getGoodsID(), po.getName(),
						po.getSize(), po.getNumInStock(),
						po.getPurchasePrice(), po.getPrice(),
						po.getLastPurchasePrice(), po.getPrice(),
						po.getGoodsClassName(), po.getManufactureDate(),
						po.getMinNumInStock());
				result.add(vo);
			}
		}
		return result;
	}

	public GoodsVO findByID(String id) throws RemoteException {
		GoodsPO po = service.findByID(id);
		GoodsVO vo = null;
		if (po != null) {
			vo = new GoodsVO(po.getGoodsID(), po.getName(), po.getSize(),
					po.getNumInStock(), po.getPurchasePrice(), po.getPrice(),
					po.getLastPurchasePrice(), po.getLastPrice(),
					po.getGoodsClassName(), po.getManufactureDate(),
					po.getMinNumInStock());
		}
		return vo;
	}

	public ArrayList<GoodsVO> showGoods() {
		ArrayList<GoodsPO> list = service.showGoods();
		ArrayList<GoodsVO> result = new ArrayList<GoodsVO>();
		for (int i = 0; i < list.size(); i++) {
			GoodsPO po = list.get(i);
			GoodsVO vo = new GoodsVO(po.getGoodsID(), po.getName(),
					po.getSize(), po.getNumInStock(), po.getPurchasePrice(),
					po.getPrice(), po.getLastPurchasePrice(),
					po.getLastPrice(), po.getGoodsClassName(),
					po.getManufactureDate(), po.getMinNumInStock());
			result.add(vo);
		}
		return result;
	}

	public ArrayList<GoodsVO> showGoodsByClass(String className) {
		ArrayList<GoodsVO> result = new ArrayList<GoodsVO>();
		ArrayList<GoodsVO> list = showGoods();
		StockGoodsClassBLService controller = new GoodsClassController();

		for (int i = 0; i < list.size(); i++) {
			GoodsVO vo = list.get(i);
			String cn = vo.getGoodsClass();
			while (!cn.equals("灯具")) {
				if (cn.equals(className)) {
					result.add(vo);
				}
				cn = controller.showGoodsClassInfo(cn).getUpClassName();

			}
		}

		return result;
	}

	public String getMaxID() {
		return service.getMaxID();
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

	public String getManufactoryDate() {
		return manufactoryDate;
	}

	public void setManufactoryDate(String manufactoryDate) {
		this.manufactoryDate = manufactoryDate;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

}
