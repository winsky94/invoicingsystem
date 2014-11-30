package dataservice.stockdataservice.goodsclassdataservice;

//客户端

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JTree;

import po.GoodsClassPO;

public interface StockGoodsClassDataService extends Remote {
	public int addGoodsClass(GoodsClassPO po) throws RemoteException;

	public int deleteGoodsClass(GoodsClassPO po) throws RemoteException;

	public int modifyGoodsClass(GoodsClassPO po) throws RemoteException;

	public ArrayList<GoodsClassPO> show() throws RemoteException;

	public String getMaxID() throws RemoteException;

	public ArrayList<GoodsClassPO> showAllPO() throws RemoteException;

	public int recordClassTree(JTree tree) throws RemoteException;

	public JTree getClassTree() throws RemoteException;
}
