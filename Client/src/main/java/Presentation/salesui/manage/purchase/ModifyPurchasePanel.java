package Presentation.salesui.manage.purchase;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import vo.CommodityVO;
import vo.PurchaseVO;
import Presentation.mainui.MainFrame;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.PurchaseBLService;

public class ModifyPurchasePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame  parent;
	PurchaseVO vo;
	PurchaseBLService service;
	AddPurchasePanel p;
	public ModifyPurchasePanel(MainFrame father,String id) throws Exception{
		parent=father;
		service=new SalesController();
		vo=service.PFindByID(id);
		p=new AddPurchasePanel(father);
		p.title.setText("修改进货单");
		p.IDLbl.setText("编号："+vo.getId());
		p.JHSBox.setSelectedItem(vo.getMemberName());
		p.JHSBox.setEditable(false);
		p.stockFld.setText(vo.getStockid());
		p.remarkFld.setText(vo.getInfo());
		p.totalLbl.setText("总计："+vo.getTotalInAll()+"元");
		ArrayList<CommodityVO> clist=vo.getPurchaseList();
		ArrayList<Object> plist=new ArrayList<Object>();
		for(int i=0;i<clist.size();i++)
			plist.add(clist.get(i));
		p.RefreshCTable(plist);
		
		
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.CENTER);
		
		
		
	}
}
