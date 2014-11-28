package Stock;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.stockbl.gift.GiftReceipt;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.MockGoods;
import businesslogic.stockbl.stockManage.MockStockControl;

public class AddGiftReceiptTest extends TestCase {
	private GiftReceipt giftReceipt;
	private MockStockControl stockControl;
	private MockGoods good1, good2, good3;
	private MockMember member;
	private double total;

	public void setUp() throws ParseException {
		member = new MockMember("00001", MemberType.XSS, MemberLevel.ONE, "小赵",
				100);
		good1 = new MockGoods();
		good2 = new MockGoods("01010001", "飞利浦日光灯", "SR01", 10, 200, 100);
		good3 = new MockGoods("01010002", "飞利浦日光灯", "SR02", 20, 300, 400);
		stockControl=new MockStockControl();

	}

	public void testAddGiftReceipt() throws RemoteException {
		//库存赠送人
		giftReceipt = new GiftReceipt(member);
		assertEquals(member, giftReceipt.getMember());
		//库存赠送商品
		ArrayList<Goods> testGiftReceiptList = new ArrayList<Goods>();
		good1 = good2.getGoods("01010001");
		
		giftReceipt.addGood(good1);
		total += good1.getPrice();
		giftReceipt.addGood(good3);
		total += good3.getPrice();

		testGiftReceiptList.add(good1);
		testGiftReceiptList.add(good3);
		
		assertEquals(testGiftReceiptList, giftReceipt.getGiftList());
		//库存赠送单总价
		stockControl.addGift(giftReceipt);
		assertEquals(total, stockControl.getGiftCost());
		giftReceipt.deleteGood(good3);
		total -= good3.getPrice();
		assertEquals(total, giftReceipt.getTotal());

	}
}
