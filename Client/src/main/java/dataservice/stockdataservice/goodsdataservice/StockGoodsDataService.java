package dataservice.stockdataservice.goodsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.GoodsPO;

public interface StockGoodsDataService extends Remote {
	public int addGoods(GoodsPO po);

	public int deleteGoods(GoodsPO po)  ;

	public int modifyGoods(GoodsPO po) ;

	public ArrayList<GoodsPO> findGoods(String message) ;

	public ArrayList<GoodsPO> showGoods() ;

	public String getMaxID();

	
}
