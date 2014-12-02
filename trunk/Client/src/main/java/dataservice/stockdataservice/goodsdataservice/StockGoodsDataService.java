package dataservice.stockdataservice.goodsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsPO;

public interface StockGoodsDataService extends Remote {
	public int addGoods(GoodsPO po);

	public int deleteGoods(GoodsPO po);

	public int modifyGoods(GoodsPO po);

	public ArrayList<GoodsPO> findGoods(String message);

	public GoodsPO findByID(String id) throws RemoteException;
	
	public ArrayList<GoodsPO> showStock(String beginDate, String endDate);

	public ArrayList<GoodsPO> checkStock();

	public String getMaxID();

	public ArrayList<GoodsPO> showGoods();
}
