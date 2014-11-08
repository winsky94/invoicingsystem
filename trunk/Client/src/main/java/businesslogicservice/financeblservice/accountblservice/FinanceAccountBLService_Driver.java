package businesslogicservice.financeblservice.accountblservice;

import vo.AccountVO;

public class FinanceAccountBLService_Driver {
	public void drive(FinanceAccountBLService fbs){
	   	 fbs.addAccount(new AccountVO());
	   	 fbs.deleteAccount(new AccountVO());
	   	 fbs.modifyAccount(new AccountVO());
	   	 fbs.findAccount(null);
	    }
		
	    public static void main(String args[]){
	   	 FinanceAccountBLService fbs=new FinanceAccountBLService_stub();
	   	 FinanceAccountBLService_Driver driver=new FinanceAccountBLService_Driver();
	   	 driver.drive(fbs);
	    }
}
