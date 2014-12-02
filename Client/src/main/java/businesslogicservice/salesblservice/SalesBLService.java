package businesslogicservice.salesblservice;
import java.util.ArrayList;

import businesslogic.receiptbl.ReceiptType;
import vo.PurchaseReturnVO;
import vo.PurchaseVO;
import vo.ReceiptVO;
import vo.SaleReturnVO;
import vo.SaleVO;


public interface SalesBLService {
	public int addSaleReceipt (ReceiptVO vo);
	//
	public int modifySaleReceipt (ReceiptVO vo);
	//
	public ArrayList<ReceiptVO> show(ReceiptType type);
	
	public ArrayList<ReceiptVO> showAll();
	//
	public ArrayList<PurchaseVO> findPurchase(String message);
	
	public String getNewID(ReceiptType type);
}
