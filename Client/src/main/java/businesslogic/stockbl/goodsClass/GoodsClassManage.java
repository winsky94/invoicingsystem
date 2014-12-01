package businesslogic.stockbl.goodsClass;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JTree;

import po.GoodsClassPO;
import vo.GoodsClassVO;
import yanTest.JXCFile;
import dataservice.stockdataservice.goodsclassdataservice.StockGoodsClassDataService;

public class GoodsClassManage {

	StockGoodsClassDataService service;

	public GoodsClassManage() {
		// System.setSecurityManager(new SecurityManager());
		String host = "localhost:1099";
		String url = "rmi://" + host + "/goodsClassService";
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
		if (name.equals("灯具")) {
			return new GoodsClassPO("0000", "灯具", "");
		} else {
			GoodsClassPO po = null;
			boolean isExist = false;
			ArrayList<GoodsClassPO> list;
			try {
				list = service.show();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getName().equals(name)) {
						po = list.get(i);
						isExist = true;
						break;
					}
				}

			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (isExist) {
				return po;
			} else {
				return null;
			}
		}
	}

	public ArrayList<GoodsClassVO> show() {
		// TODO 自动生成的方法存根
		ArrayList<GoodsClassPO> list = null;
		try {
			list = service.show();
		} catch (RemoteException e) {
			// TODO 自动生s成的 catch 块
			e.printStackTrace();
		}
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

	public String getID(String name) {
		return find(name).getID();
	}

	public JTree getClassTree() {
		// TODO 自动生成的方法存根
		JTree resultJTree = null;
//		try {
//			resultJTree = service.getClassTree();
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		
		JXCFile file=new JXCFile("classTree.ser");
		ArrayList<Object> a=file.read();
		if(a!=null){
			resultJTree=(JTree) a.get(0);
		}
		else{
			System.out.println("goodsclassmanage:"+"本地获取树失败");
		}
 		return resultJTree;
	}

	public int recordClassTree(JTree tree) {
		// TODO 自动生成的方法存根
		int result = 0;
//		try {
//			result = service.recordClassTree(tree);
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		
		JXCFile file=new JXCFile("classTree.ser");
		file.writeM(tree);
		return result;
	}
}
