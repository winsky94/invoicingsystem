package po;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.Commodity;

//CommoditList封装数据结构

public class PurchaseReturnPO extends ReceiptPO{
	ArrayList<Commodity> purchaseReturnList;
	double totalInAll;
	public PurchaseReturnPO(String id,String user,PurchasePO p, Date createDate, int status,
			String info,int hurry) {
		super(id, p.getMemberName(),p.getMemberID(), user, ReceiptType.PURCHASERETURN, createDate,
				status,hurry, info, p.getStockid());
		this.purchaseReturnList=p.getPurchaseList();
		this.totalInAll=p.getTotalInAll();
	}
	public ArrayList<Commodity> getPurchaseReturnList() {
		return purchaseReturnList;
	}
	public double getTotalInAll() {
		return totalInAll;
	}

}
