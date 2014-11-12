package po;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.Commodity;
import businesslogic.salesbl.CommodityList;



public class PurchasePO extends ReceiptPO{
	CommodityList purchaseList;
	double totalInAll;
	public PurchasePO(CommodityList purchaseList, String id,
			MemberPO member, UserPO user,Date createDate,
			int status, int hurry,String info, String stockid,double totalInAll) {
		super(id, member, user,ReceiptType.PURCHASE, createDate, status, hurry, info, stockid);
		this.purchaseList = purchaseList;
		this.totalInAll=totalInAll;
	}

	public CommodityList getPurchaseList() {
		return purchaseList;
	}
	
}
