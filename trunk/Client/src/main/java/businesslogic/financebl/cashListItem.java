package businesslogic.financebl;

public class cashListItem {
	private String name;
	private double money;
	private String  remark;
	public cashListItem(String name,double money,String remark){
		this.name=name;
		this.money=money;
		this.remark=remark;
	}
	
	public double getMoney(){
		return this.money;
	}
	

}
