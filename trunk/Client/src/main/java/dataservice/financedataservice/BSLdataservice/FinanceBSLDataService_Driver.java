package dataservice.financedataservice.BSLdataservice;

import vo.BSLVO;


public class FinanceBSLDataService_Driver {
	public void drive(FinanceBSLDataService fds){
	  	  fds.viewBSL();
	      fds.export(new BSLVO());
	    }
		
	    public static void main(String[] args){
	  	  FinanceBSLDataService fds=new FinanceBSLDataService_stub();
	  	  try {
	  			new FinanceBSLDataService_Driver().drive(fds);
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	    }
}
