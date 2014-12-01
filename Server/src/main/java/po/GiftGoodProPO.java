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
	public GiftGoodProPO(String id,String startDate,String endDate,MemberLevel l,MemberType mt,
			ArrayList<GoodsPO> list,double value)
	{
		super(id,startDate,endDate,PromotionType.GIFTGOODS,l,mt);
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
