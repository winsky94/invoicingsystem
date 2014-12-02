package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;



public class PurchaseVO extends ReceiptVO {
	private ArrayList<CommodityVO> purchaseList;
	private double totalInAll;
	private String stockid;
	public PurchaseVO(ArrayList<CommodityVO> purchaseList, String id,
			String memberName,String memberID, String user,Date createDate,
			int status, int hurry,String info, String stockid,double totalInAll) {
		super(id, memberName,memberID, user,ReceiptType.PURCHASE, createDate, status,hurry,info);
		this.purchaseList = purchaseList;
		this.totalInAll=totalInAll;
		this.stockid=stockid;
	}

	public ArrayList<CommodityVO> getPurchaseList() {
		return purchaseList;
	}

	public double getTotalInAll() {
		return totalInAll;
	}
	public String getStockid() {
		return stockid;
	}
	
	public void setPurchaseList(ArrayList<CommodityVO> list){
		this.purchaseList=list;
	}
	public void setTotalValue(double value){
		this.totalInAll=value;
	}
	
}
