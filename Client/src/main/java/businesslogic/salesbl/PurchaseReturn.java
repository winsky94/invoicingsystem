package businesslogic.salesbl;

import java.util.Date;

import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
//进货 退货单必须为逆操作，总经理只能审批通过与否
public class PurchaseReturn extends Receipt {
	private double total;

	public PurchaseReturn(String id, String memberID, String userID,
			ReceiptType type, Date date, int hurry, int status, String info,
			String sid) {
		super(id, memberID, userID, type, date, hurry, status, info, sid);
		// TODO Auto-generated constructor stub
	}
	
	//进货退货，需检查库存！
	
	public double getTotal(){
		return this.total;
	}

}
