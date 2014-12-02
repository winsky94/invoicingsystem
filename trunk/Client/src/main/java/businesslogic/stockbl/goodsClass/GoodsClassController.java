package businesslogic.stockbl.goodsClass;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.GoodsClassVO;
import businesslogicservice.stockblservice.goodsclassblservice.StockGoodsClassBLService;

public class GoodsClassController implements StockGoodsClassBLService,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int addGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		GoodsClass gc = new GoodsClass(vo.getName(), vo.getUpClassName());
		int result = 0;
		try {
			result = gc.addGoodsClass();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}

	public int deleteGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		GoodsClass gc = new GoodsClass(vo.getName(), vo.getUpClassName());
		return gc.deleteGoodsClass();
	}

	public int modifyGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		GoodsClass gc = new GoodsClass(vo.getName(), vo.getUpClassName());
		return gc.modifyGoodsClass();
	}

	public ArrayList<GoodsClassVO> show() {
		// TODO 自动生成的方法存根
		GoodsClassManage manage = new GoodsClassManage();
		return manage.show();
	}
}
