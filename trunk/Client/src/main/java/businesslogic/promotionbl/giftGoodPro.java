package businesslogic.promotionbl;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;






















import po.CommodityPO;
import po.GiftGoodProPO;
import po.PackProPO;
import po.PromotionPO;
import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;
import vo.CommodityVO;
import vo.GiftGoodsProVO;
import vo.GiftVO;
import vo.PackProVO;
import vo.PromotionVO;
import vo.SaleVO;
import businesslogic.salesbl.Commodity;
import businesslogic.stockbl.gift.GiftManage;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.MockGoods;
import businesslogic.utilitybl.getDate;

public class giftGoodPro extends promotion{	
	Commodity com;
	public giftGoodPro() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		com=new Commodity();
	}


	private ArrayList<Goods> giftList;
	private double totalValue;
	
	
	public int Modify(GiftGoodsProVO vo){
		return 0;
	}
	
	
	public ArrayList<GiftGoodsProVO> show(){
		ArrayList<PromotionPO> po =service.show(PromotionType.GIFTGOODS);
		if(po==null) return null;
		else {
			ArrayList<GiftGoodsProVO> vo=new ArrayList<GiftGoodsProVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo((GiftGoodProPO)po.get(i)));
			return vo;
		}
	
	}

	@Override
	public int Add(PromotionVO vo) {
		// TODO Auto-generated method stub
		GiftGoodsProVO v=(GiftGoodsProVO)vo;
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
		return service.Delete(id, PromotionType.GIFTGOODS);
	}


	@Override
	public PromotionVO Match(SaleVO vo) {
		// TODO Auto-generated method stub
		double total=vo.getTotalValue();
		double value=0;
		PromotionVO result=null;
		ArrayList<GiftGoodsProVO>  pro=show();
		if(pro==null) return null;
		else{
			for(int i=0;i<pro.size();i++){
				if(total>=pro.get(i).getTotalValue())
				{
					double giftvalue=cal(pro.get(i).getGiftList());
					if(value<giftvalue){
						value=giftvalue;result=pro.get(i);
					}
					
				}
			}
			return result;
		}
	}

	public static double cal(ArrayList<CommodityVO> v){
		double t=0;
		for(int i=0;i<v.size();i++){
			t+=v.get(i).getTotal();
			
		}
		return t;
	}
	public String getNewID() {
		// TODO Auto-generated method stub
		String id=null;
		ArrayList<PromotionPO> gpp=service.show(PromotionType.GIFTGOODS);
		if(gpp==null) id="001";
		else{
			int i=gpp.size();
			String date=gpp.get(i-1).getID().substring(3, 11);
			if(date.equals(getDate.getdate())){
			Double d=Double.parseDouble(gpp.get(i-1).getID().substring(13))+1;
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(3); 
		     nf.setGroupingUsed(false);
		     id=nf.format(d);}
			else id="001";
		}
		return "SP-"+getDate.getdate()+"-"+id;
	}
	
	//系统自动生成库存赠送单
	public void Excute(PromotionPO p,SaleVO vo){
		GiftGoodProPO po=(GiftGoodProPO)p;
		ArrayList<CommodityPO> clist=po.getGiftList();
	
		GiftManage  m=new GiftManage();
		m.e
	}

	
	public PromotionVO findByID(String id){
		GiftGoodProPO gpo=(GiftGoodProPO)service.find(id, PromotionType.GIFTGOODS);
		if(gpo==null) return null;
		else return poToVo(gpo);
	}
	
	
	
	
	
	public GiftGoodsProVO poToVo(GiftGoodProPO po){
		ArrayList<CommodityPO> cmp=po.getGiftList();
		GiftGoodsProVO  gpv=new GiftGoodsProVO(po.getID(),po.getStartDate(),
				po.getEndDate(),po.getLevel(),com.poTVo(cmp),po.getTotalValue());
		
		return gpv;
	}	
	
	public GiftGoodProPO voToPo(GiftGoodsProVO vo){
		ArrayList<CommodityVO> clist=vo.getGiftList();
		GiftGoodProPO  gpv=new GiftGoodProPO(vo.getId(),vo.getStartDate(),
				vo.getEndDate(),vo.getMemberlevel(),com.voTPo(clist),vo.getTotalValue());
		
		return gpv;
	}
}
