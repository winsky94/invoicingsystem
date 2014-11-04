package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionPO;

public class PromotionDataService_Stub implements PromotionDataService{

	public int Add(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Promotion Success!");
		return 0;
	}

	public int Modify(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Modify Promotion Success!");
		return 0;
	}

	public PromotionPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find Promotion (id="+id+") Success!");
		return null;
	}

	public void init() throws RemoteException {
		System.out.println("init Promotion Success!");
		// TODO Auto-generated method stub
		
	}

	public ArrayList<PromotionPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Show Promotion Success!");
		return null;
	}

}
