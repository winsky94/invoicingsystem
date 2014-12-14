package Receipt;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import po.ReceiptPO.ReceiptType;
import junit.framework.TestCase;
import vo.ReceiptVO;
import businesslogic.receiptbl.ReceiptController;
import businesslogicservice.receiptblservice.ReceiptBLService;




public class ReceiptBLService_DriverTest extends TestCase{
	private ReceiptBLService receiptblservice;
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	public void setUp() throws Exception{
		ReceiptBLService receiptbl_stub=new ReceiptController();
		receiptblservice=receiptbl_stub;
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));
		
	}
	
	public void tearDown(){
		System.setOut(console);
	}
	
	public void testReceiptBLDrive(){
		int resultAdd=receiptblservice.Add(new ReceiptVO("JHD-20141015-00001",ReceiptType.SALE,
				"JL-00001",0,1));
		int resultMod=receiptblservice.Modify("JHD-20141015-00001");
		if(resultMod==1) System.out.println("该单据无法修改！");
		String[] id={"SKD-20141012-00002","FKD-20141015-00003"};
		int resultBat=receiptblservice.Batch(id,2);
		int resultApr=receiptblservice.Approve("XJFYD-20141013-00001",1);
		ReceiptVO vo=new ReceiptVO("JHD-20141015-00001",ReceiptType.SALE,
				"JL-00001",0,1);
		receiptblservice.Send(vo);
		receiptblservice.Reply("13020001");
		receiptblservice.Refresh();
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
