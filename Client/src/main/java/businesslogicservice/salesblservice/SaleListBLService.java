package businesslogicservice.salesblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ReceiptVO;

public interface SaleListBLService {
	
	public ArrayList<ReceiptVO> getAllPurchase() ;
	public ArrayList<ReceiptVO> getAllSale() ;
	public ReceiptVO findReceiptByID(String ID) throws RemoteException;
	public double saleIncome(String startDate,String endDate);//销售收入
	public double saleCost(String startDate,String endDate);//销售成本
	public double goodsOver(String startDate,String endDate);//商品报溢收入
	public double primeCostIncome(String startDate,String endDate);//成本调价收入
	public double purchaseReturnProfitCalc(String startDate,String endDate);//进货退货差价
	public double couponProfitCalc(String startDate,String endDate);//代金券与实际收款差额收入
	public double goodsLow(String startDate,String endDate);//商品报损
	public double goodsGift(String startDate,String endDate);//商品赠出
	public double DiscountMoney(String startDate,String endDate);//折让金额
	public double GiftCouponUseCost(String startDate,String endDate);//代金券使用支出
	public double AllIncome(String startDate,String endDate);//总收入
	public double AllCost(String startDate,String endDate);//总支出
}
