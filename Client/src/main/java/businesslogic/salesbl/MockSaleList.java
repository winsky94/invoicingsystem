package businesslogic.salesbl;

import java.util.ArrayList;

public class MockSaleList extends SaleList{
	private ArrayList<MockSale> saleList;
	private double saleInCome;
	private double couponIncome;
	
	public MockSaleList(){
		this.saleList=new ArrayList<MockSale>();
		this.saleInCome=0;
	}
	
	public void AddSale(MockSale sale){
		saleList.add(sale);
		this.saleInCome+=sale.getTotalValue();
		this.couponIncome+=sale.getCouponIncome();
	}
	

	public double getSaleInCome(){
		return this.saleInCome;
	}
	
	public double getCouponIncome(){
		return this.couponIncome;
	}

}
