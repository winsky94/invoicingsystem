package vo;

import java.util.ArrayList;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PackPO;
import po.PromotionPO.PromotionType;



public class PackProVO extends PromotionVO{
	private ArrayList<PackVO> packList;
	private double totalValue;
	private double packValue;

	public PackProVO(String id,String startDate,String endDate,MemberLevel l,MemberType mt,
			 ArrayList<PackVO> pack,double value,double pvalue)
	{
		super(id,startDate,endDate,PromotionType.PACK,l,mt);
		packList=pack;
		totalValue=value;
		this.packValue=pvalue;
	}
	public ArrayList<PackVO> getPackList() {
		return packList;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public double getPackValue() {
		return packValue;
	}
	
	
}
