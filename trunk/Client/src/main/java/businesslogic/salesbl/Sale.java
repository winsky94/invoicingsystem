package businesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.promotionbl.MockCoupon;
import businesslogic.promotionbl.MockPromotion;
import businesslogic.promotionbl.coupon;
import businesslogic.promotionbl.promotion;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.stockbl.Goods;
import businesslogic.stockbl.MockStockControl;

public class Sale extends Receipt{
	//要默认业务员
    private String salesman;
    private ArrayList<SaleItem> goodsList;
    private double totalValue;
	public Sale(String id,String memberID, String userID,
			ReceiptType type, Date date, int hurry, String info,
			String sid,String man) {
		super(id, memberID, userID, type, date, hurry,0, info, sid);
		// TODO Auto-generated constructor stub
		this.salesman=man;
		this.goodsList=new ArrayList<SaleItem>();
		this.totalValue=0;
	}
	
	public void  AddGoods(SaleItem item){
		goodsList.add(item);
		this.totalValue+=(item.getTotal());
	}
	
	public void DeleteGoods(SaleItem item){
		goodsList.remove(item);
		this.totalValue-=(item.getTotal());
	}
	
	public void ModifySaleItem(SaleItem item,int num){
		this.totalValue-=item.getTotal();
		item.updateNum(num);
		this.totalValue+=item.getTotal();
	}
	
	
	
	public void useCoupon(coupon coupon){
		MockCoupon cou=(MockCoupon)coupon;
		if(!cou.GetIsUse()){
			this.totalValue-=cou.GetFaceValue();
			cou.Use();
		}
		
	}
	public void MatchProMotion(){
		MockPromotion pro=new MockPromotion(1000,0.9);
		pro=(MockPromotion) pro.Match(this);
		this.totalValue*=pro.getdiscount();
	}
	
	public void getPrivilege(){
		MockMember member=new MockMember("140001",MemberType.XSS,MemberLevel.THREE,"金金灯堂",6000000);
		member=member.find(this.getMemberID());
		this.totalValue*=member.getDiscount();
	}
	
	public void excute(MockMember member){
		member.updatePoint(this.totalValue);
		member.updateToReceive(this.totalValue);
		for(int i=0;i<goodsList.size();i++){
			goodsList.get(i).OutGoods();
		}
		
		this.setStatus(5);
		
	}
	
	public double getTotalValue(){
		return this.totalValue;
	}
	
	
	
}

