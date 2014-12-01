package businesslogic.salesbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dataservice.memberdataservice.MemberDataService;
import dataservice.salesdataservice.SalesDataService;
import po.MemberPO.MemberLevel;
import po.UserPO;
import po.UserPO.UserJob;
import vo.CommodityVO;
import vo.PromotionVO;
import vo.SaleVO;
import businesslogic.memberbl.Member;
import businesslogic.promotionbl.coupon;
import businesslogic.promotionbl.promotionController;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.userbl.User;

public class Sale extends Receipt {  //单据总值包含代金券金额
	// 要默认业务员 
	private String clerk;
	private ArrayList<CommodityVO> list;
	private double discountValue;//折让金额
	private double cost;//销售成本，商品总值
	private double couponIncome;//代金券差值收入
	private double totalOrigin;//原始总价
	private double totalValue;//折让后收入
	private double proValue;//促销让利；
	private double preValue;//会员让利
	private double addDiscount;
	private double toPay;
	SalesDataService service;
	
	public Sale(){
		String host="localhost:1099";
		String url="rmi://"+host+"/salesService";
	
		service=(SalesDataService)Naming.lookup(url);
	
	}
	
	public String getNewID(){
		
	}
	public int addSale(SaleVO vo){
		
	}
	
	
	
	
	
	
	//先find获取原item的cost,total,原位置，修改后,存回list
	public int  ModifySale(SaleVO vo){
		int i=list.indexOf(find(nitem.getId()));
		totalOrigin-=total;
		updateData(-cost,-total);
		list.set(i, nitem);
		totalOrigin+=nitem.getTotal();
		updateData(nitem.getCost(),nitem.getTotal());
	}
	
	public SaleVO find(String message,type){
		
	}



	
//使用了代金券 ，支出累加放sale还是stock
	public int  useCoupon(String id) {
		coupon cou=promotionController.find(id);
		if(cou==null||cou.getIsUse()) return 1;//改代金券编号无效
		else {
			if (this.totalValue >= cou.getValue()) {
				this.toPay=this.totalValue - cou.getValue();
			} else {
				couponIncome = cou.getValue() - this.totalValue;
				this.toPay = 0;
			}
			cou.Use();
			return 0;
		}
	}

	//算入折让
	public PromotionVO MatchProMotion(SaleVO vo) {
	
	}

	//算入折让  网络放这儿合适否？
	public double getPrivilege(String MemberID) throws MalformedURLException, RemoteException, NotBoundException {
		Member member=new Member();
		MemberLevel level=member.findById(MemberID).getmLevel();
		double dis;
		switch(level){
		case FIVE:
			dis=0.88;break;
		case FOUR:
			dis=0.9;break;
		case THREE:
			dis=0.95;break;
		case TWO:
			dis=0.98;break;
		default:
			dis=1;
		}
		return dis;

		
	}
	

//单据执行
	public void excute(SaleVO vo) {
		

	}
	
}
