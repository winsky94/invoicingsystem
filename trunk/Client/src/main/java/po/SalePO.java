package po;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.Commodity;

//double[] discount;pro/pre/money/toaldiscount;
//double[] total; cost/origin/value/couponIncom/toPay
public class SalePO extends ReceiptPO {
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
	public double getCost(){
		return total[0];
	}
	public double getTotalValue(){
		return total[2];
	}
	public double getDiscountValue(){
		return discount[3];
	}
	
	public double[] getTotal(){
		return total;
	}
	public double[] getDiscount(){
		return discount;
	}
	public void setClerk(String clerk) {
		this.clerk = clerk;
	}
	public void setSalesList(ArrayList<CommodityPO> salesList) {
		this.salesList = salesList;
	}
	
	public void setTotalOrigin(double origin) {
		this.total[1]=origin;
	}
	
	
	public void setMoneyDiscount(double money) {
		this.discount[2]=money;
	}
	
	public void setDiscount(double d){
		this.discount[3]=d;
	}
	public void setCouponPrice(double price) {
		this.total[3]=price;
	}
	
	public void setTotal(double value){
		this.total[2]=value;
	}
	public void setCost(double c){
		this.total[0]=c;
	}
	
	public void setOrgin(double o){
		this.total[1]=o;
	}
	
	public void setToPay(double t){
		this.total[4]=t;
	}
	
	
	
	
}
