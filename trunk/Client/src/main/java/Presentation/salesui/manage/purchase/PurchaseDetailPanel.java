package Presentation.salesui.manage.purchase;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.CommodityVO;
import vo.PurchaseVO;
import Presentation.mainui.MainFrame;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.viewInfoService;

public class PurchaseDetailPanel extends JPanel{
	
	MainFrame  parent;
	PurchaseVO vo;
	viewInfoService service;
	public AddPurchasePanel p;
	JLabel member;
	public PurchaseDetailPanel(MainFrame father,String id) throws Exception{
		p=new AddPurchasePanel(father);
		parent=father;
		service=new SalesController();
		vo=service.PFindByID(id);
		p.title.setText("查看进货单详情");
		p.IDLbl.setText("编号："+vo.getId());
		p.JHSLbl.setText("进货商："+vo.getMemberName());
		p.p1.remove(p.JHSBox);
		p.stockFld.setText(vo.getStockid());
		p.stockFld.setEditable(false);;
		p.remarkFld.setText(vo.getInfo());
		p.remarkFld.setEditable(false);
		p.totalLbl.setText("总计："+vo.getTotalInAll()+"元");
		ArrayList<CommodityVO> clist=vo.getPurchaseList();
		ArrayList<Object> plist=new ArrayList<Object>();
		for(int i=0;i<clist.size();i++)
			plist.add(clist.get(i));   
		p.RefreshCTable(plist);  
		p.btnPnl.remove(p.addGoodsBtn);
		p.btnPnl.remove(p.delGoodsBtn);
		p.btnPnl.remove(p.submitBtn);
		p.exitBtn.setText("返回");
		p.table.setEnabled(false);
		if(vo.getHurry()==0)
			p.hurryBox.setSelected(true);
		p.hurryBox.setEnabled(false);
		
			
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.CENTER);
		this.repaint();
	
		
		
		
		
		
	}
	public void useToReceipt() {
		// TODO Auto-generated method stub
	
		p.btnPnl.remove(p.exitBtn);
		
		
	}

}
