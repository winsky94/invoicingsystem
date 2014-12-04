package dataservice.receiptdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptPO;
import po.ReceiptPO.ReceiptType;

public interface ReceiptDataservice extends Remote {
	public int Add(ReceiptPO po)throws RemoteException;
	public ReceiptPO addAndCopy(ReceiptPO po) throws RemoteException;
	public ReceiptPO find(String id)throws RemoteException;
	public int Modify(ReceiptPO po)throws RemoteException;
	public ArrayList<ReceiptPO> showAll()throws RemoteException;
	public double getNum(ReceiptType type,String date)throws RemoteException;
	public ArrayList<ReceiptPO> show(ReceiptType type)throws RemoteException;
}
