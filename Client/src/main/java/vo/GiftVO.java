package vo;

import po.ReceiptPO.ReceiptType;

public class GiftVO extends ReceiptVO {
	String goodsName;
	String goodsID;
	String goodsSize;
	double goodsPrice;
	int num;

	public GiftVO() {

	}

	public GiftVO(String goodsName, String goodsID, String goodsSize,
			double goodsPrice, String memberID, GoodsVO goods, int num,
			String user, String info, String stockid) {
		this.goodsName = goodsName;
		this.goodsID = goodsID;
		this.goodsSize = goodsSize;
		this.goodsPrice = goodsPrice;
		this.memberID = memberID;
		this.num = num;
		this.user = user;
		this.type = ReceiptType.GIFT;
		this.status = 0;
		this.info = info;

	}

	public String getMemberID() {
		return memberID;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public int getNum() {
		return num;
	}
}
