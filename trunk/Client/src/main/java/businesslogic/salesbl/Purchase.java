package businesslogic.salesbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dataservice.salesdataservice.SalesDataService;
import vo.PurchaseVO;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.MockGoods;


public class Purchase extends Receipt {
	
	SalesDataService service;
	public Purchase() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/salesService";
	
		service=(SalesDataService)Naming.lookup(url);
	
	}
	

	
	public int AddPurchase(PurchaseVO vo){
		return service.createPurchase()
	}
	
	
	
	public PurchaseVO find(String message,String type){
		
	}
	
	public void ModifyPurchase(double total,Commodity nItem){
		int i=list.indexOf(find(nItem.getId()));
		totalValue-=total;
		list.set(i, nItem);
		totalValue+=nItem.getTotal();
		
	}
	
	public ArrayList<PurchaseVO>  show(){
		
	}

	
	private PurchasePO voToPo(PurchaseVO vo){
		
	}
	private PurchaseVo poToVo(PurchasePO po){
		
	}

	
}
