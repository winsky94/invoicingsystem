package Presentation.salesui.manage.purchase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider.Service;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;

import businesslogic.userbl.User;
import businesslogicservice.userblservice.UserBLService;
import po.ReceiptPO.ReceiptType;
import vo.CommodityVO;
import vo.PurchaseVO;
import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.mainui.outBorder;
import Presentation.uihelper.UIhelper;
//进货退货只能改变 退货价格？？
public class AddPurchaseReturnPanel extends  ChooseGoodsFatherPane{
	
	MainFrame parent;
	AddPurchasePanel p;
	PurchaseVO pvo;
	String pid;
	UserBLService user;
	purReturnListener returnlisten;
	public AddPurchaseReturnPanel(MainFrame frame,String id) throws Exception {
		user=new User();
		parent=frame;
		this.setLayout(new BorderLayout());
		p=new AddPurchasePanel(parent);
		this.add(p,BorderLayout.CENTER);
		p.title.setText("创建进货退货单");
		pvo=p.service.PFindByID(id);
		pid=p.service.getNewID(ReceiptType.PURCHASERETURN);
		p.IDLbl.setText("编号："+pid);
		p.JHSBox.setSelectedItem(pvo.getMemberName());
		p.JHSBox.setEditable(false);
		p.JHSBox.setEnabled(false);
		p.userLbl.setText("操作员："+user.showUser(pvo.getUser()).getName());
		p.stockFld.setText(pvo.getStockid());
		p.stockFld.setEnabled(false);
		p.remarkFld.setText(pvo.getInfo());
		p.totalMoney=pvo.getTotalInAll();
		p.totalLbl.setText("总计："+p.totalMoney+"元");
		ArrayList<CommodityVO> clist=pvo.getPurchaseList();
		ArrayList<Object> plist=new ArrayList<Object>();
		for(int i=0;i<clist.size();i++)
			plist.add(clist.get(i));
		p.RefreshCTable(plist);
		p.submitBtn.removeActionListener(p.psl);
		returnlisten=new purReturnListener();
		p.submitBtn.addActionListener(returnlisten);
		
		
		
		
		
		

	}
	
	
	class purReturnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
