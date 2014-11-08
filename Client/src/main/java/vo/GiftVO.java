package vo;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;

public class GiftVO extends ReceiptVO {
	GoodsVO goods;
	int num;
	public GiftVO(){
		
	}

	public GiftVO(MemberVO member, GoodsVO goods, int num, UserVO user,
			ReceiptType type, String info, String stockid) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//		String timeNow = df.format(new Date());
		
		this.member = member;
		this.goods = goods;
		this.num = num;
		this.user = user;
		this.type = type;
		this.createDate = new Date();
		this.status = 0;
		this.info = info;
		this.stockid = info;
	}

	public MemberVO getMember() {
		return member;
	}

	public GoodsVO getGoods() {
		return goods;
	}

	public int getNum() {
		return num;
	}
}
