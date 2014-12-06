package businesslogic.stockbl.gift;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import po.CommodityPO;
import po.GiftPO;
import vo.CommodityVO;
import businesslogic.receiptbl.Receipt;
import dataservice.stockdataservice.giftdataservice.GiftDataService;

public class GiftReceipt extends Receipt {
	private ArrayList<CommodityVO> giftVOList;
	private double total;
	private String host;
	private String url;
	private GiftDataService service;

	public GiftReceipt() {
		giftVOList = new ArrayList<CommodityVO>();
		host = "localhost:1099";
		url = "rmi://" + host + "/giftService";
		try {
			service = (GiftDataService) Naming.lookup(url);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public GiftReceipt(String id, String memberID, String memberName,
			String userID, po.ReceiptPO.ReceiptType type, int hurry,
			int status, String info, ArrayList<CommodityVO> giftList) {
		super(id, memberID, memberName, userID, po.ReceiptPO.ReceiptType.GIFT,
				hurry, status, info);
		giftVOList = giftList;
		host = "localhost:1099";
		url = "rmi://" + host + "/giftService";
		try {
			service = (GiftDataService) Naming.lookup(url);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 创建库存赠送单
	public int add() {
		int result = -1;
		ArrayList<CommodityPO> list = new ArrayList<CommodityPO>();
		list = VOToPO(giftVOList);

		// 生成编号
		String id = "KCZSD-" + getDate() + "-";
		String maxID = null;
		try {
			maxID = service.getMaxID();
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		if (maxID == null) {
			id += "00001";
		} else {
			NumberFormat nf = new DecimalFormat("00000");
			int tp = Integer.parseInt(maxID);
			id += nf.format(tp + 1);
		}

		GiftPO po = new GiftPO(id, super.getmemberName(), getMemberID(),
				super.getUserID(), super.getInfo(), 0, super.getHurry(), list);
		try {
			result = service.addGift(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}

	// 向赠送单列表里增加商品
	public int addGift(CommodityVO vo) {
		giftVOList.add(vo);
		total += vo.getPrice();
		return 0;
	}

	// 从赠送单列表里删除商品
	public int deleteGood(CommodityVO vo) {
		giftVOList.remove(vo);
		total -= vo.getPrice();
		return 0;
	}

	public ArrayList<CommodityVO> getGiftVOList() {
		return giftVOList;
	}

	public double getTotal() {
		return total;
	}

	// 将赠送商品列表由vo转为po
	private ArrayList<CommodityPO> VOToPO(ArrayList<CommodityVO> list) {
		ArrayList<CommodityPO> result = new ArrayList<CommodityPO>();
		for (int i = 0; i < list.size(); i++) {
			CommodityVO vo = list.get(i);
			CommodityPO po = new CommodityPO(vo.getID(), vo.getName(),
					vo.getType(), vo.getPrice(), vo.getLast_bid(), vo.getNum(),
					vo.getTotal(), vo.getCost(), vo.getTip());
			result.add(po);
		}

		return result;
	}

	private String getDate() {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		String sysDatetime = fmt.format(rightNow.getTime());

		return sysDatetime;
	}
}
