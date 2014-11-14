package businesslogic.salesbl;

import java.util.ArrayList;

public class PurchaseList {
	private double purchaseIncome;
	private ArrayList<Purchase> purchseList;
	public PurchaseList(){
		this.purchaseIncome=0;
		purchseList=new ArrayList<Purchase>();
		
	}
	
	public void AddPurchase(Purchase purchase){
		this.purchseList.add(purchase);
		this.purchaseIncome+=purchase.getTotalValue();
		
	}
	
	public double getPurchaseInCome(){
		return this.purchaseIncome;
	}
}
