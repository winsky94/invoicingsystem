package dataservice.financedataservice.BSLdataservice;

import po.BSLPO;
import vo.BSLVO;

public interface FinanceBSLDataService {
	public BSLPO viewBSL();
	public int export(BSLVO a);
}
