package Stock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;
import vo.GoodsVO;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService_stub;

public class StockGoodsBLService_DriverTest extends TestCase {
	private StockGoodsBLService stockGoodsBLService;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream bytes = null;

	public void setUp() {
		StockGoodsBLService stockGoodsbl_stub = new StockGoodsBLService_stub();
		stockGoodsBLService = stockGoodsbl_stub;
		bytes = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	public void tearDown() {
		System.setOut(console);
	}

	public void testStockGoodsBLDrive() {
		GoodsVO vo = new GoodsVO(null, null, null, 0, 0, 0, 0, 0);
		int resultAdd = stockGoodsBLService.addGoods(vo);
		int resultMod = stockGoodsBLService.modifyGoods(vo);
		int resultDel = stockGoodsBLService.deleteGoods(vo);
		stockGoodsBLService.findGoods("00001");
		stockGoodsBLService.checkStock();
		stockGoodsBLService.showStock("2014年10月1日", "2014年10月17日");
		stockGoodsBLService.showGoods();
		boolean isEnough = stockGoodsBLService.isEnough("00001", 10);
		stockGoodsBLService.PrimeCostIncome();

		assertEquals(0, resultAdd);
		assertEquals(0, resultMod);
		assertEquals(0, resultDel);
		assertEquals(true, isEnough);
		assertEquals("add goods succeed!" + line
				+ "modify goods succeed!"+ line 
				+ "delete goods succeed!" + line
				+ "find goods succeed!"+ line 
				+ "check stock succeed!"+ line 
				+"show stock succeed!" + line 
				+ "show goods succeed!" + line
				+ "check stock is enough succeed!"+line
				+ "return prime cost income succeed!"+line, bytes.toString());
	}
}
