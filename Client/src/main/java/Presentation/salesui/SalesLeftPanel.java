package Presentation.salesui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Presentation.uihelper.UserInfoButton;

public class SalesLeftPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton userInfoBtn,purchaseBtn, saleBtn, memberBtn,aboutBtn;
	JPanel memberMgrPnl, purchaseMgrPnl, saleMgrPnl, aboutPnl,rightPnl;

	public SalesLeftPanel(JPanel memberMgrPnl, JPanel purchaseMgrPnl,
			JPanel saleMgrPnl, JPanel aboutPnl, JPanel rightPnl) {
		this.setLayout(new GridLayout(10, 1));
		//
		/*!!!!!BL看这里！！：这里的构造器应放入User姓名和头像！！！！！！！！！*/
		userInfoBtn=new UserInfoButton("严顺宽", new ImageIcon("img/sales/ysk.png"));
		this.add(userInfoBtn);
		// 客户管理按钮
		memberBtn = new JButton("客户管理",
				new ImageIcon("img/sales/memberMgr.png"));
		memberBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// memberBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		memberBtn.setForeground(Color.white);
		// memberBtn.setBorderPainted(false);
		memberBtn.setBackground(new Color(47, 73, 136));
		memberBtn.setHorizontalAlignment(SwingConstants.CENTER);
		memberBtn.setFocusPainted(false);
		memberBtn.addActionListener(new MemberBtnListener());
		this.add(memberBtn);
		// 进货管理按钮
		purchaseBtn = new JButton("进货管理", new ImageIcon(
				"img/sales/purchaseMgr.png"));
		purchaseBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// purchaseBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		purchaseBtn.setForeground(Color.white);
		// purchaseBtn.setBorderPainted(false);
		purchaseBtn.setBackground(new Color(47, 73, 136));
		purchaseBtn.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseBtn.setFocusPainted(false);
		purchaseBtn.addActionListener(new PurchaseBtnListener());
		this.add(purchaseBtn);
		// 销售管理按钮
		saleBtn = new JButton("销售管理", new ImageIcon("img/sales/saleMgr.png"));
		saleBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// saleBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		saleBtn.setForeground(Color.white);
		// saleBtn.setBorderPainted(false);
		saleBtn.setBackground(new Color(47, 73, 136));
		saleBtn.setHorizontalAlignment(SwingConstants.CENTER);
		saleBtn.setFocusPainted(false);
		saleBtn.addActionListener(new SaleBtnListener());
		this.add(saleBtn);
		// 关于按钮
		aboutBtn = new JButton("关于系统", new ImageIcon("img/icon-about.png"));
		aboutBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// aboutBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		aboutBtn.setForeground(Color.white);
		// saleBtn.setBorderPainted(false);
		aboutBtn.setBackground(new Color(47, 73, 136));
		aboutBtn.setHorizontalAlignment(SwingConstants.CENTER);
		aboutBtn.setFocusPainted(false);
		aboutBtn.addActionListener(new AboutBtnListener());
		this.add(aboutBtn);
		//
		this.setBackground(new Color(47, 73, 136));
		this.memberMgrPnl = memberMgrPnl;
		this.purchaseMgrPnl = purchaseMgrPnl;
		this.saleMgrPnl = saleMgrPnl;
		this.aboutPnl=aboutPnl;
		this.rightPnl = rightPnl;
	}

	// -------------------监听----------------------------------------------
	class MemberBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			memberMgrPnl.setVisible(true);
			purchaseMgrPnl.setVisible(false);
			saleMgrPnl.setVisible(false);
			aboutPnl.setVisible(false);
			rightPnl.setVisible(false);
		}

	}

	class PurchaseBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			memberMgrPnl.setVisible(false);
			purchaseMgrPnl.setVisible(true);
			saleMgrPnl.setVisible(false);
			aboutPnl.setVisible(false);
			rightPnl.setVisible(false);
		}

	}

	class SaleBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			memberMgrPnl.setVisible(false);
			purchaseMgrPnl.setVisible(false);
			saleMgrPnl.setVisible(true);
			aboutPnl.setVisible(false);
			rightPnl.setVisible(false);
		}

	}
	class AboutBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			memberMgrPnl.setVisible(false);
			purchaseMgrPnl.setVisible(false);
			saleMgrPnl.setVisible(false);
			aboutPnl.setVisible(true);
			rightPnl.setVisible(false);
		}
		
	}
}
