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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import Presentation.mainui.MainFrame;

public class AccountPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyButton addBtn, delBtn, modBtn, refreshBtn, searchBtn;
	JTextField searchFld;
	JTable table;
	AccountTableModel atm;
	ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
	JScrollPane jsp;
	String keyWord;
	MainFrame parent;
    public AccountPanel(JFrame frame){
    	this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,50, 3,50);
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
		//------增-----------------------
		addBtn = new MyButton("添加账户", new ImageIcon(
				"img/finance/add.png"));
		addBtn.addActionListener(this);
		btnPnl.add(addBtn);
		//-----删------------------------
		delBtn = new MyButton("删除账户", new ImageIcon(
				"img/finance/delete.png"));
		delBtn.addActionListener(this);
		btnPnl.add(delBtn);
		//-------改----------------------
		modBtn = new MyButton("修改账户属性",
				new ImageIcon("img/finance/modify.png"));
		modBtn.addActionListener(this);
		btnPnl.add(modBtn);
		//-------刷新---------------------
		refreshBtn = new MyButton("刷新", new ImageIcon(
				"img/finance/refresh.png"));
		refreshBtn.addActionListener(this);
		btnPnl.add(refreshBtn);
		//---------搜索--------------------
		searchFld = new JTextField(15);
		searchFld.setFont(new Font("楷体", Font.BOLD, 13));
		//没写监听
		btnPnl.add(searchFld);
		//--------查找按钮-------------------
		searchBtn = new MyButton(new ImageIcon("img/finance/find.png"));
		searchBtn.addActionListener(this);
		btnPnl.add(searchBtn);
		//--------表格----------------------

		atm = new AccountTableModel();
		table = new JTable(atm);
		jsp = new JScrollPane(table);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
    	
    }
	public void actionPerformed(ActionEvent e) {
		
		
	}
	class AccountTableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "账户名称", "余额" };

		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return c.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}
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
	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AccountPanel gp = new AccountPanel(testFrame);
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
