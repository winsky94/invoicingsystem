package businesslogicservice.financeblservice.listblservice;

import vo.CashlistVO;
import vo.CollectionVO;
import vo.PaymentVO;
import vo.ReceiptVO;

public class FinanceListBLService_stub implements FinanceListBLService{

	public int createCollection(CollectionVO vo) {
		System.out.println("Create collection success!");
		return 0;
	}
	
	public int createPayment(PaymentVO vo) {
		System.out.println("Create payment success!");
		return 0;
	}
	
	public int createCashlist(CashlistVO vo) {
		System.out.println("Create cashlist success!");
		return 0;
	}
	
	public int createRedExtrusion(ReceiptVO vo) {
		System.out.println("Create red extrusion success!");
		return 0;
	}

	public int createRedExtrusionAndCopy(ReceiptVO vo) {
		System.out.println("Create red extrusion and copy success!");
		return 0;
	}
}
