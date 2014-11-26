package businesslogic.stockbl;

import java.util.ArrayList;

import businesslogic.memberbl.Member;
import businesslogic.receiptbl.Receipt;
import businesslogic.stockbl.goods.Goods;

public class GiftReceipt extends Receipt{
	Member member;
	ArrayList<Goods> giftList;
	double total;
	
	public GiftReceipt(){
		giftList=new ArrayList<Goods>();
	}
	
	public GiftReceipt(Member member){
		this.member=member;
		giftList=new ArrayList<Goods>();
	}
	
	public int addGood(Goods good){
		giftList.add(good);
		total+=good.getPrice();
		return 0;
	}
	
	public int deleteGood(Goods good){
		giftList.remove(good);
		total-=good.getPrice();
		return 0;
	}
	
	public ArrayList<Goods> getGiftList(){
		return giftList;
	}
	
	public double getTotal(){
		return total;
	}
	
	public Member getMember(){
		return member;
	}
}
