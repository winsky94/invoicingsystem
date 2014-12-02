
package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;




public class SaleReturnVO extends ReceiptVO{
	private String clerk;
	private ArrayList<CommodityVO> saleReturnList;
	private double[] total=new double[5];
	private double[] discount=new double[4];
	private String stockid;
	public SaleReturnVO(String id,String user,SaleVO s,int status,
			String info,int hurry){
		super(id, s.getMemberName(),s.getMemberID(), user, ReceiptType.SALERETURN, 
				status, hurry,info);
		this.total=s.getTotal();
		this.discount=s.getDiscount();
		this.clerk=s.getClerk();
		this.saleReturnList=s.getSalesList();
		this.stockid=s.getStockid();
	}
	
	public SaleReturnVO(String id,String MemName,String MemID,String user,int status,
			String info,int hurry,double[] total,double[] discount,String clerk,
			ArrayList<CommodityVO> list,String sid){
		super(id, MemName,MemID, user, ReceiptType.SALERETURN, 
				status, hurry,info);
		this.total=total;
		this.discount=discount;
		this.clerk=clerk;
		this.saleReturnList=list;
		this.stockid=sid;
	}
	
	
	
	public String getStockid() {
		return stockid;
	}
	public String getClerk() {
		return clerk;
	}
	public ArrayList<CommodityVO> getSaleReturnList() {
		return saleReturnList;
	}

	public double[] getTotal() {
		return total;
	}

	public double[] getDiscount() {
		return discount;
	}
	
	
	
}
