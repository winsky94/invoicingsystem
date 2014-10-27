import java.util.ArrayList;
import java.util.Date;

//½ø»õµ¥VO
public class PurchaseVO extends ReceiptVO {
	ArrayList<CommodityList> purchaseList;
	double totalInAll;
	public PurchaseVO(ArrayList<CommodityList> purchaseList, String id,
			MemberVO member, UserVO user,Date createDate,
			int status, String info, String stockid,double totalInAll) {
		super(id, member, user,ReceiptType.PURCHASE, createDate, status, info, stockid);
		this.purchaseList = purchaseList;
		this.totalInAll=totalInAll;
	}

	public ArrayList<CommodityList> getPurchaseList() {
		return purchaseList;
	}
	
}
