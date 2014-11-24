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

import Presentation.salesui.managerPanel.MemberMgrPanel;
import Presentation.salesui.managerPanel.PurchaseMgrPanel;
import Presentation.salesui.managerPanel.SaleMgrPanel;

public class SalesLeftBtnPnl extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton purchaseBtn, saleBtn, memberBtn;
	JPanel memberMgrPnl, purchaseMgrPnl, saleMgrPnl,rightPnl;

	public SalesLeftBtnPnl(JPanel memberMgrPnl,JPanel purchaseMgrPnl,JPanel saleMgrPnl,JPanel rightPnl) {
		this.setLayout(new GridLayout(10, 1));
		// 客户管理按钮
		memberBtn = new JButton("客户管理",
				new ImageIcon("img/sales/memberMgr.png"));
		memberBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// memberBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		memberBtn.setForeground(Color.white);
		// memberBtn.setBorderPainted(false);
		memberBtn.setBackground(new Color(47, 73, 136));
		memberBtn.setHorizontalAlignment(SwingConstants.LEFT);
		memberBtn.setFocusPainted(false);
		memberBtn.addActionListener(new MemberBtnListener());
		this.add(memberBtn);
		// 进货管理按钮
		purchaseBtn = new JButton("进货管理", new ImageIcon(
				"img/sales/memberMgr.png"));
		purchaseBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// purchaseBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		purchaseBtn.setForeground(Color.white);
		// purchaseBtn.setBorderPainted(false);
		purchaseBtn.setBackground(new Color(47, 73, 136));
		purchaseBtn.setHorizontalAlignment(SwingConstants.LEFT);
		purchaseBtn.setFocusPainted(false);
		purchaseBtn.addActionListener(new PurchaseBtnListener());
		this.add(purchaseBtn);
		// 销售管理按钮
		saleBtn = new JButton("销售管理", new ImageIcon("img/sales/memberMgr.png"));
		saleBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		// saleBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		saleBtn.setForeground(Color.white);
		// saleBtn.setBorderPainted(false);
		saleBtn.setBackground(new Color(47, 73, 136));
		saleBtn.setHorizontalAlignment(SwingConstants.LEFT);
		saleBtn.setFocusPainted(false);
		saleBtn.addActionListener(new SaleBtnListener());
		this.add(saleBtn);
		//
		this.setBackground(new Color(47, 73, 136));
		this.memberMgrPnl = memberMgrPnl;
		this.purchaseMgrPnl = purchaseMgrPnl;
		this.saleMgrPnl = saleMgrPnl;
		this.rightPnl=rightPnl;
	}

	// -------------------监听----------------------------------------------
	class MemberBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			memberMgrPnl.setVisible(true);
			purchaseMgrPnl.setVisible(false);
			saleMgrPnl.setVisible(false);
			rightPnl.setVisible(false);
		}

	}

	class PurchaseBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			memberMgrPnl.setVisible(false);
			purchaseMgrPnl.setVisible(true);
			saleMgrPnl.setVisible(false);
			rightPnl.setVisible(false);
		}

	}

	class SaleBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			memberMgrPnl.setVisible(false);
			purchaseMgrPnl.setVisible(false);
			saleMgrPnl.setVisible(true);
			rightPnl.setVisible(false);
		}

	}
}
