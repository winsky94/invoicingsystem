package businesslogic.salesbl;

import java.util.Date;

import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.stockbl.MockGoods;

public class MockPurchase extends Receipt {
	CommodityList list;

	public MockPurchase(String id, String memberID, String userID,
			ReceiptType type, Date date, int hurry, int status, String info,
			String sid, CommodityList list) {
		super(id, memberID, userID, type, date, hurry, status, info, sid);
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	public MockGoods createPurchase() {
		Commodity commodity = list.show().get(0);
		MockGoods good = new MockGoods("00020001", "飞利浦日光灯", "SR01", 20, 200,
				100);
		MockGoods newGood = new MockGoods("00020001", "飞利浦日光灯", "SR01",
				20 + commodity.getNum(), 200, 100);

		good.modifyGoods(newGood);

		return good;
	}

	public double getTotal() {
		return list.show().get(0).getTotalPrice();
	}
}
