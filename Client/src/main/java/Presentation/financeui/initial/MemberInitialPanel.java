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

public class MemberInitialPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	MemberModel mm;
	ArrayList<ArrayList<String>> memberC = new ArrayList<ArrayList<String>>();
	JTable memberTable;
	JScrollPane jsp;
	JButton addBtn,delBtn;
	JComboBox<String> memberBox;
	public MemberInitialPanel(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		c.fill=GridBagConstraints.BOTH;
		//--------表格-------------
		mm=new MemberModel();
		memberTable=new JTable(mm);
		jsp=new JScrollPane(memberTable);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		//------客户增删处-----------
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
		String memberBoxText[]={"JHS-2025634 监小听"};
		memberBox=new JComboBox<String>(memberBoxText);
		memberBox.setBackground(Color.white);
		memberBox.setFont(font);
		btnPnl.add(memberBox);
		//
		//
		addBtn = new JButton("添加客户");
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
	class MemberModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"客户编号","客户名","分类","电话","应收","应付"};
		public int getRowCount() {
			return memberC.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return memberC.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}
		public void addRow(ArrayList<String> v) {
			memberC.add(v);
		}

		public void removeRow(int row) {
			memberC.remove(row);
		}
		
	}
}
