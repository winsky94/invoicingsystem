package dataservice.financedataservice.listdataservice;

import po.PaymentPO;

public class PaymentDataService_stub implements PaymentDataService{
	public int createPayment(PaymentPO po) {
		System.out.println("Create payment success!");
		return 0;
	}
}
