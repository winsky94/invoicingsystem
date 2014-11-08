package po;

import java.util.ArrayList;
import java.util.Date;

import enumeration.ReceiptType;

public class SalePO extends ReceiptPO {
	String clerk;
	ArrayList<CommodityListPO> salesList;
	double totalYuanChu, totalZheHou, totalKeHuYingFu;
	double ZheRang, couponPrice;
	public SalePO(){
		
		
	}
	public SalePO(String clerk, ArrayList<CommodityListPO> salesList, String id,
			MemberPO member, UserPO user, Date createDate, int status,
			int hurry,String info, String stockid, double totalYuanChu,
			double totalZheHou, double totalKeHuYingFu, double ZheRang,
			double couponPrice) {
		super(id, member, user, ReceiptType.SALE, createDate, status,hurry, info,
				stockid);
		this.clerk = clerk;
		this.salesList = salesList;
		this.totalYuanChu=totalYuanChu;
		this.totalKeHuYingFu=totalKeHuYingFu;
		this.totalZheHou=totalZheHou;
		this.ZheRang=ZheRang;
		this.couponPrice=couponPrice;
	}

	public String getClerk() {
		return clerk;
	}

	public ArrayList<CommodityListPO> getSalesList() {
		return salesList;
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
