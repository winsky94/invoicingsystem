package Sales;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.Test;

import businesslogicservice.salesblservice.SaleListBLService;
import businesslogicservice.salesblservice.SaleListBLService_stub;

public class SaleListBLService_DriverTest extends TestCase{
	private SaleListBLService s;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream beos = null;

	// --------------------------------------------
	public void setUp() {
		s = new SaleListBLService_stub();
		beos = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(beos));
	}

	public void tearDown() {
		System.setOut(console);
	}

	@Test
	public void test() {
		s.showSaleList();
		s.exportSaleListToExcel();
		s.couponProfitCalc();
		s.purchaseReturnProfitCalc();
		s.totalMoneyWeGot();
		s.totalMoneyWePaid();
		assertEquals("showSaleList!"+ line
				+"Export to Excel!"+ line
				+"couponProfitCalc"+ line
				+"purchaseReturnProfitCalc"+line
				+"totalMoneyWeGot"+ line
				+"totalMoneyWePaid"+ line,beos.toString());
		
	}

}