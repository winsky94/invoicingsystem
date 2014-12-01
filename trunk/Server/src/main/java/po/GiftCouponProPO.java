package po;
/*
 * 代金券赠送促销
 */
import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;


public class GiftCouponProPO extends PromotionPO{
	private ArrayList<CouponPO> couponList;
	private double totalValue;
	public GiftCouponProPO(String id,String startDate,String endDate,MemberLevel l,MemberType mt,int release,
			ArrayList<CouponPO> coupon,double value)
	{
		super(id,startDate,endDate,PromotionType.GIFTCOUPON,l,mt,release);
		couponList=coupon;
		totalValue=value;
	}
	public ArrayList<CouponPO> getCouponList() {
		return couponList;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setCouponList(ArrayList<CouponPO> couponList) {
		this.couponList = couponList;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	
}
