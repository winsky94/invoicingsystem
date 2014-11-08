package po;
import java.util.ArrayList;
import java.util.Date;


public class PurchaseReturnPO {
	ArrayList<CommodityListPO> purchaseReturnList;
	double totalInAll;
	public PurchaseReturnPO(String id,UserPO user,PurchasePO p, Date createDate, int status,
			String info) {
		super(id, p.member, user, ReceiptType.PURCHASERETURN, createDate,
				status, info, p.stockid);
		this.purchaseReturnList=p.purchaseList;
		this.totalInAll=p.totalInAll;
	}

	public ArrayList<CommodityListPO> getPurchaseReturnList() {
		return purchaseReturnList;
	}
}
