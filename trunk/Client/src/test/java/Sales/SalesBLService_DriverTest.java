package Sales;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.Test;

import vo.PurchaseReturnVO;
import vo.PurchaseVO;
import vo.SaleReturnVO;
import vo.SaleVO;
import businesslogicservice.salesblservice.SalesBLService;
import businesslogicservice.salesblservice.SalesBLService_stub;

public class SalesBLService_DriverTest extends TestCase {
	private SalesBLService s;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream beos = null;

	// --------------------------------------------
	public void setUp() {
		s = new SalesBLService_stub();
		beos = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(beos));
	}

	public void tearDown() {
		System.setOut(console);
	}

	@Test
	public void test() {
		PurchaseVO pv = new PurchaseVO(null, line, null, null, null, null, 0, 0,
				line, line, 0);
		PurchaseReturnVO prv=new PurchaseReturnVO(line, null, pv, null, 0, line, 0);
		SaleVO sv=new SaleVO(line, null, line, null, null, null, null, 0, 0, line, line, 0, 0, 0, 0, 0);
		SaleReturnVO srv=new SaleReturnVO(line, null, sv, null, 0, line, 0);
		//
		s.purchase(pv);
		s.modifyPurchase(pv);
		s.showPurchase();
		//
		s.purchaseReturn(prv);
		s.modifyPurchaseReturn(prv);
		s.showPurchaseReturn();
		//
		s.sale(sv);
		s.modifySale(sv);
		s.showSale();
		//
		s.saleReturn(srv);
		s.modifySaleReturn(srv);
		s.showSaleReturn();
		//
		s.showSaleList();
		s.exportSaleListToExcel();
		//
		assertEquals("Purchase Successfully!"+ line
				+"Modify Purchase Successfully!"+ line
				+"showPurchase!"+ line
				+"PurchaseReturn Successfully!"+ line
				+"Modify PurchaseReturn Successfully!"+ line
				+"showPurchaseReturn!"+ line
				+"Sale Successfully!"+ line
				+"Modify Sale Successfully!"+ line
				+"showSale!"+ line
				+"SaleReturn Successfully!"+ line
				+"Modify SaleReturn Successfully!"+ line
				+"showSaleReturn!"+ line
				+"showSaleList!"+line
				+"Export to Excel!"+line,beos.toString());
		
	}

}
