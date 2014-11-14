package Receipt;



import businesslogic.financebl.MockAccount;
import businesslogic.financebl.MockCollection;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.Review;
import junit.framework.TestCase;
/*
 * 总经理审批单据,审批不通过/通过,以收款单为例
 * 单据状态有五：1.草稿  2.待审批  3.审批不通过  4.审批通过待执行 5.执行完毕
 * */
public class ApproveReceiptTest extends TestCase{
	private Review review;
	private Receipt collect_A,collect_B;
	private MockCollection collect;
	private MockMember member;
	private MockAccount account;
	
	public void setUp() {
		
		review=new Review();
		account=new MockAccount("邮政储蓄","6221503000010256558",10000);
		collect_A=new MockCollection("SKD-2014/10/15-00001");
		collect_B=new MockCollection("SKD-2014/10/15-00002");
		member=new MockMember("140001",MemberType.XSS,MemberLevel.ONE,"飞利浦",1000);
		member.updateToReceive(500);
	}
	
	public void testApproveReceipt(){
		//审批，修改收款单信息
		collect=(MockCollection)collect_A;
		collect.AddCollectItem("140001", 200);
		collect.AddCollectItem("140002",300);
		assertEquals(500.0,collect.getTotalMoney());
		//审批不通过
		review.Approve(collect_A, 3);
		assertEquals("审批不通过",collect.getStatus());
		collect=(MockCollection)collect_B;
		collect.AddCollectItem("140001",300);
		//审批通过
		review.Approve(collect, 4);
		assertEquals("审批通过待执行",collect.getStatus());
		//执行单据
		collect.excute(member,account);
		assertEquals("执行完毕",collect.getStatus());
		//客户应收减少,公司账户余额增加
		MockMember mem=member.find(collect.getMemberIDByOrder(0));
		assertEquals(200.0,mem.getToReceive());	
		assertEquals(10300.0,account.getBalance());
		
	}
}
