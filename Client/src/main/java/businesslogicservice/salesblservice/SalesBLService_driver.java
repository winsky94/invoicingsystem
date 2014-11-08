package businesslogicservice.salesblservice;

public class SalesBLService_driver {
	public void drive(SalesBLService salesBLService){
		salesBLService.purchase(new PurchaseVO(null, null, null, null, null, 0, null, null, 0));
		salesBLService.purchaseReturn(new PurchaseReturnVO(null, null, null, null, 0, null));
		salesBLService.sale(new SaleVO(null, null, null, null, null, null, 0, null, null, 0, 0, 0, 0, 0));
		salesBLService.saleReturn(new SaleReturnVO(null, null, null, null, 0, null));
		salesBLService.showSaleList();
	}
	public static void main(String[] args){
		SalesBLService_driver driver=new SalesBLService_driver();
		driver.drive(new SalesBLService_stub());
	}
}
