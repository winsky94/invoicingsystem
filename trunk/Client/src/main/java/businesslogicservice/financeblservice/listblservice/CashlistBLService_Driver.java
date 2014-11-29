package businesslogicservice.financeblservice.listblservice;

import vo.CashlistVO;

public class CashlistBLService_Driver {
	public void drive(CashlistBLService fbs){
	     fbs.createCashlist(new CashlistVO());
	    }
		
	    public static void main(String args[]){
	   	 CashlistBLService fbs=new CashlistBLService_stub();
	   	 CashlistBLService_Driver driver=new CashlistBLService_Driver();
	   	 driver.drive(fbs);
	    }
}
