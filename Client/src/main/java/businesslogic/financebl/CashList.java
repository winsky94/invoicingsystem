package businesslogic.financebl;

import java.text.NumberFormat;
import java.util.ArrayList;

import po.CashlistPO;
import po.PaymentPO;
import businesslogic.receiptbl.Receipt;
import businesslogic.utilitybl.getDate;

public class CashList extends Receipt{
	public String getNewID() {
	   	 String id=null;
			ArrayList<CashlistPO> po=service.getCashlist();
			if(po==null) id="00001";
			else{
				int i=po.size();
				String date=po.get(i-1).getId().substring(6, 14);
				if(date.equals(getDate.getdate())){
				Double d=Double.parseDouble(po.get(i-1).getId().substring(15))+1;
				 NumberFormat nf = NumberFormat.getInstance();
			     nf.setMinimumIntegerDigits(5); 
			     nf.setGroupingUsed(false);
			     id=nf.format(d);}
				else id="00001";
				
			}
			return "XJFYD-"+getDate.getdate()+"-"+id;
		}
}
