
package vo;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.CommodityList;


public class SaleReturnVO extends ReceiptVO{
	private String clerk;
	private CommodityList saleReturnList;
	private double totalOrigin, totalProDiscount, totalFinDiscount, totalToPay;
	private double moneyDiscount, couponPrice;
	public SaleReturnVO(String id,String user,SaleVO s,Date createDate, int status,
			String info,int hurry){
		super(id, s.getMemberName(),s.getMemberID(), user, ReceiptType.SALERETURN, createDate,
				status, hurry,info, s.getStockid());
		this.totalToPay=s.getTotalToPay();
		this.totalOrigin=s.getTotalOrigin();
		this.totalProDiscount=s.getTotalProDiscount();
		this.totalFinDiscount=s.getTotalFinDiscount();
		this.moneyDiscount=s.getMoneyDiscount();
		this.couponPrice=s.getCouponPrice();
		this.clerk=s.getClerk();
		this.saleReturnList=s.getSalesList();
	}
	public String getClerk() {
		return clerk;
	}
	public CommodityList getSaleReturnList() {
		return saleReturnList;
	}
	public double getTotalOrigin() {
		return totalOrigin;
	}
	public double getTotalProDiscount() {
		return totalProDiscount;
	}
	public double getTotalFinDiscount() {
		return totalFinDiscount;
	}
	public double getTotalToPay() {
		return totalToPay;
	}
	public double getMoneyDiscount() {
		return moneyDiscount;
	}
	public double getCouponPrice() {
		return couponPrice;
	}
	
}
