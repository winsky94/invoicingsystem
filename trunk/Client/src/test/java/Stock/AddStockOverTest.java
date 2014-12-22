package Stock;

import java.rmi.RemoteException;
import java.text.ParseException;

import junit.framework.TestCase;
import businesslogic.stockbl.goods.MockGoods;
import businesslogic.stockbl.stockManage.StockOverOrLowManage;

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
		try {
			good = new MockGoods("01010001", "飞利浦日光灯", "SR01", 10, 200, 100);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void testAddStockOver() throws RemoteException {
		StockOverOrLowManage stockOverOrLowReceipt = new StockOverOrLowManage(
				goodsName, size, num, exactNum);
		double total = 0;
		try {
			total = good.getGoods(goodsID).getPrice() * (num - exactNum);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			assertEquals(total,
					stockOverOrLowReceipt.getGap()
							* good.getGoods(goodsID).getPrice());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
