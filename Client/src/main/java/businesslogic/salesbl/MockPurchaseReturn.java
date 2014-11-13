package businesslogic.salesbl;

import java.util.Date;

import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.stockbl.MockGoods;

public class MockPurchaseReturn extends Receipt {
	CommodityList list;

	public MockPurchaseReturn(String id, String memberID, String userID,
			ReceiptType type, Date date, int hurry, int status, String info,
			String sid, CommodityList list) {
		super(id, memberID, userID, type, date, hurry, status, info, sid);
		// TODO Auto-generated constructor stub
		this.list = list;
	}
	
	public MockPurchaseReturn(CommodityList list){
		super();
		this.list=list;
	}

	public int createPurchaseReturn() {
		Commodity commodity = list.show().get(0);
		MockGoods good = new MockGoods("00020001", "飞利浦日光灯", "SR01", 20, 200,
				100);

		return 0;
	}

	public double getTotal() {
		return list.show().get(0).getTotalPrice();
	}
}
