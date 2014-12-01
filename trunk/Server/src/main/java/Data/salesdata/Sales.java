package Data.salesdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Data.serutility.JXCFile;
import po.PurchasePO;
import po.PurchaseReturnPO;
import po.SalePO;
import po.SaleReturnPO;
import dataservice.salesdataservice.SalesDataService;

public class Sales extends UnicastRemoteObject implements SalesDataService{
	JXCFile file;
	public Sales() throws RemoteException{
		super();
		file=new JXCFile("src/main/java/collection.ser");
	}
	public void getSaleList() {
		
		
	}

	public int purchase(PurchasePO po) {
		file=new JXCFile("src/main/java/purchase.ser");
		file.write(po);
		return 0;
	}
	
	public P

	public int purchaseReturn(PurchaseReturnPO po) {
		file=new JXCFile("src/main/java/purchasereturn.ser");
		file.write(po);
		return 0;
	}

	public int sale(SalePO po) {
		file=new JXCFile("src/main/java/sale.ser");
		file.write(po);
		return 0;
	}

	public int saleReturn(SaleReturnPO po) {
		file=new JXCFile("src/main/java/salereturn.ser");
		file.write(po);
		return 0;
	}

}
