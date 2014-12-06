package businesslogic.financebl;

import java.text.NumberFormat;
import java.util.ArrayList;

import po.CollectionPO;
import po.PaymentPO;
import businesslogic.receiptbl.Receipt;
import businesslogic.utilitybl.getDate;

public class Payment extends Receipt{

	public String getNewID() {
   	 String id=null;
		ArrayList<PaymentPO> po=service.getPayment();
		if(po==null) id="00001";
		else{
			int i=po.size();
			Double d=Double.parseDouble(po.get(i-1).getId().substring(13))+1;
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(5); 
		     nf.setGroupingUsed(false);
		     id=nf.format(d);
			
		}
		return "FKD-"+getDate.getdate()+"-"+id;
	}
}
