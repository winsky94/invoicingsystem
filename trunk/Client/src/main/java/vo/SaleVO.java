package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;

import businesslogic.salesbl.SaleItem;
//double[] discount;pro/pre/money/toaldiscount;
//double[] total; cost/origin/value/couponIncom/toPay
public class SaleVO extends ReceiptVO {
	private String clerk,operator;
	private ArrayList<SaleItem> salesList;
	private double[] discount=new double[4];//折让类数据
	private double[] total=new double[5];//总计类数据
	public SaleVO(String clerk, ArrayList<SaleItem> salesList, String id,
			String memberName,String memberID, String user, Date createDate, int status,
			int hurry,String info, String stockid, double[] total,double[] discount) {
		super(id, memberName,memberID, user, ReceiptType.SALE, createDate, status,hurry, info,
				stockid);
		this.clerk = clerk;
		this.salesList = salesList;
		this.total=total;
		this.discount=discount;
	}
	public SaleVO(){
		
	}


	public String getClerk() {
		return clerk;
	}
	public ArrayList<SaleItem> getSalesList() {
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
	public void setTotal(double[] total){
		this.total=total;
	}
	
	public void setDiscount(double[] discount){
		this.discount=discount;
	}
	
	public void setSaleList(ArrayList<SaleItem> list){
		this.salesList=list;
	}
}
