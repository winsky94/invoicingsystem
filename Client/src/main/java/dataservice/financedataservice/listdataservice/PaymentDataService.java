package dataservice.financedataservice.listdataservice;

import java.rmi.Remote;

import po.PaymentPO;

public interface PaymentDataService extends Remote{
	public int createPayment(PaymentPO po);
}
