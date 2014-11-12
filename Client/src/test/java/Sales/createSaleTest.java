package Sales;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.salesbl.CommodityList;
import businesslogic.stockbl.MockGoods;

public class createSaleTest extends TestCase {
	private MockGoods good1, good2;
	private MockMember member1, member2;
	private CommodityList list;
	public void setUp() {
		member1 = new MockMember("XSS-0000001", MemberType.XSS,
				MemberLevel.FOUR, "张三", 8000000.0, 0.0, 0.0, 40000);
		member2 = new MockMember("XSS-0000002", MemberType.XSS,
				MemberLevel.TWO, "李四", 3000000.0,2999999.0 , 0.0, 8000);
		good1=new MockGoods("01010001","飞利浦日光灯","SR01",1000,200,100);
		//库存1000个
      	good2=new MockGoods("02010002","蓝之恋吊灯","TP05",2000,2000,1000);
      	//库存2000个
      	list=new CommodityList();
      	list.add(good1.goodsID, good1.goodName, goodSize, num, price, totalPrice, memo);
	}
}
