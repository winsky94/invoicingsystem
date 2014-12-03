package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.PackProVO;
import vo.PromotionVO;
import businesslogic.stockbl.goods.Goods;

//特价包促销
public class packPro extends promotion{
	

	public packPro() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public int add(PackProVO vo){
		
		return 0;
	}
	
	public int Delete(String id){
		return 0;
	}
	public int Modify(PackProVO vo){
		return 0;
	}
	
	
	public ArrayList<PackProVO> show(){
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
	public int Delete(String id, PromotionType type) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
