package vo;

import java.util.ArrayList;

import po.ReceiptPO.ReceiptType;



public class PurchaseReturnVO extends ReceiptVO {
	private ArrayList<CommodityVO> purchaseReturnList;
	private double totalInAll;
	private String stockid;
	private String purid;
	/*public PurchaseReturnVO(String id,String user,PurchaseVO p,  int status,
			String info,int hurry) {
		super(id, p.getMemberName(),p.getMemberID(), user, ReceiptType.PURCHASERETURN,
				status,hurry, info);
		this.purchaseReturnList=p.getPurchaseList();
		this.totalInAll=p.getTotalInAll();
		this.stockid=stockid;
		this.purid=p.getId();
	}*/
	
	public PurchaseReturnVO(String id,String MemName,String MemID,String user, int status,
			String info,int hurry,ArrayList<CommodityVO> list,double total,String sid,String purid) {
		super(id,MemName,MemID, user, ReceiptType.PURCHASERETURN,
				status,hurry, info);
		this.purchaseReturnList=list;
		this.totalInAll=total;
		this.stockid=sid;
		this.purid=purid;
	}
	public String getPurid(){
		return this.purid;
	}
	public String getStockid() {
		return stockid;
	}
	public  ArrayList<CommodityVO> getPurchaseReturnList() {
		return purchaseReturnList;
	}

	public double getTotalInAll() {
		return totalInAll;
	}


	public void setPurchaseReturnList(ArrayList<CommodityVO> purchaseReturnList) {
		this.purchaseReturnList = purchaseReturnList;
	}


	public void setTotalInAll(double totalInAll) {
		this.totalInAll = totalInAll;
	}
	
	
	
}
