package dataservice.salesdataservice;
import java.rmi.Remote;


public interface SalesDataService extends Remote{
	public SaleListPO getSaleList();
	public int purchase(PurchasePO po);
	public int purchaseReturn(PurchaseReturnPO po);
	public int sale(SalePO po);
	public int saleReturn(SaleReturnPO po);
}
