package businesslogicservice.salesblservice;
import java.util.ArrayList;

import vo.PurchaseReturnVO;
import vo.PurchaseVO;
import vo.ReceiptVO;
import vo.SaleReturnVO;
import vo.SaleVO;


public interface SalesBLService {
	public int purchase (PurchaseVO vo);
	public int purchaseReturn (PurchaseReturnVO vo);
	public int sale (SaleVO vo);
	public int saleReturn (SaleReturnVO vo);
	//
	public int modifyPurchase (PurchaseVO vo);
	public int modifyPurchaseReturn (PurchaseReturnVO vo);
	public int modifySale (SaleVO vo);
	public int modifySaleReturn (SaleReturnVO vo);
	//
	public ArrayList<PurchaseVO> showPurchase();
	public ArrayList<PurchaseReturnVO> showPurchaseReturn();
	public ArrayList<SaleVO> showSale();
	public ArrayList<SaleReturnVO> showSaleReturn();
	//
	public ArrayList<PurchaseVO> findPurchase(String message);
	public ArrayList<PurchaseReturnVO> findPurchaseReturn(String message);
	public ArrayList<SaleVO> findSale(String message);
	public ArrayList<SaleReturnVO> findSaleReturn(String message);
}