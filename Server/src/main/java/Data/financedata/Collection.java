package Data.financedata;

import java.rmi.server.UnicastRemoteObject;

import po.CollectionPO;
import po.TransferItemPO;
import dataservice.financedataservice.listdataservice.CollectionDataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Data.serutility.JXCFile;

public class Collection extends UnicastRemoteObject implements CollectionDataService{
	JXCFile file;
	
	public Collection() throws RemoteException{
		super();
		file=new JXCFile("E:/Working/invoicingsystem/trunk/Server/src/main/java/collection.ser");
	}
	public int createCollection(CollectionPO po) throws RemoteException{
		file.write(po);
		ArrayList<Object> al2=file.read();
		System.out.println(al2.size());
		for(Object a:al2){
			CollectionPO b=(CollectionPO)a;
			ArrayList<TransferItemPO> c=b.getTransferlist();
			System.out.println(b.getID()+b.getSupplier()+b.getSeller()+b.getUser()+c.get(0).getMoney()+b.getTotalMoney());
		}
		return 0;
	}

	public static void main(String[] args){
		Collection a;
		try {
			a = new Collection();
			ArrayList<TransferItemPO> al=new ArrayList<TransferItemPO>();
			TransferItemPO item =new TransferItemPO("WYT",100,"He");
			al.add(item);
			a.createCollection(new CollectionPO("SKD-20141129-000001","王雅婷","王雅婷","Lucy",al,100));	
			System.out.println("Success!");

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
