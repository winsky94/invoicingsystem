package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import po.PromotionPO.PromotionType;
import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;

public interface PromotionBLService {
		public String getNewID(PromotionType type); 
		public int Delete(String id,PromotionType type);
		public int Add(PromotionVO vo);
		public int Modify(PromotionVO vo);
		public Promotion
		
		
		public GiftVO Present(PromotionVO vo);
		public ArrayList<PromotionVO> Show();

}
