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

import Presentation.mainui.MainFrame;
import Presentation.salesui.manage.sale.SalePane;
import Presentation.salesui.manage.sale.SaleReturnPane;

public class SaleMgrPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton saleBtn, saleReturnBtn, searchBtn;
	JTable saleTable;
	JTextField searchFld;
	String keyWord;
	MainFrame parent;
	public SaleMgrPanel(MainFrame frame){
		parent=frame;
		this.setBackground(Color.WHITE);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		c.fill = GridBagConstraints.BOTH;
		// 创建进货单
		saleBtn = new JButton("创建销售单", new ImageIcon(
				"img/sales/sale-blue.png"));
		saleBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		saleBtn.setForeground(new Color(47, 73, 136));
		saleBtn.setBorderPainted(false);
		saleBtn.setBackground(Color.white);
		saleBtn.setHorizontalAlignment(SwingConstants.LEFT);
		saleBtn.setFocusPainted(false);
		saleBtn.addActionListener(this);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.02;
		c.weighty = 0.02;
		gbl.setConstraints(saleBtn, c);
		this.add(saleBtn);
		// 创建进货退货单
		saleReturnBtn = new JButton("创建销售退货单", new ImageIcon(
				"img/sales/disapproved-blue.png"));
		saleReturnBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		saleReturnBtn.setForeground(new Color(47, 73, 136));
		saleReturnBtn.setBorderPainted(false);
		saleReturnBtn.setBackground(Color.white);
		saleReturnBtn.setHorizontalAlignment(SwingConstants.LEFT);
		saleReturnBtn.setFocusPainted(false);
		saleReturnBtn.addActionListener(this);
		c.gridx = 1;
		gbl.setConstraints(saleReturnBtn, c);
		this.add(saleReturnBtn);
		//
		// 搜索框
		searchFld = new JTextField();
		searchFld.setFont(new Font("楷体", Font.BOLD, 13));
		searchFld.getDocument().addDocumentListener(new SearchFldListener());
		c.gridx = 2;
		c.weightx = 0.3;
		c.fill=GridBagConstraints.HORIZONTAL;
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
		c.fill=GridBagConstraints.BOTH;
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
		saleTable = new JTable();
		c.gridx = 0;
		c.gridwidth = 5;
		c.gridy = 1;
		c.weightx = 0.9;
		c.weighty = 0.9;
		saleTable.setBackground(Color.black);
		gbl.setConstraints(saleTable, c);
		this.add(saleTable);
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==saleBtn){
			parent.setRightComponent(new SalePane(parent));
		}else if(e.getSource()==saleReturnBtn)
			parent.setRightComponent(new SaleReturnPane(parent));
			
	}
}