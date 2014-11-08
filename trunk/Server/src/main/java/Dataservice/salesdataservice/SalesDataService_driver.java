package Dataservice.salesdataservice;

import po.PurchasePO;
import po.PurchaseReturnPO;
import po.SalePO;
import po.SaleReturnPO;

public class SalesDataService_driver {
	public void drive(SalesDataService salesDataService){
		salesDataService.purchase(new PurchasePO(null, null, null, null, null, 0, 0, null, null, 0));
		salesDataService.purchaseReturn(new PurchaseReturnPO(null, null, null, null, 0, null, 0));
		salesDataService.sale(new SalePO());
		salesDataService.saleReturn(new SaleReturnPO(null, null, null, null, 0, null, 0));
		salesDataService.getSaleList();
	}
	public static void main(String[] args){
		SalesDataService_driver driver=new SalesDataService_driver();
		driver.drive(new SalesDataService_stub());
	}
}
