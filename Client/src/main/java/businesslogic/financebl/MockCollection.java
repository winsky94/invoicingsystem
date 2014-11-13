package businesslogic.financebl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;

/*
 * 收款单Mock  
 */
public class MockCollection extends Collection{
	private String id;
	private ArrayList<String> memberID;
	private ArrayList<Double> money;
	private double totalMoney;
	public MockCollection(String id
			) {
		this.id=id;
		memberID=new ArrayList<String>();
		money=new ArrayList<Double>();
		totalMoney=0;
	
	}
	
	
	public void AddCollectItem(String memberId,double Money){
		money.add(Money);
		memberID.add(memberId);
		this.totalMoney+=Money;
	}
	
	public void DeleteCollectItem(String ID){
		int i=memberID.indexOf(ID);
		memberID.remove(i);
		this.totalMoney-=money.get(i);
		money.remove(i);
		
	}
	
	public ArrayList<String> getID(){
		return this.memberID;
	}
	
	public ArrayList<Double> getMoney(){
		return this.money;
	}
	
	public double getTotalMoney(){
		return this.totalMoney;
	}
	
	
	
	

	

	
	
}
