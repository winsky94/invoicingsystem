package businesslogic.salesbl;



public class Commodity {
	String  goodID,goodName,goodType;
	double price;
	
	String memo;
	public Commodity(){
		
	}
	public Commodity(String goodID, String goodName, String goodType,
			int num, double price, double totalPrice, String memo) {
		this.goodID = goodID;
		this.goodName = goodName;
		this.goodType = goodType;
		//this.num = num;
		this.price = price;
		this.totalPrice = totalPrice;
		this.memo = memo;
	}

	public String getGoodID() {
		return goodID;
	}

	public void setGoodID(String goodID) {
		this.goodID = goodID;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
