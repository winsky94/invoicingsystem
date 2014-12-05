package Data.stockdata.stockManage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.StockErrorPO;
import po.StockOverOrLowPO;
import Data.serutility.JXCFile;
import dataservice.stockdataservice.controldataservice.StockControlDataService;

public class StockControl extends UnicastRemoteObject implements
		StockControlDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JXCFile overOrLowFile;
	JXCFile errorFile;

	public StockControl() throws RemoteException {
		overOrLowFile = new JXCFile("src/main/java/overOrLowReceipt.ser");
		errorFile = new JXCFile("src/main/java/errorReceipt.ser");
	}

	public int addStockOverOrLow(StockOverOrLowPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("StockControl.addStockOverOrLow():id:" + po.getId());
		overOrLowFile.write(po);
		return 0;
	}

	public int addStockError(StockErrorPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		errorFile.write(po);
		return 0;
	}

	public ArrayList<StockOverOrLowPO> getStockOverOrLowPO()
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<StockOverOrLowPO> result = new ArrayList<StockOverOrLowPO>();
		ArrayList<Object> list = overOrLowFile.read();

		if (list != null) {
			for (Object po : list) {
				result.add((StockOverOrLowPO) po);
			}
		}

		return result;
	}

}
