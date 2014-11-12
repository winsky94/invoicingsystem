package vo;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.CommodityList;

public class PurchaseReturnVO extends ReceiptVO {
	private CommodityList purchaseReturnList;
	private double totalInAll;
	public PurchaseReturnVO(String id,String user,PurchaseVO p, Date createDate, int status,
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
