
package po;

import java.util.ArrayList;
import java.util.Date;



public class SaleReturnPO extends ReceiptPO{
	private String clerk;
	private ArrayList<CommodityPO> saleReturnList;
	private double[] total,discount;
	public SaleReturnPO(String id,String user,SalePO s, int status,
			String info,int hurry){
		super(id, s.getMemberName(),s.getMemberID(), user, ReceiptType.SALERETURN,
				status, hurry,info, s.getStockid());
		total=s.getTotal();
		discount=s.getDiscount();
		this.clerk=s.getClerk();
		this.saleReturnList=s.getSalesList();
	}
	public String getClerk() {
		return clerk;
	}
	public ArrayList<CommodityPO>  getSaleReturnList() {
		return saleReturnList;
	}
	
	
	
}
