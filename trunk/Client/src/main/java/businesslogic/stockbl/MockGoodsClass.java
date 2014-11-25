package businesslogic.stockbl;

import java.util.ArrayList;

import vo.GoodsClassVO;
import businesslogicservice.stockblservice.goodsclassblservice.StockGoodsClassBLService;

public class MockGoodsClass implements StockGoodsClassBLService {
	String classID;
	String name;
	MockGoodsClass upClass;
	
	public MockGoodsClass(){
		
	}
	
	public MockGoodsClass(String classID , String name, MockGoodsClass upClass) {
		this.classID=classID;
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
	
	public ArrayList<MockGoods> findsGoodsInClass(MockGoodsClass goodsClass) throws Exception{
		ArrayList<MockGoods> goodsList=new ArrayList<MockGoods>();
		ArrayList<MockGoods> result=new ArrayList<MockGoods>();
		MockGoods good1=new MockGoods("00020001","飞利浦日光灯","SR01",10,200,100);
		MockGoods good2=new MockGoods("00020002","飞利浦日光灯","SR02",20,300,200);
		
		goodsList.add(good1);
		goodsList.add(good2);
		
		for(int i=0;i<goodsList.size();i++){
			if(goodsList.get(i).GoodsID.substring(0, 4).equals(goodsClass.classID)){
				result.add(goodsList.get(i));
			}
		}
		
		return result;
	}

}
