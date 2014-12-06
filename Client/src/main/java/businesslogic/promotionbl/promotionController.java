package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.GiftCouponProVO;
import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.promotionblservice.PromotionMatchService;
import businesslogicservice.promotionblservice.PromotionViewService;

public class promotionController implements PromotionViewService,
	PromotionMatchService,PromotionBLService{
	
	promotion promotion;
	public promotionController(){
		
	}

	public String getNewID() {
		// TODO Auto-generated method stub
		return null;
	}

	public int Delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Add(PromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Modify(PromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PromotionVO Match(SaleVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public GiftVO Present(PromotionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PromotionVO> Show() {
		// TODO Auto-generated method stub
		return null;
	}

	public GiftCouponProVO gpFindByID(String id) {
		// TODO Auto-generated method stub
		try {
			promotion=new giftCouponPro();
		
			return (GiftCouponProVO)promotion.findByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
