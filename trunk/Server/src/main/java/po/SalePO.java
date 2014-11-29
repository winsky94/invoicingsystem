package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import Data.receiptdata.ReceiptType;


public class SalePO extends ReceiptPO implements Serializable{
	private String clerk;
	private ArrayList<CommodityPO> salesList;
	private double[] discount=new double[4];//折让类数据
	private double[] total=new double[5];//总计类数据
	public SalePO(String clerk, ArrayList<CommodityPO> salesList, String id,
			String memberName,String memberID, String user, Date createDate, int status,
			int hurry, String info, String stockid, double[] discount,double[] total) {
		super(id, memberName,memberID, user, ReceiptType.SALE, status, hurry,
				info, stockid);
		this.clerk = clerk;
		this.salesList = salesList;
		this.discount=discount;
		this.total=total;
	}
	public String getClerk() {
		return clerk;
	}
	public ArrayList<CommodityPO> getSalesList() {
		return salesList;
	}
	public double getTotalOrigin() {
		return total[1];
	}
	public double getProDiscount() {
		return discount[0];
	}
	public double getPreDiscount() {
		return discount[1];
	}
	public double getToPay() {
		return total[4];
	}
	public double getMoneyDiscount() {
		return discount[2];
	}
	public double getCouponPrice() {
		return total[3];
	}
	
	public double[] getTotal(){
		return total;
	}
	public double[] getDiscount(){
		return discount;
	}
	

}
