package businesslogic.stockbl.stockManage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import vo.GoodsVO;
import vo.StockOverOrLowVO;
import businesslogic.stockbl.goods.GoodsController;
import businesslogicservice.stockblservice.controlblservice.StockControlBLService;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;

public class StockOverOrLowManage {
	String goodName;
	String size;
	int num;
	int exactNum;
	double gap;

	public StockOverOrLowManage() {

	}

	public StockOverOrLowManage(String goodsName, String size, int num,
			int exactNum) {
		this.goodName = goodsName;
		this.size = size;
		this.num = num;
		this.exactNum = exactNum;
		this.gap = num - exactNum;
	}

	public double getGap() {
		return gap;
	}

	// 库存报溢单
	public int addStockOverReceipt(String id, String memberName,
			String memberID, String userID, int hurry, String info) {
		// 生成编号
		String exactID = "KCBYD-" + getDate() + "-";
		StockControlBLService controller = new StockControlController();
		ArrayList<StockOverOrLowVO> overList = controller
				.showStockOverReceipt();
		if (overList == null) {
			exactID += "00001";
		} else {
			String maxID = overList.get(overList.size() - 1).getId();
			for (int i = 0; i < overList.size(); i++) {
				if (maxID.compareTo(overList.get(i).getId()) < 0) {
					maxID = overList.get(i).getId();
				}
			}
			NumberFormat nf = new DecimalFormat("00000");
			int tp = Integer.parseInt(maxID);
			String temp = nf.format(tp + 1);
			exactID += temp;
		}

		StockOverReceipt receipt = new StockOverReceipt(exactID, memberName,
				memberID, userID, hurry, info, goodName, size, num, exactNum);
		// 向系统库存中添加商品
		StockGoodsBLService goodsController = new GoodsController();
		GoodsVO vo = goodsController.findGoods(goodName + size).get(0);
		vo.setNumInStock(exactNum);
		goodsController.modifyGoods(vo);

		return receipt.add();
	}

	// 库存报损单
	public int addStockLowReceipt(String id, String memberName,
			String memberID, String userID, int hurry, String info) {

		// 生成编号
		String exactID = "KCBSD-" + getDate() + "-";
		StockControlBLService controller = new StockControlController();
		ArrayList<StockOverOrLowVO> lowList = controller.showStockOverReceipt();
		if (lowList == null) {
			exactID += "00001";
		} else {
			String maxID = lowList.get(lowList.size() - 1).getId();
			for (int i = 0; i < lowList.size(); i++) {
				if (maxID.compareTo(lowList.get(i).getId()) < 0) {
					maxID = lowList.get(i).getId();
				}
			}
			NumberFormat nf = new DecimalFormat("00000");
			int tp = Integer.parseInt(maxID);
			String temp = nf.format(tp + 1);
			exactID += temp;
		}

		StockLowReceipt receipt = new StockLowReceipt(exactID, memberName,
				memberID, userID, hurry, info, goodName, size, num, exactNum);
		// 向系统库存中减少商品
		StockGoodsBLService goodsController = new GoodsController();
		GoodsVO vo = goodsController.findGoods(goodName + size).get(0);
		vo.setNumInStock(exactNum);

		goodsController.modifyGoods(vo);

		return receipt.add();
	}

	// 库存报警（未实现）===
	public int addStockErrorReceipt() {
		System.out.println("StockOverOrLowManage.addStockErrorReceipt():尚未实现！");
		return 0;
	}

	private String getDate() {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		String sysDatetime = fmt.format(rightNow.getTime());

		return sysDatetime;
	}

}
