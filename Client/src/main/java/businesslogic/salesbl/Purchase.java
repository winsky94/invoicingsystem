package businesslogic.salesbl;


import java.rmi.Naming;


import java.util.ArrayList;

import po.CommodityPO;
import po.PurchasePO;
import dataservice.salesdataservice.SalesDataService;
import vo.CommodityVO;
import vo.PurchaseVO;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.MockGoods;


public class Purchase extends Receipt {
	Commodity com;
	SalesDataService service;
	public Purchase() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/salesService";
	
		service=(SalesDataService)Naming.lookup(url);
	
	}
	

	
	public int AddPurchase(PurchaseVO vo){
		return service.createPurchase(voToPo(vo));
	}
	
	
	
	public PurchaseVO find(String message,String type){
		
		
		return null;
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

	
	private PurchasePO voToPo(PurchaseVO vo){
		ArrayList<CommodityPO> puList=new ArrayList<CommodityPO>();
		ArrayList<CommodityVO> List=vo.getPurchaseList();
		for(int i=0;i<List.size();i++)
			puList.add(com.voToPO(List.get(i)));
		PurchasePO po=new PurchasePO(vo.getId(),vo.getMemberID(),vo.getMemberName(),
				vo.getStockid(),vo.getUser(),puList,vo.getInfo(),vo.getTotalInAll(),
				vo.getStatus(),vo.getHurry());
		return po;
	}
	private PurchaseVO poToVo(PurchasePO po){
		ArrayList<CommodityVO> puList=new ArrayList<CommodityVO>();
		ArrayList<CommodityPO> List=po.getPurchaseList();
		for(int i=0;i<List.size();i++)
			puList.add(com.poToVO(List.get(i)));
		PurchaseVO vo=new PurchaseVO(po.getId(),po.getMemberID(),po.getMemberName(),
				po.getStockID(),po.getUserID(),puList,po.getInfo(),po.getTotalInAll(),
				po.getStatus(),po.getHurry());
		return vo;
		
	}

	
}
