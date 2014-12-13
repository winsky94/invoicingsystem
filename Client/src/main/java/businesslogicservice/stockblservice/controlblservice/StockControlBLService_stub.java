package businesslogicservice.stockblservice.controlblservice;

import java.util.ArrayList;

import vo.StockErrorVO;
import vo.StockOverOrLowVO;

public class StockControlBLService_stub implements StockControlBLService {

	public int addStockOverOrLow(StockOverOrLowVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("add stockOverOrLow receipt succeed!");
		return 0;
	}

	public int addStockError(StockErrorVO vo) {
		// TODO 自动生成的方法存根
		System.out.println("add stockError receipt succeed!");
		return 0;
	}

	public double getGoodsOverIncome() {
		// TODO 自动生成的方法存根
		System.out.println("return goods over income succeed!");
		return 0;
	}

	public double getGoodsLowCost() {
		// TODO 自动生成的方法存根
		System.out.println("return goods low cost succeed!");
		return 0;
	}

	public ArrayList<ArrayList<String>> showStock(String beginDate,
			String endDate) {
		// TODO 自动生成的方法存根
		System.out.println("show stock succeed!");
		return new ArrayList<ArrayList<String>>();
	}

	public ArrayList<ArrayList<String>> checkStock() {
		// TODO 自动生成的方法存根
		System.out.println("check stock succeed!");
		return new ArrayList<ArrayList<String>>();
	}

	public boolean isEnough(String ID, int num) {
		// TODO 自动生成的方法存根
		System.out.println("check stock is enough succeed!");
		return true;
	}

	public double getPrimeCostIncome(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		System.out.println("return prime cost income succeed!");
		return 0;
	}

	public double getGiftCost() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public ArrayList<StockOverOrLowVO> showStockOverReceipt() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<StockOverOrLowVO> showStockLowReceipt() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean stockNumCheck(String goodsID) {
		// TODO 自动生成的方法存根
		return false;
	}
}
