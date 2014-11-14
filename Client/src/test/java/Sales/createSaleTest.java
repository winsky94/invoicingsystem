package Sales;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.promotionbl.MockCoupon;
import businesslogic.promotionbl.MockPromotion;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.receiptbl.Review;
import businesslogic.salesbl.CommodityList;
import businesslogic.salesbl.Sale;
import businesslogic.salesbl.SaleItem;
import businesslogic.salesbl.SalesController;
import businesslogic.stockbl.MockGoods;
import businesslogic.stockbl.MockStockControl;
import businesslogicservice.salesblservice.SalesBLService;

/*
 * 进行一次销售单创建  添加商品(检测库存是否足够)  
 * 用户使用了代金券，用户有会员优惠，有促销策略可以适用  递交审批
 * 执行，商品出库，客户应付增加，会员积分增加
 * */
public class createSaleTest extends TestCase {
	private MockGoods good1, good2;
	private MockMember member;
	private Sale sale;
	private MockCoupon coupon;
	private SaleItem item1,item2;
	private MockPromotion promotion;
	private MockStockControl stock;
	private Date date;
	private Review review;
	private DateFormat form;
	public void setUp() throws ParseException {
		form=new SimpleDateFormat("yyyy/mm/dd");
		String s="2014/12/10";
		date=form.parse(s);
		promotion=new MockPromotion(1000,0.9);
		good1=new MockGoods("01010001","飞利浦日光灯","SR01",100,150,200);
		good2=new MockGoods("02010002","蓝之恋吊灯","TP25",50,1320,2000);
		member=new MockMember("140001",MemberType.XSS,MemberLevel.THREE,"金金灯堂",6000000);
		member.updateToReceive(100);
		coupon=new MockCoupon("20141015-0001",1000);
		review=new Review();
		stock=new MockStockControl();
	}
	
	public void testSales(){
		//创建销售单
		sale=new Sale("XSD-20141015-0001","140001","14010001",ReceiptType.SALE,date,0
				    ,0,"","仓库1","王宁宁");
		//检测库存足够？
		if(stock.isEnough("01010001", 10))
			item1=new SaleItem(good1,10);
		if(stock.isEnough("02010002", 1))
			item2=new SaleItem(good2,1);
		//添加商品
		sale.AddGoods(item1);
		sale.AddGoods(item2);
		//计算总值
		assertEquals(4000.0,sale.getTotalValue());
		//修改添加数量
		sale.ModifySaleItem(item1, -5);
		assertEquals(3000.0,sale.getTotalValue());
		//使用代金券，该代金券不再可使用
		sale.useCoupon(coupon);
		assertEquals(2000.0,sale.getTotalValue());
		assertEquals(true,coupon.GetIsUse());
		//会员优惠
		sale.getPrivilege();
		assertEquals(1900.0,sale.getTotalValue());
		//促销策略匹配使用
		sale.MatchProMotion();
		assertEquals(1710.0,sale.getTotalValue());
		//审批通过
		review.Approve(sale, 4);
		assertEquals("审批通过待执行",sale.getStatus());
		//执行
		sale.excute(member);
		//客户应付增加，会员积分增加 ，商品出库
		assertEquals(1810.0,member.getToReceive());
		assertEquals(15018.1,member.getPoints());
		assertEquals(95,good1.getNumInStock());
		assertEquals(49,good2.getNumInStock());
		
	}
}
