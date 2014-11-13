package vo;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;

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
			String user, ReceiptType type, String info, String stockid) {

		// SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		// String timeNow = df.format(new Date());

		this.goodsName = goodsName;
		this.goodsID = goodsID;
		this.goodsSize = goodsSize;
		this.goodsPrice = goodsPrice;
		this.memberID = memberID;
		this.num = num;
		this.user = user;
		this.type = type;
		this.createDate = new Date();
		this.status = 0;
		this.info = info;
		this.stockid = id;
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
