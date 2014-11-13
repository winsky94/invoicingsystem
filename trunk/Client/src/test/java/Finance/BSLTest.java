package Finance;

import java.rmi.RemoteException;
import java.text.ParseException;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.CommodityList;
import businesslogic.salesbl.MockPurchaseReturn;
import businesslogic.salesbl.Sale;
import businesslogic.salesbl.SaleItem;
import businesslogic.stockbl.GiftReceipt;
import businesslogic.stockbl.MockGoods;
import businesslogic.stockbl.MockStockControl;
import businesslogic.stockbl.StockOverOrLowReceipt;

public class BSLTest extends TestCase{
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
	private MockGoods good,good1,good2,good3;
	
	public void setUp() throws ParseException {
		good=new MockGoods("01010001","飞利浦日光灯","SR01",10,100,200);
		good1=new MockGoods("01010001","飞利浦日光灯","SR02",10,100,200);
		good2=new MockGoods("01010001","飞利浦日光灯","SR02",10,85,200);
		item=new SaleItem(good,2);
		sale=new Sale("00001","00101","10001",ReceiptType.SALE,null,0,3,null,"00100",null);
		sale.AddGoods(item);
		salesIncome=sale.getTotalValue();
		
		StockOverOrLowReceipt stockOver=new StockOverOrLowReceipt("飞利浦日光灯","SR01",100,90);
		MockStockControl stockControl=new MockStockControl();
		stockControl.addStockOver(stockOver);
		goodsOverIncome=stockControl.getGoodsOverIncome();
		
		stockControl.changePrime(good1, good2);
		primeCostIncome=stockControl.getPrimeCostIncome();
		
		CommodityList list=new CommodityList();
		list.add("01010001","飞利浦日光灯","SR02",10,85, null);
		MockPurchaseReturn purchaseReturn=new MockPurchaseReturn(list);
		importReturnIncome=purchaseReturn.getTotal();
		
		totalIncome=salesIncome+goodsOverIncome+primeCostIncome+importReturnIncome+couponIncome;
		
		salesPrimeCost=sale.getTotalPurchaseValue();
		StockOverOrLowReceipt stockLow=new StockOverOrLowReceipt("飞利浦日光灯","SR01",95,100);
		stockControl.addStockLow(stockLow);
		goodsLowCost=stockControl.getGoodsLowCost();
		
		MockMember member=new MockMember("01100",MemberType.XSS ,MemberLevel.ONE ,"Jim" ,10000 );
		GiftReceipt gift=new GiftReceipt(member);
		good3=new MockGoods("01010001","飞利浦日光灯","SR03",10,100,200);
		gift.addGood(good3);
		stockControl.addGift(gift);
		goodsGiftCost=stockControl.getGiftCost();
		
		totalExpense=salesPrimeCost+goodsLowCost+goodsGiftCost;
		
		profit=totalIncome-totalExpense;
	}
	
	public void testBSL() throws RemoteException {
		System.out.println(goodsGiftCost);
		
		assertEquals(400.0,salesIncome);
		assertEquals(2000.0,goodsOverIncome);
		assertEquals(150.0,primeCostIncome);
		assertEquals(850.0,importReturnIncome);
		assertEquals(0.0,couponIncome);
		assertEquals(3400.0,totalIncome);
		
		assertEquals(200.0,salesPrimeCost);
		assertEquals(1000.0,goodsLowCost);
		assertEquals(200.0,goodsGiftCost);
		assertEquals(1400.0,totalExpense);
		
		assertEquals(2000.0,profit);
	}
}
