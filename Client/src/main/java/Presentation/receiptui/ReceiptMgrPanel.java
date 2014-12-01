package Presentation.receiptui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class ReceiptMgrPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color color = new Color(115, 46, 126);
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JFrame father;
	MyButton approvedBtn, disapprovedBtn, modBtn, refreshBtn, findBtn;
	JTextField findFld;
	JTabbedPane tab;
	JScrollPane jsp1, jsp2;
	JTable t1, t2;
	ReceiptTableModel rtm1, rtm2;
	ArrayList<ArrayList<String>> c1 = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> c2 = new ArrayList<ArrayList<String>>();

	public ReceiptMgrPanel(JFrame myFather) {
		father = myFather;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 10, 5, 10);
		c.fill = GridBagConstraints.BOTH;
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------------
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
		// --------通过-----------------
		approvedBtn = new MyButton("通过", new ImageIcon(
				"img/promotion/approved.png"));
		btnPnl.add(approvedBtn);
		// -------不通过------------------
		disapprovedBtn = new MyButton("不通过", new ImageIcon(
				"img/promotion/disapproved.png"));
		btnPnl.add(disapprovedBtn);
		// -------高级审批-----------------
		modBtn = new MyButton("高级审批", new ImageIcon("img/promotion/detail.png"));
		btnPnl.add(modBtn);
		// -------刷新--------------------
		refreshBtn = new MyButton("刷新", new ImageIcon(
				"img/promotion/refresh.png"));
		btnPnl.add(refreshBtn);
		// -------筛选--------------------
		findFld = new JTextField(10);
		btnPnl.add(findFld);
		findBtn = new MyButton(new ImageIcon("img/promotion/find.png"));
		btnPnl.add(findBtn);
		// ------------------------------
		tab = new JTabbedPane();
		tab.setFont(font);
		tab.setBackground(Color.white);
		tab.setForeground(color);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(tab, c);
		this.add(tab);
		// -------待审批-------------------
		rtm1 = new ReceiptTableModel(c1);
		t1 = new JTable(rtm1);
		jsp1 = new JScrollPane(t1);
		tab.add("待审批单据", jsp1);
		//---------已审批------------------
		rtm2=new ReceiptTableModel(c2);
		t2=new JTable(rtm2);
		jsp2=new JScrollPane(t2);
		tab.add("已审批单据",jsp2);
		
	}

	class ReceiptTableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "单据编号", "创建日期", "业务类型", "交易客户", "交易金额", "业务员", "备注" };
		ArrayList<ArrayList<String>> c;

		public ReceiptTableModel(ArrayList<ArrayList<String>> content) {
			c = content;
		}

		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public void addRow(ArrayList<String> v) {
			c.add(v);
		}

		public void removeRow(int row) {
			c.remove(row);
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
			this.setFont(font);
			this.setForeground(color);
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

		ReceiptMgrPanel gp = new ReceiptMgrPanel(testFrame);
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
