package vo;
public class CommodityListVO {
	GoodsVO good;
	int num;
	double price;
	double totalPrice;
	String memo;
	public CommodityListVO(GoodsVO good,int num,double price,String memo){
		this.good=good;
		this.num=num;
		this.price=price;
		this.totalPrice=num*price;
		this.memo=memo;
	}
}
