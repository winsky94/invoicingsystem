package businesslogic.stockbl.goodsClass;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import po.GoodsClassPO;
import po.GoodsPO;
import vo.GoodsClassVO;
import vo.GoodsVO;
import businesslogic.stockbl.goods.GoodsController;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
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
		String url1 = "rmi://" + host + "/goodsClassService";
		String url2 = "rmi://" + host + "/goodsService";
		try {
			service = (StockGoodsClassDataService) Naming.lookup(url1);
			goodsService = (StockGoodsDataService) Naming.lookup(url2);
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

	public int addGoodsClass() throws RemoteException {
		GoodsClassManage manage = new GoodsClassManage();
		boolean isExist = false;
		ArrayList<GoodsClassVO> list = new ArrayList<GoodsClassVO>();
		list = manage.show();

		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				isExist = true;
			}
		}
		if (!isExist) {
			GoodsClassPO upClass = manage.find(upClassName);
			ArrayList<GoodsPO> goodsList = goodsService.showGoods();
			if (upClass != null) {
				// 查找上级分类下是否有商品，如果有则不可以在其下加子分类
				boolean isAble = true;
				for (int i = 0; i < goodsList.size(); i++) {
					if (upClass.getName().equals(
							goodsList.get(i).getGoodsClassName())) {
						isAble = false;
						break;
					}
				}

				if (isAble == true) {
					// 商品分类编号+1
					NumberFormat nf = new DecimalFormat("0000");
					String maxID = service.getMaxID();
					if (maxID != null) {
						int tp = Integer.parseInt(maxID);
						classID = nf.format((tp + 1));
					} else {
						classID = nf.format(1);
					}
					GoodsClassPO po = new GoodsClassPO(classID, name,
							upClassName);
					return service.addGoodsClass(po);
				} else {
					return 1;// 上级分类下有商品，无法添加
				}
			} else {
				return 2;// 上级分类不存在
			}
		} else {
			return 5;// 当前分类已存在
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
			int result = 0;
			try {
				result = service.deleteGoodsClass(po);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return result;
		} else {
			return 3;
		}
	}

	public int modifyGoodsClass(GoodsClassVO oldVO) {
		int result = -1;
		try {
			GoodsClassPO oldPO = service.showGoodsClassInfo(oldVO.getName());
			GoodsClassPO newPO = new GoodsClassPO(oldPO.getID(), name,
					upClassName);
			if (service.showGoodsClassInfo(name) == null) {
				result = service.modifyGoodsClass(newPO);
				
				StockGoodsBLService controller = new GoodsController();
				ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
				list = controller.showGoods();
				for(int i=0;i<list.size();i++){
					GoodsVO vo=list.get(i);
					if(vo.getGoodsClass().equals(oldVO.getName())){
						vo.setGoodsClass(name);
						controller.modifyGoods(vo);
					}
				}
			}
			else{
				result=6;
			}

			

		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
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

}
