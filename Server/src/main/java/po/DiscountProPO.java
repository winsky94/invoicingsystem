package po;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;

public class DiscountProPO extends PromotionPO{
	private ArrayList<Double> countList;
	private ArrayList<GoodsPO>  goodsList;
	private double totalValue,discountValue;//折后总额；
	
	public DiscountProPO(Date startDate,Date endDate,MemberLevel l,MemberType mt,int release,
			ArrayList<Double> count,
			ArrayList<GoodsPO>  goods,double total,double discount)
	{
		super(startDate,endDate,PromotionType.DISCOUNT,l,mt,release);
		goodsList=goods;
		countList=count;
		totalValue=total;discountValue=discount;
	}

	public ArrayList<Double> getCountList() {
		return countList;
	}

	public ArrayList<GoodsPO> getGoodsList() {
		return goodsList;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public double getDiscountValue() {
		return discountValue;
	}
}
