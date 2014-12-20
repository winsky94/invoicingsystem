package Presentation.salesui.manage.sale;

import vo.SaleReturnVO;
import Presentation.mainui.MainFrame;

public class ModSaleReturnPanel extends AddSalePanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SaleReturnVO vo;
	public ModSaleReturnPanel(MainFrame frame,String ID) throws Exception {
		super(frame);
		title.setText("修改销售退货单");
		IDLbl.setText("编号:"+vo.getId());
		XSSBox.setSelectedItem(vo.getMemberName());
		XSSBox.setEditable(false);
		stockFld.setText(vo.getStockid());
		stockFld.setEditable(false);
		remarkFld.setText(vo.getInfo());
		//12.20带监听
	}

}
