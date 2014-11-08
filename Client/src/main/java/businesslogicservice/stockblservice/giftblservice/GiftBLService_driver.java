package businesslogicservice.stockblservice.giftblservice;

import vo.GiftVO;

public class GiftBLService_driver {
	public void drive(GiftBLService_stub giftService_stub) {
		GiftVO giftVO = new GiftVO();

		giftService_stub.addGift(giftVO);
		giftService_stub.dealGift(giftVO);
		giftService_stub.getAccount(giftVO);
		giftService_stub.giftCost();
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		GiftBLService_stub giftService_stub = new GiftBLService_stub();
		GiftBLService_driver driver = new GiftBLService_driver();
		driver.drive(giftService_stub);
	}

}
