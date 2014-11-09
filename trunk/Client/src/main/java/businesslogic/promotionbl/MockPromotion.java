package businesslogic.promotionbl;

import vo.GoodsVO;
import vo.couponVO;

public class MockPromotion extends promotion{
	double minsMoney;
	double discount;
	GoodsVO goods;
	couponVO coupon;
	
	//折扣促销
	public MockPromotion(double money,double discount){
		this.minsMoney=money;
		this.discount=discount;
	}
	
	public MockPromotion(GoodsVO vo){
		this.goods=vo;
	}
	public MockPromotion(couponVO vo){
		this.coupon=vo;
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
