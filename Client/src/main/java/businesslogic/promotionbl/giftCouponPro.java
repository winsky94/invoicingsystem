package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.CouponPO;
import po.GiftCouponProPO;
import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO;
import po.PromotionPO.PromotionType;
import vo.CouponVO;
import vo.DiscountProVO;
import vo.GiftCouponProVO;
import vo.GiftGoodsProVO;
import vo.PromotionVO;
import businesslogic.stockbl.goods.Goods;
//同类型 界面处理 放在同一行
public class giftCouponPro extends promotion{
	
	private double totalValue;
	private coupon coupon;
	public giftCouponPro() throws Exception{
		super();
		coupon=new coupon();
		
	}
	
	public double getCouponValue(String id){
		ArrayList<GiftCouponProVO> vo=show();
		for(int i=0;i<vo.size();i++){
			ArrayList<CouponVO> cvo=vo.get(i).getCouponList();
			for(int j=0;j<cvo.size();j++){
				CouponVO cv=cvo.get(i);
				if(id.equals(cv.getId())){
					if(cv.getIsUse()==true)
						return 2;//代金券已被使用
					else return cv.getValue();
				}
					
			}
		}
		
		
		return 1;//该代金券id存在
	}
	
	
	
	public ArrayList<GiftCouponProVO> show(){
		ArrayList<PromotionPO> po=service.show(PromotionType.GIFTCOUPON);
		if(po==null) return null;
		else{
			ArrayList<GiftCouponProVO> vo=new ArrayList<GiftCouponProVO>();
			for(int i=0;i<po.size();i++){
				GiftCouponProPO cpv=(GiftCouponProPO)po.get(i);
				vo.add(poToVo(cpv));
			}
			return vo;
		}
		
	}

	@Override
	public int Add(PromotionVO vo) {
		// TODO Auto-generated method stub
		GiftCouponProVO v=(GiftCouponProVO)vo;
		return service.Add(voToPo(v));
	}
	

	@Override
	public int Modify(PromotionVO vo) {
		// TODO Auto-generated method stub
		GiftCouponProVO v=(GiftCouponProVO)vo;
		return service.Modify(voToPo(v));
	}

	@Override
	public int Delete(String id, PromotionType type) {
		// TODO Auto-generated method stub
		return service.Delete(id, PromotionType.GIFTCOUPON);
	}
	
	
	
	//String id,String startDate,String endDate,MemberLevel l,
	//ArrayList<CouponVO> coupon,double value
	private GiftCouponProVO poToVo(GiftCouponProPO po){
		ArrayList<CouponVO> cvo=coupon.poTVo(po.getCouponList());
		GiftCouponProVO vo=new GiftCouponProVO(po.getID(),po.getStartDate(),
				po.getEndDate(),po.getLevel(),cvo,po.getTotalValue());
		return vo;
		
	}
	
	private GiftCouponProPO voToPo(GiftCouponProVO vo){
		ArrayList<CouponPO> cpo=coupon.voTPo(vo.getCouponList());
		GiftCouponProPO po=new GiftCouponProPO(vo.getId(),vo.getStartDate(),
				vo.getEndDate(),vo.getMemberlevel(),cpo,vo.getTotalValue());
		return po;
		
	}
	

}
