package Presentation.financeui.moneyreceipt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class AddCashReceiptPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>();
	JScrollPane jsp;
	JTable table;
	CashReceiptModel crm;
	JComboBox<String> accountBox;
	JLabel IDLbl, userLbl, totalLbl;
	JButton submitBtn, exitBtn, addBtn, delBtn;
	JTextField nameFld, moneyFld, remarkFld;

	public AddCashReceiptPanel() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建现金费用单");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.08;
		gbl.setConstraints(titlePnl, c);
		this.add(titlePnl);
		// ------table---------------------
		c.fill = GridBagConstraints.BOTH;
		crm = new CashReceiptModel();
		table = new JTable(crm);
		jsp = new JScrollPane(table);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.6;
		gbl.setConstraints(jsp, c);
		this.add(jsp);

		// ------infoPnl--------------------
		JPanel infoPnl = new JPanel();
		infoPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.2;
		gbl.setConstraints(infoPnl, c);
		this.add(infoPnl);
		infoPnl.setLayout(new GridLayout(2, 1));
		JPanel up = new JPanel();
		up.setBackground(Color.white);
		infoPnl.add(up);
		JPanel down = new JPanel();
		down.setBackground(Color.white);
		infoPnl.add(down);
		// ------ID----------------
		IDLbl = new JLabel("ID:嗷嗷嗷嗷");
		IDLbl.setFont(font);
		up.add(IDLbl);
		up.add(new JLabel("     "));
		// ------user---------------
		userLbl = new JLabel("操作员:嗷嗷嗷");
		userLbl.setFont(font);
		up.add(userLbl);
		up.add(new JLabel("     "));
		// ------account---------
		JLabel accLbl = new JLabel("账户：");
		accLbl.setFont(font);
		up.add(accLbl);
		String boxText[] = { "亲爱的我没有监听" };
		accountBox = new JComboBox<String>(boxText);
		accountBox.setFont(font);
		accountBox.setBackground(Color.white);
		up.add(accountBox);
		up.add(new JLabel("     "));
		// -----总额-------------------
		totalLbl = new JLabel("总额：嗷嗷嗷嗷");
		totalLbl.setFont(font);
		up.add(totalLbl);
		//-------条目清单---------------
		JLabel itemLbl=new JLabel("条目项：");
		itemLbl.setFont(font);
		down.add(itemLbl);
		down.add(new JLabel("      "));
		//-------条目名--------------
		JLabel nameLbl=new JLabel("条目名：");
		nameLbl.setFont(font);
		down.add(nameLbl);
		nameFld=new JTextField(5);
		nameFld.setFont(font);
		down.add(nameFld);
		down.add(new JLabel("      "));
		//-------金额-----------------
		JLabel moneyLbl=new JLabel("金额：");
		moneyLbl.setFont(font);
		down.add(moneyLbl);
		moneyFld=new JTextField(3);
		moneyFld.setFont(font);
		down.add(moneyFld);
		down.add(new JLabel("      "));
		//------备注------------------
		JLabel remarkLbl=new JLabel("备注：");
		remarkLbl.setFont(font);
		down.add(remarkLbl);
		remarkFld=new JTextField(15);
		remarkFld.setFont(font);
		down.add(remarkFld);
		// -------buttons-----------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		//
		addBtn = new JButton("添加条目");
		addBtn.setFont(font);
		addBtn.setBackground(Color.white);
		addBtn.setFocusPainted(false);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听！！！！！！！
			}
		});
		btnPnl.add(addBtn);
		delBtn = new JButton("删除选中");
		delBtn.setFont(font);
		delBtn.setBackground(Color.white);
		delBtn.setFocusPainted(false);
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听！！！！！！！
			}
		});
		btnPnl.add(delBtn);
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		btnPnl.add(submitBtn);
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		btnPnl.add(exitBtn);
	}

	class CashReceiptModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "条目名", "金额", "备注" };

		public int getRowCount() {
			return content.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return content.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}

		public void addRow(ArrayList<String> v) {

			content.add(v);
		}

		public void removeRow(int row) {
			content.remove(row);
		}
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AddCashReceiptPanel gp = new AddCashReceiptPanel();
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
