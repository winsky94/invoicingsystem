
package po;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.Commodity;



public class SaleReturnPO extends ReceiptPO{
	private String clerk;
	private ArrayList<Commodity> saleReturnList;
	private double[] total,discount;
	public SaleReturnPO(String id,String user,SalePO s,Date createDate, int status,
			String info,int hurry){
		super(id, s.getMemberName(),s.getMemberID(), user, ReceiptType.SALERETURN, createDate,
				status, hurry,info, s.getStockid());
		total=s.getTotal();
		discount=s.getDiscount();
		this.clerk=s.getClerk();
		this.saleReturnList=s.getSalesList();
	}
	public String getClerk() {
		return clerk;
	}
	public ArrayList<Commodity>  getSaleReturnList() {
		return saleReturnList;
	}
	
	
}
