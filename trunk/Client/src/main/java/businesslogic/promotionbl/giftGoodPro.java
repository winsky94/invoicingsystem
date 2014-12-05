package businesslogic.promotionbl;


import java.util.ArrayList;
import java.util.Date;













import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.GiftGoodsProVO;
import vo.PackProVO;
import vo.PromotionVO;
import vo.SaleVO;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.MockGoods;

public class giftGoodPro extends promotion{	
	public giftGoodPro() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}


	private ArrayList<Goods> giftList;
	private double totalValue;
	public int add(GiftGoodsProVO vo){
		
		return 0;
	}
	
	
	public int Modify(GiftGoodsProVO vo){
		return 0;
	}
	
	
	public ArrayList<GiftGoodsProVO> show(){
		return null;
	}

	@Override
	public int Add(PromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Modify(PromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(String id) {
		// TODO Auto-generated method stub
		return service.Delete(id, PromotionType.GIFTGOODS);
	}

	@Override
	public String getNewID(PromotionType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionVO Match(SaleVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNewID() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
