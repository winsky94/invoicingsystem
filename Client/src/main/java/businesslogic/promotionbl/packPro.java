package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import businesslogic.stockbl.goods.Goods;

//特价包促销
public class packPro extends promotion{
	private ArrayList<pack> packList;
	private double totalValue;

	public packPro(Date startDate,Date endDate,MemberLevel l,MemberType mt)
	{
		super(startDate,endDate,PromotionType.PACK,l,mt);
		packList=new ArrayList<pack>();
		totalValue=0;
	}
	
	
	public void addPack(pack pack){
		
	}

}
