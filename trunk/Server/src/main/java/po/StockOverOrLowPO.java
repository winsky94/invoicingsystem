package po;

import java.io.Serializable;

public class StockOverOrLowPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String goodsName;
	String size;
	int num;
	int exactNum;
	int gap;

	public StockOverOrLowPO(String goodsName, String size, int num,
			int exactNum, int gap) {
		this.goodsName = goodsName;
		this.size = size;
		this.num = num;
		this.exactNum = exactNum;
		this.gap = gap;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getExactNum() {
		return exactNum;
	}

	public void setExactNum(int exactNum) {
		this.exactNum = exactNum;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}
}
