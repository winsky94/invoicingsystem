package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.promotionbl.PromotionType;

public class PromotionVO {
	Date startDate,endDate;
	PromotionType type;
	MemberLevel level;
	MemberType mtype;
	int release;//发布
	public PromotionVO(){
		
	}
	public PromotionVO(Date startDate, Date endDate, PromotionType type,
			MemberLevel memberlevel,MemberType mtype) {
	
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.level = memberlevel;
		this.mtype=mtype;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public PromotionType getType() {
		return type;
	}
	public MemberLevel getMemberlevel() {
		return level;
	}
	
	

}



 class giftProVO extends PromotionVO{
	ArrayList<GoodsVO> gift;
    ArrayList<couponVO> coupon;
	public giftProVO(){
		super();
	}
    public giftProVO(ArrayList<GoodsVO> gift,ArrayList<couponVO> coupon) {
    	super();
    	if(gift!=null)
    		this.gift=gift;
    	else this.coupon=coupon;
    	
    }
 
}

 //特价包促销
class packProVO extends PromotionVO{
	ArrayList<GoodsVO> pack;
	double price;
     public packProVO(ArrayList<GoodsVO> pack,double p){
    	 this.pack=pack;
    	 this.price=p;
     	
     }
     
 }

//折让，折扣促销 ，可添加多项
class discountProVO extends PromotionVO{
	ArrayList<disrecord> provo;
	public discountProVO(ArrayList<disrecord> provo){
		this.provo=provo;
	}
	

}

//折让记录
class disrecord{
	GoodsVO vo;
	double price;
	public disrecord(GoodsVO vo,double price){
		this.vo=vo;
		this.price=price;
	}
	
}

