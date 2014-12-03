package businesslogicservice.salesblservice;
import java.util.ArrayList;

import po.ReceiptPO.ReceiptType;
import vo.PurchaseReturnVO;
import vo.PurchaseVO;
import vo.SaleReturnVO;
import vo.SaleVO;


public interface SalesBLService {
	public String getNewID(ReceiptType type);
	public int addPurchase(PurchaseVO vo);
	public int addPurchaseReturn(PurchaseReturnVO vo);
	public int addSale(SaleVO vo);
	public int addSaleReturn(SaleReturnVO vo);
	//
	public int modifyPurchase(PurchaseVO vo);
	public int modifyPurchaseReturn(PurchaseReturnVO vo);
	public int modifySale(SaleVO vo);
	public int modifySaleReturn(SaleReturnVO vo);
	//
	public ArrayList<PurchaseVO> showPurchase();
	public ArrayList<PurchaseReturnVO> showPurchaseReturn();
	public ArrayList<SaleVO> showSale();
	public ArrayList<SaleReturnVO> showSaleReturn();
	//
	public ArrayList<PurchaseVO> findPurchase(String message,String type);
	public ArrayList<PurchaseReturnVO> findPurchaseReturn(String message,String type);
	public ArrayList<SaleVO> findSale(String message,String type);
	public ArrayList<SaleReturnVO> findSaleReturn(String message,String type);
}
