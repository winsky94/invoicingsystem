package businesslogic.financebl;



public class TransferItem {
	String account;
	double money;
	String info;
	
	
	public TransferItem(){
		this(null,0,null);
	}
	
	public TransferItem(String a,double b,String c){
		account=a;
		money=b;
		info=c;
	}
	
	public String getAccount(){
		return account;
	}
	
	public double getMoney(){
		return money;
	}
	
	public String getInfo(){
		return info;
	}
}
