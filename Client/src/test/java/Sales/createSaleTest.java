package Sales;

import junit.framework.TestCase;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.memberbl.MockMember;
import businesslogic.salesbl.CommodityList;
import businesslogic.salesbl.SalesController;
import businesslogic.stockbl.MockGoods;
import businesslogicservice.salesblservice.SalesBLService;

public class createSaleTest extends TestCase {
	private MockGoods good1, good2;
	private MockMember member;
	private CommodityList list;
	SalesBLService sb;
	public void setUp() {
		sb=new SalesController();
		member = new MockMember("XSS-0000001", MemberType.XSS,
				MemberLevel.FOUR, "张三", 8000000.0, 0.0, 0.0, 40000);
		good1=new MockGoods("01010001","飞利浦日光灯","SR01",1000,200,100);
		//库存1000个
      	good2=new MockGoods("02010002","蓝之恋吊灯","TP05",2000,2000,1000);
      	//库存2000个
      	list=new CommodityList();
      	list.add(good1.getGoodsID(), good1.getName(), good1.getType(),1, 300, "单价300元");
      	list.add(good2.getGoodsID(), good2.getName(), good2.getType(),1, 2000, "单价2000元");
      	
	}
}
