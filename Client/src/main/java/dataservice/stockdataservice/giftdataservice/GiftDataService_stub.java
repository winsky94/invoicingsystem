package dataservice.stockdataservice.giftdataservice;

import java.rmi.RemoteException;

import po.GiftPO;

public class GiftDataService_stub implements GiftDataService{

	public int addGift(GiftPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("add gift in files succeed!");
		return 0;
	}

	public int dealGift(GiftPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("deal gift in files succeed!");
		return 0;
	}

	public double getAccount(GiftPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("get gift account in files succeed!");
		return 0;
	}

	public double giftCost() throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("return gift cost in file succeed!");
		return 0;
	}

}
