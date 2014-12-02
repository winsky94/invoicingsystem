package businesslogic.promotionbl;


import java.util.ArrayList;
import java.util.Date;









import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.GiftGoodsProVO;
import vo.PackProVO;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.MockGoods;

public class giftGoodPro extends promotion{	
	private ArrayList<Goods> giftList;
	private double totalValue;
	public int add(GiftGoodsProVO vo){
		
		return 0;
	}
	
	public int Delete(String id){
		return 0;
	}
	public int Modify(GiftGoodsProVO vo){
		return 0;
	}
	
	
	public ArrayList<GiftGoodsProVO> show(){
		return null;
	}
	

	
}
