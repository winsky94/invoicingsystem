package Data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.PaymentPO;
import po.TransferItemPO;
import dataservice.financedataservice.listdataservice.PaymentDataService;
import Data.serutility.JXCFile;

public class Payment extends UnicastRemoteObject implements PaymentDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JXCFile file;
	static int num=0;
	public Payment() throws RemoteException{
		super();
		file=new JXCFile("src/main/java/payment.ser");
	}

	public int createPayment(PaymentPO po) throws RemoteException {
		file.write(po);
		num++;
		return 0;
	}
	
	public ArrayList<PaymentPO> getPayment() throws RemoteException{
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<PaymentPO> buffer=new ArrayList<PaymentPO>();
		for(Object b:a){
			PaymentPO po=(PaymentPO)b;
			buffer.add(po);
		}
		
		return buffer;
		
	}
	
	public int getNum() throws RemoteException{
		return num;
	}

	public static void main(String[] args){
		Payment a;
		try {
			a = new Payment();
			ArrayList<TransferItemPO> al=new ArrayList<TransferItemPO>();
			TransferItemPO item =new TransferItemPO("WYT",100,"He");
			al.add(item);
			a.createPayment(new PaymentPO("FKD-20141129-000001","王雅婷","王雅婷","Lucy",al,100));	
			System.out.println("Success!");

    		ArrayList<PaymentPO> al2=a.getPayment();
			System.out.println(al2.size());
			for(PaymentPO b:al2){
				ArrayList<TransferItemPO> c=b.getTransferlist();
				System.out.println(b.getID()+b.getSupplier()+b.getSeller()+b.getUser()+c.get(0).getMoney()+b.getTotalMoney());				
			}
	
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
