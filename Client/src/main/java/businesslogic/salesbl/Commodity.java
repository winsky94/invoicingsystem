package businesslogic.salesbl;



public class Commodity {
	String goodID,goodName,goodType;
	int num;
	double price;
	double totalPrice;
	String memo;
	public Commodity(String goodID, String goodName, String goodType,
			int num, double price, double totalPrice, String memo) {
		this.goodID = goodID;
		this.goodName = goodName;
		this.goodType = goodType;
		this.num = num;
		this.price = price;
		this.totalPrice = totalPrice;
		this.memo = memo;
	}
	
}
