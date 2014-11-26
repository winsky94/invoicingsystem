package businesslogic.stockbl.goodsClass;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsClassPO;
import vo.GoodsClassVO;
import dataservice.stockdataservice.goodsclassdataservice.StockGoodsClassDataService;

public class GoodsClassManage {

	StockGoodsClassDataService service;

	public GoodsClassManage() {
		String host = "localhost:1099";
		String url = "rmi://" + host + "/userService";
		try {
			service = (StockGoodsClassDataService) Naming.lookup(url);
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

	public GoodsClassPO find(String name) {
		GoodsClassPO po = null;
		boolean isExist = false;
		ArrayList<GoodsClassPO> list = service.show();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
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

	public ArrayList<GoodsClassVO> show() {
		// TODO 自动生成的方法存根
		ArrayList<GoodsClassPO> list = service.show();
		ArrayList<GoodsClassVO> result = new ArrayList<GoodsClassVO>();
		for (int i = 0; i < list.size(); i++) {
			GoodsClassPO po = list.get(i);
			GoodsClassVO vo = goodsClassPOToVO(po);
			result.add(vo);
		}
		return result;
	}

	private GoodsClassVO goodsClassPOToVO(GoodsClassPO po) {
		GoodsClassVO vo = new GoodsClassVO(po.getName(), po.getUpClassName());
		return vo;
	}
	
	public String getID(String name){
		return find(name).getID();
	}
}
