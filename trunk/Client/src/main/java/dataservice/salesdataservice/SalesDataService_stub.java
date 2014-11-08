package dataservice.salesdataservice;

public class SalesDataService_stub implements SalesDataService{

	@Override
	public SaleListPO getSaleList() {
		// TODO Auto-generated method stub
		System.out.println("getSaleList!");
		return null;
	}

	@Override
	public int purchase(PurchasePO po) {
		// TODO Auto-generated method stub
		System.out.println("Purchase Created Successfully!");
		return 0;
	}

	@Override
	public int purchaseReturn(PurchaseReturnPO po) {
		// TODO Auto-generated method stub
		System.out.println("PurchaseReturn Created Successfully!");
		return 0;
	}

	@Override
	public int sale(SalePO po) {
		// TODO Auto-generated method stub
		System.out.println("Sale Created Successfully!");
		return 0;
	}

	@Override
	public int saleReturn(SaleReturnPO po) {
		// TODO Auto-generated method stub
		System.out.println("SaleReturn Created Successfully!");
		return 0;
	}

}
