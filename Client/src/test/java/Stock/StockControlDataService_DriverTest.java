package Stock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import po.StockErrorPO;
import po.StockOverOrLowPO;
import dataservice.stockdataservice.controldataservice.StockControlDataService;
import dataservice.stockdataservice.controldataservice.StockControlDataService_stub;

public class StockControlDataService_DriverTest extends TestCase {
	private StockControlDataService stockControlDataService;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream bytes = null;

	public void setUp() {
		StockControlDataService stockControlDataService_stub = new StockControlDataService_stub();
		stockControlDataService = stockControlDataService_stub;
		bytes = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	public void tearDown() {
		System.setOut(console);
	}

	public void testStockGoodsDataDrive() throws RemoteException {
		StockErrorPO stockErrorPO = new StockErrorPO(null, null);
		StockOverOrLowPO stockOverOrLowPO = new po.StockOverOrLowPO(null, null,
				0, 0);
		int resultAddError = stockControlDataService
				.addStockError(stockErrorPO);
		int resultAddOverOrLow = stockControlDataService
				.addStockOverOrLow(stockOverOrLowPO);
		stockControlDataService.goodsOverIncome();
		stockControlDataService.goodsLowCost();
		stockControlDataService.checkStock();
		stockControlDataService.showStock("2014年10月1日", "2014年10月17日");
		boolean isEnough = stockControlDataService.isEnough("00001", 10);
		stockControlDataService.PrimeCostIncome();
		assertEquals(true, isEnough);

		assertEquals(0, resultAddError);
		assertEquals(0, resultAddOverOrLow);
		assertEquals("add stockError receipt in file succeed!" + line
				+ "add stockOverOrLow receipt in file succeed!" + line
				+ "return goods over income in file succeed!" + line
				+ "return goods low cost in file succeed!" + line
				+ "check stock in file succeed!" + line
				+ "show stock in file succeed!" + line
				+ "check stock is enough in file succeed!" + line
				+ "return prime cost income  in file succeed!" + line,
				bytes.toString());
	}
}
