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
import po.CommodityPO;
import po.SalePO;
import po.UserPO;
import po.UserPO.UserJob;
import vo.CommodityVO;
import vo.PromotionVO;
import vo.SaleVO;
import businesslogic.memberbl.Member;
import businesslogic.promotionbl.giftCouponPro;
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
	static Commodity com;
	public Sale() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/salesService";
	
		service=(SalesDataService)Naming.lookup(url);
	
	}
	
	
	
	public int Add(SaleVO vo){
		
		return service.createSale(voToPo(vo));
	}
	
	
	
	
	
	
	//先find获取原item的cost,total,原位置，修改后,存回list
	public int  Modify(SaleVO vo){
		return service.updateSale(voToPo(vo));
	}
	
	public ArrayList<SaleVO> find(String message,String type){
		ArrayList<SalePO> po=service.findSale(message, type);
		if(po==null) return null;
		else{
			ArrayList<SaleVO> vo=new ArrayList<SaleVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
		
	}

	public ArrayList<SaleVO> show(){
		ArrayList<SalePO> po=service.showSale();
		if(po==null) return null;
		else{
			ArrayList<SaleVO> vo=new ArrayList<SaleVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}

	
//使用了代金券 ，支出累加放sale还是stock -1不存在  -2无效 过期
	public double  useCoupon(String id) {
		//coupon cou=promotionController.find(id);
		giftCouponPro pro=new giftCouponPro();
		return pro.getCouponValue(id);
		
	}

	//算入折让
	public PromotionVO MatchProMotion(SaleVO vo) {
	
		return null;
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
	
	public static SalePO voToPo(SaleVO vo){
		ArrayList<CommodityPO> saList;
		ArrayList<CommodityVO> List=vo.getSalesList();
		
			saList=com.voTPo(List);
		SalePO po=new SalePO(vo.getClerk(),saList,vo.getId(),vo.getMemberID(),
				vo.getMemberName(),vo.getUser(),vo.getStatus(),vo.getHurry(),
				vo.getInfo(),vo.getStockid(),vo.getDiscount(),vo.getTotal());
		return po;
	}

	
	public static SaleVO  poToVo(SalePO po){
		ArrayList<CommodityVO> saList;
		ArrayList<CommodityPO> List=po.getSalesList();
		
			saList=com.poTVo(List);
		SaleVO vo=new SaleVO(po.getClerk(),saList,po.getId(),po.getMemberName(),po.getMemberID(),
				po.getUserID(),po.getStatus(),po.getHurry(),po.getInfo(),po.getStockID(),
				po.getTotal(),po.getDiscount());
		return vo;
	}



	public String getNewID() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
