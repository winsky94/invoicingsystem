package businesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;

public class Purchase extends Receipt {
	private ArrayList<Commodity> commodityList;
	private double totalValue;

	

	public Purchase(String id, String memberID, String userID,
		 Date date, int hurry, int status, String info,
			String sid) {
		super(id, memberID, userID, ReceiptType.PURCHASE, date, hurry, status, info, sid);
		// TODO Auto-generated constructor stub
		this.commodityList=new ArrayList<Commodity>();
		this.totalValue=0;
	}

	public void AddCommodity(MockCommodity com){
		commodityList.add(com);
		this.totalValue+=com.getTotalPrice();
	}
	
	
	public void DeleteCommodity(MockCommodity com){
		commodityList.remove(com);
		this.totalValue-=com.getTotalPrice();
		
	}
	
	
	
	public double getTotalValue(){
		return this.totalValue;
	}
}
