package po;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.CommodityList;


public class PurchaseReturnPO extends ReceiptPO{
	CommodityList purchaseReturnList;
	double totalInAll;
	public PurchaseReturnPO(String id,String user,PurchasePO p, Date createDate, int status,
			String info,int hurry) {
		super(id, p.getMemberName(),p.getMemberID(), user, ReceiptType.PURCHASERETURN, createDate,
				status,hurry, info, p.getStockid());
		this.purchaseReturnList=p.getPurchaseList();
		this.totalInAll=p.getTotalInAll();
	}
	public CommodityList getPurchaseReturnList() {
		return purchaseReturnList;
	}
	public double getTotalInAll() {
		return totalInAll;
	}

}
