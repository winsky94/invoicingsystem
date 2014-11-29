package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import businesslogic.stockbl.goods.Goods;
//同类型 界面处理 放在同一行
public class giftCouponPro extends promotion{
	private ArrayList<coupon> couponList;
	private double totalValue;
	public giftCouponPro(Date startDate,Date endDate,MemberLevel l,MemberType mt)
	{
		super(startDate,endDate,PromotionType.GIFTCOUPON,l,mt);
		couponList=new ArrayList<coupon>();
		totalValue=0;
	}
	

}
