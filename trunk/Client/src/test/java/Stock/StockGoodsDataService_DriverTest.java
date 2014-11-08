package Stock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import po.GoodsPO;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService_stub;

public class StockGoodsDataService_DriverTest extends TestCase {
	private StockGoodsDataService stockGoodsDataService;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream bytes = null;

	public void setUp() {
		StockGoodsDataService stockGoodsDataService_stub = new StockGoodsDataService_stub();
		stockGoodsDataService = stockGoodsDataService_stub;
		bytes = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	public void tearDown() {
		System.setOut(console);
	}

	public void testStockGoodsDataDrive() throws RemoteException {
		GoodsPO po = new GoodsPO(null, null, null, 0, 0, 0, 0, 0, 0);
		int resultAdd = stockGoodsDataService.addGoods(po);
		int resultMod = stockGoodsDataService.modifyGoods(po);
		int resultDel = stockGoodsDataService.deleteGoods(po);
		stockGoodsDataService.findGoods("00001");
		stockGoodsDataService.checkStock();
		stockGoodsDataService.showStock("2014年10月1日", "2014年10月17日");
		stockGoodsDataService.showGoods();
		boolean isEnough = stockGoodsDataService.isEnough("00001", 10);
		stockGoodsDataService.PrimeCostIncome();
		
		assertEquals(0, resultAdd);
		assertEquals(0, resultMod);
		assertEquals(0, resultDel);
		assertEquals(true, isEnough);
		assertEquals("add goods in file succeed!" + line
				+ "modify goods in file succeed!" + line
				+ "delete goods in file succeed!" + line
				+ "find goods in file succeed!" + line
				+ "check stock in file succeed!" + line
				+ "show stock in file succeed!" + line
				+ "show goods in file succeed!" + line
				+ "check stock is enough in file succeed!" + line
				+ "return prime cost income  in file succeed!" + line, bytes.toString());
	}
}
