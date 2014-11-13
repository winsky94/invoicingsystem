package businesslogic.salesbl;

import businesslogic.stockbl.Goods;

public class SaleItem {
	private Goods good;
	private int num;
	public SaleItem(Goods good,int num){
		this.good=good;
		this.num=num;
	}
	public void ItemAdd(int n){
		num+=n;
	}
	public void ItemDelete(int n){
		num-=n;
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
	
	public double getTotal(){
		return good.getPrice()*num;
	}

}
