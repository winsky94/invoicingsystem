package Finance;

import java.rmi.RemoteException;
import java.text.ParseException;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.promotionbl.MockCoupon;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.CommodityList;
import businesslogic.salesbl.MockPurchaseReturn;
import businesslogic.salesbl.Sale;
import businesslogic.salesbl.SaleItem;
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

	private Sale sale;
	private SaleItem item;
	private MockGoods good, good1, good2, good3;
	private MockCoupon coupon;
	private StockOverOrLowReceipt stockOver;
	private MockStockControl stockControl;
	private CommodityList list;
	private StockOverOrLowReceipt stockLow;
	private MockMember member;
	private GiftReceipt gift;

	public void setUp() throws ParseException {
		good = new MockGoods("01010001", "飞利浦日光灯", "SR01", 10, 100, 200);
		good1 = new MockGoods("01010001", "飞利浦日光灯", "SR02", 10, 100, 200);
		good2 = new MockGoods("01010001", "飞利浦日光灯", "SR02", 10, 85, 200);
		sale = new Sale("00001", "00101", "10001", ReceiptType.SALE, null, 0,
				3, null, "00100", null);
		stockOver = new StockOverOrLowReceipt("飞利浦日光灯", "SR01", 100, 90);
		stockControl = new MockStockControl();
		list = new CommodityList();
		coupon = new MockCoupon("20141015-0001", 1000);
		member = new MockMember("01100", MemberType.XSS, MemberLevel.ONE,
				"Jim", 10000);
		gift = new GiftReceipt(member);
		good3 = new MockGoods("01010001", "飞利浦日光灯", "SR03", 10, 100, 200);
	}

	public void testBSL() throws RemoteException {
		// 销售收入，销售两件good商品
		item = new SaleItem(good, 2);
		sale.AddGoods(item);
		salesIncome = sale.getTotalValue();
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
		MockPurchaseReturn purchaseReturn = new MockPurchaseReturn(list);
		importReturnIncome = purchaseReturn.getTotal();
		assertEquals(850.0, importReturnIncome);
		// 代金券与实际收款差额收入
		sale.useCoupon(coupon);
		couponIncome = sale.getCouponIncome();
		assertEquals(600.0, couponIncome);
		// 总收入
		totalIncome = salesIncome + goodsOverIncome + primeCostIncome
				+ importReturnIncome + couponIncome;
		assertEquals(4000.0, totalIncome);

		// 销售成本支出
		salesPrimeCost = sale.getTotalPurchaseValue();
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
