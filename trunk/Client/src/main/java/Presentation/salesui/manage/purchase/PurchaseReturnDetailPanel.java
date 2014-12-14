package Presentation.salesui.manage.purchase;

import Presentation.mainui.MainFrame;

public class PurchaseReturnDetailPanel extends AddPurchasePanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PurchaseReturnDetailPanel(MainFrame frame) throws Exception {
		super(frame);
		title.setText("查看进货退货单详情");
		btnPnl.remove(addGoodsBtn);
		btnPnl.remove(delGoodsBtn);
		btnPnl.remove(submitBtn);
		exitBtn.setText("返回");
		hurryBox.setEnabled(false);
		stockFld.setEditable(false);
		remarkFld.setEditable(false);
		
	}

}
