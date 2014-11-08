package businesslogic.salesbl;

import java.util.ArrayList;

import vo.ReceiptVO;

public class MockSaleList {
	public int exportToEXCEL() {
		return 0;
	}

	public ArrayList<ReceiptVO> showSaleList(){
		return null;
	}
	public double 代金券与实际收款差额收入() {
		return 0.0;
	}

	public double 总的销售收入() {
		return 0.0;
	}

	public double 总的销售成本() {
		return 0.0;
	}

	// 商品进货退货差价收入
	public double importReturnIncome(double total) {
		return total;
	}
}
