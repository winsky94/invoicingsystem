package dataservice.stockdataservice.goodsclassdataservice;

//客户端

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsClassPO;

public interface StockGoodsClassDataService extends Remote {
	public int addGoodsClass(GoodsClassPO po) ;

	public int deleteGoodsClass(GoodsClassPO po);

	public int modifyGoodsClass(GoodsClassPO po);

	public ArrayList<GoodsClassPO> show()throws RemoteException;

	public String getMaxID();
	
	public ArrayList<GoodsClassPO> showAllPO();
}
