package businesslogicservice.stockblservice.goodsclassblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JTree;

import vo.GoodsClassVO;

public class StockGoodsClassBLService_stub implements StockGoodsClassBLService{

	public int addGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("add goodsClass succeed!");
		return 0;
	}

	public int deleteGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("delete goodsClass succeed!");
		return 0;
	}

	public int modifyGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("modify goodsClass succeed!");
		return 0;
	}

	public ArrayList<GoodsClassVO> show() {
		// TODO 自动生成的方法存根
		return null;
	}

	public JTree getClassTree() {
		// TODO 自动生成的方法存根
		return null;
	}

	public int recordClassTree(JTree tree) throws RemoteException {
		// TODO 自动生成的方法存根
		return 0;
	}

}
