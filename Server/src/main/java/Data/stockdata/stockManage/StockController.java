package Data.stockdata.stockManage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.serutility.JXCFile;
import po.GoodsPO;
import po.StockErrorPO;
import po.StockOverOrLowPO;
import dataservice.stockdataservice.controldataservice.StockControlDataService;

public class StockController extends UnicastRemoteObject implements StockControlDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JXCFile file;

	public StockController() throws RemoteException {
		super();
//		file = new JXCFile("src/main/java/goodsClass.ser");
	}

	public int addStockOverOrLow(StockOverOrLowPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int addStockError(StockErrorPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return 0;
	}

	public double goodsOverIncome() throws RemoteException {
		// TODO 自动生成的方法存根
		return 0;
	}

	public double goodsLowCost() throws RemoteException {
		// TODO 自动生成的方法存根
		return 0;
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

	public boolean isEnough(String goodsID, int num) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public double PrimeCostIncome() throws RemoteException {
		// TODO 自动生成的方法存根
		return 0;
	}

	public ArrayList<StockOverOrLowPO> getStockOverOrLowPO()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
