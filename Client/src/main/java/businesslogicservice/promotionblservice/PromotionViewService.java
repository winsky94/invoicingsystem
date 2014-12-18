package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.DiscountProVO;
import vo.GiftCouponProVO;
import vo.GiftGoodsProVO;
import vo.PackProVO;
import vo.PromotionVO;

public interface PromotionViewService {
	
	public GiftCouponProVO gpFindByID(String id);
	public GiftGoodsProVO ggFindByID(String id);
	public DiscountProVO  dtFindByID(String id);
	public PackProVO pFindByID(String id);
	public ArrayList<PromotionVO> Show();

}
