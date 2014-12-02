package po;

/*
 * 商品赠送促销
 */
import java.io.Serializable;
import java.util.ArrayList;

import po.MemberPO.MemberLevel;

public class GiftGoodProPO extends PromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<GoodsPO> giftList;
	private double totalValue;
	public GiftGoodProPO(String id,String startDate,String endDate,MemberLevel l,
			ArrayList<GoodsPO> list,double value)
	{
		super(id,startDate,endDate,PromotionType.GIFTGOODS,l);
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
