package Presentation.salesui.managerPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;



public class MemberMgrPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addBtn, delBtn, modBtn,refreshBtn;
	JTable memberTable;

	public MemberMgrPanel() {
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		// c.fill=GridBagConstraints.BOTH;
		//
		addBtn = new JButton("添加客户", new ImageIcon("img/sales/addMember-blue.png"));
		addBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addBtn.setForeground(new Color(47, 73, 136));
		addBtn.setBorderPainted(false);
		addBtn.setBackground(Color.white);
		addBtn.setHorizontalAlignment(SwingConstants.LEFT);
		addBtn.setFocusPainted(false);
		//addBtn.addActionListener(new addBtnListener());
		c.gridx=0;
		c.gridy=0;
		c.weightx=0.02;
		c.weighty=0.02;
		gbl.setConstraints(addBtn, c);
		this.add(addBtn);
		//
		delBtn = new JButton("删除客户", new ImageIcon("img/sales/delMember-blue.png"));
		delBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		delBtn.setForeground(new Color(47, 73, 136));
		delBtn.setBorderPainted(false);
		delBtn.setBackground(Color.white);
		delBtn.setHorizontalAlignment(SwingConstants.LEFT);
		delBtn.setFocusPainted(false);
		//delBtn.addActionListener(new addBtnListener());
		c.gridx=1;
		c.gridy=0;
		gbl.setConstraints(delBtn, c);
		this.add(delBtn);
		//
		modBtn = new JButton("修改客户", new ImageIcon("img/sales/modify-blue.png"));
		modBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		modBtn.setForeground(new Color(47, 73, 136));
		modBtn.setBorderPainted(false);
		modBtn.setBackground(Color.white);
		modBtn.setHorizontalAlignment(SwingConstants.LEFT);
		modBtn.setFocusPainted(false);
		//modBtn.addActionListener(new addBtnListener());
		c.gridx=2;
		c.gridy=0;
		gbl.setConstraints(modBtn, c);
		this.add(modBtn);
		//
		refreshBtn = new JButton("刷新列表", new ImageIcon("img/sales/refresh-blue.png"));
		refreshBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		refreshBtn.setForeground(new Color(47, 73, 136));
		refreshBtn.setBorderPainted(false);
		refreshBtn.setBackground(Color.white);
		refreshBtn.setHorizontalAlignment(SwingConstants.LEFT);
		refreshBtn.setFocusPainted(false);
		//refreshBtn.addActionListener(new addBtnListener());
		c.gridx=3;
		c.gridy=0;
		gbl.setConstraints(refreshBtn, c);
		this.add(refreshBtn);
		//
		memberTable=new JTable();
		c.gridx=0;
		c.gridwidth=4;
		c.gridy=1;
		c.weightx=0.98;
		c.weighty=0.98;
		gbl.setConstraints(memberTable, c);
		this.add(memberTable);
	}
}
