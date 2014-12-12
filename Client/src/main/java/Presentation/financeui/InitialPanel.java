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
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import Presentation.financeui.initial.AddInitialPanel;
import Presentation.mainui.MainFrame;
import Presentation.mainui.MyTableCellRenderer;

//期初建账
public class InitialPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame father;
	InitialModel im;
	JTable table;
	JScrollPane jsp;
	Color color = new Color(242, 125, 5);
	MyButton addBtn, detailBtn, refreshBtn;
	ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();

	public InitialPanel(MainFrame frame) {
		father = frame;
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints wn = new GridBagConstraints();
		wn.insets = new Insets(6, 50, 6, 50);
		wn.fill = GridBagConstraints.BOTH;
		// -----------------------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		wn.gridx = 0;
		wn.gridy = 0;
		wn.gridheight = 2;
		wn.gridwidth = GridBagConstraints.REMAINDER;
		wn.weightx = 1;
		wn.weighty = 0.1;
		gbl.setConstraints(btnPnl, wn);
		this.add(btnPnl);
		// --------新建一套账--------------
		addBtn = new MyButton("建账", new ImageIcon("img/finance/add.png"));
		addBtn.addActionListener(this);
		btnPnl.add(addBtn);
		// -------查看详情----------------
		detailBtn = new MyButton("查看详情", new ImageIcon(
				"img/finance/details.png"));
		detailBtn.addActionListener(this);
		btnPnl.add(detailBtn);
		// -------刷新---------------------
		refreshBtn = new MyButton("刷新",
				new ImageIcon("img/finance/refresh.png"));
		refreshBtn.addActionListener(this);
		btnPnl.add(refreshBtn);
		// --------表格------------------
		im = new InitialModel();
		table = new JTable(im);
		table.getTableHeader().setReorderingAllowed(false);

		// table 渲染器，设置文字内容居中显示，设置背景色等
		DefaultTableCellRenderer tcr = new MyTableCellRenderer();
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
		}
		jsp = new JScrollPane(table);
		wn.gridx = 0;
		wn.gridy = 2;
		wn.gridheight = 6;
		wn.gridwidth = GridBagConstraints.REMAINDER;
		wn.weightx = 1;
		wn.weighty = 1;
		gbl.setConstraints(jsp, wn);
		this.add(jsp);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addBtn){
			father.setRightComponent(new AddInitialPanel(father));
		}

	}

	class MyButton extends JButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text, Icon icon) {
			super(text, icon);
			this.setFont(new Font("微软雅黑", Font.PLAIN, 15));
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

	class InitialModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "建账时间", "操作员", "备注" };

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

		public void addRow(ArrayList<String> v) {
			c.add(v);
		}

		public void removeRow(int row) {
			c.remove(row);
		}

	}
}
