package Stock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import po.StockErrorPO;
import po.StockOverOrLowPO;
import dataservice.stockdataservice.errordataservice.StockErrorDataService;
import dataservice.stockdataservice.errordataservice.StockErrorDataService_stub;

public class StockErrorDataService_DriverTest extends TestCase{
	private StockErrorDataService stockErrorDataService;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream bytes = null;

	public void setUp() {
		StockErrorDataService stockErrorDataService_stub = new StockErrorDataService_stub();
		stockErrorDataService = stockErrorDataService_stub;
		bytes = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	public void tearDown() {
		System.setOut(console);
	}

	public void testStockGoodsDataDrive() throws RemoteException {
		StockErrorPO stockErrorPO=new StockErrorPO(null, null);
		StockOverOrLowPO stockOverOrLowPO=new po.StockOverOrLowPO(null, null, 0, 0, 0);
		int resultAddError = stockErrorDataService.addStockError(stockErrorPO);
		int resultAddOverOrLow = stockErrorDataService.addStockOverOrLow(stockOverOrLowPO);
		stockErrorDataService.goodsOverIncome();
		stockErrorDataService.goodsLowCost();
		
		assertEquals(0, resultAddError);
		assertEquals(0, resultAddOverOrLow);
		assertEquals("add stockError receipt in file succeed!" + line
				+ "add stockOverOrLow receipt in file succeed!" + line
				+ "return goods over income in file succeed!" + line
				+ "return goods low cost in file succeed!" + line, bytes.toString());
	}
}
