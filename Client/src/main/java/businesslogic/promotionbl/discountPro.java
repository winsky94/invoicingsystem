package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import businesslogic.stockbl.goods.Goods;

public class discountPro extends promotion{
	private ArrayList<Double> countList;
	private ArrayList<Goods>  goodsList;
	private double totalValue,discountValue;//折后总额；
	
	public discountPro(Date startDate,Date endDate,MemberLevel l,MemberType mt)
	{
		super(startDate,endDate,PromotionType.DISCOUNT,l,mt);
		goodsList=new ArrayList<Goods>();
		countList=new ArrayList<Double>();
		totalValue=0;discountValue=0;
	}
}
