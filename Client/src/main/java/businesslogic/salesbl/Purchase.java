package businesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.stockbl.Goods;
import businesslogic.stockbl.MockGoods;

public class Purchase extends Receipt {
	private ArrayList<Goods> commodityList;
	private double totalValue;
	
	public Purchase(){
		
	}

	public Purchase(String id, String memberID, String userID,
		 Date date, int hurry, int status, String info,
			String sid) {
		super(id, memberID, userID, ReceiptType.PURCHASE, date, hurry, status, info, sid);
		// TODO Auto-generated constructor stub
		this.commodityList=new ArrayList<Goods>();
		this.totalValue=0;
	}

	public void AddGood(Goods good){
		commodityList.add(good);
		this.totalValue+=good.getPurchasePrice();
	}
	
	public void DeleteGood(MockCommodity com){
		commodityList.remove(com);
		this.totalValue-=com.getTotalPrice();
		
	}
	
	
	
	public double getTotalValue(){
		return this.totalValue;
	}

	public MockGoods createPurchase() throws Exception{
		MockGoods good0 = (MockGoods) commodityList.get(0);
		MockGoods good = new MockGoods("00020001", "飞利浦日光灯", "SR01", 20, 200,
				100);
		MockGoods newGood = new MockGoods("00020001", "飞利浦日光灯", "SR01",
				20 + good0.getNum(), 200, 100);

		good.modifyGoods(newGood);

		return good;
	}
}
