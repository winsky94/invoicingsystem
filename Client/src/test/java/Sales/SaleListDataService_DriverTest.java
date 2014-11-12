package Sales;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.Test;

import po.PurchasePO;
import po.PurchaseReturnPO;
import po.SalePO;
import po.SaleReturnPO;
import dataservice.salesdataservice.SaleListDataService;
import dataservice.salesdataservice.SaleListDataService_stub;

public class SaleListDataService_DriverTest extends TestCase{
	private SaleListDataService s;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream beos = null;

	// --------------------------------------------
	public void setUp() {
		s = new SaleListDataService_stub();
		beos = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(beos));
	}

	public void tearDown() {
		System.setOut(console);
	}

	@Test
	public void test() {
		s.makeSaleList();
		//
		assertEquals("makeSaleList" + line,beos.toString());
	}

}