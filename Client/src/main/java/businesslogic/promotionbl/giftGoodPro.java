package businesslogic.promotionbl;


import java.util.ArrayList;
import java.util.Date;

import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.stockbl.Goods;
import businesslogic.stockbl.MockGoods;

public class giftGoodPro extends promotion{	
	private ArrayList<Goods> giftList;
	private double totalValue;
	public giftGoodPro(Date startDate,Date endDate,MemberLevel l,MemberType mt)
	{
		super(startDate,endDate,PromotionType.GIFTGOODS,l,mt);
		giftList=new ArrayList<Goods>();
	}
	
	public void AddGoods(Goods good)
	{
		giftList.add(good);
		totalValue+=((MockGoods)good).getPurchasePrice();
		
	}
	
	public void deleteGoods(Goods good)
	{
		giftList.remove(good);
		totalValue-=((MockGoods)good).getPurchasePrice();
	}

	public double getTotalValue() {
		return totalValue;
	}
	
	//是否合适
	public ArrayList<Goods> getgiftList(){
		return giftList;
	}

	
}
