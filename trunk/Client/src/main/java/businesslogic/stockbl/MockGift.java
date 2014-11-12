package businesslogic.stockbl;

import businesslogic.memberbl.Member;

public class MockGift extends Gift{
	Member member;
	Goods goods;
	
	public MockGift(Member member,Goods goods){
		this.member=member;
		this.goods=goods;
	}
	
	public MockGift(){
		
	}
	
	public double getGiftCost(double total){
		return total;
	}
}
