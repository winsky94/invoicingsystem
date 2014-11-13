package businesslogic.promotionbl;

import businesslogic.salesbl.Sale;
import vo.GoodsVO;
import vo.couponVO;

public class MockPromotion extends promotion{
	private double minsMoney;
	private double discount;
	
	
	//折扣促销
	public MockPromotion(double money,double discount){
		this.minsMoney=money;
		this.discount=discount;
	}
	
	public promotion Match(Sale sale){
		if(sa)
		
	}
	
	public double getminsMoney(){
		return minsMoney;
	}
	
	public double getdiscount(){
		return discount;
	}

	public GoodsVO getGoods() {
		return goods;
	}
	public couponVO getCoupon() {
		return coupon;
	}

	
	
	
	
}
