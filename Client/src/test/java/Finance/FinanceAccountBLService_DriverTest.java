package Finance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;
import vo.AccountVO;
import businesslogicservice.financeblservice.accountblservice.FinanceAccountBLService;
import businesslogicservice.financeblservice.accountblservice.FinanceAccountBLService_stub;


public class FinanceAccountBLService_DriverTest extends TestCase{
     
	private FinanceAccountBLService accountblservice;
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	public void setUp(){
		FinanceAccountBLService accountbl_stub=new FinanceAccountBLService_stub();
		accountblservice=accountbl_stub;
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));	
	}
	
	public void tearDown(){
		System.setOut(console);
	}
	
	public void testPromotionBLDrive(){
		AccountVO vo=new AccountVO();
		int resultAdd=accountblservice.addAccount(vo);
		int resultDel=accountblservice.deleteAccount(vo);
		int resultMod=accountblservice.modifyAccount(vo);
		accountblservice.findAccount(null);
		assertEquals(0,resultAdd);
		assertEquals(0,resultDel);
		assertEquals(0,resultMod);
		assertEquals("Add Account Success!"+line
				+"Delete Account Success!"+line
				+"Modify account success!"+line
				+"Find account success!"+line,bytes.toString());		
	}
	
}

