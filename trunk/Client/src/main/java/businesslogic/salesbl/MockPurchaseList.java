package businesslogic.salesbl;

import java.util.ArrayList;

public class MockPurchaseList{
	private double purchaseIncome;
	private ArrayList<MockPurchase> purchseList;
	public MockPurchaseList(){
		this.purchaseIncome=0;
		purchseList=new ArrayList<MockPurchase>();
		
	}
	
	public void AddPurchase(MockPurchase purchase){
		this.purchseList.add(purchase);
		this.purchaseIncome+=purchase.getTotalValue();
		
	}
	
	public double getPurchaseInCome(){
		return this.purchaseIncome;
	}

}
