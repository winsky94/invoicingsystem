package Finance;

import java.rmi.RemoteException;
import java.text.ParseException;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.promotionbl.MockCoupon;
import businesslogic.salesbl.CommodityList;
import businesslogic.salesbl.MockPurchaseReturnList;
import businesslogic.salesbl.MockSale;
import businesslogic.salesbl.MockSaleItem;
import businesslogic.salesbl.MockSaleList;
import businesslogic.stockbl.GiftReceipt;
import businesslogic.stockbl.MockGoods;
import businesslogic.stockbl.MockStockControl;
import businesslogic.stockbl.StockOverOrLowReceipt;

public class BSLTest extends TestCase {
	private double salesIncome;
	private double goodsOverIncome;
	private double primeCostIncome;
	private double importReturnIncome;
	private double couponIncome;
	private double totalIncome;

	private double salesPrimeCost;
	private double goodsLowCost;
	private double goodsGiftCost;
	private double totalExpense;

	private double profit;

	private MockSale sale1,sale2;
	private MockSaleItem item1,item2;
	private MockGoods good, good1, good2, good3;
	private MockCoupon coupon;
	private StockOverOrLowReceipt stockOver;
	private MockStockControl stockControl;
	private CommodityList list;
	private StockOverOrLowReceipt stockLow;
	private MockMember member;
	private GiftReceipt gift;
	private MockSaleList saleList1,saleList2;
	private MockPurchaseReturnList purchaseReturnList;
	public void setUp() throws ParseException {
		good = new MockGoods("01010001", "飞利浦日光灯", "SR01", 10, 100, 200);
		good1 = new MockGoods("01010001", "飞利浦日光灯", "SR02", 10, 100, 200);
		good2 = new MockGoods("01010001", "飞利浦日光灯", "SR02", 10, 85, 200);
		sale1 = new MockSale("00001");
		sale2 = new MockSale("00002");
		stockOver = new StockOverOrLowReceipt("飞利浦日光灯", "SR01", 100, 90);
		stockControl = new MockStockControl();
		list = new CommodityList();
		coupon = new MockCoupon("20141015-0001", 1000);
		member = new MockMember("01100", MemberType.XSS, MemberLevel.ONE,
				"Jim", 10000);
		gift = new GiftReceipt(member);
		good3 = new MockGoods("01010001", "飞利浦日光灯", "SR03", 10, 100, 200);
		saleList1=new MockSaleList();
		saleList2=new MockSaleList();
		purchaseReturnList=new MockPurchaseReturnList();
	}

	public void testBSL() throws RemoteException {
		// 销售收入，两个销售单
		item1 = new MockSaleItem(good, 1);
		sale1.AddGoods(item1);
		saleList1.AddSale(sale1);
		item2 = new MockSaleItem(good, 1);
		sale2.AddGoods(item2);
		saleList1.AddSale(sale2);
		salesIncome = saleList1.getSaleInCome();
		assertEquals(400.0, salesIncome);
		// 库存报溢收入
		stockControl.addStockOver(stockOver);
		goodsOverIncome = stockControl.getGoodsOverIncome();
		assertEquals(2000.0, goodsOverIncome);
		// 库存成本调价收入
		stockControl.changePrime(good1, good2);
		primeCostIncome = stockControl.getPrimeCostIncome();
		assertEquals(150.0, primeCostIncome);
		// 进货退货收入
		list.add("01010001", "飞利浦日光灯", "SR02", 10, 85, null);
//		PurchaseReturn purchaseReturn = new PurchaseReturn(list);
		
		importReturnIncome = purchaseReturnList.getTotalValue();
		assertEquals(850.0, importReturnIncome);
		// 代金券与实际收款差额收入
		sale1.useCoupon(coupon);
		saleList2.AddSale(sale1);
		couponIncome = saleList2.getCouponIncome();
		assertEquals(600.0, couponIncome);
		// 总收入
		totalIncome = salesIncome + goodsOverIncome + primeCostIncome
				+ importReturnIncome + couponIncome;
		assertEquals(4000.0, totalIncome);

		// 销售成本支出
		salesPrimeCost = saleList1.getSalesPrimeCost();
		assertEquals(200.0, salesPrimeCost);
		// 库存报损支出
		stockLow = new StockOverOrLowReceipt("飞利浦日光灯", "SR01", 95, 100);
		stockControl.addStockLow(stockLow);
		goodsLowCost = stockControl.getGoodsLowCost();
		// 库存赠送支出
		gift.addGood(good3);
		stockControl.addGift(gift);
		goodsGiftCost = stockControl.getGiftCost();
		// 总支出
		totalExpense = salesPrimeCost + goodsLowCost + goodsGiftCost;
		// 盈利
		profit = totalIncome - totalExpense;

		assertEquals(1000.0, goodsLowCost);
		assertEquals(200.0, goodsGiftCost);
		assertEquals(1400.0, totalExpense);

		assertEquals(2600.0, profit);
	}
}
