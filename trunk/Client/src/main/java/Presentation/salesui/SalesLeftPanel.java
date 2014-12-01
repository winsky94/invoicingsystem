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
import businesslogicservice.memberblservice.MemberBLService;
import vo.UserVO;
import Presentation.mainui.JLeftButton;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.memberui.MemberMgrPanel;
import Presentation.salesui.manage.PurchaseMgrPanel;
import Presentation.salesui.manage.SaleMgrPanel;
import Presentation.salesui.manage.sale.SalePane;
import Presentation.uihelper.AboutPanel;
import Presentation.uihelper.UIhelper;
import Presentation.uihelper.UserInfoButton;

public class SalesLeftPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//JPanel leftPnl;
	////int screenWidth = UIhelper.getScreenWidth();
	//int screenHeight = UIhelper.getScreenHeight();
	////int frameWidth = screenWidth * 85 / 100;
	//int frameHeight = screenHeight * 85 / 100;

	JLeftButton purchaseBtn, saleBtn, memberBtn,aboutBtn,backBtn;
	//JPanel memberMgrPnl, purchaseMgrPnl, saleMgrPnl, aboutPnl,rightPnl;
	Color salesColor;
	MainFrame parent;
	JPanel headPane;
	MemberBLService service;
	public SalesLeftPanel(MainFrame frame){
		salesColor=frame.getTheme()[0];
		parent=frame;
		//===构造头像
		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
	
		UserVO user=frame.getUser();
		this.setLayout(grid);
		
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;c.gridy=0;
		c.gridheight=2;
		
		headPane=new headPane(parent,this,user,0);
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
		
		
		//
		/*!!!!!BL看这里！！：这里的构造器应放入User姓名和头像！！！！！！！！！*/
		//userInfoBtn=new UserInfoButton("严顺宽", new ImageIcon("img/sales/ysk.png"),salesColor);
		// 客户管理按钮
		
		memberBtn = new JLeftButton("客户管理",
				new ImageIcon("img/sales/memberMgr.png"),salesColor);
		
		
		memberBtn.addActionListener(this);
		down.add(memberBtn);
		// 进货管理按钮
		purchaseBtn = new JLeftButton("进货管理", new ImageIcon(
				"img/sales/purchaseMgr.png"),salesColor);
		purchaseBtn.addActionListener(this);
		down.add(purchaseBtn);
		// 销售管理按钮
		saleBtn = new JLeftButton("销售管理", new ImageIcon("img/sales/saleMgr.png"),
				salesColor);

		saleBtn.addActionListener(this);
		down.add(saleBtn);
		// 关于按钮
		aboutBtn = new JLeftButton("关于系统", new ImageIcon("img/icon-about.png"),
				salesColor);
		aboutBtn.addActionListener(this);
		down.add(aboutBtn);
		//
		
		backBtn=new JLeftButton("收起菜单",new ImageIcon("img/mainFrame/back.png"),salesColor);
		backBtn.addActionListener(this);
		c.gridx=0;c.gridy=8;
		grid.setConstraints(backBtn, c);
		this.add(backBtn);
		this.setBackground(salesColor);
		
}
	
	//JButton userInfoBtn,purchaseBtn, saleBtn, memberBtn,aboutBtn;
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==purchaseBtn){
			parent.setRightComponent(new PurchaseMgrPanel(parent));
		}else if(e.getSource()==memberBtn){
			MemberMgrPanel mgr=new MemberMgrPanel(parent);
			try {
				service=new Member();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			parent.setRightComponent(mgr);
			mgr.RefreshMemberTable(service.showMembers());
		}else if(e.getSource()==saleBtn){
			parent.setRightComponent(new SaleMgrPanel(parent));
			
		}else if(e.getSource()==aboutBtn){
			parent.setRightComponent(new AboutPanel());
		}else if(e.getSource()==backBtn){
			parent.setLeftComponent(new SaleLeftShortPanel(parent));
		}
		
			
		
	}
}