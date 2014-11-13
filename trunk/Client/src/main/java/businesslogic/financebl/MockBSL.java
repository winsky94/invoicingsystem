package businesslogic.financebl;

public class MockBSL extends BSL {
	private double salesIncome;
	private double goodsOverIncome;
	private double primeCostIncome;
	private double importReturnIncome;
	private double couponIncome;
	private double totalIncome;

	private double salesPrimeCost;
	private double goodsLowCost;
	private double goodsGiftCost;
	private double totalExpense;

	private double profit;

	public MockBSL(double salesIncome, double goodsOverIncome,
			double primeCostIncome, double importReturnIncome,
			double couponIncome, double salesPrimeCost, double goodsLowCost,
			double goodsGiftCost) {
		this.salesIncome = salesIncome;
		this.goodsOverIncome = goodsOverIncome;
		this.primeCostIncome = primeCostIncome;
		this.importReturnIncome = importReturnIncome;
		this.couponIncome = couponIncome;
		this.totalIncome = salesIncome + goodsOverIncome + primeCostIncome
				+ importReturnIncome + couponIncome;
		this.salesPrimeCost = salesPrimeCost;
		this.goodsLowCost = goodsLowCost;
		this.goodsGiftCost = goodsGiftCost;
		this.totalExpense = salesPrimeCost + goodsLowCost + goodsGiftCost;
		this.profit = totalIncome - totalExpense;
	}

	public double getSalesIncome() {
		return salesIncome;
	}

	public void setSalesIncome(double salesIncome) {
		this.salesIncome = salesIncome;
	}

	public double getGoodsOverIncome() {
		return goodsOverIncome;
	}

	public void setGoodsOverIncome(double goodsOverIncome) {
		this.goodsOverIncome = goodsOverIncome;
	}

	public double getPrimeCostIncome() {
		return primeCostIncome;
	}

	public void setPrimeCostIncome(double primeCostIncome) {
		this.primeCostIncome = primeCostIncome;
	}

	public double getImportReturnIncome() {
		return importReturnIncome;
	}

	public void setImportReturnIncome(double importReturnIncome) {
		this.importReturnIncome = importReturnIncome;
	}

	public double getCouponIncome() {
		return couponIncome;
	}

	public void setCouponIncome(double couponIncome) {
		this.couponIncome = couponIncome;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public double getSalesPrimeCost() {
		return salesPrimeCost;
	}

	public void setSalesPrimeCost(double salesPrimeCost) {
		this.salesPrimeCost = salesPrimeCost;
	}

	public double getGoodsLowCost() {
		return goodsLowCost;
	}

	public void setGoodsLowCost(double goodsLowCost) {
		this.goodsLowCost = goodsLowCost;
	}

	public double getGoodsGiftCost() {
		return goodsGiftCost;
	}

	public void setGoodsGiftCost(double goodsGiftCost) {
		this.goodsGiftCost = goodsGiftCost;
	}

	public double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}

	public double getProfit() {
		return profit;
	}
}
