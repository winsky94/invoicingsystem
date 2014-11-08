package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;


public class PurchaseVO extends ReceiptVO {
	ArrayList<CommodityListVO> purchaseList;
	double totalInAll;
	public PurchaseVO(ArrayList<CommodityListVO> purchaseList, String id,
			MemberVO member, UserVO user,Date createDate,
			int status, int hurry,String info, String stockid,double totalInAll) {
		super(id, member, user,ReceiptType.PURCHASE, createDate, status,hurry,info, stockid);
		this.purchaseList = purchaseList;
		this.totalInAll=totalInAll;
	}

	public ArrayList<CommodityListVO> getPurchaseList() {
		return purchaseList;
	}
	
}
