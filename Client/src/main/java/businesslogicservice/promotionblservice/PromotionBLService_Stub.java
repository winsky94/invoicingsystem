package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;

public class PromotionBLService_Stub implements PromotionBLService{

	
	public int Add(PromotionVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Add Promotion Success!");
		return 0;
	}

	public PromotionVO Match(SaleVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Match Promotion Success!");
		PromotionVO promotionvo=new PromotionVO();
		return promotionvo;
	}

	public int Modify(PromotionVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Modify Promotion Success!");
		return 0;
	}

	public GiftVO Present(PromotionVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Give Present by Promotion Success!");
		GiftVO giftvo=new GiftVO();
		return giftvo;
	}

	public ArrayList<PromotionVO> Show() {
		// TODO Auto-generated method stub
		System.out.println("Show Promotion Success!");
		ArrayList<PromotionVO> volist=new ArrayList<PromotionVO>();
		return volist;
	}

	

}
