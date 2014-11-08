package Stock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import po.GiftPO;
import dataservice.stockdataservice.giftdataservice.GiftDataService;
import dataservice.stockdataservice.giftdataservice.GiftDataService_stub;

public class GiftDataService_DriverTest extends TestCase{
	private GiftDataService giftDataService;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream bytes = null;

	public void setUp() {
		GiftDataService giftDataService_stub = new GiftDataService_stub();
		giftDataService = giftDataService_stub;
		bytes = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	public void tearDown() {
		System.setOut(console);
	}

	public void testStockGoodsDataDrive() throws RemoteException {
		GiftPO po=new GiftPO(null, null, 0);
		int resultAdd = giftDataService.addGift(po);
		int resultDeal = giftDataService.dealGift(po);
		giftDataService.getAccount(po);
		giftDataService.giftCost();

		assertEquals(0, resultAdd);
		assertEquals(0, resultDeal);
		
		assertEquals("add gift in files succeed!" + line
				+ "deal gift in files succeed!" + line
				+ "get gift account in files succeed!" + line
				+ "return gift cost in file succeed!" + line, bytes.toString());
	}
}
