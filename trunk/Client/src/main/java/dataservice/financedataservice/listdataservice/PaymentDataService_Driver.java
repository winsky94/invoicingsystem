package dataservice.financedataservice.listdataservice;

import po.PaymentPO;


public class PaymentDataService_Driver {
	public void drive(PaymentDataService fds){
	  	  fds.createPayment(new PaymentPO());
	    }
		
	    public static void main(String[] args){
	  	  PaymentDataService fds=new PaymentDataService_stub();
	  	  try {
	  			new PaymentDataService_Driver().drive(fds);
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	    }
}
