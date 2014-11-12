package businesslogic.promotionbl;

//使用操作 在哪儿

public class coupon {
	private String number;
	private double value;
	private boolean isUse;
	private int num;
	public coupon(double price,int num){
		this.number=getNew();
		this.value=price;
		this.isUse=false;
		this.num=num;
	}
	
	/*
	 * 生成代金券编号
	 */
	public String getNew(){
			String number="";
			return number;
	}

	
	public void setIsUse(){
		this.isUse=true;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public int getNum(){
		return num;
	}
	public void setNum(int num){
		this.num=num;
	}
	
	
}
