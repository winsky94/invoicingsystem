package Presentation.salesui.manage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Presentation.salesui.manage.purchase.PurchaseDialog;

public class PurchaseMgrPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton purchaseBtn, purchaseReturnBtn, searchBtn;
	JTable purchaseTable;
	JTextField searchFld;
	String keyWord;

	public PurchaseMgrPanel() {
		this.setBackground(Color.WHITE);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		c.fill = GridBagConstraints.HORIZONTAL;
		// 创建进货单
		purchaseBtn = new JButton("创建进货单", new ImageIcon(
				"img/sales/purchase-blue.png"));
		purchaseBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		purchaseBtn.setForeground(new Color(47, 73, 136));
		purchaseBtn.setBorderPainted(false);
		purchaseBtn.setBackground(Color.white);
		purchaseBtn.setHorizontalAlignment(SwingConstants.LEFT);
		purchaseBtn.setFocusPainted(false);
		purchaseBtn.addActionListener(new PurchaseBtnListener());
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.02;
		c.weighty = 0.02;
		gbl.setConstraints(purchaseBtn, c);
		this.add(purchaseBtn);
		// 创建进货退货单
		purchaseReturnBtn = new JButton("创建进货退货单", new ImageIcon(
				"img/sales/disapproved-blue.png"));
		purchaseReturnBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		purchaseReturnBtn.setForeground(new Color(47, 73, 136));
		purchaseReturnBtn.setBorderPainted(false);
		purchaseReturnBtn.setBackground(Color.white);
		purchaseReturnBtn.setHorizontalAlignment(SwingConstants.LEFT);
		purchaseReturnBtn.setFocusPainted(false);
		purchaseReturnBtn.addActionListener(new PurchaseReturnBtnListener());
		c.gridx = 1;
		gbl.setConstraints(purchaseReturnBtn, c);
		this.add(purchaseReturnBtn);
		//
		// 搜索框
		searchFld = new JTextField();
		searchFld.setFont(new Font("楷体", Font.BOLD, 13));
		searchFld.getDocument().addDocumentListener(new SearchFldListener());
		c.gridx = 2;
		c.weightx = 0.3;
		c.gridy = 0;
		gbl.setConstraints(searchFld, c);
		this.add(searchFld);
		// 查找按钮
		searchBtn = new JButton(new ImageIcon("img/sales/find-blue.png"));
		searchBtn.setForeground(new Color(47, 73, 136));
		searchBtn.setBorderPainted(false);
		searchBtn.setBackground(Color.white);
		searchBtn.setHorizontalAlignment(SwingConstants.LEFT);
		searchBtn.setFocusPainted(false);
		searchBtn.addActionListener(new SearchBtnListener());
		c.gridx = 3;
		c.weightx = 0.02;
		gbl.setConstraints(searchBtn, c);
		this.add(searchBtn);
		//-------------------------BLANK-----------------------------
		JLabel blankLbl=new JLabel();
		c.gridx = 4;
		c.weightx = 0.5;
		gbl.setConstraints(blankLbl, c);
		this.add(blankLbl);
		//
		/*
		 * 
		 * 
		 * 这个表格BL来搞一下~注入信息
		 */
		purchaseTable = new JTable();
		c.gridx = 0;
		c.gridwidth = 5;
		c.gridy = 1;
		c.weightx = 0.9;
		c.weighty = 0.9;
		purchaseTable.setBackground(Color.black);
		gbl.setConstraints(purchaseTable, c);
		this.add(purchaseTable);
	}

	class PurchaseBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JDialog purchaseDlg=new PurchaseDialog();

		}

	}

	class PurchaseReturnBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class SearchFldListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

		public void removeUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

		public void changedUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

	}

	class SearchBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
