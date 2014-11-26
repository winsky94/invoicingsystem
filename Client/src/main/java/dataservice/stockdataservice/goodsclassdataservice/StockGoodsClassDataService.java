package dataservice.stockdataservice.goodsclassdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.GoodsClassPO;

public interface StockGoodsClassDataService extends Remote {
	public int addGoodsClass(GoodsClassPO po);

	public int deleteGoodsClass(GoodsClassPO po);

	public int modifyGoodsClass(GoodsClassPO po);

	public ArrayList<GoodsClassPO> show();

	public String getMaxID();

}
