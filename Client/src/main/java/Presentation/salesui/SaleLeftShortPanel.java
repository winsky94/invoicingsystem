package Presentation.salesui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import businesslogic.memberbl.Member;
import businesslogic.salesbl.SaleList;
import businesslogic.userbl.User;
import businesslogicservice.memberblservice.MemberBLService;
import businesslogicservice.salesblservice.SaleListBLService;
import vo.UserVO;
import Presentation.mainui.JLeftButton;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.memberui.MemberMgrPanel;
import Presentation.salesui.manage.PurchaseMgrPanel;
import Presentation.salesui.manage.SaleMgrPanel;
import Presentation.uihelper.AboutPanel;
import Presentation.userui.UserMgrPanel;

//选中后 变色 以后==========
public class SaleLeftShortPanel extends JPanel implements ActionListener{
	MainFrame parent;	
	Color salesColor;
	MemberBLService service;
	JLeftButton purchaseBtn, saleBtn, memberBtn,aboutBtn,backBtn;
	SaleListBLService  saleservice;
	public SaleLeftShortPanel(MainFrame frame) throws Exception{
		salesColor=frame.getTheme()[0];
		parent=frame;
		saleservice=new SaleList();
		//===构造头像
		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
	
		UserVO user=frame.getUser();
		this.setLayout(grid);
		
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;c.gridy=0;
		c.gridheight=2;
		
		headPane headPane=new headPane(parent,this,user,1);
		grid.setConstraints(headPane, c);
		this.add(headPane);
		
		
		
		
		JPanel down=new JPanel();
		c.weightx=3;c.weighty=4;
		c.gridx=0;c.gridy=2;
		c.gridheight=6;
		c.gridwidth=1;
		grid.setConstraints(down, c);
		this.add(down);
		down.setBackground(salesColor);
		down.setLayout(new GridLayout(6,1));
		
		
		memberBtn = new JLeftButton(
				new ImageIcon("img/sales/memberMgr.png"),salesColor);
		
		
		memberBtn.addActionListener(this);
		down.add(memberBtn);
		// 进货管理按钮
		purchaseBtn = new JLeftButton(new ImageIcon(
				"img/sales/purchaseMgr.png"),salesColor);
		purchaseBtn.addActionListener(this);
		down.add(purchaseBtn);
		// 销售管理按钮
		saleBtn = new JLeftButton( new ImageIcon("img/sales/saleMgr.png"),
				salesColor);

		saleBtn.addActionListener(this);
		down.add(saleBtn);
		// 关于按钮
		aboutBtn = new JLeftButton( new ImageIcon("img/icon-about.png"),
				salesColor);
		aboutBtn.addActionListener(this);
		down.add(aboutBtn);
		//
		
		backBtn=new JLeftButton(new ImageIcon("img/mainFrame/backLong.png"),salesColor);
		backBtn.addActionListener(this);
		c.gridx=0;c.gridy=8;
		grid.setConstraints(backBtn, c);
		this.add(backBtn);
		this.setBackground(salesColor);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==backBtn)
			parent.setLeftComponent(new SalesLeftPanel(parent));
		else if(e.getSource()==aboutBtn)
			parent.setRightComponent(new AboutPanel());
		else if(e.getSource()==saleBtn)
			parent.setRightComponent(new SaleMgrPanel(parent));
		else if(e.getSource()==memberBtn){
			MemberMgrPanel mgr=new MemberMgrPanel(parent);
			try {
				service=new Member();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			parent.setRightComponent(mgr);
			if(service.showMembers()!=null)
				mgr.RefreshMemberTable(service.showMembers());
		
			
		}else if(e.getSource()==purchaseBtn){
			
			parent.setRightComponent(new PurchaseMgrPanel(parent));}
	//	else if(e.getSource())
		
	}
	

}
