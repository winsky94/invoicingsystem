package po;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.CommodityList;

public class SalePO extends ReceiptPO {
	private String clerk;
	private CommodityList salesList;
	private double totalOrigin, totalProDiscount, totalFinDiscount, totalToPay;
	private double moneyDiscount, couponPrice;
	public SalePO(String clerk, CommodityList salesList, String id,
			String memberName,String memberID, String user, Date createDate, int status,
			int hurry, String info, String stockid, double totalOrigin,
			double totalProDiscount, double totalFinDiscount,
			double totalToPay, double moneyDiscount, double couponPrice) {
		super(id, memberName,memberID, user, ReceiptType.SALE, createDate, status, hurry,
				info, stockid);
		this.clerk = clerk;
		this.salesList = salesList;
		this.totalOrigin = totalOrigin;
		this.totalToPay = totalToPay;
		this.totalProDiscount = totalProDiscount;
		this.totalFinDiscount = totalFinDiscount;
		this.moneyDiscount = moneyDiscount;
		this.couponPrice = couponPrice;
	}
	public String getClerk() {
		return clerk;
	}
	public CommodityList getSalesList() {
		return salesList;
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
