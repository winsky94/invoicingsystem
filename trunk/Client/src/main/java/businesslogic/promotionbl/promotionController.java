package businesslogic.promotionbl;

import java.util.ArrayList;

import po.PromotionPO;
import po.PromotionPO.PromotionType;
import vo.DiscountProVO;
import vo.GiftCouponProVO;
import vo.GiftGoodsProVO;
import vo.GiftVO;
import vo.PackProVO;
import vo.PromotionVO;
import vo.SaleVO;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.promotionblservice.PromotionMatchService;
import businesslogicservice.promotionblservice.PromotionViewService;

public class promotionController implements PromotionViewService,
	PromotionMatchService,PromotionBLService{
	
	static giftCouponPro gcp;
	static giftGoodPro ggp;
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

	
	//优先级商品 代金券 折扣 特价包
	// gcp;
		//giftGoodPro ggp;
		//packPro pp;
		//discountPro dcp;
	//0表示已匹配
	public SaleVO Match(SaleVO vo) {
		// TODO Auto-generated method stub	
	PromotionVO pro=null;
	if((pro=ggp.Match(vo))!=null){
		vo.setProid(pro.getId());pro.setIsMatch(true);return vo;
	}else if((pro=gcp.Match(vo))!=null){
		vo.setProid(pro.getId());pro.setIsMatch(true);return vo;
	}else if((pro=dcp.Match(vo))!=null){
		vo.setProid(pro.getId());
		vo=dcp.excute(pro,vo);return vo;
	}else if((pro=pp.Match(vo))!=null){
		vo.setProid(pro.getId());
		vo=pp.excute(pro, vo);return vo;
	}
	return vo;
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

	

	@Override
	public double getCouponValue(String id) {
		// TODO Auto-generated method stub
		return gcp.getCouponValue(id);
	}

	public static void Excute(String proid,SaleVO vo) {
		// TODO Auto-generated method stub
		promotion pro;
		try {
			pro = new promotion();
			PromotionPO po=pro.find(proid);
			if(po!=null){
			if(po.getType()==PromotionType.GIFTCOUPON){
				//gcp.useCoupon(vo.getCouponid());没有用  仅为赠出
			}else{
			
				ggp.Excute(po,vo);
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Override
	public PromotionVO find(String id, PromotionType type) {
		// TODO Auto-generated method stub
		switch(type){
		case PACK:
			return pp.findByID(id);
		case DISCOUNT:
			return dcp.findByID(id);
		case GIFTGOODS:
			return ggp.findByID(id);
		default:
			return gcp.findByID(id);
		}
		
	}
	public GiftCouponProVO gpFindByID(String id) {
		// TODO Auto-generated method stub
		try {
		
			return (GiftCouponProVO)gcp.findByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public GiftGoodsProVO ggFindByID(String id) {
		// TODO Auto-generated method stub
		try {
		
		
			return (GiftGoodsProVO)ggp.findByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DiscountProVO dtFindByID(String id) {
		// TODO Auto-generated method stub
		try {
		
			return (DiscountProVO)dcp.findByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PackProVO pFindByID(String id) {
		// TODO Auto-generated method stub
		try {
		
			return (PackProVO)pp.findByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
