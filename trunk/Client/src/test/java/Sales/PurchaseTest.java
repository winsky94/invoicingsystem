package Sales;

import java.rmi.RemoteException;
import java.text.ParseException;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.salesbl.CommodityList;
import businesslogic.salesbl.Purchase;
import businesslogic.salesbl.PurchaseList;
import businesslogic.stockbl.goods.MockGoods;

public class PurchaseTest extends TestCase {
	private Purchase purchase1, purchase2;
	private CommodityList list;
	private MockGoods good;
	private MockMember member;
	private PurchaseList purchaseList1, purchaseList2;

	public void setUp() throws ParseException {
		member = new MockMember("00001", MemberType.JHS, MemberLevel.ONE,
				"飞利浦", 100000);
		good = new MockGoods("00020001", "飞利浦日光灯", "SR01", 20, 200, 100);
		list = new CommodityList();
		list.add("00020001", "飞利浦日光灯", "SR01", 10, 100, null);
		purchase1 = new Purchase(null, null, null, null, 0, 0, null, null);
		purchase2 = new Purchase(null, null, null, null, 0, 0, null, null);
		purchaseList1 = new PurchaseList();
		purchaseList2 = new PurchaseList();
	}

	public void testAddPromotion() throws RemoteException {
		// 进货单审批不通过
		purchase1.AddGood(good);
		purchase1.setStatus(3);
		purchaseList1.AddPurchase(purchase1);
		if (purchase1.getStatus().equals("审批不通过")) {
			assertEquals(20, good.getNumInStock());
			assertEquals(0.0, member.getToPay());
		}
		// 进货单审批通过执行
		purchase2.AddGood(good);
		purchase2.setStatus(4);
		purchaseList2.AddPurchase(purchase2);
		if (purchase2.getStatus().equals("审批通过待执行")) {
			good = purchase2.createPurchase();
			assertEquals(40, good.getNumInStock());
			member.updateToPay(member.getToPay() + purchase2.getTotalValue());
			assertEquals(200.0, member.getToPay());
		}

	}
}
