package dataservice.salesdataservice;

public class SalesDataService_driver {
	public void drive(SalesDataService salesDataService){
		salesDataService.purchase(new PurchasePO());
		salesDataService.purchaseReturn(new PurchaseReturnPO());
		salesDataService.sale(new SalePO());
		salesDataService.saleReturn(new SaleReturnPO());
		salesDataService.getSaleList();
	}
	public static void main(String[] args){
		SalesDataService_driver driver=new SalesDataService_driver();
		driver.drive(new SalesDataService_stub());
	}
}
