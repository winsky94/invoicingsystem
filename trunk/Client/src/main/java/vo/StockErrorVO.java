package vo;

import po.ReceiptPO.ReceiptType;

public class StockErrorVO extends ReceiptVO {
	String goodsName;
	String goodsSize;
	String stockID;

	public StockErrorVO(String id, String user, int status, int hurry,
			ReceiptType type, String goodsName, String goodsSize, String stockid) {
		super(id, ReceiptType.STOCKERROR, user, status, hurry);
		this.goodsName = goodsName;
		this.goodsSize = goodsSize;
		this.stockID = stockid;

	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getGoodsSize() {
		return goodsSize;
	}
}