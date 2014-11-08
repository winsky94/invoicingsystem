package Finance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import vo.CashlistVO;
import vo.CollectionVO;
import vo.PaymentVO;
import vo.ReceiptVO;
import businesslogicservice.financeblservice.listblservice.FinanceListBLService;
import businesslogicservice.financeblservice.listblservice.FinanceListBLService_stub;
import junit.framework.TestCase;

public class FinanceListBLService_DriverTest extends TestCase{

	private FinanceListBLService listblservice;
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	public void setUp(){
		FinanceListBLService listbl_stub=new FinanceListBLService_stub();
		listblservice=listbl_stub;
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));	
		System.setOut(new PrintStream(bytes));
		
	}
	public void tearDown(){
		System.setOut(console);
	}
	
	public void testPromotionDatadrive() throws RemoteException {
	    CollectionVO vo1=new CollectionVO();
	    PaymentVO vo2=new PaymentVO();
	    CashlistVO vo3=new CashlistVO();
	    ReceiptVO vo4=new ReceiptVO();
		int result1=listblservice.createCollection(vo1);
		int result2=listblservice.createPayment(vo2);
		int result3=listblservice.createCashlist(vo3);
		int result4=listblservice.createRedExtrusion(vo4);
		int result5=listblservice.createRedExtrusionAndCopy(vo4);
		assertEquals(0,result1);
		assertEquals(0,result2);
		assertEquals(0,result3);
		assertEquals(0,result4);
		assertEquals(0,result5);
		assertEquals("Create collection success!"+line
				+"Create payment success!"+line
				+"Create cashlist success!"+line
				+"Create red extrusion success!"+line
				+"Create red extrusion and copy success!"+line,bytes.toString());		
	}
	
}
