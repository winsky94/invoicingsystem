package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.CommodityList;


public class PurchaseVO extends ReceiptVO {
	ArrayList<CommodityList> purchaseList;
	double totalInAll;
	public PurchaseVO(ArrayList<CommodityList> purchaseList, String id,
			String memberName,String memberID, String user,Date createDate,
			int status, int hurry,String info, String stockid,double totalInAll) {
		super(id, memberName,memberID, user,ReceiptType.PURCHASE, createDate, status,hurry,info, stockid);
		this.purchaseList = purchaseList;
		this.totalInAll=totalInAll;
	}

	public ArrayList<CommodityList> getPurchaseList() {
		return purchaseList;
	}
	
}
