package businesslogic.stockbl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.GoodsClassPO;
import po.GoodsPO;
import vo.GoodsClassVO;
import businesslogicservice.stockblservice.goodsclassblservice.StockGoodsClassBLService;
import dataservice.stockdataservice.goodsclassdataservice.StockGoodsClassDataService;
import dataservice.stockdataservice.goodsclassdataservice.StockGoodsClassDataService_stub;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService;

public class GoodsClass implements StockGoodsClassBLService {
	String classID;
	String name;
	String upClassName;
	StockGoodsClassDataService service;
	StockGoodsDataService goodsService;

	public GoodsClass() throws Exception {
		System.setSecurityManager(new SecurityManager());
		String host = "localhost:1099";
		String url = "rmi://" + host + "/userService";
		service = (StockGoodsClassDataService_stub) Naming.lookup(url);
		goodsService = (StockGoodsDataService) Naming.lookup(url);
	}

	public int addGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		GoodsClassPO po = goodsClassVOToPO(vo);
		GoodsClassPO upClass = find(po.getUpClassName());
		ArrayList<GoodsPO> goodsList = goodsService.showGoods();
		// 查找上级分类下是否有商品，如果有则不可以在其下加子分类
		boolean isAble = true;
		for (int i = 0; i < goodsList.size(); i++) {
			if (upClass.getName().equals(goodsList.get(i).getGoodsClassName())) {
				isAble = false;
				break;
			}
		}

		if (isAble) {
			return service.addGoodsClass(po);
		} else {
			return 1;
		}
	}

	public int deleteGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		GoodsClassPO po = goodsClassVOToPO(vo);
		ArrayList<GoodsPO> goodsList = goodsService.showGoods();
		// 查找当前分类下是否有商品，如果有则不可以删除该分类
		boolean isAble = true;
		for (int i = 0; i < goodsList.size(); i++) {
			if (po.getName().equals(goodsList.get(i).getGoodsClassName())) {
				isAble = false;
				break;
			}
		}

		if (isAble) {
			return service.deleteGoodsClass(po);
		} else {
			return 3;
		}
	}

	public int modifyGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		GoodsClassPO po = goodsClassVOToPO(vo);
		ArrayList<GoodsPO> goodsList = goodsService.showGoods();
		// 查找当前分类下是否有商品，如果有则不可以删除该分类
		boolean isAble = true;
		for (int i = 0; i < goodsList.size(); i++) {
			if (po.getName().equals(goodsList.get(i).getGoodsClassName())) {
				isAble = false;
				break;
			}
		}

		if (isAble) {
			return service.modifyGoodsClass(po);
		} else {
			return 2;
		}
	}

	public GoodsClassPO goodsClassVOToPO(GoodsClassVO vo) {
		GoodsClassPO po = new GoodsClassPO(vo.getName(), vo.getUpClassName());
		return po;
	}

	public GoodsClassPO find(String upClassName) {
		// TODO 自动生成的方法存根
		GoodsClassPO po = null;
		boolean isExist = false;
		ArrayList<GoodsClassPO> list = service.show();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(upClassName)) {
				po = list.get(i);
				isExist = true;
				break;
			}
		}
		if (isExist) {
			return po;
		} else {
			return null;
		}
	}

}
