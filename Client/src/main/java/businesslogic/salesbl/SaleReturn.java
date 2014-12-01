package businesslogic.salesbl;

import java.util.Date;

import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;

public class SaleReturn extends Receipt {

	public SaleReturn(String id, String memberID, String userID,
			ReceiptType type, Date date, int hurry, int status, String info) {
		super(id, memberID, userID, type, date, hurry, status, info);
		// TODO Auto-generated constructor stub
	}

}
