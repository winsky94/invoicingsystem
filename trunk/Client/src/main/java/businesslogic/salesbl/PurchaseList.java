package businesslogic.salesbl;

import java.rmi.Naming;
import java.util.ArrayList;

import dataservice.salesdataservice.SalesDataService;

public class PurchaseList {
	private double purchaseIncome;
	private ArrayList<Purchase> purchseList;
	
		SalesDataService service;
		public PurchaseList() throws Exception{
			String host="localhost:1099";
			String url="rmi://"+host+"/salesService";
		
			service=(SalesDataService)Naming.lookup(url);
		
		}
	
	public double getPurchaseInCome(){
		return this.purchaseIncome;
	}
}
