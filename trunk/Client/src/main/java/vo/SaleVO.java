package vo;

import java.util.ArrayList;
import java.util.Date;

public class SaleVO extends ReceiptVO {
	String clerk;
	ArrayList<CommodityListVO> salesList;
	double totalYuanChu, totalZheHou, totalKeHuYingFu;
	double ZheRang, couponPrice;
	public SaleVO(){
		
		
	}
	public SaleVO(String clerk, ArrayList<CommodityListVO> salesList, String id,
			MemberVO member, UserVO user, Date createDate, int status,
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

	public ArrayList<CommodityListVO> getSalesList() {
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
