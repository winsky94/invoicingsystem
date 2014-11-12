package businesslogic.stockbl;

import vo.GiftVO;
import businesslogic.memberbl.Member;
import businesslogic.receiptbl.Receipt;
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

}
