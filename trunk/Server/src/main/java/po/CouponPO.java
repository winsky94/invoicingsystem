package po;

import java.io.Serializable;

/*
 * 代金券
 */
public class CouponPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	private double value;
	private boolean isUse;
	private String useDate="";

	public CouponPO(String id,double price,boolean isUse){
        this.id=id;
		this.value=price;
		this.isUse=isUse;
	}
	public void setuseDate(String date){
		this.useDate=date;
	}
	public String getId() {
		return id;
	}

	public double getValue() {
		return value;
	}

	public boolean getIsUse() {
		return isUse;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}
	
	
}
