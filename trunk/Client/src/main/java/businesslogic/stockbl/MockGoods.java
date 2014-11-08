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
	
	//库存充足检查
	public boolean isEnough(String goodsID){
		boolean isEnough=false;
		isEnough=true;
		return isEnough;
	}
	
	//商品报溢收入
	public double goodsOverIncome(double total){
		return total;
	}
	
	//商品调价收入
	public double PrimeCostIncome(double total){
		return total;
	}
	
	//商品进货退货差价收入
	public double importReturnIncome (double total){
		return total;
	}
	
	//商品报损支出
	public double goodsLowCost(double total){
		return total;
	}
	
	//商品赠送支出
	public double giftCost(double total){
		return total;
	}
}
