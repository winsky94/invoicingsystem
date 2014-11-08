package vo;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;

public class StockOverOrLowVO extends ReceiptVO {
	String goodsName;
	String size;
	int num;
	int exactNum;
	int gap;

	public StockOverOrLowVO(String goodsName, String size, int num,
			int exactNum, int gap, UserVO user, ReceiptType type, String info,
			String stockid) {
		this.goodsName = goodsName;
		this.size = size;
		this.num = num;
		this.exactNum = exactNum;
		this.gap = gap;
		this.user = user;
		this.type = type;
		this.createDate = new Date();
		this.status = 0;
		this.info = info;
		this.stockid = stockid;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getSize() {
		return size;
	}

	public int getNum() {
		return num;
	}

	public int getExactNum() {
		return exactNum;
	}

	public int getGap() {
		return gap;
	}

}
