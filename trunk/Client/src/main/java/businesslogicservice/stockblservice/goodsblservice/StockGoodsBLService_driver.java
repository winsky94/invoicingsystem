package businesslogicservice.stockblservice.goodsblservice;

import vo.GoodsVO;

public class StockGoodsBLService_driver {
	public void drive(StockGoodsBLService_stub stockGoodsBLService) {
		GoodsVO goodsVO = new GoodsVO("00001", "飞利浦日光灯", "SR01", 10, 100, 150,
				100, 150);

		stockGoodsBLService.addGoods(goodsVO);
		stockGoodsBLService.deleteGoods(goodsVO);
		stockGoodsBLService.modifyGoods(goodsVO);
		stockGoodsBLService.findGoods("00001");
		stockGoodsBLService.showGoods();
		stockGoodsBLService.checkStock();
		stockGoodsBLService.showStock("2014年10月1日", "2014年10月17日");
		stockGoodsBLService.isEnough("00001", 10);
		stockGoodsBLService.PrimeCostIncome();

	}

	public static void main(String[] args) {
		StockGoodsBLService_stub stockGoodsBLService = new StockGoodsBLService_stub();
		StockGoodsBLService_driver driver = new StockGoodsBLService_driver();
		driver.drive(stockGoodsBLService);
	}
}
