package businesslogicservice.salesblservice;
import java.util.ArrayList;


public class SalesBLService_stub implements SalesBLService{

	@Override
	public int purchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Purchase Successfully!");
		return 0;
	}

	@Override
	public int purchaseReturn(PurchaseReturnVO vo) {
		// TODO Auto-generated method stub
		System.out.println("PurchaseReturn Successfully!");
		return 0;
	}

	@Override
	public int sale(SaleVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Sale Successfully!");
		return 0;
	}

	@Override
	public int saleReturn(SaleReturnVO vo) {
		// TODO Auto-generated method stub
		System.out.println("SaleReturn Successfully!");
		return 0;
	}

	@Override
	public SaleListVO showSaleList() {
		// TODO Auto-generated method stub
		System.out.println("showSaleList!");
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> showPurchase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PurchaseReturnVO> showPurchaseReturn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SaleVO> showSale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SaleReturnVO> showSaleReturn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyPurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyPurchaseReturn(PurchaseReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifySale(SaleVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifySaleReturn(SaleReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
