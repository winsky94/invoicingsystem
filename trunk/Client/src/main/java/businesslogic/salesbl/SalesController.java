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
	public int purchase(PurchaseVO vo) {
		return 0;
	}

	public int purchaseReturn(PurchaseReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int sale(SaleVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int saleReturn(SaleReturnVO vo) {
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
	public int sendSaleReceipt(ReceiptVO vo) throws MalformedURLException, RemoteException, NotBoundException{
		String host="localhost:1099";
		String url="rmi://"+host+"/userService";
		SalesDataService service=(SalesDataService)Naming.lookup(url);
		if(service==null)
			return 1;//服务连接失败
		else{
			switch(vo.getType()){
			case SALE:
				 SalePO  salepo=saleVoToPo(vo);service.createSale(salepo);break;
			case PURCHASE:
				 PurchasePO purchasepo=purchaseVoToPo(vo);service.createPurchase(purchasepo);break;
			case PURCHASERETURN:
				
				
				
			}
			
			
		}
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
	
	
	
	

}
