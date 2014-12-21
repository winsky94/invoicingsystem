package Presentation.salesui.manage.sale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesBLService;
import vo.LogVO;
import vo.SaleVO;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.mainui.log;
import Presentation.salesui.manage.SaleMgrPanel;

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
		
		p.stockFld.setEditable(false);
		p.remarkFld.setText(vo.getInfo());
		ArrayList<Object> list=new ArrayList<Object>();
		list.addAll(vo.getSalesList());
		p.RefreshCTable(list);
		p.submitBtn.removeActionListener(p);
		p.submitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					p.getSale();
					int result = service.addSale(p.sale);
					if (result == 0) {
						log.addLog(new LogVO(log.getdate(),parent.getUser()
							.getID(), parent.getUser().getName(), "修改一笔销售单", 3));
						headPane.RefreshGrades();
						SaleMgrPanel sp = new SaleMgrPanel(parent);
						parent.setRightComponent(sp);
						sp.RefreshPanel();

					} else
						JOptionPane.showMessageDialog(null, "销售单修改失败", "提示",
							JOptionPane.WARNING_MESSAGE);

			
				}catch(Exception err){
					err.printStackTrace();
				}
			}
			
		});

		//12.20带监听
	}
	
	public void UseToModify(ActionListener ok,ActionListener exit){
		p.submitBtn.addActionListener(ok);
		p.exitBtn.addActionListener(exit);
		
	}
}

