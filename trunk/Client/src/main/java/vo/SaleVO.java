package vo;

import java.util.ArrayList;

import po.ReceiptPO.ReceiptType;

//double[] discount;pro/pre/money/toaldiscount;
//double[] total; cost/origin/value/couponIncom/toPay
public class SaleVO extends ReceiptVO {
	private String clerk,operator;
	private ArrayList<CommodityVO> salesList;
	private double[] discount=new double[4];//折让类数据
	private double[] total=new double[5];//总计类数据
	private String stockid;
	public SaleVO(String clerk, ArrayList<CommodityVO> salesList, String id,
			String memberName,String memberID, String user,  int status,
			int hurry,String info, String stockid, double[] total,double[] discount) {
		super(id, memberName,memberID, user, ReceiptType.SALE, status,hurry, info)
			;
		this.clerk = clerk;
		this.salesList = salesList;
		this.total=total;
		this.discount=discount;
		this.stockid=stockid;
	}

	public String getStockid() {
		return stockid;
	}

	public String getClerk() {
		return clerk;
	}
	public ArrayList<CommodityVO> getSalesList() {
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
	
	public double getCouponIncome() {
		return total[3];
	}
	
	public double getTotalValue(){
		return total[2];
	}
	
	public double getCost(){
		return total[0];
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
	
	public void setSaleList(ArrayList<CommodityVO> list){
		this.salesList=list;
	}
}
