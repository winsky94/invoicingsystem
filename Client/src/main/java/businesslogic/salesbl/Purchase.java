package businesslogic.salesbl;

import java.util.Date;

import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;

public class Purchase extends Receipt {
	CommodityList list;

	public Purchase() {
		// TODO 自动生成的构造函数存根
	}

	public Purchase(String id, String memberID, String userID,
			ReceiptType type, Date date, int hurry, int status, String info,
			String sid) {
		super(id, memberID, userID, type, date, hurry, status, info, sid);
		// TODO Auto-generated constructor stub
	}

	public Purchase(String id, String memberID, String userID,
			ReceiptType type, Date date, int hurry, int status, String info,
			String sid, CommodityList list) {
		super(id, memberID, userID, type, date, hurry, status, info, sid);
		// TODO 自动生成的构造函数存根
		this.list = list;
	}
}
