package businesslogic.salesbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.MemberPO.MemberLevel;
import po.UserPO;
import po.UserPO.UserJob;
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
	private ArrayList<Commodity> list;
	private double discountValue;//折让金额
	private double cost;//销售成本，商品总值
	private double couponIncome;//代金券差值收入
	private double totalOrigin;//原始总价
	private double totalValue;//折让后收入
	private double proValue;//促销让利；
	private double preValue;//会员让利
	private double addDiscount;
	private double toPay;
	//private SaleVO vo;
	public Sale(SaleVO vo) {
		list=vo.getSalesList();
		this.proValue=vo.getProDiscount();
		this.preValue=vo.getPreDiscount();
		this.addDiscount=vo.getMoneyDiscount();
		this.discountValue=proValue+preValue+addDiscount;
		this.cost=vo.getCost();
		this.totalOrigin=vo.getTotalOrigin();
		this.totalValue=vo.getTotalValue();
		this.couponIncome=vo.getCouponIncome();
		this.toPay=vo.getToPay();
		
		
	}

	public Sale(String id, String memberID, String userID, 
			Date date, int hurry, int status, String info, String sid,
			String man) {
		super(id, memberID, userID, ReceiptType.SALE, date, hurry, 0, info, sid);
		// TODO Auto-generated constructor stub
		list=new ArrayList<Commodity>();
		couponIncome=0;
		discountValue=0;
		this.clerk = man;
		this.totalValue = 0;
		this.cost=0;
	}

	public int addSaleItem(Commodity item){
		if(!(list.indexOf(item)<0)){
			return 1;//添加失败，已存在
		}
		else
		{list.add(item);
		 totalOrigin+=item.getTotal();
		 updateData(item.getCost(),item.getTotal());
		return 0;}
	}
	
	public void updateData(double costToAdd,double totalToAdd){
		cost+=costToAdd;
		totalValue+=totalToAdd;
	}
	
	public void deleteSaleItem(String ID){
		Commodity item=find(ID);
		totalOrigin-=item.getTotal();
		updateData(-item.getCost(),-item.getTotal());
		list.remove(item);
	}
	
	public Commodity find(String ID){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId().equals(ID))
				return list.get(i);
		}
		return null;//不可能没有把
	}
	//先find获取原item的cost,total,原位置，修改后,存回list
	public void ModifySaleItem(double cost,double total,Commodity nitem){
		int i=list.indexOf(find(nitem.getId()));
		totalOrigin-=total;
		updateData(-cost,-total);
		list.set(i, nitem);
		totalOrigin+=nitem.getTotal();
		updateData(nitem.getCost(),nitem.getTotal());
	}
	
	//人为折让
	public int AddDiscount(double value) throws MalformedURLException, RemoteException, NotBoundException{
		User User;
		try {
			User = new User();
			UserPO user=User.voToPO(User.showUser(this.getUserID()));
			if(this.totalValue<=value)
				return 1;//折让金额过高；
			else if((user.getJob()==UserJob.SALE)&&value>5000){
				return 2;//销售经理最高折让5000	
			}else{
				this.totalValue-=value;
				this.addDiscount=value;
				this.discountValue+=value;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
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
	public void MatchProMotion() {
	
	}

	//算入折让  网络放这儿合适否？
	public void getPrivilege() throws MalformedURLException, RemoteException, NotBoundException {
		Member member=new Member();
		MemberLevel level=member.findMember(this.getMemberID()).getmLevel();
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
		preValue=(1-dis)*totalValue;
		totalValue*=dis;
		discountValue+=preValue;

		
	}
	
	public void updateSaleVO(SaleVO  vo){
		vo.setDiscount(new double[]{proValue,preValue,addDiscount,discountValue});
		vo.setTotal(new double[]{cost,totalOrigin,totalValue,couponIncome,toPay});
		vo.setSaleList(list);
	}

	public void excute(Member member) {
		member.updatePoints(this.totalValue);
		member.updateToReceive(this.totalValue);
		for (int i = 0; i <list.size(); i++) {
		//	list.get(i).OutGoods();
		}

		this.setStatus(5);//执行完毕

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
	public double getPreValue(){
		return preValue;
	}
	public double getProValue(){
		return proValue;
	}
	

}
