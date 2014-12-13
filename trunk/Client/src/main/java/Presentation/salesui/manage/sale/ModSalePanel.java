package Presentation.salesui.manage.sale;

import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesBLService;
import vo.SaleVO;
import Presentation.mainui.MainFrame;

public class ModSalePanel {
	MainFrame parent;
	AddSalePanel p;
	SaleVO vo;
	SalesBLService service;
	
	public  ModSalePanel(MainFrame father,String id) throws Exception{
		parent=father;
		service=new SalesController();
		vo=service.SFindByID(id);
		p=new AddSalePanel(father);
		p.title.setText("修改销售单");
		p.IDLbl.setText("编号:"+vo.getId());
		p.XSSBox.setSelectedItem(vo.getMemberName());
		p.XSSBox.setEditable(false);
		p.stockFld.setText(vo.getStockid());
		p.remarkFld.setText(vo.getInfo());
		
		
	}
}
