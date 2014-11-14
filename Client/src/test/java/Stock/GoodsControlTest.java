package Stock;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import junit.framework.TestCase;
import businesslogic.stockbl.MockGoods;
import businesslogic.stockbl.MockGoodsClass;

public class GoodsControlTest extends TestCase{
	MockGoodsClass goodsClass1,goodsClass2;
	String ClassName1;
	String upClass1;
	String ClassID1;
	
	MockGoods good1,good2;
	
	
	public void setUp() throws ParseException {
		goodsClass1=new MockGoodsClass("0001","日光灯类",null);
		goodsClass2=new MockGoodsClass("0002","飞利浦日光灯",goodsClass1);
		
		good1=new MockGoods("00020001","飞利浦日光灯","SR01",10,200,100);
		good2=new MockGoods("00020002","飞利浦日光灯","SR02",20,300,200);
	}

	public void testAddGiftReceipt() throws RemoteException {
		//查找商品分类
		MockGoods good=good1.findByClass(goodsClass2);
		assertEquals(good1,good);
		//添加商品
		ArrayList<MockGoods> goodsList=goodsClass2.findsGoodsInClass(goodsClass2);
		assertEquals(goodsList.size(),2);
	}
}


