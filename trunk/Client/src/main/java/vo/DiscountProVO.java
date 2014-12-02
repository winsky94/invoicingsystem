package vo;

import java.util.ArrayList;


import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;

public class DiscountProVO extends PromotionVO{
	private ArrayList<Double> countList;
	private ArrayList<GoodsVO>  goodsList;
	private double totalValue,discountValue;//折后总额；
	
	public DiscountProVO(String id,String startDate,String endDate,MemberLevel l,MemberType mt,
			ArrayList<Double> count,
			ArrayList<GoodsVO>  goods,double total,double discount)
	{
		super(id,startDate,endDate,PromotionType.DISCOUNT,l,mt);
		goodsList=goods;
		countList=count;
		totalValue=total;discountValue=discount;
	}

	public ArrayList<Double> getCountList() {
		return countList;
	}

	public ArrayList<GoodsVO> getGoodsList() {
		return goodsList;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public double getDiscountValue() {
		return discountValue;
	}
	
}
