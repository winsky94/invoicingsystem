package Finance;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import po.CashlistPO;
import po.CollectionPO;
import po.PaymentPO;
import po.ReceiptPO;
import dataservice.financedataservice.listdataservice.FinanceListDataService;
import dataservice.financedataservice.listdataservice.FinanceListDataService_stub;


public class FinanceListDataService_DriverTest extends TestCase{
	private FinanceListDataService listdataservice;
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	public void setUp(){
		FinanceListDataService listdata_stub=new FinanceListDataService_stub();
		listdataservice=listdata_stub;
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));	
		System.setOut(new PrintStream(bytes));
		
	}
	public void tearDown(){
		System.setOut(console);
	}
	
	public void testPromotionDatadrive() throws RemoteException {
	    CollectionPO po1=new CollectionPO();
	    PaymentPO po2=new PaymentPO();
	    CashlistPO po3=new CashlistPO();
	    ReceiptPO po4=new ReceiptPO();
		int result1=listdataservice.createCollection(po1);
		int result2=listdataservice.createPayment(po2);
		int result3=listdataservice.createCashlist(po3);
		int result4=listdataservice.createRedExtrusion(po4);
		int result5=listdataservice.createRedExtrusionAndCopy(po4);
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
