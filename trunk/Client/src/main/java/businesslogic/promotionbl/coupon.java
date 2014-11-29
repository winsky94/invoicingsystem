package businesslogic.promotionbl;

//使用操作 在哪儿 无使用期限
public class coupon {
	private String id;
	private double value;
	private boolean isUse;

	public coupon(String id,double price){
        this.id=id;
		this.value=price;
		isUse=false;
	}

	
	
	
	public void Use(){
		isUse=true;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
		
	public boolean getIsUse(){
		return isUse;
	}
}
