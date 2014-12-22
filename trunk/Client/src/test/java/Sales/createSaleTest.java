package Sales;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.ReceiptPO.ReceiptType;
import vo.CommodityVO;
import vo.SaleVO;
import junit.framework.TestCase;
import businesslogic.memberbl.MockMember;
import businesslogic.promotionbl.MockCoupon;
import businesslogic.promotionbl.MockPromotion;
import businesslogic.promotionbl.giftCouponPro;
import businesslogic.promotionbl.promotionController;
import businesslogic.receiptbl.Review;
import businesslogic.salesbl.MockCommodity;
import businesslogic.salesbl.MockSaleItem;
import businesslogic.salesbl.Sale;
import businesslogic.salesbl.SalesController;
import businesslogic.stockbl.goods.MockGoods;
import businesslogic.stockbl.stockManage.MockStockControl;
import businesslogicservice.salesblservice.SalesBLService;

/*
 * 进行一次销售单创建  添加商品(检测库存是否足够)  
 * 用户使用了代金券，用户有会员优惠，有促销策略可以适用  递交审批
 * 执行，商品出库，客户应付增加，会员积分增加
 * */
public class createSaleTest extends TestCase {
	private MockGoods good1, good2;
	private MockMember member;
	private SaleVO sale;
	private SalesController control;
	private MockCoupon coupon;
	private MockSaleItem item1,item2;
	private MockPromotion promotion;
	private MockStockControl stock;
	private Date date;
	private Review review;
	private DateFormat form;
	public void setUp() throws Exception {
		form=new SimpleDateFormat("yyyy/mm/dd");
		String s="2014/12/10";
		date=form.parse(s);
		control=new SalesController();
		promotion=new MockPromotion(1000,0.9);
		good1=new MockGoods("01010001","飞利浦日光灯","SR01",100,150,200);
		good2=new MockGoods("02010002","蓝之恋吊灯","TP25",50,1320,2000);
		member=new MockMember("140001",MemberType.XSS,MemberLevel.THREE,"金金灯堂",6000000);
		member.updateToReceive(100);
		coupon=new MockCoupon("20141015-0001",1000);
		review=new Review();
		stock=new MockStockControl();
	}
	
	public void testSales() throws Exception{
		ArrayList<CommodityVO> commodity=new ArrayList<CommodityVO>();
		CommodityVO com=new CommodityVO("0001-SR01-0001","蓝之恋吊灯","SR01",1000,800,1,1000,800
				,"在做测试");
		commodity.add(com);
		double[] total=new double[]{100,120,110,0,110};
		double[] discount=new double[]{0,0,0,0};
		sale=new SaleVO("金金",commodity,"XSD-20141205-00001","马建国","XSS-00001",
				"XS-00001",0,0,"","1","","",total,discount);
		////使用代金券，该代金券不再可使用
		
		giftCouponPro p=new giftCouponPro();
		p.useCoupon(coupon.getID(),true);
		assertEquals(2000.0,sale.getTotalValue());
		assertEquals(true,coupon.GetIsUse());
		
		//会员优惠
		double privilege=control.getPrivilege("XSS-00001");
		double dis[]=sale.getDiscount();
		dis[1]=(sale.getTotalOrigin()-sale.getProDiscount()-sale.getDiscount()[2])*privilege;
		sale.setDiscount(dis);
		assertEquals(1900.0,sale.getTotalValue());
		//促销策略匹配使用
		promotionController pro=new promotionController();
		sale=pro.Match(sale);
		assertEquals(1710.0,sale.getTotalValue());
		//创建销售单
		control.addSale(sale);
		//审批执行
		Review view=new Review();
		view.Approve(sale.getId(), 0);
		//检测库存足够？
		if(stock.isEnough("01010001", 10))
			item1=new MockSaleItem(good1,10);
		if(stock.isEnough("02010002", 1))
			item2=new MockSaleItem(good2,1);
		//计算总值
		assertEquals(4000.0,sale.getTotalValue());
		//修改添加数量
		
		//审批通过
		review.Approve(sale.getId(), 0);
		assertEquals("审批通过",sale.getStatus());
		//执行
		//通过过即执行
		//客户应付增加，会员积分增加 ，商品出库
		assertEquals(1810.0,member.getToReceive());
		assertEquals(15018.1,member.getPoints());
		assertEquals(95,good1.getNumInStock());
		assertEquals(49,good2.getNumInStock());
		
	}
}
