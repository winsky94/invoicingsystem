package Sales;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import vo.CommodityVO;
import vo.PurchaseVO;
import junit.framework.TestCase;
import businesslogic.memberbl.MockMember;
import businesslogic.receiptbl.Review;
import businesslogic.salesbl.Commodity;
import businesslogic.salesbl.MockCommodityList;
import businesslogic.salesbl.Purchase;
import businesslogic.salesbl.SaleList;
import businesslogic.stockbl.goods.MockGoods;


public class PurchaseTest extends TestCase {
	private PurchaseVO purchase1, purchase2;
	private MockCommodityList list;
	private MockGoods good;
	private MockMember member;
	private Purchase pur;
	private SaleList plist;
//	private SaleList purchaseList1, purchaseList2;

	public void setUp() throws Exception {
		member=new MockMember("140001",MemberType.XSS,MemberLevel.THREE,"金金灯堂",6000000);
		
		good = new MockGoods("00020001", "飞利浦日光灯", "SR01", 20, 200, 100);
		list = new MockCommodityList();
		list.add("00020001", "飞利浦日光灯", "SR01", 10, 100, null);
		//String id,
		//String memberName,String memberID, String stockid, String user,ArrayList<CommodityVO> purchaseList,
		//String info,double totalInAll,int status, int hurry)
		purchase1 = new PurchaseVO("JHD-20141208-00001", "金大大","JHS-00001","2", "XS-00002", null,
				"",0,0,1);
		purchase2 = new PurchaseVO("JHD-20141208-00002", "金大大","JHS-00001","2", "XS-00002", null,
				"",0,0,1);
	//	purchaseList1 = new PurchaseList();
	//	purchaseList2 = new PurchaseList();
	}

	public void testAddPromotion() throws Exception {
		// 进货单审批不通过
	//	purchase1.AddGood(good);
		pur=new Purchase();
		pur.Add(purchase1);
		Review view=new Review();
		view.Approve(purchase1.getId(), 2);
		if (purchase1.getStatus()==2) 
		{
			System.out.println("审批不通过！");
			assertEquals(20, good.getNumInStock());
			assertEquals(0.0, member.getToPay());
		}
		// 进货单审批通过执行
		//商品从界面获取
		//purchase2.AddGood(good);
		pur.Add(purchase2);
		view.Approve(purchase2.getId(), 1);
		
		if (purchase2.getStatus()==1) {
			System.out.println("审批通过");
			ArrayList<CommodityVO> list = purchase2.getPurchaseList();
			assertEquals(40, good.getNumInStock());
			member.updateToPay(member.getToPay() + purchase2.getTotalInAll());
			assertEquals(200.0, member.getToPay());
		}

	}
}
