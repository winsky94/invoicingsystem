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
	JXCFile file;// 记录库存调价收入

	public StockControl() throws RemoteException {
		overOrLowFile = new JXCFile("src/main/java/overOrLowReceipt.ser");
		errorFile = new JXCFile("src/main/java/errorReceipt.ser");
		file = new JXCFile("src/main/java/primeChangeRecord.ser");
	}

	public int addStockOverOrLow(StockOverOrLowPO po) throws RemoteException {
		// TODO 自动生成的方法存根
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

	public int recordPrimeCostIncome(String primeCostIncome)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<Object> preRecordObject = new ArrayList<Object>();
		preRecordObject = file.read();
		ArrayList<String> record = new ArrayList<String>();
		for (Object o : preRecordObject) {
			record.add((String) o);
		}

		String[] newData = primeCostIncome.split(";");
		String date = newData[0];
		double money = 0;
		money = Double.parseDouble(newData[1]);
		int index = -1;
		for (int i = 0; i < record.size(); i++) {
			String preRecord = record.get(i);
			String data[] = preRecord.split(";");
			if (date.equals(data[1])) {
				money += Double.parseDouble(data[1]);
				index = i;
				break;
			}
		}

		String newRecord = date + String.valueOf(money);

		if (index == -1) {
			record.add(newRecord);
		} else {
			record.set(index, newRecord);
		}

		file.writeM(record);
		return 0;
	}

	public ArrayList<String> getPrimeCostIncome() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<Object> preRecordObject = new ArrayList<Object>();
		preRecordObject = file.read();
		ArrayList<String> record = new ArrayList<String>();
		for (Object o : preRecordObject) {
			record.add((String) o);
		}

		return record;
	}

}
