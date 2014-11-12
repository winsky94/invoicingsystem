package vo;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.CommodityList;

public class PurchaseReturnVO extends ReceiptVO {
	CommodityList purchaseReturnList;
	double totalInAll;
	public PurchaseReturnVO(String id,String user,PurchaseVO p, Date createDate, int status,
			String info,int hurry) {
		super(id, p.memberName,p.memberID, user, ReceiptType.PURCHASERETURN, createDate,
				status,hurry, info, p.stockid);
		this.purchaseReturnList=p.purchaseList;
		this.totalInAll=p.totalInAll;
	}

	public CommodityList getPurchaseReturnList() {
		return purchaseReturnList;
	}
	
}
