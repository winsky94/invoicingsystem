package Sales;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.Test;

import po.PurchasePO;
import po.PurchaseReturnPO;
import po.SalePO;
import po.SaleReturnPO;
import vo.PurchaseReturnVO;
import vo.SaleReturnVO;
import vo.SaleVO;
import dataservice.salesdataservice.SalesDataService;
import dataservice.salesdataservice.SalesDataService_stub;

public class SalesDataSevice_DriverTest extends TestCase{
	private SalesDataService s;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream beos = null;

	// --------------------------------------------
	public void setUp() {
		s = new SalesDataService_stub();
		beos = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(beos));
	}

	public void tearDown() {
		System.setOut(console);
	}

	@Test
	public void test() {
		PurchasePO pp = new PurchasePO(null, line, null, null, null, 0, 0,
				line, line, 0);
		PurchaseReturnPO prp=new PurchaseReturnPO(line, null, pp, null, 0, line, 0);
		SalePO sp=new SalePO(line, null, line, null, null, null, 0, 0, line, line, 0, 0, 0, 0, 0, 0);
		SaleReturnPO srp=new SaleReturnPO(line, null, sp, null, 0, line, 0);
		String message="";
		s.createPurchase(pp);
		s.createPurchaseReturn(prp);
		s.createSale(sp);
		s.createSaleReturn(srp);
		//
		s.updatePurchase(pp);
		s.updatePurchaseReturn(prp);
		s.updateSale(sp);
		s.updateSaleReturn(srp);
		//
		s.showPurchase();
		s.showPurchaseReturn();
		s.showSale();
		s.showSaleReturn();
		//
		s.findPurchase(message);
		s.findPurchaseReturn(message);
		s.findSale(message);
		s.findSaleReturn(message);
		//
		assertEquals("createPurchase" + line
				+ "createPurchaseReturn" + line
				+ "createSale"+ line
				+ "createSaleReturn" + line
				+ "updatePurchase" + line
				+ "updatePurchaseReturn"+ line
				+ "updateSale" + line
				+ "updateSaleReturn" + line
				+ "showPurchase" + line
				+ "showPurchaseReturn"+ line
				+ "showSale" + line
				+ "showSaleReturn" + line
				+ "findPurchase" + line
				+ "findPurchaseReturn"+ line
				+ "findSale" + line
				+ "findSaleReturn" + line,beos.toString());
	}

}