package Presentation.salesui.manage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import Presentation.salesui.manage.MemberMgrPanel.AddBtnListener;
import Presentation.salesui.manage.MemberMgrPanel.DelBtnListener;

public class PurchaseMgrPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton createPurchaseBtn,createPurchaseReturnBtn;
	JTable purchaseTable;
	public PurchaseMgrPanel(){
		this.setBackground(Color.WHITE);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets=new Insets(3,3,3,3);
		c.fill=GridBagConstraints.HORIZONTAL;
//		// 增
//		createPurchaseBtn = new JButton("创建进货单", new ImageIcon(
//						"img/sales/addMember-blue.png"));
//		createPurchaseBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		createPurchaseBtn.setForeground(new Color(47, 73, 136));
//		createPurchaseBtn.setBorderPainted(false);
//		createPurchaseBtn.setBackground(Color.white);
//		createPurchaseBtn.setHorizontalAlignment(SwingConstants.LEFT);
//		createPurchaseBtn.setFocusPainted(false);
//		createPurchaseBtn.addActionListener(new AddBtnListener());
//				c.gridx = 0;
//				c.gridy = 0;
//				c.weightx = 0.02;
//				c.weighty = 0.02;
//				gbl.setConstraints(addBtn, c);
//				this.add(addBtn);
//				// 删
//				delBtn = new JButton("删除客户", new ImageIcon(
//						"img/sales/delMember-blue.png"));
//				delBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
//				delBtn.setForeground(new Color(47, 73, 136));
//				delBtn.setBorderPainted(false);
//				delBtn.setBackground(Color.white);
//				delBtn.setHorizontalAlignment(SwingConstants.LEFT);
//				delBtn.setFocusPainted(false);
//				delBtn.addActionListener(new DelBtnListener());
//				c.gridx = 1;
//				c.gridy = 0;
//				gbl.setConstraints(delBtn, c);
//				this.add(delBtn);
	}
}
