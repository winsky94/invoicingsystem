package businesslogic.promotionbl;


import java.util.ArrayList;
import java.util.Date;







import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.MockGoods;

public class giftGoodPro extends promotion{	
	private ArrayList<Goods> giftList;
	private double totalValue;
	
	public void AddGoods(Goods good)
	{
		giftList.add(good);
		totalValue+=((MockGoods)good).getPrice();
		
	}
	
	public void deleteGoods(Goods good)
	{
		giftList.remove(good);
		totalValue-=((MockGoods)good).getPrice();
	}

	public double getTotalValue() {
		return totalValue;
	}
	
	//是否合适
	public ArrayList<Goods> getgiftList(){
		return giftList;
	}

	
}
