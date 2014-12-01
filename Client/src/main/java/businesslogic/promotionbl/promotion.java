package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;






import businesslogicservice.promotionblservice.PromotionBLService;
import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;
//release 去掉？？？当前促销是否还有效？
public class promotion implements PromotionBLService{
	
	

	
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
	//子类不重写
	public ArrayList<PromotionVO> Show(){
		
		return null;
	}
	
	//查看某条记录
	public PromotionVO show(String id){
		
		return null;
	}
	
	
	
}
