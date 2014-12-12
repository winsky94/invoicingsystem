package businesslogic.promotionbl;


import java.text.NumberFormat;
import java.util.ArrayList;









import javax.swing.JTabbedPane;

import businesslogic.utilitybl.getDate;
import po.CouponPO;
import po.GiftCouponProPO;
import po.PromotionPO;
import po.PromotionPO.PromotionType;
import vo.CommodityVO;
import vo.CouponVO;
import vo.GiftCouponProVO;
import vo.PromotionVO;
import vo.SaleVO;

//同类型 界面处理 放在同一行
public class giftCouponPro extends promotion{
	
	private double totalValue;
	private coupon coupon;
	public giftCouponPro() throws Exception{
		super();
		coupon=new coupon();
		
	}
	
	//data层modify可能有问题
	public void useCoupon(String couponid){
		 ArrayList<PromotionPO> po =service.show(PromotionType.GIFTCOUPON);
		 boolean tag=false;
		 for(int i=0;i<po.size();i++){
			 ArrayList<CouponPO>  clist=((GiftCouponProPO)po.get(i)).getCouponList();
			 for(int j=0;j<clist.size();j++){
				 if(couponid.equals(clist.get(j).getId())){
					 GiftCouponProPO p=((GiftCouponProPO)po.get(i));
					 p.getCouponList().get(j).setUse(true);
					 service.Modify(p);
					 tag=true;
					 break;
					 
				 }
				 if(tag)
					 break;
			 }
		 }
		
	}
	
	public double getCouponValue(String id){
		ArrayList<GiftCouponProVO> vo=show();
		for(int i=0;i<vo.size();i++){
			ArrayList<CouponVO> cvo=vo.get(i).getCouponList();
			for(int j=0;j<cvo.size();j++){
				CouponVO cv=cvo.get(j);
				if(id.equals(cv.getId())){
					if(cv.getIsUse()==true)
						return -2;//代金券已被使用
					else return cv.getValue();
				}
					
			}
		}
		
		
		return -1;//该代金券id不存在
	}
	
	public String[] getCouponId(int n){
		 NumberFormat nf = NumberFormat.getInstance();
	     nf.setMinimumIntegerDigits(5); 
	     nf.setGroupingUsed(false);
	     String date=getDate.getdate();
		String[] result=new String[n];
		ArrayList<PromotionPO> po=service.show(PromotionType.GIFTCOUPON);
		if(po==null){
			for(int i=1;i<=n;i++)
				result[i-1]=date+nf.format(i);
		}else{
			GiftCouponProPO gpv=(GiftCouponProPO)po.get(po.size()-1);
			int size=gpv.getCouponList().size();
			String id=gpv.getCouponList().get(size-1).getId();
			
		if(date.equals(id.substring(0, 8)))
		{	id=id.substring(8);
			double d=Double.parseDouble(id)+1;
			for(int i=0;i<n;i++)
				result[i]=date+nf.format(d++);}
		else{
			for(int i=1;i<=n;i++)
				result[i-1]=date+nf.format(i);
		}
		}
		
		return result;
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
		ArrayList<CouponVO> cvo=v.getCouponList();
		String[] cid=getCouponId(cvo.size());
		for(int i=0;i<cid.length;i++)
			cvo.get(i).setId(cid[i]);
		return service.Add(voToPo(v));
	}
	

	@Override
	public int Modify(PromotionVO vo) {
		// TODO Auto-generated method stub
		GiftCouponProVO v=(GiftCouponProVO)vo;
		return service.Modify(voToPo(v));
	}

	@Override
	public int Delete(String id) {
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

	@Override
	public PromotionVO Match(SaleVO vo) {
		// TODO Auto-generated method stub
		double total=vo.getTotalValue();
		double maxcoupon=0;
		PromotionVO result=null;
		ArrayList<GiftCouponProVO> pro=show();
		if(pro==null)
			return null;
		else{
			for(int i=0;i<pro.size();i++)
			{
				if(total>=pro.get(i).getTotalValue())
				{
					double value=getCouponValue(pro.get(i).getCouponList());
					if(maxcoupon<value)
						{maxcoupon=value;result=pro.get(i);}
				}
				
				
			}
			return result;
		}
	}

	
	public double getCouponValue(ArrayList<CouponVO> vo){
		double t=0;
		for(int i=0;i<vo.size();i++)
			t+=vo.get(i).getValue();
		return t;
	}
	public String getNewID() {
		// TODO Auto-generated method stub
		String id=null;
		ArrayList<PromotionPO> gpp=service.show(PromotionType.GIFTCOUPON);
		if(gpp==null) id="001";
		else{
			int i=gpp.size();
			String date=gpp.get(i-1).getID().substring(4, 12);
			if(date.equals(getDate.getdate())){
			Double d=Double.parseDouble(gpp.get(i-1).getID().substring(13))+1;
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(3); 
		     nf.setGroupingUsed(false);
		     id=nf.format(d);}
			else id="001";
		}
		return "DJQ-"+getDate.getdate()+"-"+id;
	}

	

	
	public PromotionVO findByID(String id){
		GiftCouponProPO gpo=(GiftCouponProPO)service.find(id, PromotionType.GIFTCOUPON);
		if(gpo==null) return null;
		else return poToVo(gpo);
		
	}

}
