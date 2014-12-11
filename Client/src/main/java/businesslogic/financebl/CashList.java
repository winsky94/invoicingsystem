package businesslogic.financebl;

import java.rmi.Naming;
import java.text.NumberFormat;
import java.util.ArrayList;

import dataservice.financedataservice.listdataservice.CashlistDataService;
import po.CashlistPO;
import po.ClauseItemPO;
import vo.CashlistVO;
import vo.ClauseItemVO;
import vo.ReceiptVO;
import businesslogic.receiptbl.Receipt;
import businesslogic.utilitybl.getDate;
import businesslogicservice.financeblservice.listblservice.CashlistBLService;

public class CashList extends Receipt implements CashlistBLService{
	 CashlistDataService service;
	 
	 public CashList()throws Exception{
		 //   	System.setSecurityManager(new SecurityManager());
		 		String host="localhost:1099";
		 		String url="rmi://"+host+"/cashlistService";
		 		
		 		service=(CashlistDataService)Naming.lookup(url);
		     }
	 
	public String getNewID() {
	   	 String id=null;
			ArrayList<CashlistPO> po=service.getCashlist();
			if(po==null) id="00001";
			else{
				int i=po.size();
				String date=po.get(i-1).getId().substring(6, 14);
				if(date.equals(getDate.getdate())){
				Double d=Double.parseDouble(po.get(i-1).getId().substring(15))+1;
				 NumberFormat nf = NumberFormat.getInstance();
			     nf.setMinimumIntegerDigits(5); 
			     nf.setGroupingUsed(false);
			     id=nf.format(d);}
				else id="00001";
				
			}
			return "XJFYD-"+getDate.getdate()+"-"+id;
		}

	public int createCashlist(CashlistVO vo) {
		CashlistPO po=voToPo(vo);
			return service.createCashlist(po);
	}
	
	
	
	public void excute(ReceiptVO v){
		CashlistVO vo=(CashlistVO)v;
		
	}

	public ArrayList<CashlistVO> getCashlist() {
		ArrayList<CashlistPO> po;
	    po = service.getCashlist();
	    
		if(po==null) return null;
		else return poToVo(po);
		
	}
	
	public CashlistPO voToPo(CashlistVO vo){
		if(vo==null)
			return null;
		 ArrayList<ClauseItemVO> a=vo.getClauselist();
		 ArrayList<ClauseItemPO> b=new ArrayList<ClauseItemPO>();
		 ClauseItemPO po1;
		 for(int i=0;i<a.size();i++){
			 ClauseItemVO vo1=a.get(i);
			 po1=new ClauseItemPO(vo1.getName(),vo1.getMoney(),vo1.getInfo());
			 b.add(po1);
		 }
	
		CashlistPO po=new CashlistPO(vo.getId(),vo.getUser(),vo.getAccount(),b,vo.getTotalMoney(),vo.getStatus(),vo.getHurry());
		return po;
	}

	
	public static CashlistVO poToVo(CashlistPO po){
		if(po==null)
			return null;
		 ArrayList<ClauseItemPO> a=po.getClauselist();
		 ArrayList<ClauseItemVO> b=new ArrayList<ClauseItemVO>();
		 ClauseItemVO vo1;
		 for(int i=0;i<a.size();i++){
			 ClauseItemPO po1=a.get(i);
			 vo1=new ClauseItemVO(po1.getName(),po1.getMoney(),po1.getInfo());
			 b.add(vo1);
		 }
	
		 CashlistVO vo=new CashlistVO(po.getId(),po.getUserID(),po.getAccount(),b,po.getTotalMoney(),po.getStatus(),po.getHurry());
		 return vo;
	}
	
	public ArrayList<CashlistPO> voToPo(ArrayList<CashlistVO> vo){
		if(vo==null)
			return null;
		ArrayList<CashlistPO> po=new ArrayList<CashlistPO>();
		for(CashlistVO v:vo){
			CashlistPO p=voToPo(v);
			po.add(p);
		}
		return po;
	}

	public ArrayList<CashlistVO> poToVo(ArrayList<CashlistPO> po){
		if(po==null)
			return null;
		ArrayList<CashlistVO> vo=new ArrayList<CashlistVO>();
		for(CashlistPO p:po){
			CashlistVO v=poToVo(p);
			vo.add(v);
		}
		return vo;
	}
}

