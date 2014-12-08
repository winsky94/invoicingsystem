package dataservice.stockdataservice.controldataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public interface StockControlDataService extends Remote {

	public int addStockOverOrLow(StockOverOrLowPO po);

	public int addStockError(StockErrorPO po);

	// 获得所有库存报溢报损单
	public ArrayList<StockOverOrLowPO> getStockOverOrLowPO();

	// 获得所有库存报警单
	public ArrayList<StockErrorPO> getStockErrorPO();

	// 记录库存调价收入
	public int recordPrimeCostIncome(String primeCostIncome);

	// 获得库存调价收入
	public ArrayList<String> getPrimeCostIncome();

	public String getMaxID();

	public String getErrorMaxID();

	public StockOverOrLowPO findByID(String id);

	public int getWarnnigNum();

	public int setWarningNum(int num);
}
