package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;

public interface PromotionBLService {
		public String getNewID(); 
		public int Add(PromotionVO vo);
		public int Modify(PromotionVO vo);
		public PromotionVO Match(SaleVO vo);
		public GiftVO Present(PromotionVO vo);
		public ArrayList<PromotionVO> Show();

}
