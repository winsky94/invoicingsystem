package businesslogic.salesbl;

import java.util.ArrayList;

import vo.ReceiptVO;
import businesslogicservice.salesblservice.SaleListBLService;

public class MockSaleList implements SaleListBLService{
	public int exportSaleListToExcel() {
		return 0;
	}
	public ArrayList<ReceiptVO> showSaleList(){
		return null;
	}
	public double couponProfitCalc(){
		//计算代金券与实际收款差额收入
		return 0.0;
	}
	
	public double purchaseReturnProfitCalc() {
			// 计算商品进货退货差价收入
			return 0.0;
		}
	public double totalMoneyWeGot(){
		//总的销售收入
		return 0.0;
	}
	public double totalMoneyWePaid(){
		//总的销售成本
		return 0.0;
	}	
}
