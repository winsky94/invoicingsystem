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

import javax.swing.JOptionPane;

import po.CommodityPO;
import po.GiftPO;
import po.ReceiptPO.ReceiptType;
import vo.CommodityVO;
import vo.GiftVO;
import vo.GoodsVO;
import vo.ReceiptVO;
import businesslogic.receiptbl.Receipt;
import businesslogic.stockbl.goods.GoodsController;
import businesslogic.stockbl.stockManage.StockControlController;
import businesslogicservice.stockblservice.controlblservice.StockControlBLService;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
import dataservice.stockdataservice.giftdataservice.GiftDataService;

public class GiftReceipt extends Receipt {
	private ArrayList<CommodityVO> giftVOList;
	private double total;
	private String host;
	private String url;
	private GiftDataService service;

	public GiftReceipt() throws Exception {
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
		String id = getNewID();

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

	// 库存赠送单的处理
	public int excute(ReceiptVO v) {
		GiftVO giftVO = (GiftVO) v;
		StockControlBLService controller = new StockControlController();
		GiftReceipt receipt = new GiftReceipt(giftVO.getId(),
				giftVO.getMemberID(), giftVO.getMemberName(), giftVO.getUser(),
				ReceiptType.GIFT, giftVO.getHurry(), giftVO.getStatus(),
				giftVO.getInfo(), giftVO.getGiftList());
		boolean isAble = true;// 库存是否满足
		ArrayList<CommodityVO> list = receipt.getGiftVOList();
		for (int i = 0; i < list.size(); i++) {
			CommodityVO vo = list.get(i);
			boolean isEnough = controller.isEnough(vo.getID(), vo.getNum());
			if (!isEnough) {
				isAble = false;
				break;
			}
		}
		if (isAble) {
			// 减少库存数量
			StockGoodsBLService goodsController = new GoodsController();
			for (int i = 0; i < list.size(); i++) {
				CommodityVO vo = list.get(i);
				GoodsVO good = null;
				try {
					good = goodsController.findByID(vo.getID());
				} catch (RemoteException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

				good.setNumInStock(good.getNumInStock() - vo.getNum());
				goodsController.modifyGoods(good);

				// 检测库存是否报警
				StockControlBLService stockController = new StockControlController();
				boolean result = stockController.stockNumCheck(good
						.getGoodsID());
				if (result) {
					//
					JOptionPane.showMessageDialog(null, "库存不足啦！", null,
							JOptionPane.WARNING_MESSAGE);
				}

			}

			// 调用服务器端处理库存赠送单
			GiftPO po = new GiftPO(receipt.getId(), receipt.getMemberID(),
					receipt.getmemberName(), receipt.getUserID(),
					receipt.getInfo(), giftVO.getStatus(), receipt.getHurry(),
					VOToPO(list));
			int result = -1;
			try {
				result = service.dealGift(po);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

			return result;
		} else {
			return 7;
		}

	}

	// 修改
	public int modify(String id) {
		int result = 0;
		try {
			GiftPO oldPo = service.findByID(id);
			GiftPO po = new GiftPO(id, super.getMemberID(),
					super.getmemberName(), super.getUserID(), super.getInfo(),
					oldPo.getStatus(), super.getHurry(), VOToPO(giftVOList));
			result = service.modify(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<CommodityVO> getGiftVOList() {
		return giftVOList;
	}

	public double getTotal() {
		return total;
	}

	public String getNewID() {
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
		return id;
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
