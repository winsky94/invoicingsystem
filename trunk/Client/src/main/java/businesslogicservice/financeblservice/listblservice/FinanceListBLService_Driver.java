package businesslogicservice.financeblservice.listblservice;

import vo.CashlistVO;
import vo.CollectionVO;
import vo.PaymentVO;
import vo.ReceiptVO;

public class FinanceListBLService_Driver {
	public void drive(FinanceListBLService fbs){
	     fbs.createCollection(new CollectionVO());
	     fbs.createPayment(new PaymentVO());
	     fbs.createCashlist(new CashlistVO());
	     fbs.createRedExtrusion(new ReceiptVO());
		 fbs.createRedExtrusionAndCopy(new ReceiptVO());
   
	    }
		
	    public static void main(String args[]){
	   	 FinanceListBLService fbs=new FinanceListBLService_stub();
	   	 FinanceListBLService_Driver driver=new FinanceListBLService_Driver();
	   	 driver.drive(fbs);
	    }
}
