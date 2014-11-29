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
}
