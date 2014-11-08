package businesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.memberbl.Member;
import businesslogic.stockbl.User;

public class Purchase {
	ArrayList<CommodityList> purchaseList;
	Member member; 
	User user;
	Date createDate;
	int status,hurry;
	String id,info,stockid;
	double totalInAll;
	//---------------------------------------------
	public Purchase(ArrayList<CommodityList> purchaseList, String id,
			Member member, User user,Date createDate,
			int status, int hurry,String info, String stockid){
		this.id = id;
		this.member = member;
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
