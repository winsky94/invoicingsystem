package businesslogic.stockbl;

public class MockStockControl {
	String num;
	double goodsOverIncome;
	double primeCostIncome;
	double goodsLowCost;
	double giftCost;

	// 库存充足检查
	public boolean isEnough(String goodsID, int num) {
		boolean isEnough = false;
		isEnough = true;
		return isEnough;
	}

	// 商品调价收入
	public double getPrimeCostIncome(double total) {
		return total;
	}

	// 商品报溢收入
	public double getGoodsOverIncome(double total) {
		return total;
	}

	// 商品报损支出
	public double getGoodsLowCost(double total) {
		return total;
	}

	// 商品赠送支出
	public double getGiftCost(double total) {
		return total;
	}
}
