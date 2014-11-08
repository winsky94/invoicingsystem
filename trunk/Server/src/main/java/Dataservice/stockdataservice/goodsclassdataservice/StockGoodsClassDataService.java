package Dataservice.stockdataservice.goodsclassdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.GoodsClassPO;

public interface StockGoodsClassDataService extends Remote {
	public int addGoodsClass(GoodsClassPO po) throws RemoteException;

	public int deleteGoodsClass(GoodsClassPO po) throws RemoteException;

	public int modifyGoodsClass(GoodsClassPO po) throws RemoteException;

}
