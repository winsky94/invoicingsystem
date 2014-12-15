package businesslogic.salesbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.ArrayList;

import po.CommodityPO;
import po.PurchaseReturnPO;
import po.ReceiptPO;
import po.SaleReturnPO;
import vo.CommodityVO;
import vo.GoodsVO;
import vo.PurchaseReturnVO;
import vo.ReceiptVO;
import vo.SaleReturnVO;
import businesslogic.memberbl.Member;
import businesslogic.receiptbl.Receipt;
import businesslogic.stockbl.goods.GoodsController;
import businesslogic.utilitybl.getDate;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
import dataservice.salesdataservice.SalesDataService;
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
	
	public int excute(ReceiptVO v){
		// 修改库存
		
		PurchaseReturnVO vo=(PurchaseReturnVO)v;
		Member m;
		try {
			m = new Member();
			m.changeToPay(vo.getMemberID(),-vo.getTotalInAll());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		StockGoodsBLService goodsController = new GoodsController();
		ArrayList<CommodityVO> list = vo.getPurchaseReturnList();
		for (CommodityVO cvo : list) {
			try {
				GoodsVO goodsVO = goodsController.findByID(cvo.getID());
				goodsVO.setNumInStock(goodsVO.getNumInStock()
						- cvo.getNum());
				goodsController.modifyGoods(goodsVO);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
	return 0;
	}
	
	public PurchaseReturnVO find(String id) {
		ReceiptPO po = service.findReceiptByID(id);
		if (po == null)
			return null;
		else {
			PurchaseReturnPO ppo = (PurchaseReturnPO) po;
			return poToVo(ppo);
		}

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
				vo.getStockid(),vo.getPurid(),vo.getUser(),puList,vo.getInfo(),vo.getTotalInAll(),
				vo.getStatus(),vo.getHurry());
		return po;
	}
	
	//String id,String MemName,String MemID,String user, int status,
	//String info,int hurry,ArrayList<CommodityVO> list,double total,String sid) {
	public static PurchaseReturnVO poToVo(PurchaseReturnPO po){
		ArrayList<CommodityVO> puList;
		ArrayList<CommodityPO> List=po.getPurchaseReturnList();
		
			puList=com.poTVo(List);
		PurchaseReturnVO vo=new PurchaseReturnVO(po.getId(),po.getMemberName(),po.getMemberID(),po.getUserID(),
				po.getStatus(),po.getInfo(),po.getHurry(),puList,po.getTotalInAll(),po.getStockID(),po.getpurid()
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
			String date=po.get(i-1).getId().substring(6, 14);
			if(date.equals(getDate.getdate())){
			Double d=Double.parseDouble(po.get(i-1).getId().substring(15))+1;
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(5); 
		     nf.setGroupingUsed(false);
		     id=nf.format(d);}
			else id="00001";
			
		}
		return id;
	}
	//进货退货，需检查库存！
	
	public double getTotal(){
		return this.total;
	}



	

}
