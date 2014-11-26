package businesslogic.stockbl.goodsClass;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsClassPO;
import po.GoodsPO;
import dataservice.stockdataservice.goodsclassdataservice.StockGoodsClassDataService;
import dataservice.stockdataservice.goodsdataservice.StockGoodsDataService;

public class GoodsClass {
	String classID;
	String name;
	String upClassName;
	StockGoodsClassDataService service;
	StockGoodsDataService goodsService;

	public GoodsClass() {
		// System.setSecurityManager(new SecurityManager());
		String host = "localhost:1099";
		String url = "rmi://" + host + "/userService";
		try {
			service = (StockGoodsClassDataService) Naming.lookup(url);
			goodsService = (StockGoodsDataService) Naming.lookup(url);
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

	public GoodsClass(String name, String upClassName) {
		this();
		this.name = name;
		this.upClassName = upClassName;
	}

	public String getClassID() {
		return classID;
	}

	public String getName() {
		return name;
	}

	public String getUpClassName() {
		return upClassName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUpClassName(String upClassName) {
		this.upClassName = upClassName;
	}

	public int addGoodsClass() {
		GoodsClassManage manage = new GoodsClassManage();
		GoodsClassPO upClass = manage.find(upClassName);
		ArrayList<GoodsPO> goodsList = goodsService.showGoods();
		if (!upClass.equals(null)) {
			// 查找上级分类下是否有商品，如果有则不可以在其下加子分类
			boolean isAble = true;
			for (int i = 0; i < goodsList.size(); i++) {
				if (upClass.getName().equals(
						goodsList.get(i).getGoodsClassName())) {
					isAble = false;
					break;
				}
			}

			if (isAble) {
				// 商品分类编号+1
				String maxID=service.getMaxID();
				int tp = Integer.parseInt(maxID);
				classID = String.valueOf(tp + 1);
				GoodsClassPO po = new GoodsClassPO(classID, name, upClassName);
				return service.addGoodsClass(po);
			} else {
				return 1;
			}
		} else {
			return 2;
		}
	}

	public int deleteGoodsClass() {
		ArrayList<GoodsPO> goodsList = goodsService.showGoods();
		// 查找当前分类下是否有商品，如果有则不可以删除该分类
		boolean isAble = true;
		for (int i = 0; i < goodsList.size(); i++) {
			if (name.equals(goodsList.get(i).getGoodsClassName())) {
				isAble = false;
				break;
			}
		}

		if (isAble) {
			GoodsClassPO po = new GoodsClassPO(classID, name, upClassName);
			return service.deleteGoodsClass(po);
		} else {
			return 3;
		}
	}

	public int modifyGoodsClass() {
		GoodsClassPO po = new GoodsClassPO(classID, name, upClassName);
		return service.modifyGoodsClass(po);
	}

}
