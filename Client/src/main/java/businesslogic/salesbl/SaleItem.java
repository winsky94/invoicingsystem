package businesslogic.salesbl;

import businesslogic.stockbl.Goods;
import businesslogic.stockbl.MockGoods;

public class SaleItem {
	private Goods good;
	private int num;
	public SaleItem(Goods good,int num){
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
	public Goods getGoods(){
		return good;
	}
	public int getNum(){
		return num;
	}
	public double getPrice(){
		return good.getPrice();
	}
	
	public double getPurchasePrice(){
		return good.getPurchasePrice();
	}
	
	public double getTotal(){
		return ((MockGoods)good).getPurchasePrice()*num;
	}
	
	public double getTotalPurchase(){
		return good.getPurchasePrice()*num;
	}

}
