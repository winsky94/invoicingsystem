package po;

public class CouponPO {
	private String id;
	private double value;
	private boolean isUse;

	public CouponPO(String id,double price,boolean isUse){
        this.id=id;
		this.value=price;
		this.isUse=isUse;
	}

	public String getId() {
		return id;
	}

	public double getValue() {
		return value;
	}

	public boolean isUse() {
		return isUse;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}
	
	
}
