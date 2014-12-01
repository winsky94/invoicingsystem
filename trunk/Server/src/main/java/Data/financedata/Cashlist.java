package Data.financedata;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Data.serutility.JXCFile;
import po.CashlistPO;
import po.ClauseItemPO;
import dataservice.financedataservice.listdataservice.CashlistDataService;

public class Cashlist extends UnicastRemoteObject implements CashlistDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JXCFile file;
	static int num=0;
	public Cashlist() throws RemoteException{
		super();
		file=new JXCFile("src/main/java/cashlist.ser");
	}
	public int createCashlist(CashlistPO po) throws RemoteException {
		file.write(po);
		num++;
		return 0;
	}
	
	public ArrayList<CashlistPO> getCashlist() throws RemoteException{
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<CashlistPO> buffer=new ArrayList<CashlistPO>();
		for(Object b:a){
			CashlistPO po=(CashlistPO)b;
			buffer.add(po);
		}
		
		return buffer;
		
	}
	
	public int getNum() throws RemoteException{
		return num;
	}

	public static void main(String[] args){
		Cashlist a;
		try {
			a = new Cashlist();
			ArrayList<ClauseItemPO> al=new ArrayList<ClauseItemPO>();
			ClauseItemPO item =new ClauseItemPO("王雅婷拿去吃饭的",100,"He");
			al.add(item);
			a.createCashlist(new CashlistPO("XJFYD-20141129-000001","Lucy","王雅婷",al,100));	
			System.out.println("Success!");

    		ArrayList<CashlistPO> al2=a.getCashlist();
			System.out.println(al2.size());
			for(CashlistPO b:al2){
				ArrayList<ClauseItemPO> c=b.getClauselist();
				System.out.println(b.getID()+b.getUser()+b.getAccount()+c.get(0).getMoney()+b.getTotalMoney());				
			}
	
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
