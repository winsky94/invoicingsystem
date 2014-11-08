
package po;

import java.util.ArrayList;
import java.util.Date;

import Data.receiptdata.ReceiptType;


public class SaleReturnPO extends ReceiptPO{
	String clerk;
	ArrayList<CommodityListPO> saleReturnList;
	double totalYuanChu, totalZheHou, totalKeHuYingFu;
	double ZheRang, couponPrice;
	public SaleReturnPO(String id,UserPO user,SalePO s,Date createDate, int status,
			String info,int hurry){
		super(id, s.member, user, ReceiptType.SALERETURN, createDate,
				status, hurry,info, s.stockid);
		this.totalKeHuYingFu=s.totalKeHuYingFu;
		this.totalYuanChu=s.totalYuanChu;
		this.totalZheHou=s.totalZheHou;
		this.ZheRang=s.ZheRang;
		this.couponPrice=s.couponPrice;
		this.clerk=s.clerk;
		this.saleReturnList=s.salesList;
	}
	public String getClerk() {
		return clerk;
	}
	public ArrayList<CommodityListPO> getSaleReturnList() {
		return saleReturnList;
	}
	public double getTotalYuanChu() {
		return totalYuanChu;
	}
	public double getTotalZheHou() {
		return totalZheHou;
	}
	public double getTotalKeHuYingFu() {
		return totalKeHuYingFu;
	}
	public double getZheRang() {
		return ZheRang;
	}
	public double getCouponPrice() {
		return couponPrice;
	}
}
