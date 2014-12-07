package businesslogic.promotionbl;

import java.util.ArrayList;

import po.PromotionPO.PromotionType;
import vo.GiftCouponProVO;
import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.promotionblservice.PromotionMatchService;
import businesslogicservice.promotionblservice.PromotionViewService;

public class promotionController implements PromotionViewService,
	PromotionMatchService,PromotionBLService{
	
	giftCouponPro gcp;
	giftGoodPro ggp;
	packPro pp;
	discountPro dcp;
	public promotionController() throws Exception{
		gcp=new giftCouponPro();
		ggp=new giftGoodPro();
		pp=new packPro();
		dcp=new discountPro();
		
	}

	public String getNewID(PromotionType type) {
		// TODO Auto-generated method stub
		switch(type){
		case GIFTCOUPON:
				return gcp.getNewID();
		case GIFTGOODS:
			return  ggp.getNewID();
		case PACK:
			return pp.getNewID();
		default:
			return dcp.getNewID();
			
		}
	}

	public int Delete(String id,PromotionType type) {
		// TODO Auto-generated method stub
		switch(type){
		case GIFTCOUPON:
			return gcp.Delete(id);
		case GIFTGOODS:
			return  ggp.Delete(id);
		case PACK:
			return pp.Delete(id);
		default:
			return dcp.Delete(id);
		}
	}

	public int Add(PromotionVO vo) {
		// TODO Auto-generated method stub
		switch(vo.getType()){
		case GIFTCOUPON:
			return gcp.Add(vo);
		case GIFTGOODS:
			return  ggp.Add(vo);
		case PACK:
			return pp.Add(vo);
		default:
			return dcp.Add(vo);
		}
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
		promotion promotion=null;
		try {
			promotion = new promotion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return promotion.Show();
	}

	public GiftCouponProVO gpFindByID(String id) {
		// TODO Auto-generated method stub
		try {
			promotion promotion=new giftCouponPro();
		
			return (GiftCouponProVO)promotion.findByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
