package businesslogicservice.stockblservice.goodsclassblservice;

import java.util.ArrayList;

import vo.GoodsClassVO;

public interface StockGoodsClassBLService {
	public int addGoodsClass(GoodsClassVO vo);

	public int deleteGoodsClass(GoodsClassVO vo);

	public int modifyGoodsClass(GoodsClassVO vo);

	public ArrayList<GoodsClassVO> show();
}
