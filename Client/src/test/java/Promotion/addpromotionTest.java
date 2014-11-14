package Promotion;



import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;
import businesslogic.promotionbl.promotion;
import businesslogic.promotionbl.PromotionType;
import businesslogic.promotionbl.giftGoodPro;
import businesslogic.promotionbl.promotionList;
import businesslogic.stockbl.MockGoods;
import junit.framework.TestCase;
/*
 * 创建赠品促销策略(基本信息，添加赠品)，并发布
 */
public class addpromotionTest extends TestCase{
		private Date startDate,endDate;
		private DateFormat form;
		private promotion promotion;
		private MemberLevel level;
		private MemberType type;
		private MockGoods good1,good2,good3,good4,good;
		private promotionList list;
		public void setUp() throws ParseException {
				form=new SimpleDateFormat("yyyy/mm/dd");
				String s="2014/12/10";
				startDate=form.parse(s);
				s="2014/12/25";
	          	endDate=form.parse(s);
	          	level=MemberLevel.ONE;
	          	type=MemberType.XSS;
	          	list=new promotionList();
	          	good3=new MockGoods();
	          	good4=new MockGoods();
	          	good1=new MockGoods("01010001","飞利浦日光灯","SR01",10,200,100);
	          	good2=new MockGoods("02010002","蓝之恋吊灯","TP05",20,2000,1000);
	         
	          
				
		}
		public void testAddPromotion() throws RemoteException{
			//创建一个赠品促销策略
			promotion=new giftGoodPro(startDate,endDate,level,type);
		    giftGoodPro pro=(giftGoodPro)promotion;
		    good3=good1.getGoods("01010001");
		    good4=good2.getGoods("02010002");
		    //添加，删除已选择赠品
		    pro.AddGoods(good3);
		    pro.AddGoods(good4);  
		    double value=good3.getPurchasePrice()+good4.getPurchasePrice();
		    //统计赠品总值
		    assertEquals(value,pro.getTotalValue());
		    pro.deleteGoods(good3);
		    value-=good3.getPurchasePrice();
		    assertEquals(value,pro.getTotalValue());
		    //发布促销策略
		    int resultRelease=pro.Release(pro);
		    assertEquals(0,resultRelease);
		    assertEquals(1,pro.GetRelease());
		   //赠品列表录取新的赠品信息
		    assertEquals(good4,pro.getgiftList().get(0));
		    //促销策略列表出现新添加的策略
		    assertEquals(pro,list.getProList().get(0));
		    
	}
		

}
