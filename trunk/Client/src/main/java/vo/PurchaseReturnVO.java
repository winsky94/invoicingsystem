package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.Commodity;


public class PurchaseReturnVO extends ReceiptVO {
	private ArrayList<Commodity> purchaseReturnList;
	private double totalInAll;
	public PurchaseReturnVO(String id,String user,PurchaseVO p, Date createDate, int status,
			String info,int hurry) {
		super(id, p.getMemberName(),p.getMemberID(), user, ReceiptType.PURCHASERETURN, createDate,
				status,hurry, info, p.getStockid());
		this.purchaseReturnList=p.getPurchaseList();
		this.totalInAll=p.getTotalInAll();
	}
	

	public  ArrayList<Commodity> getPurchaseReturnList() {
		return purchaseReturnList;
	}

	public double getTotalInAll() {
		return totalInAll;
	}


	public void setPurchaseReturnList(ArrayList<Commodity> purchaseReturnList) {
		this.purchaseReturnList = purchaseReturnList;
	}


	public void setTotalInAll(double totalInAll) {
		this.totalInAll = totalInAll;
	}
	
	
	
}
