package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.Commodity;



public class PurchaseVO extends ReceiptVO {
	private ArrayList<Commodity> purchaseList;
	private double totalInAll;
	public PurchaseVO(ArrayList<Commodity> purchaseList, String id,
			String memberName,String memberID, String user,Date createDate,
			int status, int hurry,String info, String stockid,double totalInAll) {
		super(id, memberName,memberID, user,ReceiptType.PURCHASE, createDate, status,hurry,info, stockid);
		this.purchaseList = purchaseList;
		this.totalInAll=totalInAll;
	}

	public ArrayList<Commodity> getPurchaseList() {
		return purchaseList;
	}

	public double getTotalInAll() {
		return totalInAll;
	}
	
	public void setPurchaseList(ArrayList<Commodity> list){
		this.purchaseList=list;
	}
	public void setTotalValue(double value){
		this.totalInAll=value;
	}
	
}
