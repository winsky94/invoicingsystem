package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;

public class promotion {
	//属性？
	public promotion(){
		
	}
	
	//发布和添加？
	public int Add(PromotionVO vo){
		
		return 0;
	}
	
	public int Modify(PromotionVO vo){
		
		return 0;
	}
	
	public PromotionVO Match(SaleVO vo){
		
		return null;
	}
	
	//自动生成库存赠送但
	public GiftVO Present(PromotionVO vo){
		
		return null;
	
	}
	
	public ArrayList<PromotionVO> show(){
		
		return null;
	}
	
	//查看某条记录
	public PromotionVO show(String id){
		
		return null;
	}
}
