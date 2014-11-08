package dataservice.financedataservice.listdataservice;

import po.CashlistPO;
import po.CollectionPO;
import po.PaymentPO;
import po.ReceiptPO;

public class FinanceListDataService_stub implements FinanceListDataService{

	public int createCollection(CollectionPO po) {
		System.out.println("Create collection success!");
		return 0;
	}

	public int createPayment(PaymentPO po) {
		System.out.println("Create payment success!");
		return 0;
	}
	
	public int createCashlist(CashlistPO po) {
		System.out.println("Create cashlist success!");
		return 0;
	}
	
	public int createRedExtrusion(ReceiptPO po) {
		System.out.println("Create red extrusion success!");
		return 0;
	}

	public int createRedExtrusionAndCopy(ReceiptPO po) {
		System.out.println("Create red extrusion and copy success!");
		return 0;
	}
	
}
