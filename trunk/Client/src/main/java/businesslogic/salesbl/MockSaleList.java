package businesslogic.salesbl;

import java.util.ArrayList;

public class MockSaleList extends SaleList{
	private ArrayList<MockSale> saleList;
	private double saleInCome;
	
	public MockSaleList(){
		this.saleList=new ArrayList<MockSale>();
		this.saleInCome=0;
	}
	
	public void AddSale(MockSale sale){
		saleList.add(sale);
		this.saleInCome+=sale.getTotalValue();
	}
	

	public double getSaleInCome(){
		return this.saleInCome;
	}

}
