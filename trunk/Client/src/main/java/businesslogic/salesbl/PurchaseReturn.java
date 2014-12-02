package businesslogic.salesbl;

import java.rmi.Naming;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

import po.CommodityPO;
import po.PurchasePO;
import po.PurchaseReturnPO;
import vo.CommodityVO;
import vo.PurchaseReturnVO;
import vo.PurchaseVO;
import dataservice.salesdataservice.SalesDataService;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
//进货 退货单必须为逆操作，总经理只能审批通过与否
public class PurchaseReturn extends Receipt {
	private double total;

	static Commodity com;
	SalesDataService service;
	public PurchaseReturn() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/salesService";
	
		service=(SalesDataService)Naming.lookup(url);
	
	}
	public int AddPurchaseReturn(PurchaseReturnVO vo){
		return service.createPurchaseReturn(voToPo(vo));
	}
	
	
	
	public ArrayList<PurchaseReturnVO> find(String message,String type){
		
		
		ArrayList<PurchaseReturnPO> po=service.findPurchaseReturn(message, type);
		if(po==null) return null;
		else{
			ArrayList<PurchaseReturnVO> vo=new ArrayList<PurchaseReturnVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}
	
	public int ModifyPurchaseReturn(PurchaseReturnVO vo){
		return service.updatePurchaseReturn(voToPo(vo));
		
	}
	
	public ArrayList<PurchaseReturnVO>  show(){
		ArrayList<PurchaseReturnPO> po=service.showPurchaseReturn();
		if(po==null) return null;
		else{
			ArrayList<PurchaseReturnVO> vo=new ArrayList<PurchaseReturnVO>();
			for(int i=0;i<po.size();i++){
				vo.add(poToVo(po.get(i)));
			}
			
			return vo;
		}
	}

	
	private PurchaseReturnPO voToPo(PurchaseReturnVO vo){
		ArrayList<CommodityPO> puList;
		ArrayList<CommodityVO> List=vo.getPurchaseReturnList();
		
			puList=com.voTPo(List);
		PurchaseReturnPO po=new PurchaseReturnPO(vo.getId(),vo.getMemberID(),vo.getMemberName(),
				vo.getStockid(),vo.getUser(),puList,vo.getInfo(),vo.getTotalInAll(),
				vo.getStatus(),vo.getHurry());
		return po;
	}
	
	//String id,String MemName,String MemID,String user, int status,
	//String info,int hurry,ArrayList<CommodityVO> list,double total,String sid) {
	static PurchaseReturnVO poToVo(PurchaseReturnPO po){
		ArrayList<CommodityVO> puList;
		ArrayList<CommodityPO> List=po.getPurchaseReturnList();
		
			puList=com.poTVo(List);
		PurchaseReturnVO vo=new PurchaseReturnVO(po.getId(),po.getMemberName(),po.getMemberID(),po.getUserID(),
				po.getStatus(),po.getInfo(),po.getHurry(),puList,po.getTotalInAll(),po.getStockID()
				);
		return vo;
		
	}



	public String getNewID() {
		// TODO Auto-generated method stub
		String id=null;
		ArrayList<PurchaseReturnPO> po=service.showPurchaseReturn();
		if(po==null) id="00001";
		else{
			int i=po.size();
			Double d=Double.parseDouble(po.get(i-1).getId().substring(15)+1);
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(5); 
		     nf.setGroupingUsed(false);
		     id=nf.format(d);
			
		}
		return id;
	}
	//进货退货，需检查库存！
	
	public double getTotal(){
		return this.total;
	}



	

}