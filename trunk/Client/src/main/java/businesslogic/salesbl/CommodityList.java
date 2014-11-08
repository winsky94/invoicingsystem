package businesslogic.salesbl;



public class CommodityList {
	String goodID,goodName,goodSize;
	int num;
	double price;
	double totalPrice;
	String memo;
	public CommodityList(String goodID, String goodName, String goodSize,
			int num, double price, double totalPrice, String memo) {
		this.goodID = goodID;
		this.goodName = goodName;
		this.goodSize = goodSize;
		this.num = num;
		this.price = price;
		this.totalPrice = totalPrice;
		this.memo = memo;
	}
	
}
