package dataservice.stockdataservice.controldataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.StockErrorPO;
import po.StockOverOrLowPO;

public interface StockControlDataService extends Remote {

	public int addStockOverOrLow(StockOverOrLowPO po);

	public int addStockError(StockErrorPO po);

	// // 商品报溢收入
	// public double goodsOverIncome();
	//
	// // 商品报损支出
	// public double goodsLowCost();
	//
	// public ArrayList<GoodsPO> showStock(String beginDate, String endDate);
	//
	// public ArrayList<GoodsPO> checkStock();
	//
	// // 库存充足检查
	// public boolean isEnough(String goodsID, int num);
	//
	// // 商品调价收入
	// public double PrimeCostIncome();

	// 获得所有库存报溢报损单
	public ArrayList<StockOverOrLowPO> getStockOverOrLowPO();
}
