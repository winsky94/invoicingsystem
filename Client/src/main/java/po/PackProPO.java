package po;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;


public class PackProPO extends PromotionPO{
	private ArrayList<PackPO> packList;
	private double totalValue;
	private double packValue;

	public PackProPO(String id,String startDate,String endDate,MemberLevel l,
			 ArrayList<PackPO> pack,double value,double pvalue)
	{
		super(id,startDate,endDate,PromotionType.PACK,l);
		packList=pack;
		totalValue=value;
		this.packValue=pvalue;
	}

	public ArrayList<PackPO> getPackList() {
		return packList;
	}
	
	public void setPackList(ArrayList<PackPO> list){
		this.packList=list;
	}
	
	public void settotalValue(double value)
	{
		this.totalValue=value;
	}

	public double getTotalValue() {
		return totalValue;
	}
	
	public void setPackValue(double value){
		this.packValue=value;
	}
	public double getPackValue() {
		return packValue;
	}
	

	
}
