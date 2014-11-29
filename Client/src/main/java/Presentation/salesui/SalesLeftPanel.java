package Presentation.salesui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import po.UserPO.UserJob;
import businesslogic.userbl.User;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.memberui.MemberMgrPanel;
import Presentation.salesui.manage.PurchaseMgrPanel;
import Presentation.salesui.manage.SaleMgrPanel;
import Presentation.salesui.manage.sale.SaleDialog;
import Presentation.uihelper.AboutPanel;
import Presentation.uihelper.UIhelper;
import Presentation.uihelper.UserInfoButton;

public class SalesLeftPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel leftPnl;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int frameWidth = screenWidth * 85 / 100;
	int frameHeight = screenHeight * 85 / 100;

	JButton userInfoBtn,purchaseBtn, saleBtn, memberBtn,aboutBtn,backBtn;
	//JPanel memberMgrPnl, purchaseMgrPnl, saleMgrPnl, aboutPnl,rightPnl;
	Color salesColor;
	MainFrame parent;
	JPanel headPane;
	public SalesLeftPanel(JFrame frame){
		salesColor=((MainFrame)frame).getTheme()[0];
		parent=(MainFrame)frame;
		//暂时处理  需读文件读取
		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
	//	this.setLayout(new GridLayout(8, 1));
		User user=new User("王宁宁",UserJob.SALE,1200);
		this.setLayout(grid);
		
		//this.setLayout(new GridLayout(9,1));
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;c.gridy=0;
		c.gridheight=2;
		
		headPane=new headPane(parent,this,user);
		//c.gridheight=headPane.getHeight();
		grid.setConstraints(headPane, c);
		this.add(headPane);
		JPanel down=new JPanel();
		c.weightx=0.3;c.weighty=0.4;
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
		
		memberBtn = new JButton("客户管理",
				new ImageIcon("img/sales/memberMgr.png"));
		memberBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// memberBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		memberBtn.setForeground(Color.white);
		// memberBtn.setBorderPainted(false);
		memberBtn.setBackground(salesColor);
		memberBtn.setHorizontalAlignment(SwingConstants.CENTER);
		memberBtn.setFocusPainted(false);
		memberBtn.addActionListener(this);
		down.add(memberBtn);
		// 进货管理按钮
		purchaseBtn = new JButton("进货管理", new ImageIcon(
				"img/sales/purchaseMgr.png"));
		purchaseBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// purchaseBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		purchaseBtn.setForeground(Color.white);
		// purchaseBtn.setBorderPainted(false);
		purchaseBtn.setBackground(salesColor);
		purchaseBtn.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseBtn.setFocusPainted(false);
		purchaseBtn.addActionListener(this);
		down.add(purchaseBtn);
		// 销售管理按钮
		saleBtn = new JButton("销售管理", new ImageIcon("img/sales/saleMgr.png"));
		saleBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// saleBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		saleBtn.setForeground(Color.white);
		// saleBtn.setBorderPainted(false);
		saleBtn.setBackground(salesColor);
		saleBtn.setHorizontalAlignment(SwingConstants.CENTER);
		saleBtn.setFocusPainted(false);
		saleBtn.addActionListener(this);
		down.add(saleBtn);
		// 关于按钮
		aboutBtn = new JButton("关于系统", new ImageIcon("img/icon-about.png"));
		aboutBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		aboutBtn.setForeground(Color.white);
		aboutBtn.setBackground(salesColor);
		aboutBtn.setHorizontalAlignment(SwingConstants.CENTER);
		aboutBtn.setFocusPainted(false);
		aboutBtn.addActionListener(this);
		down.add(aboutBtn);
		//
		
		backBtn=new JButton("收起菜单",new ImageIcon("img/mainFrame/back.png"));
		backBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		backBtn.setForeground(Color.white);
		backBtn.setBackground(salesColor);
		backBtn.setHorizontalAlignment(SwingConstants.CENTER);
		backBtn.setFocusPainted(false);
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
			
		}else if(e.getSource()==memberBtn){
			
		}else if(e.getSource()==saleBtn){
			parent.setRightComponent(new SaleDialog(parent));
			
		}else if(e.getSource()==aboutBtn){
			
		}else if(e.getSource()==backBtn){
			
		}
		
	}
}
