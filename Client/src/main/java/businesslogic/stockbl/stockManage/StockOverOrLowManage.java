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
		if (overList.size() == 0) {
			exactID += "00001";
		} else {
			String maxID;
			String tpID = overList.get(overList.size() - 1).getId();
			String tempID[] = tpID.split("-");
			maxID = tempID[2];
			for (int i = 0; i < overList.size(); i++) {
				String currnetID = overList.get(i).getId();
				String detailID[] = currnetID.split("-");
				if (maxID.compareTo(detailID[2]) < 0) {
					maxID = detailID[2];
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
		ArrayList<StockOverOrLowVO> lowList = controller.showStockLowReceipt();
		if (lowList.size() == 0) {
			exactID += "00001";
		} else {
			String maxID;
			String tpID = lowList.get(lowList.size() - 1).getId();
			String tempID[] = tpID.split("-");
			maxID = tempID[2];
			for (int i = 0; i < lowList.size(); i++) {
				String currnetID = lowList.get(i).getId();
				String detailID[] = currnetID.split("-");
				if (maxID.compareTo(detailID[2]) < 0) {
					maxID = detailID[2];
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
