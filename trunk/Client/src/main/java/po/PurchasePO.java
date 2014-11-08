package po;
import java.util.ArrayList;
import java.util.Date;


public class PurchasePO extends ReceiptPO{
	ArrayList<CommodityListPO> purchaseList;
	double totalInAll;
	public PurchasePO(ArrayList<CommodityListPO> purchaseList, String id,
			MemberPO member, UserPO user,Date createDate,
			int status, String info, String stockid,double totalInAll) {
		super(id, member, user,ReceiptType.PURCHASE, createDate, status, info, stockid);
		this.purchaseList = purchaseList;
		this.totalInAll=totalInAll;
	}

	public ArrayList<CommodityListPO> getPurchaseList() {
		return purchaseList;
	}
	
}
