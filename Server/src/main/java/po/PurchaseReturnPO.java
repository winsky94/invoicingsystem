package po;
import java.util.Date;

import Data.receiptdata.ReceiptType;
import Data.salesdata.CommodityList;


public class PurchaseReturnPO extends ReceiptPO{
	CommodityList purchaseReturnList;
	double totalInAll;
	public PurchaseReturnPO(String id,UserPO user,PurchasePO p, Date createDate, int status,
			String info,int hurry) {
		super(id, p.member, user, ReceiptType.PURCHASERETURN, createDate,
				status,hurry, info, p.stockid);
		this.purchaseReturnList=p.purchaseList;
		this.totalInAll=p.totalInAll;
	}

	public CommodityList getPurchaseReturnList() {
		return purchaseReturnList;
	}
	
}
