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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MyTableCellRenderer;

public class GoodsInitialPanel extends ChooseGoodsFatherPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	GoodsModel gm;
	JTable goodsTable;
	JScrollPane jsp;
	JButton addBtn,delBtn;
	public GoodsInitialPanel(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		c.fill=GridBagConstraints.BOTH;
		//--------表格-------------
		gm=new GoodsModel();
		goodsTable=new JTable(gm);
		// table 渲染器，设置文字内容居中显示，设置背景色等
				DefaultTableCellRenderer tcr = new MyTableCellRenderer();
				for (int i = 0; i < goodsTable.getColumnCount(); i++) {
					goodsTable.getColumn(goodsTable.getColumnName(i)).setCellRenderer(
							tcr);
				}
		jsp=new JScrollPane(goodsTable);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		//------商品增删处-----------
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
		addBtn = new JButton("添加商品");
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
	class GoodsModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"商品编号","客户名","分类","型号","默认进价","默认售价"};
		public int getRowCount() {
			return 0;
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return null;
		}

		public String getColumnName(int col) {
			return head[col];
		}
		public void addRow(ArrayList<String> v) {
			
		}

		public void removeRow(int row) {
			
		}
		
	}
}
