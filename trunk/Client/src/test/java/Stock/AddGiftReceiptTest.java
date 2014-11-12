package Stock;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import junit.framework.TestCase;
import businesslogic.memberbl.Member;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.stockbl.GiftReceipt;
import businesslogic.stockbl.Goods;
import businesslogic.stockbl.MockGoods;

public class AddGiftReceiptTest extends TestCase {
	private GiftReceipt giftReceipt;
	private MockGoods good1, good2,good3;
	private Member member;
	private double total;

	public void setUp() throws ParseException {
		member=new Member("00001",MemberType.XSS,MemberLevel.ONE,"小赵","1234567890","南京大学仙林校区","220041",null,null,100,100,100,0);
		good1 = new MockGoods();
		good2 = new MockGoods("01010001", "飞利浦日光灯", "SR01", 10, 200, 100);
		good3 = new MockGoods("01010002", "飞利浦日光灯", "SR02", 20, 300, 400);
		
	}

	public void testAddGiftReceipt() throws RemoteException {
		giftReceipt = new GiftReceipt(member);
		
		assertEquals(member,giftReceipt.getMember());
		
		ArrayList<Goods> testGiftReceiptList=new ArrayList<Goods>();
		good1 = good2.getGoods("01010001");

		giftReceipt.addGood(good1);
		total+=good1.getPrice();
		giftReceipt.addGood(good3);
		total+=good3.getPrice();
		
		testGiftReceiptList.add(good1);
		testGiftReceiptList.add(good3);
		
		assertEquals(testGiftReceiptList, giftReceipt.getGiftList());
		assertEquals(total, giftReceipt.getTotal());
		
		giftReceipt.deleteGood(good3);
		total-=good3.getPrice();
		assertEquals(total, giftReceipt.getTotal());
		
	}
}
