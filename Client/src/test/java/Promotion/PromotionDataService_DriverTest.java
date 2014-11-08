package Promotion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import po.PromotionPO;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.promotiondataservice.PromotionDataService_Stub;



public class PromotionDataService_DriverTest extends TestCase {
	private PromotionDataService promotiondataservice;
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	public void setUp(){
		PromotionDataService promotiondata_stub=new PromotionDataService_Stub();
		promotiondataservice=promotiondata_stub;
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));
		
	}
	public void tearDown(){
		System.setOut(console);
	}
	
	public void testPromotionDatadrive() throws RemoteException {
		PromotionPO po=new PromotionPO();
		promotiondataservice.init();
		int resultAdd=promotiondataservice.Add(po);
		int resultMod=promotiondataservice.Modify(po);
		PromotionPO findpo=promotiondataservice.find("CXD-20141015-00001");
		promotiondataservice.show();	
		assertEquals(0,resultAdd);
		assertEquals(0,resultMod);
		assertEquals("init Promotion Success!"+line
				+"Add Promotion Success!"+line
				+"Modify Promotion Success!"+line
				+"find Promotion (id=CXD-20141015-00001) Success!"+line
				+"Show Promotion Success!"+line,bytes.toString());
		
	}
}
