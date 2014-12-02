package businesslogic.salesbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PurchasePO;
import po.PurchaseReturnPO;
import po.ReceiptPO;
import po.ReceiptPO.ReceiptType;
import po.SalePO;
import po.SaleReturnPO;
import dataservice.salesdataservice.SalesDataService;
import vo.ReceiptVO;
import businesslogicservice.salesblservice.SaleListBLService;

public class SaleList implements SaleListBLService{
	SalesDataService service;

	public SaleList() throws Exception {
		String host="localhost:1099";
		String url="rmi://"+host+"/salesService";
	
		service=(SalesDataService)Naming.lookup(url);
	
	}
	
	
	public double couponProfitCalc(){
		//计算代金券与实际收款差额收入
		return 0.0;
	}
	
	public double purchaseReturnProfitCalc() {
		// 计算商品进货退货差价收入
		return 0.0;
	}
	public double totalMoneyWeGot(){
		//总的销售收入
		return 0.0;
	}
	public double totalMoneyWePaid(){
		//总的销售成本
		return 0.0;
	}

	public ArrayList<ReceiptVO> getAllPurchase() {
		ArrayList<ReceiptPO> po=service.getAllPurchase();
		ArrayList<ReceiptVO> vo=new ArrayList<ReceiptVO>();
		if(po==null) return null;
		else{
			for(int i=0;i<po.size();i++){
				ReceiptPO p=po.get(i);
				ReceiptVO v;
				if(p.getType()==ReceiptType.PURCHASE)
				{	PurchasePO pp=(PurchasePO)p;
						v=Purchase.poToVo(pp);}
				else{
					PurchaseReturnPO pp=(PurchaseReturnPO)p;
					 v=PurchaseReturn.poToVo(pp);}
				vo.add(v);
			}
			
			return vo;
		// TODO Auto-generated method stub
		}
	}

	public ArrayList<ReceiptVO> getAllSale() {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> po=service.getAllSale();
		ArrayList<ReceiptVO> vo=new ArrayList<ReceiptVO>();
		if(po==null) return null;
		else{
			for(int i=0;i<po.size();i++){
				ReceiptPO p=po.get(i);
				ReceiptVO v;
				if(p.getType()==ReceiptType.SALE)
				{	SalePO pp=(SalePO)p;
						v=Sale.poToVo(pp);}
				else{
					SaleReturnPO pp=(SaleReturnPO)p;
					 v=SaleReturn.poToVo(pp);}
				vo.add(v);
			}
			
			return vo;
		// TODO Auto-generated method stub
		}
	
	}

	public ReceiptVO findReceiptByID(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		ReceiptPO p=service.findReceiptByID(ID);
		if(p==null)return null;
		else{
			ReceiptVO v;
			if(p.getType()==ReceiptType.SALE)
			{SalePO po=(SalePO)p;
			v=Sale.poToVo(po);
			}else if(p.getType()==ReceiptType.PURCHASE){
				PurchasePO po=(PurchasePO)p;
				v=Purchase.poToVo(po);
			}else if(p.getType()==ReceiptType.SALERETURN){
				SaleReturnPO po=(SaleReturnPO)p;
				v=SaleReturn.poToVo(po);
			}else{
				PurchaseReturnPO po=(PurchaseReturnPO)p;
				v=PurchaseReturn.poToVo(po);
			}
			return v;
		}
		
		
	}	
}
