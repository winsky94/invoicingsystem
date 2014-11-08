package Receipt;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;
import vo.ReceiptVO;
import businesslogicservice.receiptblservice.ReceiptBLService;
import businesslogicservice.receiptblservice.ReceiptBLService_Stub;



public class ReceiptBLService_DriverTest extends TestCase{
	private ReceiptBLService receiptblservice;
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	public void setUp(){
		ReceiptBLService receiptbl_stub=new ReceiptBLService_Stub();
		receiptblservice=receiptbl_stub;
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));
		
	}
	public void tearDown(){
		System.setOut(console);
	}
	
	public void testReceiptBLDrive(){
		int resultAdd=receiptblservice.Add(new ReceiptVO());
		int resultMod=receiptblservice.Modify("JHD-20141015-00001");
		if(resultMod==1) System.out.println("该单据无法修改！");
		String[] id={"SKD-20141012-00002","FKD-20141015-00003"};
		int resultBat=receiptblservice.Batch(id);
		int resultApr=receiptblservice.Approve("XJFYD-20141013-00001");
		ReceiptVO vo=new ReceiptVO();
		receiptblservice.Send(vo);
		receiptblservice.Reply("13020001");
		receiptblservice.View();
		receiptblservice.Refresh();	
		assertEquals(0,resultAdd);
		assertEquals(0,resultMod);
		assertEquals(0,resultBat);
		assertEquals("Add Receipt Success!"+line
				    +"Modify Receipt (id=JHD-20141015-00001) Success!"+line
				    +"Batch Receipt(id=SKD-20141012-00002) Success!"+line
				    +"Batch Receipt(id=FKD-20141015-00003) Success!"+line
				    +"Approve Receipt(id=XJFYD-20141013-00001) Success!"+line
				    +"Send Receipt Success!"+line
				    +"Reply to the User(id=13020001) Success!"+line
				    +"View All Receipt Success!"+line
				    +"Refresh Receipt Success!"+line
				,bytes.toString());
		
		
	}
	
}
