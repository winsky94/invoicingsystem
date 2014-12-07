package Presentation.financeui.initial;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class AccountInitialPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	AccountModel am;
	ArrayList<ArrayList<String>> accountC = new ArrayList<ArrayList<String>>();
	JTable accountTable;	
	JScrollPane jsp;
	JButton addBtn,delBtn;
	JComboBox<String> accountBox;
	public AccountInitialPanel(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		c.fill=GridBagConstraints.BOTH;
		//--------表格-------------
		am=new AccountModel();
		accountTable=new JTable(am);
		jsp=new JScrollPane(accountTable);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		//------账户增删处-----------
		JPanel btnPnl=new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		//
		String accountBoxText[]={"中国工商银行658962"};
		accountBox=new JComboBox<String>(accountBoxText);
		accountBox.setBackground(Color.white);
		accountBox.setFont(font);
		btnPnl.add(accountBox);
		//
		//
		addBtn = new JButton("添加账户");
		addBtn.setFont(font);
		addBtn.setBackground(new Color(204, 242, 239));
		addBtn.setFocusPainted(false);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//监听!!!!
			}
		});
		btnPnl.add(addBtn);
		delBtn = new JButton("删除选中");
		delBtn.setFont(font);
		delBtn.setBackground(new Color(204, 242, 239));
		delBtn.setFocusPainted(false);
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听！！！！！！！
			}
		});
		btnPnl.add(delBtn);
	}
	class AccountModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"账户名","余额"};
		public int getRowCount() {
			return accountC.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return accountC.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}
		public void addRow(ArrayList<String> v) {
			accountC.add(v);
		}

		public void removeRow(int row) {
			accountC.remove(row);
		}
		
	}
}
