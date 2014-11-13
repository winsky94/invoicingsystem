package Sales;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.promotionbl.MockCoupon;
import businesslogic.promotionbl.MockPromotion;
import businesslogic.salesbl.CommodityList;
import businesslogic.salesbl.SaleItem;
import businesslogic.salesbl.SalesController;
import businesslogic.stockbl.MockGoods;
import businesslogicservice.salesblservice.SalesBLService;

/*
 * 进行一次销售单创建  添加商品(检测库存是否足够)  
 * 用户使用了代金券，有促销策略可以适用  递交审批
 * */
public class createSaleTest extends TestCase {
	private MockGoods good1, good2;
	private MockMember member;
	private CommodityList list;
	private MockCoupon coupon;
	private SaleItem item;
	private MockPromotion promotion;
	public void setUp() {
		promotion=new MockPromotion(1000,0.9);
		
		
	}
	public void testSales(){
		
	}
}
