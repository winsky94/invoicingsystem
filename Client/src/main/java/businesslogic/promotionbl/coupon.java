package businesslogic.promotionbl;

import java.util.ArrayList;

import po.CouponPO;
import vo.CouponVO;

public class coupon {
	//String id,  double money,boolean isUse
	private CouponVO  poToVo(CouponPO po){
		CouponVO vo=new CouponVO(po.getId(),po.getValue(),po.getIsUse());
		return vo;
	}
	
	private CouponPO voToPo(CouponVO vo){
		CouponPO po=new CouponPO(vo.getId(),vo.getValue(),vo.getIsUse());
		return po;
	}
	
	
	 ArrayList<CouponPO> voTPo(ArrayList<CouponVO> vo){
		ArrayList<CouponPO> po=new ArrayList<CouponPO>();
		for(int i=0;i<vo.size();i++)
			po.add(voToPo(vo.get(i)));
		return po;
	}
	
	
	ArrayList<CouponVO> poTVo(ArrayList<CouponPO> po){
		ArrayList<CouponVO> vo=new ArrayList<CouponVO>();
		for(int i=0;i<po.size();i++)
			vo.add(poToVo(po.get(i)));
		return vo;
	}

}
