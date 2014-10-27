import java.util.ArrayList;
import java.util.Date;


public class SaleReturnVO extends ReceiptVO{
	String clerk;
	ArrayList<CommodityList> saleReturnList;
	double totalYuanChu, totalZheHou, totalKeHuYingFu;
	double ZheRang, couponPrice;
	public SaleReturnVO(String id,UserVO user,SaleVO s,Date createDate, int status,
			String info){
		super(id, s.member, user, ReceiptType.SALERETURN, createDate,
				status, info, s.stockid);
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
	public ArrayList<CommodityList> getSaleReturnList() {
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
