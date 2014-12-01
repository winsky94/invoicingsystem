package vo;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;

public class StockErrorVO extends ReceiptVO {
	String goodsName;
	String goodsSize;

	public StockErrorVO(String goodsName, String goodsSize, String user,
			ReceiptType type, String info, String stockid) {
		this.goodsName = goodsName;
		this.goodsSize = goodsSize;
		this.user = user;
		this.type = type;
		this.createDate = new Date();
		this.status = 0;
		this.info = info;
		
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getGoodsSize() {
		return goodsSize;
	}
}