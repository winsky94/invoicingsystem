package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Date;

import po.CommodityPO;
import po.DiscountProPO;
import po.GoodsPO;
import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.CommodityVO;
import vo.DiscountProVO;
import vo.GoodsVO;
import vo.PackProVO;
import vo.PromotionVO;
import vo.SaleVO;
import businesslogic.salesbl.Commodity;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.GoodsController;

public  class discountPro extends promotion{
	
	//private double totalValue,discountValue;//折后总额；
	Commodity com;
	public discountPro() throws Exception {
		super();
		com=new Commodity();
	
		// TODO Auto-generated constructor stub
	}


	
	public int add(DiscountProVO vo){
		
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
	public int Delete(String id) {
		// TODO Auto-generated method stub
		return service.Delete(id, PromotionType.DISCOUNT);
	}
	
	//String id,String startDate,String endDate,MemberLevel l,
	//ArrayList<Double> count,
	//ArrayList<GoodsPO>  goods,double total,double discount
	private DiscountProPO voToPo(DiscountProVO vo){
		ArrayList<CommodityVO> cvlist=vo.getGoodsList();
		ArrayList<CommodityPO> cplist=com.voTPo(cvlist);
		
		DiscountProPO po=new DiscountProPO(vo.getId(),vo.getStartDate(),vo.getEndDate(),
				vo.getMemberlevel(),vo.getCountList(),cplist,vo.getTotalValue(),
				vo.getDiscountValue());
		return po;
	}
	
	
	public DiscountProVO poToVo(DiscountProPO po){
		ArrayList<CommodityPO> cplist=po.getGoodsList();
		ArrayList<CommodityVO> cvlist=com.poTVo(cplist);
		
		DiscountProVO vo=new DiscountProVO(po.getID(),po.getStartDate(),po.getEndDate(),
				po.getLevel(),po.getCountList(),cvlist,po.getTotalValue(),
				po.getDiscountValue());
		return vo;
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
	
	//String id,String startDate,String endDate,MemberLevel l,
//	ArrayList<Double> count,
	//ArrayList<GoodsVO>  goods,double total,double discount
	
}
