package Sales;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.salesbl.CommodityList;
import businesslogic.salesbl.MockPurchase;
import businesslogic.stockbl.MockGoods;

public class PurchaseTest extends TestCase {
	private MockPurchase purchase;
	private Date date;
	private DateFormat form;
	private CommodityList list;
	private MockGoods good;
	private MockMember member;

	public void setUp() throws ParseException {
		form = new SimpleDateFormat("yyyy/mm/dd");
		String s = "2014/12/10";
		date = form.parse(s);
		member=new MockMember("00001",MemberType.JHS,MemberLevel.ONE,"飞利浦",100000);
		good = new MockGoods("00020001", "飞利浦日光灯", "SR01", 20, 200, 100);
		list = new CommodityList();
		list.add("00020001", "飞利浦日光灯", "SR01", 10, 100, null);
		purchase = new MockPurchase("JHD-20141210-00001", "00001", "SR01",
				ReceiptType.PURCHASE, date, 0, 3, null, null,list);
	}

	public void testAddPromotion() throws RemoteException {
		purchase.setStatus(3);
		if (purchase.getStatus().equals("审批不通过")) {
			assertEquals(20, good.getNumInStock());
			assertEquals(0.0, member.getToPay());
		}
		
		purchase.setStatus(4);
		if (purchase.getStatus().equals("审批通过待执行")) {
			good = purchase.createPurchase();
			assertEquals(30, good.getNumInStock());
			member.updateToPay(member.getToPay()+purchase.getTotal());
			assertEquals(1000.0, member.getToPay());
		}


	}
}
