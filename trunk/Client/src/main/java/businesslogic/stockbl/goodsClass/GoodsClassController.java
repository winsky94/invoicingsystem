package businesslogic.stockbl.goodsClass;

import java.util.ArrayList;

import vo.GoodsClassVO;
import businesslogicservice.stockblservice.goodsclassblservice.StockGoodsClassBLService;

public class GoodsClassController implements StockGoodsClassBLService {

	public int addGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		GoodsClass gc = new GoodsClass(vo.getName(), vo.getUpClassName());
		return gc.addGoodsClass();
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
