package dataservice.financedataservice.listdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PaymentPO;

public class PaymentDataService_stub implements PaymentDataService{
	public int createPayment(PaymentPO po) {
		System.out.println("Create payment success!");
		return 0;
	}

	public ArrayList<PaymentPO> getPayment() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
}
