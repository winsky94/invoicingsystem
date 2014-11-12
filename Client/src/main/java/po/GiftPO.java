package po;

import java.io.Serializable;

import businesslogic.receiptbl.Receipt;

public class GiftPO extends Receipt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MemberPO member;
	GoodsPO goods;
	int num;

	public GiftPO(){
		
	}
	
	public GiftPO(MemberPO member, GoodsPO goods, int num) {
		super();
		this.member = member;
		this.goods = goods;
		this.num = num;
	}

	public MemberPO getMember() {
		return member;
	}

	public void setMember(MemberPO member) {
		this.member = member;
	}

	public GoodsPO getGoods() {
		return goods;
	}

	public void setGoods(GoodsPO goods) {
		this.goods = goods;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
