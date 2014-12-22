package Finance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import vo.CollectionVO;
import businesslogicservice.financeblservice.listblservice.CollectionBLService;
import businesslogicservice.financeblservice.listblservice.CollectionBLService_stub;
import junit.framework.TestCase;

public class FinanceListBLService_DriverTest extends TestCase{

	private CollectionBLService listblservice;
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	public void setUp(){
		CollectionBLService listbl_stub=new CollectionBLService_stub();
		listblservice=listbl_stub;
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));	
		System.setOut(new PrintStream(bytes));
		
	}
	public void tearDown(){
		System.setOut(console);
	}
	
	public void testListBLdrive() throws RemoteException {
	    CollectionVO vo1=new CollectionVO(line, line, line, line, null, 0, 0, 0);
		int result1=listblservice.createCollection(vo1);
		assertEquals(0,result1);
		assertEquals("Create collection success!"+line
                      ,bytes.toString());		
	}
	
}
