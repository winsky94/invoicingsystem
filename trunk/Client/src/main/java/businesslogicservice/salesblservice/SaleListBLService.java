package businesslogicservice.salesblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptPO;
import vo.ReceiptVO;

public interface SaleListBLService {
	
	public ArrayList<ReceiptVO> getAllPurchase() ;
	public ArrayList<ReceiptVO> getAllSale() ;
	public ReceiptVO findReceiptByID(String ID) throws RemoteException;
	public double couponProfitCalc();
	public double totalMoneyWeGot();
	public double totalMoneyWePaid();
	public double purchaseReturnProfitCalc();
}
