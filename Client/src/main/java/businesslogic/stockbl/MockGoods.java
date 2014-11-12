package businesslogic.stockbl;

public class MockGoods extends Goods {
	String GoodsID;
	String name;
	String type;
	int numInStock;
	double purchasePrice;// 售价
	double price;// 进价
	double lastPurchasePrice;
	double lastPrice;

	public MockGoods(String goodsID, String name, String type, int numInStock,
			double purchasePrice, double price) {
		GoodsID = goodsID;
		this.name = name;
		this.type = type;
		this.numInStock = numInStock;
		this.purchasePrice = purchasePrice;
		this.price = price;
		this.lastPurchasePrice = 0;
		this.lastPrice = 0;
	}

	public MockGoods() {

	}

	public MockGoods getGoods(String goodsID) {
		MockGoods good = new MockGoods(goodsID, name, type, numInStock,
				purchasePrice, price);
		return good;
	}

	// 商品价格
	public double getPrice() {
		return price;
	}

	public double getLastPurchasePrice() {
		return lastPurchasePrice;
	}

	public void setLastPurchasePrice(double lastPurchasePrice) {
		this.lastPurchasePrice = lastPurchasePrice;
	}

	public String getGoodsID() {
		return GoodsID;
	}

	public void setGoodsID(String goodsID) {
		GoodsID = goodsID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumInStock() {
		return numInStock;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}
}
