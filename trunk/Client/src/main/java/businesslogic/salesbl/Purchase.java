package businesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

import vo.PurchaseVO;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogic.stockbl.goods.Goods;
import businesslogic.stockbl.goods.MockGoods;

public class Purchase extends Receipt {
	private ArrayList<Commodity> list;//商品清单
	private double totalValue;
	private String stockID;
	
	public Purchase(PurchaseVO vo){
		list=vo.getPurchaseList();
		totalValue=vo.getTotalInAll();
		
	}

	
	public int AddPurchaseItem(Commodity item){
		if(!(list.indexOf(item)<0)){
			return 1;//添加失败，已存在
		}
		else
		{list.add(item);
		 totalValue+=item.getTotal();
		return 0;}
	}
	
	public void DeletePurcaseItem(String ID){
		Commodity item=find(ID);
		totalValue-=item.getTotal();
		
		list.remove(item);
		
	}
	
	public Commodity find(String ID){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId().equals(ID))
				return list.get(i);
		}
		return null;//不可能没有把
	}
	
	public void ModifyPurchaseItem(double total,Commodity nItem){
		int i=list.indexOf(find(nItem.getId()));
		totalValue-=total;
		list.set(i, nItem);
		totalValue+=nItem.getTotal();
		
	}
	
	public void updateVO(PurchaseVO vo){
		vo.setPurchaseList(list);
		vo.setTotalValue(totalValue);
		
	}
	
	public double getTotalValue(){
		return this.totalValue;
	}

	
}
