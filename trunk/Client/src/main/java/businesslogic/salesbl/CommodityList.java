package businesslogic.salesbl;

import businesslogic.stockbl.Goods;


public class CommodityList {
	Goods good;
	int num;
	double price;
	double totalPrice;
	String memo;
	public CommodityList(Goods good,int num,double price,String memo){
		this.good=good;
		this.num=num;
		this.price=price;
		this.totalPrice=num*price;
		this.memo=memo;
	}
}
