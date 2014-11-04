package Receipt;

import businesslogicservice.receiptblservice.ReceiptBLService;
import junit.framework.TestCase;
/*Author:JIncui
 *Date:2014-11-3
 *Description:Receit TUS2
 * 
 * */
public class Receipt_BTest extends TestCase{
	private ReceiptBLService blService;
	private String[] receiptID;
	public Receipt_BTest(String method){
		super(method);
	}
	public void setUp(){
		receiptID=new String[]{"SKD-20141016-00001","SXD-20141016-00001","JHTHD-20141016-00001","XJFYD-20141016-00001",
				"XSTHD-20141016-00001","JHD-20141016-00001","SKD-20141016-00001","FKD-20141016-00001",
				"XJFYD-20141016-00001","KCZSD-20141016-00001","KCBYD-20141016-00001",
				"KCBJD-20141016-00001","KCBSD-20141016-00001"};
		
	}
	
	/*TUS2-1*/
	public void testReceipt_1(){
		blService.Batch(receiptID);
		
	}
	
	/*TUS2-2*/
	public void testReceipt_2(){
		blService.Batch(receiptID);
		for(int i=0;i<receiptID.length;i++){
			blService.Reply(receiptID[i]);
		}
	}

}
