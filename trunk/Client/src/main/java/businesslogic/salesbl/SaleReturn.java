package businesslogic.salesbl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.ArrayList;

import po.CommodityPO;
import po.SaleReturnPO;
import vo.CommodityVO;
import vo.GoodsVO;
import vo.ReceiptVO;
import vo.SaleReturnVO;
import businesslogic.receiptbl.Receipt;
import businesslogic.stockbl.goods.GoodsController;
import businesslogic.utilitybl.getDate;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
import dataservice.salesdataservice.SalesDataService;

public class SaleReturn extends Receipt {

	static Commodity com;
	SalesDataService service;

	public SaleReturn() throws Exception {
		String host = "localhost:1099";
		String url = "rmi://" + host + "/salesService";

		service = (SalesDataService) Naming.lookup(url);

	}

	public int add(SaleReturnVO vo) {

		return service.createSaleReturn(voToPo(vo));
	}

	public int Modify(SaleReturnVO vo) {
		return service.updateSaleReturn(voToPo(vo));
	}

	public ArrayList<SaleReturnVO> find(String message, String type) {
		ArrayList<SaleReturnPO> po = service.findSaleReturn(message, type);
		if (po == null)
			return null;
		else {
			ArrayList<SaleReturnVO> vo = new ArrayList<SaleReturnVO>();
			for (int i = 0; i < po.size(); i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}

	public String getNewID() {
		// TODO Auto-generated method stub
		String id = null;
		ArrayList<SaleReturnPO> po = service.showSaleReturn();
		if (po == null)
			id = "00001";
		else {
			int i = po.size();
			String date = po.get(i - 1).getId().substring(6, 14);
			if (date.equals(getDate.getdate())) {
				Double d = Double.parseDouble(po.get(i - 1).getId()
						.substring(15)) + 1;
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMinimumIntegerDigits(5);
				nf.setGroupingUsed(false);
				id = nf.format(d);
			} else
				id = "00001";

		}
		return id;
	}

	public int excute(ReceiptVO v) {
		// 修改库存
		SaleReturnVO vo=(SaleReturnVO)v;
		StockGoodsBLService goodsController = new GoodsController();
		ArrayList<CommodityVO> list = vo.getSaleReturnList();
		for (CommodityVO cvo : list) {
			try {
				GoodsVO goodsVO = goodsController.findByID(cvo.getID());
				goodsVO.setNumInStock(goodsVO.getNumInStock() + cvo.getNum());
				goodsController.modifyGoods(goodsVO);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
		return 0;

	}

	public ArrayList<SaleReturnVO> show() {

		ArrayList<SaleReturnPO> po = service.showSaleReturn();
		if (po == null)
			return null;
		else {
			ArrayList<SaleReturnVO> vo = new ArrayList<SaleReturnVO>();
			for (int i = 0; i < po.size(); i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}

	public static SaleReturnVO poToVo(SaleReturnPO po) {
		ArrayList<CommodityPO> list = po.getSalesreturnList();
		ArrayList<CommodityVO> rList = com.poTVo(list);
		SaleReturnVO vo = new SaleReturnVO(po.getId(), po.getMemberName(),
				po.getMemberID(), po.getUserID(), po.getStatus(), po.getInfo(),
				po.getHurry(), po.getTotal(), po.getDiscount(), po.getClerk(),
				rList, po.getStockID());
		return vo;

	}

	public SaleReturnPO voToPo(SaleReturnVO vo) {
		ArrayList<CommodityVO> list = vo.getSaleReturnList();
		ArrayList<CommodityPO> rList = com.voTPo(list);
		SaleReturnPO po = new SaleReturnPO(vo.getClerk(), rList, vo.getId(),
				vo.getMemberID(), vo.getMemberName(), vo.getUser(),
				vo.getStatus(), vo.getHurry(), vo.getInfo(), vo.getStockid(),
				vo.getDiscount(), vo.getTotal());
		return po;
	}
}
