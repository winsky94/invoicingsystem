package Data.stockdata.goods;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.GoodsPO;
import Data.serutility.JXCFile;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService;

public class Goods extends UnicastRemoteObject implements StockGoodsDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JXCFile file;

	public Goods() throws RemoteException {
		file = new JXCFile("src/main/java/stock.ser");
	}

	public int addGoods(GoodsPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		file.write(po);
		return 0;
	}

	public int deleteGoods(GoodsPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<Object> a = file.read();

		int i;
		for (i = 0; i < a.size(); i++) {
			GoodsPO b = (GoodsPO) a.get(i);
			if (b.getGoodsID().equals(po.getGoodsID())) {
				a.remove(i);
			}
		}

		file.writeM(a);
		return 0;
	}

	public int modifyGoods(GoodsPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<Object> a = file.read();

		int i;
		for (i = 0; i < a.size(); i++) {
			// System.out.println(i);
			GoodsPO b = (GoodsPO) a.get(i);
			if (b.getGoodsID().equals(po.getGoodsID())) {
				a.set(i, po);
			}
		}

		file.writeM(a);
		return 0;
	}

	public ArrayList<GoodsPO> findGoods(String message) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<Object> a = file.read();
		ArrayList<GoodsPO> result = new ArrayList<GoodsPO>();
		int i;
		if (a != null) {
			for (i = 0; i < a.size(); i++) {
				GoodsPO b = (GoodsPO) a.get(i);
				// 定义模糊查找的范围：编号、名称、型号(暂时)
				String tp = "" + b.getGoodsID() + b.getName() + b.getSize();
				if (tp.contains(message)) {
					result.add(b);
				}
			}
		}
		return result;
	}

	public GoodsPO findByID(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		GoodsPO result = null;
		ArrayList<Object> list = new ArrayList<Object>();
		list = file.read();
		for (int i = 0; i < list.size(); i++) {
			GoodsPO po = (GoodsPO) list.get(i);
			if (po.getGoodsID().equals(id)) {
				result = po;
				break;
			}
		}

		return result;
	}

	public ArrayList<GoodsPO> showGoods() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<GoodsPO> result = new ArrayList<GoodsPO>();
		ArrayList<Object> a = file.read();
		if (a == null) {
			return result;
		} else {
			int i;
			for (i = 0; i < a.size(); i++) {
				GoodsPO b = (GoodsPO) a.get(i);
				result.add(b);
			}

			return result;
		}
	}

	public ArrayList<GoodsPO> showStock(String beginDate, String endDate)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<GoodsPO> checkStock() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public String getMaxID() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<GoodsPO> list = showGoods();
		String result = "";
		if (list.size() != 0) {
			String[] temp = list.get(0).getGoodsID().split("-");
			result = temp[2];

			for (int i = 0; i < list.size(); i++) {
				String tp[] = list.get(i).getGoodsID().split("-");
				if (Integer.parseInt(result) < Integer.parseInt(tp[2])) {
					result = tp[2];
				}

			}
			return result;
		} else {
			return null;
		}

	}

}
