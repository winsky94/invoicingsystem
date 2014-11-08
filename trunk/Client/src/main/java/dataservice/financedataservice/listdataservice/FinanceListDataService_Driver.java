package dataservice.financedataservice.listdataservice;

import po.CashlistPO;
import po.CollectionPO;
import po.PaymentPO;
import vo.ReceiptVO;

public class FinanceListDataService_Driver {
	public void drive(FinanceListDataService fds){
	  	  fds.createCollection(new CollectionPO());
	  	  fds.createPayment(new PaymentPO());
	  	  fds.createCashlist(new CashlistPO());
	  	  fds.createRedExtrusion(new ReceiptVO());
		  fds.createRedExtrusionAndCopy(new ReceiptVO());
	    }
		
	    public static void main(String[] args){
	  	  FinanceListDataService fds=new FinanceListDataService_stub();
	  	  try {
	  			new FinanceListDataService_Driver().drive(fds);
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	    }
}
