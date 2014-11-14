package businesslogic.salesbl;

import java.util.ArrayList;

public class MockSale extends Sale{
	private String id;
	private ArrayList<MockSaleItem> goodsList;
	private double totalValue;
	public MockSale(String id){
		this.id =id;
		this.goodsList=new ArrayList<MockSaleItem>();
		this.totalValue=0;
	}
	
	public void AddGoods(MockSaleItem item){
		goodsList.add(item);
		this.totalValue+=(item.getTotal());
	}
	
	
	public void DeleteGoods(MockSaleItem item){
		goodsList.remove(item);
		this.totalValue-=(item.getTotal());
	}
	
	public double getTotalValue(){
		return this.totalValue;
	}
	

}
