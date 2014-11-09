package businesslogic.promotionbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.stockbl.Goods;

public class giftGoodPro extends promotion{	
	private ArrayList<Goods> GoodsList;
	private double totalValue;
	public giftGoodPro(Date t1,Date t2,MemberLevel l,MemberType mt)
	{
		super(t1,t2,PromotionType.GIFTGOODS,l,mt);
		GoodsList=new ArrayList<Goods>();
	}
	
	public void AddGoods(Goods good)
	{
		GoodsList.add(good);
		totalValue+=good.getPrice();
		
	}
	
	public void deleteGoods(Goods good)
	{
		GoodsList.remove(good);
		totalValue-=good.getPrice();
	}
}
