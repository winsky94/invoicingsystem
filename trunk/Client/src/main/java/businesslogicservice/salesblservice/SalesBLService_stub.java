package businesslogicservice.salesblservice;
import java.util.ArrayList;

import vo.PurchaseReturnVO;
import vo.PurchaseVO;
import vo.SaleReturnVO;
import vo.SaleVO;


public class SalesBLService_stub implements SalesBLService{

	public int purchase(PurchaseVO vo) {
		System.out.println("Purchase Successfully!");
		return 0;
	}

	public int purchaseReturn(PurchaseReturnVO vo) {
		// TODO Auto-generated method stub
		System.out.println("PurchaseReturn Successfully!");
		return 0;
	}

	public int sale(SaleVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Sale Successfully!");
		return 0;
	}

	public int saleReturn(SaleReturnVO vo) {
		// TODO Auto-generated method stub
		System.out.println("SaleReturn Successfully!");
		return 0;
	}

	public void showSaleList() {
		// TODO Auto-generated method stub
		System.out.println("showSaleList!");

	}

	public ArrayList<PurchaseVO> showPurchase() {
		// TODO Auto-generated method stub
		System.out.println("showPurchase!");
		return null;
	}

	public ArrayList<PurchaseReturnVO> showPurchaseReturn() {
		// TODO Auto-generated method stub
		System.out.println("showPurchaseReturn!");
		return null;
	}

	public ArrayList<SaleVO> showSale() {
		// TODO Auto-generated method stub
		System.out.println("showSale!");
		return null;
	}

	public ArrayList<SaleReturnVO> showSaleReturn() {
		// TODO Auto-generated method stub
		System.out.println("showSaleReturn!");
		return null;
	}

	public int modifyPurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Modify Purchase Successfully!");
		return 0;
	}

	public int modifyPurchaseReturn(PurchaseReturnVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Modify PurchaseReturn Successfully!");
		return 0;
	}

	public int modifySale(SaleVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Modify Sale Successfully!");
		return 0;
	}

	public int modifySaleReturn(SaleReturnVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Modify SaleReturn Successfully!");
		return 0;
	}

	public int exportSaleListToExcel() {
		// TODO Auto-generated method stub
		System.out.println("Export to Excel!");
		return 0;
	}

}
