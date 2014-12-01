package businesslogic.salesbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

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

public class SalesController implements SalesBLService {
	Sale sale;
	SaleReturn saleReturn;
	Purchase purchase;
	PurchaseReturn purchaseReturn;
	
	public SalesController(){
		sale=new Sale();
		purchase=new Purchase();
		purchaseReturn=new PurchaseReturn();
		saleReturn=new SaleReturn();
	}
	public String getNewID(ReceiptType type){
		
		return null;
		
	}
	
	//通知审批
	public int addSaleReceipt(ReceiptVO vo){
		int result;
		switch(vo.getType()){
		case SALE:
			result=
		}
		return 0;
		
	}
	
	public int ModifySaleReceipt(ReceiptVO vo ){
		return 0;
		
	}

	
			
			
	
	public int modifySale(SaleVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifySaleReturn(SaleReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<PurchaseVO> showPurchase() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PurchaseReturnVO> showPurchaseReturn() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SaleVO> showSale() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SaleReturnVO> showSaleReturn() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PurchaseVO> findPurchase(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PurchaseReturnVO> findPurchaseReturn(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SaleVO> findSale(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SaleReturnVO> findSaleReturn(String message) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public SalePO saleVoToPo(ReceiptVO VO){
		SaleVO vo=(SaleVO)VO;
		SalePO po=new SalePO(vo.getClerk(),vo.getSalesList(),vo.getId(),
				vo.getMemberName(),vo.getMemberID(),vo.getUser(),vo.getCreateDate(),
				vo.getStatus(),vo.getHurry(),vo.getInfo(),vo.getStockid(),vo.getDiscount(),vo.getTotal());
		
		return po;
		
	}
	
	public PurchasePO purchaseVoToPo(ReceiptVO VO){
		PurchaseVO vo=(PurchaseVO)VO;
		PurchasePO po=new PurchasePO(vo.getPurchaseList(),vo.getId(),
				vo.getMemberName(),vo.getMemberID(),vo.getUser(),vo.getCreateDate(),
				vo.getStatus(),vo.getHurry(),vo.getInfo(),vo.getStockid(),vo.getTotalInAll());
		
		return po;
	}

	public int modifySaleReceipt(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ReceiptVO> show(ReceiptType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ReceiptVO> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public double couponProfitCalc() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double totalMoneyWeGot() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double totalMoneyWePaid() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double purchaseReturnProfitCalc() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
