
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
	public SaleReturnVO(String id,String user,SaleVO s,Date createDate, int status,
			String info,int hurry){
		super(id, s.getMemberName(),s.getMemberID(), user, ReceiptType.SALERETURN, createDate,
				status, hurry,info);
		this.total=s.getTotal();
		this.discount=s.getDiscount();
		this.clerk=s.getClerk();
		this.saleReturnList=s.getSalesList();
		this.stockid=s.getStockid();
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
	
	
}
