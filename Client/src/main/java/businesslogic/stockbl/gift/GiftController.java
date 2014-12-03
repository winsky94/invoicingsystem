package businesslogic.stockbl.gift;

import java.util.ArrayList;

import po.GiftPO;
import po.ReceiptPO.ReceiptType;
import vo.GiftVO;
import businesslogic.receiptbl.Receipt;
import businesslogicservice.stockblservice.giftblservice.GiftBLService;

public class GiftController extends Receipt implements GiftBLService {

	public int addGift(GiftVO vo) {
		// TODO 自动生成的方法存根
		GiftReceipt receipt = new GiftReceipt(vo.getId(), vo.getMemberID(),
				vo.getMemberName(), vo.getUser(), ReceiptType.GIFT,
				vo.getHurry(), vo.getStatus(), vo.getInfo());
		return receipt.add();
	}

	public int dealGift(GiftVO vo) {
		// TODO 自动生成的方法存根
		GiftManage manage = new GiftManage();
		if (vo.getStatus() == 1) {
			return 80;
		}
		if (vo.getStatus() == 1) {
			return 81;
		}

		GiftReceipt receipt = new GiftReceipt(vo.getId(), vo.getMemberID(),
				vo.getMemberName(), vo.getUser(), ReceiptType.GIFT,
				vo.getHurry(), 2, vo.getInfo());
		return manage.excute(receipt);
	}

	public double getGiftCost() {
		// TODO 自动生成的方法存根
		GiftManage manage=new GiftManage();
		return manage.getGiftCost();
	}

	public ArrayList<GiftPO> getGiftList(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		GiftManage manage=new GiftManage();
		return manage.getGiftList(beginDate, endDate);
	}

	public int getGiftNum(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		GiftManage manage=new GiftManage();
		return manage.getGiftNum(beginDate, endDate);
	}

	public double getGiftMoney(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		GiftManage manage=new GiftManage();
		return manage.getGiftMoney(beginDate, endDate);
	}

}
