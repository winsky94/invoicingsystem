package businesslogic.salesbl;

import java.util.ArrayList;

public class MockPurchase extends Purchase{
	private String id;
	private ArrayList<MockCommodity> list;
	private double totalValue;
	public MockPurchase(String id){
		this.id=id;
		list=new ArrayList<MockCommodity>();
		this.totalValue=0;
	}
	
	
	public void AddCommodity(MockCommodity com){
		list.add(com);
		this.totalValue+=com.getTotalPrice();
	}
	
	
	public void DeleteCommodity(MockCommodity com){
		list.remove(com);
		this.totalValue-=com.getTotalPrice();
		
	}
	
	
	
	public double getTotalValue(){
		return this.totalValue;
	}

}
