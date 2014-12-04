package vo;

import po.ReceiptPO.ReceiptType;

public class StockOverOrLowVO extends ReceiptVO {
	String goodsName;
	String size;
	int num;
	int exactNum;
	int gap;

	public StockOverOrLowVO(String goodsName, String size, int num,
			int exactNum, String user, ReceiptType type, String info) {
		this.goodsName = goodsName;
		this.size = size;
		this.num = num;
		this.exactNum = exactNum;
		this.gap = num - exactNum;
		this.user = user;
		this.type = type;
		
		this.status = 0;
		this.info = info;
		
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