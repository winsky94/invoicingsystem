package Presentation.salesui.manage.sale;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesBLService;
import vo.LogVO;
import vo.SaleVO;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.mainui.log;
import Presentation.salesui.manage.SaleMgrPanel;

public class ModSalePanel extends JPanel{
	MainFrame parent;
	AddSalePanel p;
	SaleVO vo;
	SalesBLService service;
	
	public  ModSalePanel(MainFrame father,String id) throws Exception{
		parent=father;
		service=new SalesController();
		vo=service.SFindByID(id);
		
		p=new AddSalePanel(father);
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.CENTER);
		p.title.setText("修改销售单");
		p.IDLbl.setText("编号:"+vo.getId());
		p.XSSBox.setSelectedItem(vo.getMemberName());
		p.XSSBox.setEditable(false);
		p.stockFld.setText(vo.getStockid());
		p.discountMoneyFld.setText(vo.getDiscount()[2]+"");
		p.stockFld.setEditable(false);
		p.remarkFld.setText(vo.getInfo());
		p.btnPnl.remove(p.addGoodsBtn);
		p.btnPnl.remove(p.delGoodsBtn);
		p.totalOriginLbl.setText("原初总价:"+vo.getTotalOrigin()+"元");
		p.totalProDiscountLbl.setText("折让金额:"+(vo.getTotalOrigin()-vo.getTotalValue())+"元");
		p.totalFinDiscountLbl.setText("折后总价:"+vo.getTotalValue()+"元");
		p.totalToPayLbl.setText("客户应付:"+vo.getToPay()+"元");
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
					int result = service.modifySale(p.sale);
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
		p.exitBtn.removeActionListener(p);;

		//12.20带监听
	}
	
	public void UseToModify(ActionListener ok){
		p.submitBtn.addActionListener(ok);
		p.exitBtn.addActionListener(ok);
		
	}
}

