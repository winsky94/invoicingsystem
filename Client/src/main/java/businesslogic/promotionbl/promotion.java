package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;





import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;

public class promotion {
	Date startDate,endDate;
	PromotionType type;
	MemberLevel level;
	MemberType mtype;
	int release;
	public promotion(){
		
	}
	public promotion(Date d1,Date d2,PromotionType t,MemberLevel l,MemberType mt){
		this.startDate=d1;
		this.endDate=d2;
		this.type=t;
		this.mtype=mt;
		this.level=l;
		this.release=0;//未发布
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
	
	public int Release(promotion pro) throws RemoteException{
		pro.release=1;
		return promotionList.AddPromotion(pro);
	}
	
	public int  GetRelease(){
		return release;
	}
	
	//发布
}