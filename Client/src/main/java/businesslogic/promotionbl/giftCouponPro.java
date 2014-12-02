package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.DiscountProVO;
import vo.GiftCouponProVO;
import vo.GiftGoodsProVO;
import businesslogic.stockbl.goods.Goods;
//同类型 界面处理 放在同一行
public class giftCouponPro extends promotion{
	
	private double totalValue;
	public giftCouponPro(){
		
		
	}
	
	public double getCouponValue(String id){
		
		
		return 0;
	}
	public int add(GiftCouponProVO vo){
		
		return 0;
	}
	
	public int Delete(String id){
		return 0;
	}
	public int Modify(GiftCouponProVO vo){
		return 0;
	}
	
	
	public ArrayList<GiftCouponProVO> show(){
		return null;
	}
	
	
	

}
