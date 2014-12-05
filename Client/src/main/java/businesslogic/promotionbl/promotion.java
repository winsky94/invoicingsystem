package businesslogic.promotionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;













import dataservice.promotiondataservice.PromotionDataService;
import dataservice.salesdataservice.SalesDataService;
import businesslogicservice.promotionblservice.PromotionBLService;
import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO;
import po.PromotionPO.PromotionType;
import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;
//release 去掉？？？当前促销是否还有效？
public  class promotion implements PromotionBLService{
	
	PromotionDataService service;
	public promotion() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/promotionService";
	
		service=(PromotionDataService)Naming.lookup(url);
	
	}
	public String getNewID(PromotionType type){return null;};
	
	//发布和添加？
	public  int Add(PromotionVO vo){return 0;};
	
	public  int Modify(PromotionVO vo){return 0;};
	

	
	public PromotionVO Match(SaleVO vo){return null;};
	
	//自动生成库存赠送但
	public GiftVO Present(PromotionVO vo){
		
		return null;
	
	}
	//子类不重写
	public ArrayList<PromotionVO> Show(){
		ArrayList<PromotionPO> po=service.showAll();
		if(po==null) return null;
		else{
			ArrayList<PromotionVO> vo=new ArrayList<PromotionVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));

			return vo;
		}
		
	}
	
	//查看某条记录
	public PromotionVO show(String id){
		
		return null;
	}
	
	

	public static String getdate() {
		 Calendar rightNow = Calendar.getInstance();
	        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
	        String sysDatetime = fmt.format(rightNow.getTime());   
	return sysDatetime;
	}
	public String getNewID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PromotionVO poToVo(PromotionPO po){
		PromotionVO vo=new PromotionVO(po.getID(),po.getStartDate(),po.getEndDate(),
				po.getType(),po.getLevel());
		return vo;
	}
	public int Delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
