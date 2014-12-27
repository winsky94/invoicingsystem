package Promotion;

import java.util.ArrayList;

import po.GiftGoodProPO;
import po.MemberPO.MemberLevel;
import po.PromotionPO;
import po.PromotionPO.PromotionType;
import vo.CommodityVO;
import vo.GiftGoodsProVO;
import vo.PromotionVO;
import businesslogic.promotionbl.giftGoodPro;
import businesslogic.promotionbl.promotionController;
import junit.framework.TestCase;

//TUS1 promotion
public class Promotion_ATest extends TestCase{
	promotionController controll;
	GiftGoodsProVO  goodpro;
	String startDate,endDate;
	ArrayList<CommodityVO> commodity;
	public void setUp() throws Exception{
		controll=new promotionController();
		commodity=new ArrayList<CommodityVO>();
	}
	
	
	//TUS1-1  正常添加一条赠品促销策略
	public void test_1(){
		CommodityVO vo=new CommodityVO("0001-SR01-0001","蓝之恋吊灯","SR01",1000,800,1,1000,800
				,"在做测试");
		startDate="20141201";endDate="20141212";
		commodity.add(vo);
		goodpro=new GiftGoodsProVO("SP-20141128-001",startDate,endDate,MemberLevel.ONE,commodity,
				10000);
		int result=controll.Add(goodpro);
		assertEquals(0,result);
		
		System.out.println("添加一条赠品促销完成");
		PromotionVO gfp=controll.find(goodpro.getId(), PromotionType.GIFTGOODS);
		GiftGoodsProVO v=(GiftGoodsProVO)gfp;
		CommodityVO com=v.getGiftList().get(0);
		assertEquals(vo.getID(),com.getID());
		
		
		
	}
	
	
	//TUS1-2 添加一条代金券促销策略
	public void test_2(){
		ArrayList<PromotionVO> po=controll.Show();
		for(int i=0;i<po.size();i++);
		
	}
	
	//TUS1-3 添加一条折扣促销策略
	public void test_3(){
			
	}
	
	
	//TUS1-4 添加一条特价包促销策略
	public void test_4(){
				
	}
	

	
	

}
