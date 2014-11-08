package businesslogic.stockbl;

import vo.GoodsVO;

public class MockGoods {
	String GoodsID;
	String name;
	String size;
	int numInStock;
	double purchasePrice;
	double price;
	double PurchasePrice;
	double lastPrice;

	public MockGoods(String goodsID, String name, String size, int numInStock,
			double purchasePrice, double price, double lastPurchasePrice,
			double lastPrice) {
		GoodsID = goodsID;
		this.name = name;
		this.size = size;
		this.numInStock = numInStock;
		this.purchasePrice = purchasePrice;
		this.price = price;
		this.PurchasePrice = lastPurchasePrice;
		this.lastPrice = lastPrice;
	}

	public GoodsVO getGoods(String goodsID) {
		GoodsVO goodsVO = new GoodsVO(goodsID, name, size, numInStock,
				lastPrice, lastPrice, lastPrice, lastPrice);

		return goodsVO;
	}
	
	//商品价格
	public double getPrice(double price){
		return price;
	}
	
}
