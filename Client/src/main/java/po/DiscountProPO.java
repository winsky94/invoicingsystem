package po;

/*
 * 折让促销
 */
import java.io.Serializable;
import java.util.ArrayList;

import po.MemberPO.MemberLevel;

public class DiscountProPO extends PromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Double> countList;
	private ArrayList<GoodsPO>  goodsList;
	private double totalValue,discountValue;//折后总额；
	
	public DiscountProPO(String id,String startDate,String endDate,MemberLevel l,
			ArrayList<Double> count,
			ArrayList<GoodsPO>  goods,double total,double discount)
	{
		super(id,startDate,endDate,PromotionType.DISCOUNT,l);
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
	
	public void setDiscount(ArrayList<Double> count,
	ArrayList<GoodsPO>  goods){
		this.countList=count;
		this.goodsList=goods;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	
}
