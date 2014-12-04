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
import po.PromotionPO.PromotionType;
import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;
//release 去掉？？？当前促销是否还有效？
public abstract  class  promotion implements PromotionBLService{
	
	PromotionDataService service;
	public promotion() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/promotionService";
	
		service=(PromotionDataService)Naming.lookup(url);
	
	}
	public abstract String getNewID(PromotionType type);
	
	//发布和添加？
	public abstract int Add(PromotionVO vo);
	
	public abstract int Modify(PromotionVO vo);
	
	public abstract int Delete(String id,PromotionType type);
	
	
	public abstract PromotionVO Match(SaleVO vo);
	
	//自动生成库存赠送但
	public GiftVO Present(PromotionVO vo){
		
		return null;
	
	}
	//子类不重写
	public ArrayList<PromotionVO> Show(){
		
		return null;
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
	
	
}
