package po;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;


public class PackProPO extends PromotionPO{
	private ArrayList<PackPO> packList;
	private double totalValue;

	public PackProPO(Date startDate,Date endDate,MemberLevel l,MemberType mt,int release,
			 ArrayList<PackPO> pack,double value)
	{
		super(startDate,endDate,PromotionType.PACK,l,mt,release);
		packList=pack;
		totalValue=value;
	}

	public ArrayList<PackPO> getPackList() {
		return packList;
	}

	public double getTotalValue() {
		return totalValue;
	}

}
