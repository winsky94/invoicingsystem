package po;

/*
 * 特价包促销
 */
import java.io.Serializable;
import java.util.ArrayList;

import po.MemberPO.MemberLevel;


public class PackProPO extends PromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PackPO> packList;
	private double totalValue;
	private double packValue;

	public PackProPO(String id,String startDate,String endDate,MemberLevel l,
			 ArrayList<PackPO> pack,double value,double packv)
	{
		super(id,startDate,endDate,PromotionType.PACK,l);
		packList=pack;
		totalValue=value;
		packValue=packv;
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
	
	public double getPackValue(){
		return packValue;
	}
	
	public void setPackValue(double value){
		this.packValue=value;
	}

}
