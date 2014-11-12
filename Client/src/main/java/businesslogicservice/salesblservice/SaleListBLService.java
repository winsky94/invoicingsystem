package businesslogicservice.salesblservice;

import java.util.ArrayList;

import vo.ReceiptVO;

public interface SaleListBLService {
	public int exportSaleListToExcel();
	public ArrayList<ReceiptVO> showSaleList();
	public double couponProfitCalc();
	public double totalMoneyWeGot();
	public double totalMoneyWePaid();
}
