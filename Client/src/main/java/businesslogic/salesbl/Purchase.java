package businesslogic.salesbl;


import java.rmi.Naming;
import java.text.NumberFormat;
import java.util.ArrayList;

import po.CommodityPO;
import po.PurchasePO;
import po.ReceiptPO;
import vo.CommodityVO;
import vo.PurchaseVO;
import vo.ReceiptVO;
import businesslogic.receiptbl.Receipt;
import dataservice.salesdataservice.SalesDataService;


public class Purchase extends Receipt {
	static Commodity com;
	SalesDataService service;
	public Purchase() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/salesService";
	
		service=(SalesDataService)Naming.lookup(url);
	
	}
	

	
	public int AddPurchase(PurchaseVO vo){
		return service.createPurchase(voToPo(vo));
	}
	
	
	
	public ArrayList<PurchaseVO> find(String message,String type){
		
		
		ArrayList<PurchasePO> po=service.findPurchase(message, type);
		if(po==null) return null;
		else{
			ArrayList<PurchaseVO> vo=new ArrayList<PurchaseVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}
	
	
	public PurchaseVO find(String id){
		ReceiptPO po=service.findReceiptByID(id);
		if(po==null) return null;
		else{
			PurchasePO ppo=(PurchasePO)po;
			return poToVo(ppo);
		}
		
	}
	public int ModifyPurchase(PurchaseVO vo){
		return service.updatePurchase(voToPo(vo));
		
	}
	
	public ArrayList<PurchaseVO>  show(){
		ArrayList<PurchasePO> po=service.showPurchase();
		if(po==null) return null;
		else{
			ArrayList<PurchaseVO> vo=new ArrayList<PurchaseVO>();
			for(int i=0;i<po.size();i++){
				vo.add(poToVo(po.get(i)));
			}
			
			return vo;
		}
	}

	
	public static PurchasePO voToPo(PurchaseVO vo){
		ArrayList<CommodityPO> puList;
		ArrayList<CommodityVO> List=vo.getPurchaseList();
		
			puList=com.voTPo(List);
		PurchasePO po=new PurchasePO(vo.getId(),vo.getMemberID(),vo.getMemberName(),
				vo.getStockid(),vo.getUser(),puList,vo.getInfo(),vo.getTotalInAll(),
				vo.getStatus(),vo.getHurry());
		return po;
	}
	public static PurchaseVO poToVo(PurchasePO po){
		ArrayList<CommodityVO> puList;
		ArrayList<CommodityPO> List=po.getPurchaseList();
		
			puList=com.poTVo(List);
		PurchaseVO vo=new PurchaseVO(po.getId(),po.getMemberID(),po.getMemberName(),
				po.getStockID(),po.getUserID(),puList,po.getInfo(),po.getTotalInAll(),
				po.getStatus(),po.getHurry());
		return vo;
		
	}



	public String getNewID() {
		// TODO Auto-generated method stub
		String id=null;
		ArrayList<PurchasePO> po=service.showPurchase();
		if(po==null) id="00001";
		else{
			int i=po.size();
			Double d=Double.parseDouble(po.get(i-1).getId().substring(13))+1;
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(5); 
		     nf.setGroupingUsed(false);
		     id=nf.format(d);
			
		}
		return id;
	}

	
}
