package dataservice.receiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptPO;

public class ReceiptDataService_Stub implements ReceiptDataService{

	public int Add(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Receipt Success!");
		return 0;
	}

	public int Modify(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Modify Receipt Success!");
		return 0;
	}

	public ReceiptPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find Receipt (id="+id+") Success!");
		return null;
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("init Success!");
	}

	public ArrayList<ReceiptPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Show All Receipt Success!");
		return null;
	}
	

}
