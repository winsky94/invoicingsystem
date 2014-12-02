package businesslogic.salesbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import po.PurchasePO;
import po.ReceiptPO;
import po.SalePO;
import dataservice.salesdataservice.SalesDataService;
import dataservice.userdataservice.UserDataService;
import vo.PurchaseReturnVO;
import vo.PurchaseVO;
import vo.ReceiptVO;
import vo.SaleReturnVO;
import vo.SaleVO;
import businesslogic.receiptbl.ReceiptType;
import businesslogicservice.salesblservice.SalesBLService;

public class SalesController implements SalesBLService{
	Sale sale;
	SaleReturn saleReturn;
	Purchase purchase;
	PurchaseReturn purchaseReturn;
	
	public SalesController() throws Exception{
		sale=new Sale();
		purchase=new Purchase();
		purchaseReturn=new PurchaseReturn();
		saleReturn=new SaleReturn();
	}
	public String getNewID(ReceiptType type){
		//获取当期日期变成String;
			ArrayList<ReceiptPO> po;
			String id=null;
			String d=null;
			switch(type){
			case SALE:
				id="XSD-";d=sale.getNewID();break;
			case PURCHASE:
				id="JHD-";d=purchase.getNewID();break;
			case SALERETURN:
				id="XSTHD-";d=saleReturn.getNewID();break;
			default:
				id="JHTHD-";id=purchaseReturn.getNewID();
			
				
			}
			String date=getdate()+"-";
			return id+date+d;
		
	}
	
	//通知审批
	

	
			
			
	
	public int modifySale(SaleVO vo) {
		// TODO Auto-generated method stub
		return sale.Modify(vo);
	}
	
	public int modifySaleReturn(SaleReturnVO vo) {
		// TODO Auto-generated method stub
		return saleReturn.Modify(vo);
	}

	public ArrayList<PurchaseVO> showPurchase() {
		// TODO Auto-generated method stub
		return purchase.show();
	}

	public ArrayList<PurchaseReturnVO> showPurchaseReturn() {
		// TODO Auto-generated method stub
		return purchaseReturn.show();
	}

	public ArrayList<SaleVO> showSale() {
		// TODO Auto-generated method stub
		return sale.show();
	}

	public ArrayList<SaleReturnVO> showSaleReturn() {
		// TODO Auto-generated method stub
		return saleReturn.show();
	}

	public ArrayList<PurchaseVO> findPurchase(String message,String type) {
		// TODO Auto-generated method stub
		return purchase.find(message, type);
	}

	public ArrayList<PurchaseReturnVO> findPurchaseReturn(String message,String type) {
		// TODO Auto-generated method stub
		return purchaseReturn.find(message, type);
	}

	public ArrayList<SaleVO> findSale(String message,String type) {
		// TODO Auto-generated method stub
		return sale.find(message, type);
	}

	public ArrayList<SaleReturnVO> findSaleReturn(String message,String type) {
		// TODO Auto-generated method stub
		return saleReturn.find(message, type);
	}
	
	



	public static String getdate() {
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int day=c.get(Calendar.DATE);
		String d=year+""+month+day;
	return d;
	}
	public int addPurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int addPurchaseReturn(PurchaseReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int addSale(SaleVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int addSaleReturn(SaleReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int modifyPurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int modifyPurchaseReturn(PurchaseReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
