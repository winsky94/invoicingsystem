package vo;

import java.util.ArrayList;

import po.ReceiptPO.ReceiptType;

public class GiftVO extends ReceiptVO {
	private ArrayList<CommodityVO> giftList;

	public GiftVO(String id, String memberName, String memberID, String user,
			int status, int hurry, String info) {
		super(id, memberName, memberID, user, ReceiptType.GIFT, status, hurry,
				info);
		giftList = new ArrayList<CommodityVO>();
	}

	public ArrayList<CommodityVO> getGiftList() {
		return giftList;
	}
}
