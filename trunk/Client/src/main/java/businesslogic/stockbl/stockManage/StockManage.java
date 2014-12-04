package businesslogic.stockbl.stockManage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import po.CommodityPO;
import po.GiftPO;
import po.GoodsPO;
import po.PurchasePO;
import po.ReceiptPO.ReceiptType;
import po.SalePO;
import po.StockOverOrLowPO;
import vo.StockOverOrLowVO;
import businesslogic.stockbl.goods.Goods;
import dataservice.salesdataservice.SalesDataService;
import dataservice.stockdataservice.controldataservice.StockControlDataService;
import dataservice.stockdataservice.giftdataservice.GiftDataService;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService;

public class StockManage {
	private double primeCostIncome = 0;
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
		url4 = "rmi://" + host + "/salesService";
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

	// 显示库存报溢单
	public ArrayList<StockOverOrLowVO> showStockOverReceipt() {
		ArrayList<StockOverOrLowPO> list = new ArrayList<StockOverOrLowPO>();
		ArrayList<StockOverOrLowPO> OverLsit = new ArrayList<StockOverOrLowPO>();
		ArrayList<StockOverOrLowVO> result = new ArrayList<StockOverOrLowVO>();
		list = service.getStockOverOrLowPO();
		for (StockOverOrLowPO po : list) {
			if (po.getType().equals(ReceiptType.STOCKOVER)) {
				OverLsit.add(po);
			}
		}
		result = POToVO(OverLsit);
		return result;
	}

	// 显示库存报损单
	public ArrayList<StockOverOrLowVO> showStockLowReceipt() {
		ArrayList<StockOverOrLowPO> list = new ArrayList<StockOverOrLowPO>();
		ArrayList<StockOverOrLowPO> lowLsit = new ArrayList<StockOverOrLowPO>();
		ArrayList<StockOverOrLowVO> result = new ArrayList<StockOverOrLowVO>();
		list = service.getStockOverOrLowPO();
		for (StockOverOrLowPO po : list) {
			if (po.getType().equals(ReceiptType.STOCKLOW)) {
				lowLsit.add(po);
			}
		}
		result = POToVO(lowLsit);
		return result;
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

	// 库存盘点(库存均价==)
	public ArrayList<ArrayList<String>> checkStock() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		ArrayList<GoodsPO> goodsList = goodsService.showGoods();
		if (goodsList != null) {
			int i = 0;
			for (GoodsPO po : goodsList) {
				ArrayList<String> tp = new ArrayList<String>();
				// 包括当天的各种商品的名称，型号，库存数量，库存均价，批次，[盘点时，相当于设置了一个截止点，这个点就是批次（日期）批号（序号），这是系统根据当前盘点时间产生的。]批号，出厂日期，并且显示行号
				// 行号、商品名称、型号、库存数量、库存均价、批次、批号、出厂日期
				NumberFormat nf = new DecimalFormat("00000");
				String hang = nf.format(i);
				tp.add(hang);// 行号
				tp.add(po.getName());// 名称
				tp.add(po.getSize());// 型号
				tp.add(String.valueOf(po.getNumInStock()));// 库存数量
				tp.add(String.valueOf(po.getPurchasePrice()));// 库存均价
				tp.add(getDate());// 批次
				tp.add(hang);// 批号
				tp.add(po.getManufactureDate());// 出厂日期
				result.add(tp);
				i++;
			}
		}

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
		ArrayList<GiftPO> gl = new ArrayList<GiftPO>();
		try {
			gl = giftService.getGiftList(beginDate, endDate);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for (int i = 0; i < gl.size(); i++) {
			ArrayList<CommodityPO> list = gl.get(i).getGiftList();
			for (int j = 0; j < list.size(); j++) {
				gNum += list.get(j).getNum();
				gMoney += list.get(j).getCost();
			}

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
				pMoney += purchaseList.get(j).getCost();
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
				pMoney += purchaseList.get(j).getCost();
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

	// 获得库存调价收入(未完成==)
	public double getPrimeCostIncome() {

		return primeCostIncome;
	}

	// 获得库存报溢收入
	public double getGoodsOverIncome() {
		double goodsOverIncome = 0;
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
		double goodsLowCost = 0;
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
		double giftCost = 0;
		try {
			ArrayList<GiftPO> list = giftService.getGiftList();
			for (int i = 0; i < list.size(); i++) {
				ArrayList<CommodityPO> commodityList = list.get(i)
						.getGiftList();
				for (int j = 0; j < commodityList.size(); j++) {
					giftCost += commodityList.get(j).getCost();
				}
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return giftCost;
	}

	private ArrayList<StockOverOrLowVO> POToVO(ArrayList<StockOverOrLowPO> list) {
		ArrayList<StockOverOrLowVO> result = new ArrayList<StockOverOrLowVO>();
		for (StockOverOrLowPO po : list) {
			StockOverOrLowVO vo = new StockOverOrLowVO(po.getGoodsName(),
					po.getSize(), po.getNum(), po.getExactNum(),
					po.getUserID(), ReceiptType.STOCKOVER, po.getInfo());
			result.add(vo);
		}
		return result;
	}

	private String getDate() {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		String sysDatetime = fmt.format(rightNow.getTime());

		return sysDatetime;
	}

}
