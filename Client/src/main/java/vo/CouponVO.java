package vo;

import java.util.Date;

public class CouponVO {
	String id;
	double money;//�ɵ��ý��
	boolean isUse;
	public CouponVO(String id,  double money,boolean isUse) {
		this.id = id;
		this.money = money;
		this.isUse=isUse;
		//this.createDate=
	}
	public String getId() {
		return id;
	}

	public double getValue() {
		return money;
	}

	public boolean getIsUse() {
		return isUse;
	}
	

}
