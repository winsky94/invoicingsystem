package dataservice.financedataservice.BSLdataservice;

import po.BSLPO;
import vo.BSLVO;

public class FinanceBSLDataService_stub implements FinanceBSLDataService{
	
	public BSLPO viewBSL() {
		System.out.println("ViewBSL success!");
		return new BSLPO();
	}

	public int export(BSLVO a) {
		System.out.println("Export businessstatementlist success!");
		return 0;
	}
	
}
