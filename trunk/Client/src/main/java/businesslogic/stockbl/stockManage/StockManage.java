package businesslogic.stockbl.stockManage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import po.GiftPO;
import po.GoodsPO;
import po.PurchasePO;
import po.SalePO;
import po.StockOverOrLowPO;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.stockbl.goods.Goods;
import dataservice.salesdataservice.SalesDataService;
import dataservice.stockdataservice.controldataservice.StockControlDataService;
import dataservice.stockdataservice.giftdataservice.GiftDataService;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService;

public class StockManage {
	private double goodsOverIncome;
	private double primeCostIncome;
	private double goodsLowCost;
	private double giftCost;
	private StockControlDataService service;
	private StockGoodsDataService goodsService;
	private GiftDataService giftService;
	private SalesDataService saleService;
	private String host;
	private String url;
	private String url2;
	private String url3;
	private String url4;

	public StockManage() {
		host = "localhost:1099";
		url = "rmi://" + host + "/stockManageService";
		url2 = "rmi://" + host + "/goodsService";
		url3 = "rmi://" + host + "/giftService";
		url4 = "rmi://" + host + "/saleService";
		try {
			service = (StockControlDataService) Naming.lookup(url);
			goodsService = (StockGoodsDataService) Naming.lookup(url2);
			giftService = (GiftDataService) Naming.lookup(url3);
			saleService = (SalesDataService) Naming.lookup(url4);
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

	// 库存查看
	public ArrayList<String> showStock(String beginDate, String endDate) {
		ArrayList<String> result = new ArrayList<String>();
		// 出库
		String out = getOutRecord(beginDate, endDate);
		result.add(out);

		// 入库
		String in = getInRecord(beginDate, endDate);
		result.add(in);

		// 销售
		String sale = getSaleRecord(beginDate, endDate);
		result.add(sale);

		// 进货
		String purchase = getPurchaseRecord(beginDate, endDate);
		result.add(purchase);

		return result;
	}

	// 出库数量及金额记录
	private String getOutRecord(String beginDate, String endDate) {
		// 销售出库
		int sNum = 0;// 出库数量
		double sMoney = 0;// 出库金额
		ArrayList<SalePO> sl = saleService.showSale();
		for (int i = 0; i < sl.size(); i++) {
			ArrayList<CommodityPO> purchaseList = sl.get(i).getSalesList();
			for (int j = 0; j < purchaseList.size(); j++) {
				sNum += purchaseList.get(j).getNum();
				sMoney += purchaseList.get(j).getTotal();
			}
		}
		// 库存赠送出库
		int gNum = 0;
		double gMoney = 0;
		ArrayList<GiftPO> gl = giftService.getGiftList(beginDate, endDate);
		for (int i = 0; i < gl.size(); i++) {
			gNum += gl.get(i).getNum();
			gMoney += (gl.get(i).getGoods().getPrice() * gl.get(i).getNum());
		}

		// 库存报损
		// 报溢报损好像不算入库出库
		int lNum = 0;
		double lMoney = 0;
		// ArrayList<StockOverOrLowPO> ll = service.getStockOverOrLowPO();
		// for (int i = 0; i < ll.size(); i++) {
		// if (ll.get(i).getType().equals(ReceiptType.STOCKLOW)) {
		// lNum += (0 - ll.get(i).getGap());//报损单的gap是负值
		// String n = ll.get(i).getGoodsName();
		// GoodsPO po = goodsService.findGoods(n).get(0);
		// lMoney += (po.getPrice() * (0 - ll.get(i).getGap()));
		// }
		// }
		String outNum = String.valueOf(sNum + gNum + lNum);
		String outMoney = String.valueOf(sMoney + gMoney + lMoney);
		String out = "出库;" + outNum + ";" + outMoney + ";";

		return out;
	}

	// 入库数量及金额记录
	private String getInRecord(String beginDate, String endDate) {
		// 进货
		int pNum = 0;
		double pMoney = 0;
		ArrayList<PurchasePO> pl = saleService.showPurchase();
		for (int i = 0; i < pl.size(); i++) {
			ArrayList<CommodityPO> purchaseList = pl.get(i).getPurchaseList();
			for (int j = 0; j < purchaseList.size(); j++) {
				pNum += purchaseList.get(j).getNum();
				pMoney += purchaseList.get(j).getTotal();
			}
		}

		// 库存报溢
		// 报溢报损好像不算入库出库
		int oNum = 0;
		double oMoney = 0;
		// ArrayList<StockOverOrLowPO> ol = service.getStockOverOrLowPO();
		// for (int i = 0; i < ol.size(); i++) {
		// if (ol.get(i).getType().equals(ReceiptType.STOCKOVER)) {
		// oNum += ol.get(i).getGap();
		// String n = ol.get(i).getGoodsName();
		// GoodsPO po = goodsService.findGoods(n).get(0);
		// oMoney += (po.getPrice() * ol.get(i).getGap());
		// }
		// }

		String inNum = String.valueOf(pNum + oNum);
		String inMoney = String.valueOf(pMoney + oMoney);
		String in = "入库;" + inNum + ";" + inMoney;

		return in;
	}

	// 销售数量及金额记录
	private String getSaleRecord(String beginDate, String endDate) {
		// 销售
		int sNum = 0;// 销售数量
		double sMoney = 0;// 销售金额
		ArrayList<SalePO> sl = saleService.showSale();
		for (int i = 0; i < sl.size(); i++) {
			ArrayList<CommodityPO> purchaseList = sl.get(i).getSalesList();
			for (int j = 0; j < purchaseList.size(); j++) {
				sNum += purchaseList.get(j).getNum();
				sMoney += purchaseList.get(j).getTotal();
			}
		}

		String num = String.valueOf(sNum);
		String money = String.valueOf(sMoney);
		String sale = "销售;" + num + ";" + money;

		return sale;
	}

	// 进货数量及金额记录
	private String getPurchaseRecord(String beginDate, String endDate) {
		// 进货
		int pNum = 0;
		double pMoney = 0;
		ArrayList<PurchasePO> pl = saleService.showPurchase();
		for (int i = 0; i < pl.size(); i++) {
			ArrayList<CommodityPO> purchaseList = pl.get(i).getPurchaseList();
			for (int j = 0; j < purchaseList.size(); j++) {
				pNum += purchaseList.get(j).getNum();
				pMoney += purchaseList.get(j).getTotal();
			}
		}

		String num = String.valueOf(pNum);
		String money = String.valueOf(pMoney);
		String purchase = "进货;" + num + ";" + money;

		return purchase;
	}

	// 库存调价(未完成==)
	public int changePrime(Goods good, Goods newGood) {
		primeCostIncome += (good.getPurchasePrice() - newGood
				.getPurchasePrice()) * newGood.getNumInStock();
		return 0;
	}

	// 检查库存是否充足满足销售需求
	public boolean isEnough(String id, int num) {
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
		goodsOverIncome = 0;
		ArrayList<StockOverOrLowPO> list = service.getStockOverOrLowPO();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getType().equals(ReceiptType.STOCKOVER)) {
				String n = list.get(i).getGoodsName();
				GoodsPO po = goodsService.findGoods(n).get(0);
				goodsOverIncome += (po.getPrice() * list.get(i).getGap());
			}
		}
		return goodsOverIncome;
	}

	// 获得库存报损支出
	public double getGoodsLowCost() {
		goodsLowCost = 0;
		ArrayList<StockOverOrLowPO> list = service.getStockOverOrLowPO();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getType().equals(ReceiptType.STOCKLOW)) {
				String n = list.get(i).getGoodsName();
				GoodsPO po = goodsService.findGoods(n).get(0);
				goodsLowCost += (po.getPrice() * (0 - list.get(i).getGap()));
			}
		}
		return goodsLowCost;
	}

	// 获得商品赠送支出
	public double getGiftCost() {
		giftCost = 0;
		try {
			ArrayList<GiftPO> list = giftService.getGiftList();
			for (int i = 0; i < list.size(); i++) {
				giftCost += (list.get(i).getGoods().getPrice() * list.get(i)
						.getNum());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return giftCost;
	}
}
