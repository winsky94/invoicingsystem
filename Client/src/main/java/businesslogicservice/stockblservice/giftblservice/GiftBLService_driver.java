package businesslogicservice.stockblservice.giftblservice;

import vo.GiftVO;
import vo.GoodsVO;
import vo.MemberVO;
import vo.UserVO;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.receiptbl.ReceiptType;

public class GiftBLService_driver {
	public void drive(GiftBLService_stub giftService_stub) {
		GoodsVO goodsVO = new GoodsVO("00001", "飞利浦日光灯", "SR01", 10, 100, 150,
				100, 150);
		MemberVO memberVO = new MemberVO("00001", MemberType.XSS,
				MemberLevel.ONE, "小赵", "18013878510", "南京大学仙林校区", "210046", "",
				"", 0, 0, 0);
		UserVO userVO = new UserVO("小赵", "00001", "123456", "库存管理员");
		GiftVO giftVO = new GiftVO(memberVO, goodsVO, 10, userVO,
				ReceiptType.GIFT, "", "00001");
		
		giftService_stub.addGift(giftVO);
		giftService_stub.dealGift(giftVO);
		giftService_stub.getAccount(giftVO);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		GiftBLService_stub giftService_stub = new GiftBLService_stub();
		GiftBLService_driver driver = new GiftBLService_driver();
		driver.drive(giftService_stub);
	}

}
