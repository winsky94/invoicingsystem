package Data.receiptdata;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Data.financedata.Cashlist;
import Data.financedata.Collection;
import Data.financedata.Payment;
import po.CashlistPO;
import po.CollectionPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.ReceiptPO.ReceiptType;
import dataservice.receiptdataservice.ReceiptDataservice;

public class Receipt extends UnicastRemoteObject implements ReceiptDataservice{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Receipt() throws RemoteException {
		super();
	}
	
	public int Add(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ReceiptPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int Modify(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ReceiptPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public double getNum(ReceiptType type, String date) throws RemoteException {
		int num=0;
		if(type==ReceiptType.COLLECTION){
			Collection c=new Collection();
			ArrayList<CollectionPO> a=c.getCollection();
			for(CollectionPO po:a){
				String s=po.getID();
				String[] buffer=s.split("-");
				String d=buffer[1];
				if(d.equals(date));
				   num++;
			}			
		}
		else if(type==ReceiptType.PAYMENT){
			Payment c=new Payment();
			ArrayList<PaymentPO> a=c.getPayment();
			for(PaymentPO po:a){
				String s=po.getID();
				String[] buffer=s.split("-");
				String d=buffer[1];
				if(d.equals(date));
				   num++;
			}			
		}
		else if(type==ReceiptType.CASHLIST){
			Cashlist c=new Cashlist();
			ArrayList<CashlistPO> a=c.getCashlist();
			for(CashlistPO po:a){
				String s=po.getID();
				String[] buffer=s.split("-");
				String d=buffer[1];
				if(d.equals(date));
				   num++;
			}			
		}
		
		return num;
	}
      
}
