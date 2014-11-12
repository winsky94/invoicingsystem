package businesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

public class Purchase {
	CommodityList purchaseList;
	String memberName;
	String memberID;
	String user;
	Date createDate;
	int status,hurry;
	String id,info,stockid;
	double totalInAll;
	//---------------------------------------------
	public Purchase(CommodityList purchaseList, String id,
			String memberName,String memberID,String user,Date createDate,
			int status, int hurry,String info, String stockid){
		this.id = id;
		this.memberName = memberName;
		this.memberID=memberID;
		this.user = user;
		this.createDate = createDate;
		this.status = status;
		this.hurry=hurry;
		this.info = info;
		this.stockid = stockid;
		this.purchaseList = purchaseList;
	}
	public int createPurchase(){
		return 0;
	}
	
	
}
