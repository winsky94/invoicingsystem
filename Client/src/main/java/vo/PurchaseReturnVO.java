package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.Commodity;

public class PurchaseReturnVO extends ReceiptVO {
	ArrayList<Commodity> purchaseReturnList;
	double totalInAll;
	public PurchaseReturnVO(String id,String user,PurchaseVO p, Date createDate, int status,
			String info,int hurry) {
		super(id, p.memberName,p.memberID, user, ReceiptType.PURCHASERETURN, createDate,
				status,hurry, info, p.stockid);
		this.purchaseReturnList=p.purchaseList;
		this.totalInAll=p.totalInAll;
	}

	public ArrayList<Commodity> getPurchaseReturnList() {
		return purchaseReturnList;
	}
	
}
