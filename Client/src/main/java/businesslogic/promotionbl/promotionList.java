package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionDataService;
import po.DiscountProPO;
import po.GiftCouponProPO;
import po.GiftGoodProPO;
import po.PackProPO;
import po.PromotionPO;

public class promotionList {
	private static ArrayList<promotion> proList;
	
	private static PromotionDataService service;
	public promotionList(){
		proList=new ArrayList<promotion>();
	}
	
	public  static int AddPromotion(promotion pro) throws RemoteException{
		PromotionPO po = null;
		if(pro.release==1){
			switch(pro.type){
			case DISCOUNT:
				po=new DiscountProPO();
			case GIFTCOUPON:
				po=new GiftCouponProPO();
			case GIFTGOODS:
				po=new GiftGoodProPO();
			case PACK:
				po=new PackProPO();		
			}
		}
		//模拟实现
		proList.add(pro);
		//service.Add(po);
		return  0;
	}

	
	public ArrayList<promotion> getProList(){
		return proList;
	}
}
