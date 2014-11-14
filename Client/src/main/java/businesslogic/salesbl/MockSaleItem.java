package businesslogic.salesbl;

import businesslogic.stockbl.Goods;
import businesslogic.stockbl.MockGoods;

public class MockSaleItem extends SaleItem{
	private MockGoods good;
	private int num;
	public MockSaleItem(MockGoods good,int num){
		this.good=good;
		this.num=num;
	}
	
	public void updateNum(int n){
		this.num+=n;
	}
	
	
	public void OutGoods(){
		MockGoods Mockgoods=(MockGoods)good;
		Mockgoods.SaleGoods(num);
		
		
	}
	
	public int getNum(){
		return num;
	}
	public double getPrice(){
		return good.getPrice();
	}
	
	public double getTotal(){
		return good.getPrice()*num;
	}
	
	public double getTotalPurchase(){
		return good.getPurchasePrice()*num;
	}

}
