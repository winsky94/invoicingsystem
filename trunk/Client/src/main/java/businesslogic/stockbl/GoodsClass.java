package businesslogic.stockbl;

import vo.GoodsClassVO;
import businesslogicservice.stockblservice.goodsclassblservice.StockGoodsClassBLService;

public class GoodsClass implements StockGoodsClassBLService {
	String name;
	GoodsClass upClass;
	
	public GoodsClass(){
		
	}
	
	public GoodsClass(String name, GoodsClass upClass) {
		this.name = name;
		this.upClass = upClass;
	}


	public int addGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int deleteGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int modifyGoodsClass(GoodsClassVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

}
