package businesslogic.promotionbl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

import po.CommodityPO;
import po.DiscountProPO;
import po.GoodsPO;
import po.PromotionPO;
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
import businesslogic.utilitybl.getDate;

public  class discountPro extends promotion{
	
	//private double totalValue,discountValue;//折后总额；
	Commodity com;
	public discountPro() throws Exception {
		super();
		com=new Commodity();
	
		// TODO Auto-generated constructor stub
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
		DiscountProVO v=(DiscountProVO)vo;
		return service.Add(voToPo(v));
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
				vo.getMemberlevel(),vo.getCountList(),cplist
				);
		return po;
	}
	
	
	public DiscountProVO poToVo(DiscountProPO po){
		ArrayList<CommodityPO> cplist=po.getGoodsList();
		ArrayList<CommodityVO> cvlist=com.poTVo(cplist);
		
		DiscountProVO vo=new DiscountProVO(po.getID(),po.getStartDate(),po.getEndDate(),
				po.getLevel(),po.getCountList(),cvlist
				);
		return vo;
	}







	



	public String getNewID() {
		// TODO Auto-generated method stub
		String id=null;
		ArrayList<PromotionPO> gpp=service.show(PromotionType.DISCOUNT);
		if(gpp==null) id="001";
		else{
			int i=gpp.size();
			String date=gpp.get(i-1).getID().substring(3, 11);
			if(date.equals(getDate.getdate())){
			Double d=Double.parseDouble(gpp.get(i-1).getID().substring(12))+1;
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(3); 
		     nf.setGroupingUsed(false);
		     id=nf.format(d);}
			else id="001";
		}
		return "ZQ-"+getDate.getdate()+"-"+id;
	}
	
	//String id,String startDate,String endDate,MemberLevel l,
//	ArrayList<Double> count,
	//ArrayList<GoodsVO>  goods,double total,double discount
	
}
