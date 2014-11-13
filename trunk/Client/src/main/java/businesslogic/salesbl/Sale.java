package businesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.stockbl.Goods;

public class Sale extends Receipt{
	//要默认业务员
    private String salesman;
    private ArrayList<SaleItem> goodsList;
    private double totalValue;
	public Sale(String id,String memberID, String userID,
			ReceiptType type, Date date, int hurry, int status, String info,
			String sid,String man) {
		super(id, memberID, userID, type, date, hurry, status, info, sid);
		// TODO Auto-generated constructor stub
		this.salesman=man;
		this.goodsList=new ArrayList<SaleItem>();
		this.totalValue=0;
	}
	
	public void  AddGoods(SaleItem item){
		goodsList.add(item);
		this.totalValue+=(item.getTotal());
	}
	
	public void DeleteGoods(SaleItem item){
		goodsList.remove(item);
		this.totalValue-=(item.getTotal());
	}
	
	public void ModifySaleItem(SaleItem item,int i){
		goodsList.set(i, item);
	}
	public int FindSaleItem(SaleItem item){
		return goodsList.indexOf(item);
	}
	
	public void MatchProMotion()
	
	
}

