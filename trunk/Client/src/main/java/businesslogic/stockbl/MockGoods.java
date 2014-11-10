package businesslogic.stockbl;

public class MockGoods extends Goods {
	String GoodsID;
	String name;
	String type;
	int numInStock;
	double purchasePrice;//售价
	double price;//进价
	double lastPurchasePrice;
	double lastPrice;
	
	public MockGoods(String goodsID, String name, String type, int numInStock,
			 double purchasePrice ,
			double price) {
		GoodsID = goodsID;
		this.name = name;
		this.type = type;
		this.numInStock = numInStock;
		this.purchasePrice = purchasePrice;
		this.price = price;
		this.lastPurchasePrice = 0;
		this.lastPrice = 0;
	}
	
	public MockGoods(){
		
	}
	public  MockGoods getGoods(String goodsID) {
		MockGoods good = new MockGoods(goodsID, name, type, numInStock,
				purchasePrice, price);
		
		return good;
	}
	
	//商品价格
	public double getPrice(double price){
		return price;
	}

	public double getLastPurchasePrice() {
		return lastPurchasePrice;
	}

	public void setLastPurchasePrice(double lastPurchasePrice) {
		this.lastPurchasePrice = lastPurchasePrice;
	}
}
