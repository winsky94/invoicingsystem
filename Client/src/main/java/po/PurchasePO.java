package po;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.Commodity;





public class PurchasePO extends ReceiptPO{
	private ArrayList<CommodityPO> purchaseList;
	private double totalInAll;
	public PurchasePO(ArrayList<CommodityPO> purchaseList, String id,
			String memberName,String memberID, String user,
			int status, int hurry,String info, String stockid,double totalInAll) {
		super(id, memberName,memberID, user,ReceiptType.PURCHASE, status, hurry, info, stockid);
		this.purchaseList = purchaseList;
		this.totalInAll=totalInAll;
	}
	public ArrayList<CommodityPO> getPurchaseList() {
		return purchaseList;
	}
	public double getTotalInAll() {
		return totalInAll;
	}
	public void setPurchaseList(ArrayList<CommodityPO> purchaseList) {
		this.purchaseList = purchaseList;
	}
	public void setTotalInAll(double totalInAll) {
		this.totalInAll = totalInAll;
	}
	
	
}
