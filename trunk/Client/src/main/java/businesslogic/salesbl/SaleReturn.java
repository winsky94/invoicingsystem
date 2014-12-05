package businesslogic.salesbl;

import java.rmi.Naming;
import java.text.NumberFormat;
import java.util.ArrayList;

import po.CommodityPO;
import po.SaleReturnPO;
import vo.CommodityVO;
import vo.SaleReturnVO;
import businesslogic.receiptbl.Receipt;
import dataservice.salesdataservice.SalesDataService;

public class SaleReturn extends Receipt {

	static Commodity com;
	SalesDataService service;
	public SaleReturn() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/salesService";
	
		service=(SalesDataService)Naming.lookup(url);
	
	}
	
	public int add(SaleReturnVO vo){
		
		return service.createSaleReturn(voToPo(vo));
	}
	
	public int Modify(SaleReturnVO vo){
		return service.updateSaleReturn(voToPo(vo));
	}
	
	public ArrayList<SaleReturnVO> find(String message,String type){
		ArrayList<SaleReturnPO> po=service.findSaleReturn(message, type);
		if(po==null) return null;
		else{
			ArrayList<SaleReturnVO> vo=new ArrayList<SaleReturnVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}

	public String getNewID() {
		// TODO Auto-generated method stub
		String id=null;
		ArrayList<SaleReturnPO> po=service.showSaleReturn();
		if(po==null) id="00001";
		else{
			int i=po.size();
			Double d=Double.parseDouble(po.get(i-1).getId().substring(15))+1;
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(5); 
		     nf.setGroupingUsed(false);
		     id=nf.format(d);
			
		}
		return id;
	}
	
	
	public ArrayList<SaleReturnVO> show(){
		
		ArrayList<SaleReturnPO> po=service.showSaleReturn();
		if(po==null) return null;
		else{
			ArrayList<SaleReturnVO> vo=new ArrayList<SaleReturnVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}
	
	
	public static SaleReturnVO poToVo(SaleReturnPO po){
		ArrayList<CommodityPO> list=po.getSalesreturnList();
		ArrayList<CommodityVO>  rList=com.poTVo(list);
		SaleReturnVO vo=new SaleReturnVO(po.getId(),po.getMemberName(),
				po.getMemberID(),po.getUserID(),po.getStatus(),po.getInfo(),
				po.getHurry(),po.getTotal(),po.getDiscount(),po.getClerk(),
				rList,po.getStockID());
		return vo;
		
	}

	public SaleReturnPO voToPo(SaleReturnVO vo){
		ArrayList<CommodityVO> list=vo.getSaleReturnList();
		ArrayList<CommodityPO>  rList=com.voTPo(list);
		SaleReturnPO po=new SaleReturnPO(vo.getClerk(),rList,vo.getId(),
				vo.getMemberID(),vo.getMemberName(),vo.getUser(),vo.getStatus(),
				vo.getHurry(),vo.getInfo(),vo.getStockid(),vo.getDiscount(),vo.getTotal());
		return po;
	}
}
