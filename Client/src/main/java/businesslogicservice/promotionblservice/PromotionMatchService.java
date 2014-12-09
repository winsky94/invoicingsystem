package businesslogicservice.promotionblservice;


import vo.PromotionVO;
import vo.SaleVO;

public interface PromotionMatchService {
	public PromotionVO Match(SaleVO vo);
}
