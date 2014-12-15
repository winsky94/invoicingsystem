package Presentation.salesui.manage.sale;

import Presentation.mainui.MainFrame;

public class SaleDetailPanel extends AddSalePanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SaleDetailPanel(String ID,MainFrame frame) throws Exception {
		super(frame);
		title.setText("查看销售单详情");
	}


}
