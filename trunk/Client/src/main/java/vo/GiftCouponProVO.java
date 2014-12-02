package vo;

import java.util.ArrayList;


import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;

public class GiftCouponProVO extends PromotionVO{
	private ArrayList<CouponVO> couponList;
	private double totalValue;
	public GiftCouponProVO(String id,String startDate,String endDate,MemberLevel l,MemberType mt,
			ArrayList<CouponVO> coupon,double value)
	{
		super(id,startDate,endDate,PromotionType.GIFTCOUPON,l,mt);
		couponList=coupon;
		totalValue=value;
	}
	public ArrayList<CouponVO> getCouponList() {
		return couponList;
	}
	public double getTotalValue() {
		return totalValue;
	}
}
