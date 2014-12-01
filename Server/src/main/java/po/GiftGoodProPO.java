package po;
/*
 * 商品赠送促销
 */
import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;

public class GiftGoodProPO extends PromotionPO{
	private ArrayList<GoodsPO> giftList;
	private double totalValue;
	public GiftGoodProPO(Date startDate,Date endDate,MemberLevel l,MemberType mt,int release,
			ArrayList<GoodsPO> list,double value)
	{
		super(startDate,endDate,PromotionType.GIFTGOODS,l,mt,release);
		this.giftList=list;
		this.totalValue=value;
		
	}
	public ArrayList<GoodsPO> getGiftList() {
		return giftList;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setGiftList(ArrayList<GoodsPO> giftList) {
		this.giftList = giftList;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	
}
