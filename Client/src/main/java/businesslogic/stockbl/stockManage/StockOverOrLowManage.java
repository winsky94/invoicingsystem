package businesslogic.stockbl.stockManage;

import vo.GoodsVO;
import businesslogic.stockbl.goods.GoodsController;
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
		StockOverReceipt receipt = new StockOverReceipt("", memberName,
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
		StockLowReceipt receipt = new StockLowReceipt("", memberName, memberID,
				userID, hurry, info, goodName, size, num, exactNum);
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
}
