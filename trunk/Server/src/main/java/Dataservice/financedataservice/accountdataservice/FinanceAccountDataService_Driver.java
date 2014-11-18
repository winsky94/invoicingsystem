package dataservice.financedataservice.accountdataservice;

import po.AccountPO;

public class FinanceAccountDataService_Driver {
	public void drive(FinanceAccountDataService fds){
	  	  fds.addAccount(new AccountPO());
	  	  fds.deleteAccount(new AccountPO());
	  	  fds.modifyAccount(new AccountPO());
	  	  fds.findAccount(null);
	    }
		
	    public static void main(String[] args){
	  	  FinanceAccountDataService fds=new FinanceAccountDataService_stub();
	  	  try {
	  			new FinanceAccountDataService_Driver().drive(fds);
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	    }
}
