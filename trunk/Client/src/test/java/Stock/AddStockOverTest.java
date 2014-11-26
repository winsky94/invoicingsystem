package Stock;

import java.rmi.RemoteException;
import java.text.ParseException;

import junit.framework.TestCase;
import businesslogic.stockbl.StockOverOrLowReceipt;
import businesslogic.stockbl.goods.MockGoods;

public class AddStockOverTest extends TestCase {
	String goodsID;
	private String goodsName;
	String size;
	int num;
	int exactNum;
	int gap;
	MockGoods good;

	public void setUp() throws ParseException {
		goodsID = "01010001";
		goodsName = "飞利浦日光灯";
		size = "SR01";
		num = 100;
		exactNum = 90;
		gap = num - exactNum;
		good = new MockGoods("01010001", "飞利浦日光灯", "SR01", 10, 200, 100);
	}

	public void testAddStockOver() throws RemoteException {
		StockOverOrLowReceipt stockOverOrLowReceipt = new StockOverOrLowReceipt(
				goodsName, size, num, exactNum);
		double total = good.getGoods(goodsID).getPrice() * (num - exactNum);
		assertEquals(total,
				stockOverOrLowReceipt.getGap()
						* good.getGoods(goodsID).getPrice());
	}
}
