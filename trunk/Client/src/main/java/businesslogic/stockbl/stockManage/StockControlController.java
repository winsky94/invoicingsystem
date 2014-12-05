package businesslogic.stockbl.stockManage;

import java.util.ArrayList;

import po.ReceiptPO.ReceiptType;
import vo.StockErrorVO;
import vo.StockOverOrLowVO;
import businesslogicservice.stockblservice.controlblservice.StockControlBLService;

public class StockControlController implements StockControlBLService {

	public int addStockOverOrLow(StockOverOrLowVO vo) {
		// TODO 自动生成的方法存根
		StockOverOrLowManage manage = new StockOverOrLowManage(
				vo.getGoodsName(), vo.getSize(), vo.getNum(), vo.getExactNum());
		if (vo.getType().equals(ReceiptType.STOCKOVER)) {
			return manage
					.addStockOverReceipt(vo.getId(), vo.getMemberName(),
							vo.getMemberID(), vo.getUser(), vo.getHurry(),
							vo.getInfo());
		} else {
			return manage
					.addStockLowReceipt(vo.getId(), vo.getMemberName(),
							vo.getMemberID(), vo.getUser(), vo.getHurry(),
							vo.getInfo());
		}
	}

	public int addStockError(StockErrorVO vo) {
		// TODO 自动生成的方法存根
		StockOverOrLowManage manage = new StockOverOrLowManage();
		return manage.addStockErrorReceipt();
	}

	// 获得库存报溢收入
	public double getGoodsOverIncome() {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.getGoodsOverIncome();
	}

	// 获得库存报损支出
	public double getGoodsLowCost() {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.getGoodsLowCost();
	}

	// 库存查看
	public ArrayList<String> showStock(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.showStock(beginDate, endDate);

	}

	// 库存盘点(库存均价)
	public ArrayList<ArrayList<String>> checkStock() {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.checkStock();
	}

	// 销售检查库存是否充足
	public boolean isEnough(String ID, int num) {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.isEnough(ID, num);
	}

	// 商品调价收入(未测试==)
	public double getPrimeCostIncome(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		StockManage manage=new StockManage();
		return manage.getPrimeCostIncome(beginDate, endDate);
	}

	// 获得商品赠送支出
	public double getGiftCost() {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.getGiftCost();
	}

	// 显示库存报溢单
	public ArrayList<StockOverOrLowVO> showStockOverReceipt() {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.showStockOverReceipt();
	}

	// 显示库存报损单
	public ArrayList<StockOverOrLowVO> showStockLowReceipt() {
		// TODO 自动生成的方法存根
		StockManage manage = new StockManage();
		return manage.showStockLowReceipt();
	}
}
