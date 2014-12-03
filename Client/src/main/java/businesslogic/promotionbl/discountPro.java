package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Date;

import po.DiscountProPO;
import po.GoodsPO;
import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.DiscountProVO;
import vo.GoodsVO;
import vo.PackProVO;
import vo.PromotionVO;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.GoodsController;

public class discountPro extends promotion{
	
	//private double totalValue,discountValue;//折后总额；
	
	public discountPro() throws Exception {
		super();
		GoodsController good=new GoodsController();
		// TODO Auto-generated constructor stub
	}


	
	public int add(DiscountProVO vo){
		
		return 0;
	}
	
	public int Delete(String id){
		return 0;
	}
	public int Modify(DiscountProVO vo){
		return 0;
	}
	
	
	public ArrayList<DiscountProVO> show(){
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
	
	//String id,String startDate,String endDate,MemberLevel l,
	//ArrayList<Double> count,
	//ArrayList<GoodsPO>  goods,double total,double discount
	private DiscountProPO voToPo(DiscountProVO vo){
		ArrayList<GoodsVO> gpo=vo.getGoodsList();
		ArrayList<GoodsPO> gvo=new ArrayList<GoodsPO>();
		for(int i=0;i<gpo.size();i++)
			gvo.add()
		
		DiscountProPO po=new DiscountProPO(vo.getId(),vo.getStartDate(),vo.getEndDate(),
				vo.getMemberlevel(),vo.getCountList(),vo.getGoodsList(),vo.getTotalValue(),
				vo.getDiscountValue());
		return po;
	}
	
	//String id,String startDate,String endDate,MemberLevel l,
//	ArrayList<Double> count,
	//ArrayList<GoodsVO>  goods,double total,double discount
	
}
