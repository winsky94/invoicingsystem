package businesslogicservice.stockblservice.giftblservice;

import vo.GiftVO;

public interface GiftBLService {
	public int addGift(GiftVO vo);

	public int dealGift(GiftVO vo);

	public double getAccount(GiftVO vo);
}
