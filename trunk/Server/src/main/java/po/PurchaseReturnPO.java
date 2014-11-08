package po;
import java.util.ArrayList;
import java.util.Date;

import Data.receiptdata.ReceiptType;


public class PurchaseReturnPO extends ReceiptPO{
	ArrayList<CommodityListPO> purchaseReturnList;
	double totalInAll;
	public PurchaseReturnPO(String id,UserPO user,PurchasePO p, Date createDate, int status,
			String info,int hurry) {
		super(id, p.member, user, ReceiptType.PURCHASERETURN, createDate,
				status,hurry, info, p.stockid);
		this.purchaseReturnList=p.purchaseList;
		this.totalInAll=p.totalInAll;
	}

	public ArrayList<CommodityListPO> getPurchaseReturnList() {
		return purchaseReturnList;
	}
	
}
