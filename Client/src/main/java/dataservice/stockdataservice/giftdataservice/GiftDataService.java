package dataservice.stockdataservice.giftdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.GiftPO;

public interface GiftDataService extends Remote {
	public int addGift(GiftPO po) throws RemoteException;

	public int dealGift(GiftPO po) throws RemoteException;

	public double getAccount(GiftPO po) throws RemoteException;

	// 商品赠送支出
	public double giftCost() throws RemoteException;
}
