package Receipt;

import vo.ReceiptVO;
import dataservice.receiptdataservice.ReceiptDataService;
import businesslogicservice.receiptblservice.ReceiptBLService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/*Author:jincui
 *Date:2014/11/3
 *Description:TUS1 for ReceiptReview
 * 
 * */
public class Receipt_ATest  extends TestCase
{
	private ReceiptBLService  blService;
	private ReceiptDataService dataService;
	
	public Receipt_ATest(String method){
		super(method);
		
	}
	/*初始化*/
	public void setUp(){
		
		
	}
	
	
	/*TUS1-1*/ //单据详细信息
    public void testReceipt_1(){
        blService.View("SKD-20141015-00001");
    	
    }
    
    /*TUS1-2*///修改通过 不提交
    public void testReceipt_2(){
    	blService.Modify("SKD-20141015-00002");
    	blService.Approve("SKD-20141015-00002");
    	
    	
    }
    
    /*TUS1-3*///userid未定义 入职年份(两位)+部门(两位)+部门编号(四位) 修改通过 提交
    public void testReceipt_3(){
    	blService.Modify("SKD-20141015-00003");
    	blService.Approve("SKD-20141015-00003");
    	blService.Reply("130120002");
    	
    }
    /*TUS1-4*/ //通过且提交
    public void testReceipt_4(){
    	blService.Approve("SKD-20141015-00004");
    	blService.Reply("130120001");
    }
    
    /*TUS1-5*///审批不通过 
    public void testReceipt_5(){
    	blService.Approve("SKD-20141015-00004");
    	blService.Reply("130120001");
    }
    
}
