package Presentation.salesui.manage.purchase;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import vo.CommodityVO;
import vo.PurchaseReturnVO;
import Presentation.mainui.MainFrame;

public class ModPurchaseReturnPanel extends AddPurchasePanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PurchaseReturnVO vo;
	public ModPurchaseReturnPanel( String id,MainFrame frame) throws Exception {
		super(frame);
		title.setText("修改进货退货单");
		IDLbl.setText("编号："+vo.getId());
		JHSBox.setSelectedItem(vo.getMemberName());
		JHSBox.setEditable(false);
		stockFld.setText(vo.getStockid());
		remarkFld.setText(vo.getInfo());
		totalLbl.setText("总计："+vo.getTotalInAll()+"元");
		ArrayList<CommodityVO> clist=vo.getPurchaseReturnList();
		ArrayList<Object> plist=new ArrayList<Object>();
		for(int i=0;i<clist.size();i++)
			plist.add(clist.get(i));
		RefreshCTable(plist);
		//12.20待加监听
	}
	
	public void UseToModify(ActionListener ok){
		submitBtn.addActionListener(ok);
		exitBtn.addActionListener(ok);
		
	}

}
