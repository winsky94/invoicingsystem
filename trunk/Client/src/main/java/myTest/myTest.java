package myTest;

import vo.GoodsClassVO;
import businesslogic.stockbl.goodsClass.GoodsClass;

public class myTest {
	public static void main(String[] args) {
		GoodsClass gc=new GoodsClass();
		GoodsClassVO vo=new GoodsClassVO("菲利普", "日光灯");
		gc.addGoodsClass(vo);
	}
	

	
	
}
