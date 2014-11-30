package po;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;


public class PackProPO extends PromotionPO{
	private ArrayList<PackPO> packList;
	private double totalValue;
	private double packValue;

	public PackProPO(Date startDate,Date endDate,MemberLevel l,MemberType mt,int release,
			 ArrayList<PackPO> pack,double value,double pvalue)
	{
		super(startDate,endDate,PromotionType.PACK,l,mt,release);
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
	
	public void totalValue(double value)
	{
		this.totalValue=value;
	}

	public double getTotalValue() {
		return totalValue;
	}
	
	public void setPackValue(double value){
		this.packValue=value;
	}

	
}
