package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.DiscountProVO;
import vo.PackProVO;
import businesslogic.stockbl.goods.Goods;

public class discountPro extends promotion{
	
	private double totalValue,discountValue;//折后总额；
	public int add(DiscountProVO vo){
		
		return 0;
	}
	
	public int Delete(String id){
		return 0;
	}
	public int Modify(DiscountProVO vo){
		return 0;
	}
	
	
	public ArrayList<DiscountProVO> show(){
		return null;
	}
	
	
}
