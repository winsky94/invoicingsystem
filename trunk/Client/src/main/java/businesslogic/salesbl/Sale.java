package businesslogic.salesbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.ArrayList;

import po.CommodityPO;
import po.MemberPO.MemberLevel;
import po.ReceiptPO.ReceiptType;
import po.SalePO;
import vo.CommodityVO;
import vo.GoodsVO;
import vo.PromotionVO;
import vo.ReceiptVO;
import vo.SaleVO;
import businesslogic.memberbl.Member;
import businesslogic.promotionbl.giftCouponPro;
import businesslogic.receiptbl.Receipt;
import businesslogic.stockbl.goods.GoodsController;
import businesslogic.utilitybl.getDate;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
import dataservice.salesdataservice.SalesDataService;

public class Sale extends Receipt { // 单据总值包含代金券金额
	// 要默认业务员
	/*
	 * private String clerk; private ArrayList<CommodityVO> list; private double
	 * discountValue;//折让金额 private double cost;//销售成本，商品总值 private double
	 * couponIncome;//代金券差值收入 private double totalOrigin;//原始总价 private double
	 * totalValue;//折让后收入 private double proValue;//促销让利； private double
	 * preValue;//会员让利 private double addDiscount; private double toPay;
	 */
	SalesDataService service;
	static Commodity com;

	public Sale() throws Exception {
		String host = "localhost:1099";
		String url = "rmi://" + host + "/salesService";

		service = (SalesDataService) Naming.lookup(url);

	}

	public int Add(SaleVO vo) {

		return service.createSale(voToPo(vo));
	}

	// 先find获取原item的cost,total,原位置，修改后,存回list
	public int Modify(SaleVO vo) {
		return service.updateSale(voToPo(vo));
	}

	public ArrayList<SaleVO> find(String message, String type) {
		ArrayList<SalePO> po = service.findSale(message, type);
		if (po == null)
			return null;
		else {
			ArrayList<SaleVO> vo = new ArrayList<SaleVO>();
			for (int i = 0; i < po.size(); i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}

	}

	public ArrayList<SaleVO> show() {
		ArrayList<SalePO> po = service.showSale();
		if (po == null)
			return null;
		else {
			ArrayList<SaleVO> vo = new ArrayList<SaleVO>();
			for (int i = 0; i < po.size(); i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}

	// 使用了代金券 ，支出累加放sale还是stock -1不存在 -2无效 过期
	public double useCoupon(String id) throws Exception {
		// coupon cou=promotionController.find(id);
		giftCouponPro pro = new giftCouponPro();
		return pro.getCouponValue(id);

	}

	// 算入折让
	public PromotionVO MatchProMotion(SaleVO vo) {

		return null;
	}

	// 算入折让 网络放这儿合适否？
	public double getPrivilege(String MemberID) throws Exception
			{
		Member member = new Member();
		MemberLevel level = member.findById(MemberID).getmLevel();
		double dis;
		switch (level) {
		case FIVE:
			dis = 0.88;
			break;
		case FOUR:
			dis = 0.9;
			break;
		case THREE:
			dis = 0.95;
			break;
		case TWO:
			dis = 0.98;
			break;
		default:
			dis = 1;
		}
		return dis;

	}

	// 单据执行
	public void excute(ReceiptVO v) {
		//修改库存
		SaleVO vo=(SaleVO)v;
		StockGoodsBLService goodsController = new GoodsController();
			ArrayList<CommodityVO> list = vo.getSalesList();
			for (CommodityVO cvo : list) {
				try {
					GoodsVO goodsVO = goodsController.findByID(cvo.getID());
					goodsVO.setNumInStock(goodsVO.getNumInStock()
							- cvo.getNum());
					goodsController.modifyGoods(goodsVO);
				} catch (RemoteException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}
	}
	
	public static SalePO voToPo(SaleVO vo) {
		ArrayList<CommodityPO> saList;
		ArrayList<CommodityVO> List = vo.getSalesList();

		saList = com.voTPo(List);
		SalePO po = new SalePO(vo.getClerk(), saList, vo.getId(),
				vo.getMemberID(), vo.getMemberName(), vo.getUser(),
				vo.getStatus(), vo.getHurry(), vo.getInfo(), vo.getStockid(),
				vo.getProid(),vo.getProid(), vo.getDiscount(), vo.getTotal());
		return po;
	}

	public static SaleVO poToVo(SalePO po) {
		ArrayList<CommodityVO> saList;
		ArrayList<CommodityPO> List = po.getSalesList();

		saList = com.poTVo(List);
		SaleVO vo = new SaleVO(po.getClerk(), saList, po.getId(),
				po.getMemberName(), po.getMemberID(), po.getUserID(),
				po.getStatus(), po.getHurry(), po.getInfo(), po.getStockID(),
				po.getProid(),po.getCouponid(), po.getTotal(), po.getDiscount());
		return vo;
	}

	public String getNewID() {
		// TODO Auto-generated method stub
		String id = null;
		ArrayList<SalePO> po = service.showSale();
		if (po == null)
			id = "00001";
		else {
			int i = po.size();
			String date = po.get(i - 1).getId().substring(4, 12);
			if (date.equals(getDate.getdate())) {
				Double d = Double.parseDouble(po.get(i - 1).getId()
						.substring(13)) + 1;
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMinimumIntegerDigits(5);
				nf.setGroupingUsed(false);
				id = nf.format(d);
			} else
				id = "00001";

		}
		return id;
	}

}
