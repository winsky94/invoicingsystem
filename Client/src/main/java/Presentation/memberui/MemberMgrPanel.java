package Presentation.memberui;

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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Presentation.mainui.MainFrame;

public class MemberMgrPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addBtn, delBtn, modBtn, refreshBtn, searchBtn;
	JTextField searchFld;
	JTable memberTable;
	String keyWord;
	MainFrame parent;
	public MemberMgrPanel(MainFrame frame) {
		parent=frame;
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets=new Insets(3,3,3,3);
		c.fill=GridBagConstraints.BOTH;
		// 增
		addBtn = new JButton("添加客户", new ImageIcon(
				"img/sales/addMember-blue.png"));
		addBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addBtn.setForeground(new Color(47, 73, 136));
		addBtn.setBorderPainted(false);
		addBtn.setBackground(Color.white);
		addBtn.setHorizontalAlignment(SwingConstants.LEFT);
		addBtn.setFocusPainted(false);
		addBtn.addActionListener(new AddBtnListener());
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.02;
		c.weighty = 0.02;
		gbl.setConstraints(addBtn, c);
		this.add(addBtn);
		// 删
		delBtn = new JButton("删除客户", new ImageIcon(
				"img/sales/delMember-blue.png"));
		delBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		delBtn.setForeground(new Color(47, 73, 136));
		delBtn.setBorderPainted(false);
		delBtn.setBackground(Color.white);
		delBtn.setHorizontalAlignment(SwingConstants.LEFT);
		delBtn.setFocusPainted(false);
		delBtn.addActionListener(new DelBtnListener());
		c.gridx = 1;
		gbl.setConstraints(delBtn, c);
		this.add(delBtn);
		// 改
		modBtn = new JButton("修改客户", new ImageIcon("img/sales/modify-blue.png"));
		modBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		modBtn.setForeground(new Color(47, 73, 136));
		modBtn.setBorderPainted(false);
		modBtn.setBackground(Color.white);
		modBtn.setHorizontalAlignment(SwingConstants.LEFT);
		modBtn.setFocusPainted(false);
		modBtn.addActionListener(new ModBtnListener());
		c.gridx = 2;
		gbl.setConstraints(modBtn, c);
		this.add(modBtn);
		// 刷新
		refreshBtn = new JButton("刷新列表", new ImageIcon(
				"img/sales/refresh-blue.png"));
		refreshBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		refreshBtn.setForeground(new Color(47, 73, 136));
		refreshBtn.setBorderPainted(false);
		refreshBtn.setBackground(Color.white);
		refreshBtn.setHorizontalAlignment(SwingConstants.LEFT);
		refreshBtn.setFocusPainted(false);
		refreshBtn.addActionListener(new RefreshBtnListener());
		c.gridx = 3;
		gbl.setConstraints(refreshBtn, c);
		this.add(refreshBtn);
		// 搜索框
		searchFld = new JTextField();
		searchFld.setFont(new Font("楷体", Font.BOLD, 13));
		searchFld.getDocument().addDocumentListener(new SearchFldListener());
		c.gridx = 4;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		c.weighty = 0.02;
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
		c.gridx = 5;
		c.weightx = 0.02;
		c.gridy = 0;
		gbl.setConstraints(searchBtn, c);
		this.add(searchBtn);
		//
		/*
		 * 
		 * 
		 * 这个表格BL来搞一下~注入信息啊
		 * 
		 * 
		 * 
		 */
		memberTable = new JTable();
		memberTable.setBackground(Color.black);
		c.gridx = 0;
		c.gridwidth = 6;
		c.fill=GridBagConstraints.BOTH;
		c.gridy = 1;
		c.weightx = 0.98;
		c.weighty = 0.98;
		gbl.setConstraints(memberTable, c);
		this.add(memberTable);
	}
	class AddBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			parent.setRightComponent(new AddMemberPanel(parent));
		}
		
	}
	class DelBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//-----应当传入客户编号-----------------------
			
			JDialog delMemberDlg=new DelMemberDialog(null,null,parent);
		}
		
	}
	class ModBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//-----应当传入客户信息-----------------------
			parent.setRightComponent(new ModMemberPanel(parent));
		}
		
	}
	class RefreshBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class SearchFldListener implements DocumentListener{

		public void insertUpdate(DocumentEvent e) {
			keyWord=searchFld.getText();
		}

		public void removeUpdate(DocumentEvent e) {
			keyWord=searchFld.getText();
		}

		public void changedUpdate(DocumentEvent e) {
			keyWord=searchFld.getText();
		}
		
	}
	class SearchBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
