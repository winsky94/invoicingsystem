//进货和销售时的商品清单
public class CommodityList {
	GoodsVO good;
	int num;
	double price;
	double totalPrice;
	String memo;
	public CommodityList(GoodsVO good,int num,double price,String memo){
		this.good=good;
		this.num=num;
		this.price=price;
		this.totalPrice=num*price;
		this.memo=memo;
	}
}
