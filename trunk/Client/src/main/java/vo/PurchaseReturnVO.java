package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;

public class PurchaseReturnVO extends ReceiptVO {
	ArrayList<CommodityListVO> purchaseReturnList;
	double totalInAll;
	public PurchaseReturnVO(String id,UserVO user,PurchaseVO p, Date createDate, int status,
			String info,int hurry) {
		super(id, p.member, user, ReceiptType.PURCHASERETURN, createDate,
				status,hurry, info, p.stockid);
		this.purchaseReturnList=p.purchaseList;
		this.totalInAll=p.totalInAll;
	}

	public ArrayList<CommodityListVO> getPurchaseReturnList() {
		return purchaseReturnList;
	}
	
}
