package businesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;



import businesslogic.promotionbl.MockCoupon;
import businesslogic.promotionbl.MockPromotion;
import businesslogic.promotionbl.coupon;
import businesslogic.promotionbl.promotionController;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;

public class Sale extends Receipt {
	// 要默认业务员  当前操作员
	private String salesman,operator;
	private ArrayList<SaleItem> list;
	private double discountValue;//折让金额
	private double cost;//销售成本，商品总值
	private double couponIncome;//代金券差值收入
	private double totalValue;//折让后收入
	public Sale() {
		
	}

	public Sale(String id, String memberID, String userID, 
			Date date, int hurry, int status, String info, String sid,
			String man,String operator) {
		super(id, memberID, userID, ReceiptType.SALE, date, hurry, 0, info, sid);
		// TODO Auto-generated constructor stub
		list=new ArrayList<SaleItem>();
		couponIncome=0;
		discountValue=0;
		this.salesman = man;
		this.operator=operator;
		this.totalValue = 0;
		this.cost=0;
	}
	
	public int addItem(SaleItem item){
		if(!(list.indexOf(item)<0)){
			return 1;//添加失败，已存在
		}
		else
		{list.add(item);
		 updateData(item.getCost(),item.getTotal());
		return 0;}
	}
	
	public void updateData(double costToAdd,double totalToAdd){
		cost+=costToAdd;
		totalValue+=totalToAdd;
	}
	
	public void deleteItem(String ID){
		SaleItem item=find(ID);
		updateData(-item.getCost(),-item.getTotal());
		list.remove(item);
	}
	
	public SaleItem find(String ID){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId().equals(ID))
				return list.get(i);
		}
		return null;//不可能没有把
	}
	//先find获取原item的cost,total,原位置，修改后,存回list
	public void ModifyItem(double cost,double total,int i,SaleItem nitem){
		updateData(-cost,-total);
		list.set(i, nitem);
		updateData(nitem.getCost(),nitem.getTotal());
	}
	
	public double getCost() {
		return cost;
	}


	
//使用了代金券 ，支出累加放sale还是stock
	public int  useCoupon(String id) {
		coupon cou=promotionController.find(id);
		if(cou==null||cou.getIsUse()) return 1;//改代金券编号无效
		else {
			if (this.totalValue >= cou.getValue()) {
				this.totalValue -= cou.getValue();
			} else {
				couponIncome = cou.getValue() - this.totalValue;
				this.totalValue = 0;
			}
			cou.Use();
			return 0;
		}
	}

	public void MatchProMotion() {
		MockPromotion pro = new MockPromotion(1000, 0.9);
		pro = (MockPromotion) pro.Match(this);
		this.totalValue *= pro.getdiscount();
	}

	public void getPrivilege() {
		Member member = new Member("140001", MemberType.XSS,
				MemberLevel.THREE, "金金灯堂", 6000000);
		member = member.find(this.getMemberID());
		this.totalValue *= member.getDiscount();
	}

	public void excute(Member member) {
		member.updatePoint(this.totalValue);
		member.updateToReceive(this.totalValue);
		for (int i = 0; i < goodsList.size(); i++) {
			goodsList.get(i).OutGoods();
		}

		this.setStatus(5);

	}
	public void setDiscountValue(double value){
		this.discountValue=value;
	}
	
	public double getDiscountValue(){
		return this.discountValue;
	}

	public double getTotalValue() {
		return this.totalValue;
	}

	public double getCouponIncome() {
		return this.couponIncome;
	}
	
	

}
