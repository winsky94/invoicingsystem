package Receipt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.financebl.MockCollection;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.Review;
import junit.framework.TestCase;
/*
 * 总经理审批单据，并修改单据有关信息,审批不通过/通过
 * */
public class ApproveReceiptTest extends TestCase{
	private Review review;
	private Receipt collect_A,collect_B;
	private MockCollection collect;
	private MockMember member;
	
	public void setUP() throws ParseException{
		
		review=new Review();
		collect_A=new MockCollection("SKD-2014/10/15-00001");
		collect_B=new MockCollection("SKD-2014/10/15-00002");
		member=new MockMember("140001",MemberType.JHS,MemberLevel.ONE,"飞利浦",1000);
	}
	
	public void testApproveReceipt(){
		collect=(MockCollection)collect_A;
		collect.AddCollectItem("140001", 200);
		collect.AddCollectItem("140002",300);
		assertEquals(500,collect.getTotalMoney());
		review.Approve(collect, 3);//审批失败
		assertEquals("审批不通过",collect_A.getStatus());
		collect=(MockCollection)collect_B;
		collect.AddCollectItem("140001",300);
		
		
	}
}
