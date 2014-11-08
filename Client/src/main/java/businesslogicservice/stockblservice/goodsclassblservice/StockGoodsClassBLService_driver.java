package businesslogicservice.stockblservice.goodsclassblservice;

import vo.GoodsClassVO;

public class StockGoodsClassBLService_driver {
	public void drive(StockGoodsClassBLService_stub stockGoodsClassBLService) {
		GoodsClassVO goodsClassVO = new GoodsClassVO("日光灯", "民用灯");
		stockGoodsClassBLService.addGoodsClass(goodsClassVO);
		stockGoodsClassBLService.deleteGoodsClass(goodsClassVO);
		stockGoodsClassBLService.modifyGoodsClass(goodsClassVO);
	}

	public static void main(String[] args) {
		StockGoodsClassBLService_stub stockGoodsClassBLService = new StockGoodsClassBLService_stub();
		StockGoodsClassBLService_driver driver = new StockGoodsClassBLService_driver();
		driver.drive(stockGoodsClassBLService);
	}

}
