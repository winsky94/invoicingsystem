package businesslogicservice.stockblservice.goodsclassblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JTree;

import vo.GoodsClassVO;

public interface StockGoodsClassBLService {
	public int addGoodsClass(GoodsClassVO vo);

	public int deleteGoodsClass(GoodsClassVO vo);

	public int modifyGoodsClass(GoodsClassVO vo);

	public ArrayList<GoodsClassVO> show();

	public JTree getClassTree();

	public int recordClassTree(JTree tree) throws RemoteException;
}
