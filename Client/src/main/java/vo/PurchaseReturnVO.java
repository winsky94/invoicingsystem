import java.util.ArrayList;
import java.util.Date;

public class PurchaseReturnVO extends ReceiptVO {
	ArrayList<CommodityList> purchaseReturnList;
	double totalInAll;
	public PurchaseReturnVO(String id,UserVO user,PurchaseVO p, Date createDate, int status,
			String info) {
		super(id, p.member, user, ReceiptType.PURCHASERETURN, createDate,
				status, info, p.stockid);
		this.purchaseReturnList=p.purchaseList;
		this.totalInAll=p.totalInAll;
	}

	public ArrayList<CommodityList> getPurchaseReturnList() {
		return purchaseReturnList;
	}
	
}
