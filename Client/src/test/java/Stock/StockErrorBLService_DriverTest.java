package Stock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;
import vo.StockErrorVO;
import vo.StockOverOrLowVO;
import businesslogicservice.stockblservice.errorblservice.StockErrorBLService;
import businesslogicservice.stockblservice.errorblservice.StockErrorBLService_stub;

public class StockErrorBLService_DriverTest extends TestCase {
	private StockErrorBLService stockErrorBLService;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream bytes = null;

	public void setUp() {
		StockErrorBLService stockErrorbl_stub = new StockErrorBLService_stub();
		stockErrorBLService = stockErrorbl_stub;
		bytes = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	public void tearDown() {
		System.setOut(console);
	}

	public void testStockGoodsBLDrive() {
		StockErrorVO stockErrorVO = new StockErrorVO(null, null, null, null,
				null, null);
		StockOverOrLowVO stockOverOrLowVO = new StockOverOrLowVO(null, null, 0,
				0, 0, null, null, null, null);
		int resultAddError = stockErrorBLService.addStockError(stockErrorVO);
		int resultAddOverOrLow = stockErrorBLService.addStockOverOrLow(stockOverOrLowVO);
		stockErrorBLService.goodsOverIncome();
		stockErrorBLService.goodsLowCost();
		
		assertEquals(0, resultAddError);
		assertEquals(0, resultAddOverOrLow);

		assertEquals("add stockError receipt succeed!" + line
				+"add stockOverOrLow receipt succeed!" + line 
				+"return goods over income succeed!" + line 
				+"return goods low cost succeed!" + line, bytes.toString());

	}
}
