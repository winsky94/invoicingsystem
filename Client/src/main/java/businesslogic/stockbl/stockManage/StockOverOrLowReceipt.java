package businesslogic.stockbl.stockManage;

import businesslogic.receiptbl.Receipt;

public class StockOverOrLowReceipt extends Receipt {
	String goodsName;
	String size;
	int num;
	int exactNum;
	double gap;

	public StockOverOrLowReceipt() {

	}

	public StockOverOrLowReceipt(String goodsName, String size, int num,
			int exactNum) {
		super();
		this.goodsName = goodsName;
		this.size = size;
		this.num = num;
		this.exactNum = exactNum;
		this.gap = num - exactNum;
	}

	public double getGap() {
		return gap;
	}

}
