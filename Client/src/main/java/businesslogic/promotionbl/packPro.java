package businesslogic.promotionbl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PackProPO;
import po.PromotionPO;
import po.PromotionPO.PromotionType;
import vo.PackProVO;
import vo.PromotionVO;
import vo.SaleVO;
import businesslogic.stockbl.goods.Goods;
import businesslogic.utilitybl.getDate;

//特价包促销
public class packPro extends promotion{
	
	pack pack;
	public packPro() throws Exception {
		super();
		// TODO Auto-generated constructor stub
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
		PackProVO v=(PackProVO) vo;
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
		return service.Delete(id, PromotionType.PACK);
	}

	

	@Override
	public PromotionVO Match(SaleVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNewID() {
		// TODO Auto-generated method stub
		String id=null;
		ArrayList<PromotionPO> gpp=service.show(PromotionType.PACK);
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
		return "TJB-"+getDate.getdate()+"-"+id;
	}

	public PackProPO voToPo(PackProVO vo){
		PackProPO po=new PackProPO(vo.getID(),vo.getStartDate(),vo.getEndDate(),
				vo.getMemberlevel(),pack.voToPo(vo.getPack()));
		return po;
	}
	
	
	public PackProVO poToVo(PackProPO po){
		PackProVO vo=new PackProVO(po.getID(),po.getStartDate(),po.getEndDate(),
				po.getLevel(),pack.poToVo(po.getPackList()));
		return vo;
	}
	

}
