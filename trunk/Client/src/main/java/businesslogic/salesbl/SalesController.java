package businesslogic.salesbl;

import java.util.ArrayList;

import vo.PurchaseReturnVO;
import vo.PurchaseVO;
import vo.SaleReturnVO;
import vo.SaleVO;
import businesslogicservice.salesblservice.SalesBLService;

public class SalesController implements SalesBLService{

	public int purchase(PurchaseVO vo) {
		Purchase p=new Purchase(vo.getPurchaseList(), vo.getId(),
				vo.getMemberName(),vo.getMemberID(), vo.getUser(),vo.getCreateDate(),
				vo.getStatus(), vo.getHurry(),vo.getInfo(),vo.getStockid());
		return p.createPurchase();
	}

	public int purchaseReturn(PurchaseReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int sale(SaleVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int saleReturn(SaleReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void showSaleList() {
		// TODO Auto-generated method stub
		
	}

	public int modifyPurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifyPurchaseReturn(PurchaseReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifySale(SaleVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifySaleReturn(SaleReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<PurchaseVO> showPurchase() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PurchaseReturnVO> showPurchaseReturn() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SaleVO> showSale() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SaleReturnVO> showSaleReturn() {
		// TODO Auto-generated method stub
		return null;
	}

	public int exportSaleListToExcel() {
		// TODO Auto-generated method stub
		return 0;
	}

}
