package Stock;

import java.rmi.RemoteException;
import java.text.ParseException;

import junit.framework.TestCase;
import businesslogic.memberbl.Member;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.stockbl.GoodsClass;
import businesslogic.stockbl.MockGoods;

public class GoodsControlTest extends TestCase{
	GoodsClass goodsClass1,goodsClass2;
	String ClassName1;
	String upClass1;
	String ClassID1;
	
	public void setUp() throws ParseException {
		goodsClass1=new GoodsClass("日光灯类","灯具类");
		goodsClass2=new GoodsClass("飞利浦日光灯","日光灯类");
		
	}

	public void testAddGiftReceipt() throws RemoteException {
		
	}
}


