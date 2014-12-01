package dataservice.salesdataservice;

import java.util.ArrayList;

import po.ReceiptPO;

public interface SaleListDataService {
	public void getSaleList();
	public ArrayList<ReceiptPO> makeSaleList();
}
