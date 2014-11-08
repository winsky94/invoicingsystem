package businesslogic.stockbl;

public class MockStock {
	String num;
	double goodsOverIncome;
	double PrimeCostIncome;
	double importReturnIncome;
	double goodsLowCost;
	double giftCost;

	// 库存充足检查
	public boolean isEnough(String goodsID, int num) {
		boolean isEnough = false;
		isEnough = true;
		return isEnough;
	}

	// 商品调价收入
	public double PrimeCostIncome(double total) {
		return total;
	}

	// 商品报溢收入
	public double goodsOverIncome(double total) {
		return total;
	}

	// 商品报损支出
	public double goodsLowCost(double total) {
		return total;
	}

	// 商品赠送支出
	public double giftCost(double total) {
		return total;
	}
}
