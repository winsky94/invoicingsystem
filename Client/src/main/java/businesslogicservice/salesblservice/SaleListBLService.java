package businesslogicservice.salesblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptPO;
import vo.ReceiptVO;

public interface SaleListBLService {
	
	public ArrayList<ReceiptVO> getAllPurchase() ;
	public ArrayList<ReceiptVO> getAllSale() ;
	public ReceiptVO findReceiptByID(String ID) throws RemoteException;
	public double couponProfitCalc(String startDate,String endDate);
	public double totalMoneyWeGot(String startDate,String endDate);
	public double totalMoneyWePaid(String startDate,String endDate);
	public double purchaseReturnProfitCalc(String startDate,String endDate);
}
