package vo;

public class GoodsVO {
	String GoodsID;
	String name;
	String size;
	int numInStock;
	double purchasePrice;
	double price;
	double lastPurchasePrice;
	double lastPrice;

	public GoodsVO(String goodsID, String name, String size, int numInStock,
			double purchasePrice, double price, double lastPurchasePrice,
			double lastPrice) {
		GoodsID = goodsID;
		this.name = name;
		this.size = size;
		this.numInStock = numInStock;
		this.purchasePrice = purchasePrice;
		this.price = price;
		this.lastPurchasePrice = lastPurchasePrice;
		this.lastPrice = lastPrice;
	}

	public String getGoodsID() {
		return GoodsID;
	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public int getNumInStock() {
		return numInStock;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public double getPrice() {
		return price;
	}

	public double getLastPurchasePrice() {
		return lastPurchasePrice;
	}

	public double getLastPrice() {
		return lastPrice;
	}
}
