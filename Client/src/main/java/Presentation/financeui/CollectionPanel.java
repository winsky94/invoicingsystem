package Presentation.financeui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Presentation.mainui.MainFrame;

public class CollectionPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane tab;
	JTable t1, t2, t3;
	CollectionModel cm1, cm2;
	CashModel cashm;
	JScrollPane jsp1,jsp2,jsp3;
	ArrayList<ArrayList<String>> c1 = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> c2 = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> c3 = new ArrayList<ArrayList<String>>();
	//--------------------------
	MyButton collectionBtn,payBtn,cashBtn,refreshBtn,detailBtn;
	MainFrame parent;
	public CollectionPanel(MainFrame frame) {
		parent=frame;
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,40, 3,40);
		c.fill = GridBagConstraints.BOTH;
		// -----------------------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		//------制定收款单-----------------
		collectionBtn = new MyButton("制定收款单", new ImageIcon(
				"img/finance/receipts.png"));
		collectionBtn.addActionListener(this);
		btnPnl.add(collectionBtn);
		//-----制定付款单--------------------
		payBtn = new MyButton("制定付款单", new ImageIcon(
				"img/finance/receipts.png"));
		payBtn.addActionListener(this);
		btnPnl.add(payBtn);
		//------制定现金费用单-----------------
		cashBtn = new MyButton("制定现金费用单",
				new ImageIcon("img/finance/receipts.png"));
		cashBtn.addActionListener(this);
		btnPnl.add(cashBtn);
		//-------刷新------------------------
		refreshBtn = new MyButton("刷新", new ImageIcon(
				"img/finance/refresh.png"));
		refreshBtn.addActionListener(this);
		btnPnl.add(refreshBtn);
		//------查看详情----------------------
		detailBtn = new MyButton("查看详情", new ImageIcon(
				"img/finance/details.png"));
		detailBtn.addActionListener(this);
		btnPnl.add(detailBtn);
		//--------tab-----------------
		tab = new JTabbedPane();
		tab.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		tab.setBackground(Color.white);
		tab.setForeground(new Color(242,125,5));
		c.insets = new Insets(3,40, 20,40);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(tab, c);
		this.add(tab);
		//------收款单-----------------
		cm1 = new CollectionModel(c1);
		t1 = new JTable(cm1);
		jsp1 = new JScrollPane(t1);
		tab.add("收款单", jsp1);
		//------付款单-----------------
		cm2 = new CollectionModel(c2);
		t2 = new JTable(cm2);
		jsp2 = new JScrollPane(t2);
		tab.add("付款单", jsp2);
		//-------现金费用单-------------
		cashm = new CashModel();
		t3 = new JTable(cashm);
		jsp3 = new JScrollPane(t3);
		tab.add("现金费用单", jsp3);
	}

	public void actionPerformed(ActionEvent e) {

	}
	class MyButton extends JButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text, Icon icon) {
			super(text, icon);
			this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			this.setForeground(new Color(242,125,5));
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}

		MyButton(Icon icon) {
			super(icon);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
	}
	
	class CashModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"编号","状态","日期","操作员","银行账户","总额"};
		public int getRowCount() {
			return c3.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return c3.get(row).get(col);
		}
		public String getColumnName(int col){
			return head[col];
		}
		public void addRow(ArrayList<String> v) {

			c3.add(v);
		}

		public void removeRow(int row) {
			c3.remove(row);
		}
		
	}
	class CollectionModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"编号","状态","日期","供应商","销售商","操作员","总额汇总"};
		ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
		public CollectionModel(ArrayList<ArrayList<String>> content){
			this.c=content;
		}
		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return c.get(row).get(col);
		}
		public String getColumnName(int col){
			return head[col];
		}
		public void addRow(ArrayList<String> v) {

			c.add(v);
		}

		public void removeRow(int row) {
			c.remove(row);
		}
	}
}
