package dataservice.salesdataservice;

import po.PurchasePO;
import po.PurchaseReturnPO;
import po.SalePO;
import po.SaleReturnPO;

public class SalesDataService_stub implements SalesDataService{

	public void getSaleList() {
		// TODO Auto-generated method stub
		System.out.println("getSaleList!");
	}

	public int purchase(PurchasePO po) {
		// TODO Auto-generated method stub
		System.out.println("Purchase Created Successfully!");
		return 0;
	}


	public int purchaseReturn(PurchaseReturnPO po) {
		// TODO Auto-generated method stub
		System.out.println("PurchaseReturn Created Successfully!");
		return 0;
	}


	public int sale(SalePO po) {
		// TODO Auto-generated method stub
		System.out.println("Sale Created Successfully!");
		return 0;
	}


	public int saleReturn(SaleReturnPO po) {
		// TODO Auto-generated method stub
		System.out.println("SaleReturn Created Successfully!");
		return 0;
	}


}
