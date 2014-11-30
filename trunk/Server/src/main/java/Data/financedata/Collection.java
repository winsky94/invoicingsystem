package Data.financedata;

import java.rmi.server.UnicastRemoteObject;

import po.CollectionPO;
import po.TransferItemPO;
import dataservice.financedataservice.listdataservice.CollectionDataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Data.serutility.JXCFile;

public class Collection extends UnicastRemoteObject implements CollectionDataService{
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	JXCFile file;
	static int num=0;
	public Collection() throws RemoteException{
		super();
		file=new JXCFile("src/main/java/collection.ser");
	}
	public int createCollection(CollectionPO po) throws RemoteException{
		file.write(po);
		num++;
/*		ArrayList<Object> al2=file.read();
		System.out.println(al2.size());
		for(Object a:al2){
			CollectionPO b=(CollectionPO)a;
			ArrayList<TransferItemPO> c=b.getTransferlist();
			System.out.println(b.getID()+b.getSupplier()+b.getSeller()+b.getUser()+c.get(0).getMoney()+b.getTotalMoney());
			
		}
*/
		return 0;
	}
	
	public ArrayList<CollectionPO> getCollection() throws RemoteException{
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<CollectionPO> buffer=new ArrayList<CollectionPO>();
		for(Object b:a){
			CollectionPO po=(CollectionPO)b;
			buffer.add(po);
		}
		
		return buffer;
		
	}
	
	public int getNum(){
		return num;
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
			e.printStackTrace();
		}
		
	}
}
