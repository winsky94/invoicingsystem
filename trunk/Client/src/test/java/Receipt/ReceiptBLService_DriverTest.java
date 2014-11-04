package Receipt;

import businesslogicservice.receiptblservice.ReceiptBLService;
import businesslogicservice.receiptblservice.ReceiptBLService_Stub;
import junit.framework.TestCase;
import vo.ReceiptVO;



public class ReceiptBLService_DriverTest extends TestCase{
	private ReceiptBLService receiptblservice;
	public void setUp(){
		ReceiptBLService receiptbl_stub=new ReceiptBLService_Stub();
		receiptblservice=receiptbl_stub;
		
	}
	
	
	public void testdrive(){
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
		assertEquals(resultAdd,0);
		assertEquals(resultMod,0);
		assertEquals(resultBat,0);
		
		
	}
	
}
