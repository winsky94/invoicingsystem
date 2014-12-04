package vo;

import po.ReceiptPO.ReceiptType;

public class StockErrorVO extends ReceiptVO {
	String goodsName;
	String goodsSize;

	public StockErrorVO(String goodsName, String goodsSize, String user,
			ReceiptType type, String info, String stockid) {
		this.goodsName = goodsName;
		this.goodsSize = goodsSize;
		this.user = user;
		this.type = type;
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