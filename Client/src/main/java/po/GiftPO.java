package po;

import java.io.Serializable;

import vo.GoodsVO;
import vo.MemberVO;

public class GiftPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MemberVO member;
	GoodsVO goods;
	int num;

	public GiftPO(MemberVO member, GoodsVO goods, int num) {
		this.member = member;
		this.goods = goods;
		this.num = num;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public GoodsVO getGoods() {
		return goods;
	}

	public void setGoods(GoodsVO goods) {
		this.goods = goods;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
