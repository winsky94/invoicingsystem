package Receipt;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import po.ReceiptPO;
import dataservice.receiptdataservice.ReceiptDataService;
import dataservice.receiptdataservice.ReceiptDataService_Stub;

public class ReceiptDataService_DriverTest extends TestCase{
	private ReceiptDataService receiptdataservice;
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	public void setUp(){
		ReceiptDataService receiptdata_stub=new ReceiptDataService_Stub();
		receiptdataservice=receiptdata_stub;
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));
		
	}
	public void tearDown(){
		System.setOut(console);
	}
	public void testReceiptDatadrive() throws RemoteException{
		ReceiptPO po=new ReceiptPO();
		receiptdataservice.init();
		int resultAdd=receiptdataservice.Add(po);
		int resultMod=receiptdataservice.Modify(po);
		ReceiptPO receipt=receiptdataservice.find("SKD-20141015-00001");
		receiptdataservice.show();
		assertEquals(0,resultAdd);
		assertEquals(0,resultMod);
		assertEquals("init Success!"+line+
				"Add Receipt Success!"+line+
				"Modify Receipt Success!"+line+
				"find Receipt (id=SKD-20141015-00001) Success!"+line+
				"Show All Receipt Success!"+line,bytes.toString()
				);
	}
}
