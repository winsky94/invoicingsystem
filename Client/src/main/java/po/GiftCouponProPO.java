package po;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import businesslogic.promotionbl.coupon;

public class GiftCouponProPO extends PromotionPO{
	private ArrayList<CouponPO> couponList;
	private double totalValue;
	public GiftCouponProPO(Date startDate,Date endDate,MemberLevel l,MemberType mt,int release,
			ArrayList<CouponPO> coupon,double value)
	{
		super(startDate,endDate,PromotionType.GIFTCOUPON,l,mt,release);
		couponList=coupon;
		totalValue=value;
	}
	public ArrayList<CouponPO> getCouponList() {
		return couponList;
	}
	public double getTotalValue() {
		return totalValue;
	}
	
}
