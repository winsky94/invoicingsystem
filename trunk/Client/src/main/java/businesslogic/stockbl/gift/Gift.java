package businesslogic.stockbl.gift;

import java.util.ArrayList;

import po.GiftPO;
import vo.GiftVO;
import businesslogic.memberbl.Member;
import businesslogic.receiptbl.Receipt;
import businesslogic.stockbl.goods.Goods;
import businesslogicservice.stockblservice.giftblservice.GiftBLService;

public class Gift extends Receipt implements GiftBLService {
	Member member;
	Goods goods;

	public Gift() {

	}

	public Gift(Member member, Goods goods) {
		super();
		this.member=member;
		this.goods=goods;
	}

	public int addGift(GiftVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int dealGift(GiftVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public double getAccount(GiftVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public double getGiftCost() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public ArrayList<GiftPO> getGiftList(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		return null;
	}

	public int getGiftNum(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public double getGiftMoney(String beginDate, String endDate) {
		// TODO 自动生成的方法存根
		return 0;
	}

}
