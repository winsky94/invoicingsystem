package dataservice.stockdataservice.goodsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsPO;

public interface StockGoodsDataService extends Remote {
	public int addGoods(GoodsPO po) throws RemoteException;

	public int deleteGoods(GoodsPO po) throws RemoteException;

	public int modifyGoods(GoodsPO po) throws RemoteException;

	public ArrayList<GoodsPO> findGoods(String message) throws RemoteException;

	public ArrayList<GoodsPO> showStock(String beginDate, String endDate)
			throws RemoteException;

	public ArrayList<GoodsPO> checkStock() throws RemoteException;

	public ArrayList<GoodsPO> showGoods() throws RemoteException;

	// 库存充足检查
	public boolean isEnough(String goodsID,int num) throws RemoteException;

	// 商品调价收入
	public double PrimeCostIncome() throws RemoteException;
}
