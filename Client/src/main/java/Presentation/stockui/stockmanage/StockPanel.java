package Presentation.stockui.stockmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import Presentation.mainui.MainFrame;
import Presentation.mainui.MyTableCellRenderer;
import businesslogic.stockbl.stockManage.CheckModel;
import businesslogic.stockbl.stockManage.LowModel;
import businesslogic.stockbl.stockManage.OverModel;

public class StockPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color stockColor = new Color(51, 125, 86);
	JTabbedPane tab;
	JScrollPane jsp1, jsp2, jsp3;
	JTable inventoryTbl, overflowTbl, lossTbl;
	MyButton overflowBtn, lossBtn, stockBtn, exportBtn, refreshBtn;
	MainFrame frame;
	Color[] color;

	public StockPanel(MainFrame myframe) {
		frame = myframe;
		color = frame.getTheme();
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(3, 40, 3, 40);
		// ---------btnPnl-----------------
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
		// ---------overflowBtn----------------------------------
		overflowBtn = new MyButton("创建库存报溢单", new ImageIcon(
				"img/stock/overflow.png"));
		overflowBtn.addActionListener(new OverflowBtnListener());
		btnPnl.add(overflowBtn);
		// -------------lossBtn-----------------------------------
		lossBtn = new MyButton("创建库存报损单", new ImageIcon("img/stock/delete.png"));
		lossBtn.addActionListener(new LossBtnListener());
		btnPnl.add(lossBtn);
		// -----------stockBtn---------------------------------
		stockBtn = new MyButton("库存查看",
				new ImageIcon("img/stock/inventory.png"));
		stockBtn.addActionListener(new StockBtnListener());
		btnPnl.add(stockBtn);
		// --------refresh----------------
		refreshBtn = new MyButton("刷新", new ImageIcon("img/stock/refresh.png"));
		btnPnl.add(refreshBtn);
		// ---------export----------------
		exportBtn = new MyButton("导出库存快照",
				new ImageIcon("img/stock/export.png"));
		btnPnl.add(exportBtn);
		// -----------JTabbedPane----------------------------
		tab = new JTabbedPane();
		tab.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		tab.setBackground(Color.white);
		tab.setForeground(stockColor);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(tab, c);
		this.add(tab);
		// ---------------inventoryTbl---------------------------
		inventoryTbl = new JTable();
		// table 渲染器，设置文字内容居中显示，设置背景色等
				DefaultTableCellRenderer tcr = new MyTableCellRenderer();
				for (int i = 0; i < inventoryTbl.getColumnCount(); i++) {
					inventoryTbl.getColumn(inventoryTbl.getColumnName(i))
							.setCellRenderer(tcr);
				}
		CheckModel cm = new CheckModel();
		
		inventoryTbl.setModel(cm);
		jsp1 = new JScrollPane(inventoryTbl);
		tab.add("库存盘点", jsp1);
		// --------------overflowTbl--------------------------------
		overflowTbl = new JTable();
		OverModel om = new OverModel();
		// table 渲染器，设置文字内容居中显示，设置背景色等
		for (int i = 0; i < overflowTbl.getColumnCount(); i++) {
			overflowTbl.getColumn(overflowTbl.getColumnName(i))
					.setCellRenderer(tcr);
		}
		overflowTbl.setModel(om);
		jsp2 = new JScrollPane(overflowTbl);
		tab.add("库存报溢表", jsp2);
		// --------------lossTbl--------------------------------
		lossTbl = new JTable();
		LowModel lm = new LowModel();
		// table 渲染器，设置文字内容居中显示，设置背景色等
		for (int i = 0; i < lossTbl.getColumnCount(); i++) {
			lossTbl.getColumn(lossTbl.getColumnName(i)).setCellRenderer(tcr);
		}
		lossTbl.setModel(lm);
		jsp3 = new JScrollPane(lossTbl);
		tab.add("库存报损表", jsp3);
	}

	class OverflowBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			frame.setRightComponent(new OverflowPanel(frame));

		}

	}

	class LossBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			frame.setRightComponent(new LossPanel(frame));

		}

	}

	class StockBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			frame.setRightComponent(new StockShowPanel(frame));
		}

	}

	/*
	 * public static void main(String[] args) { JFrame testFrame = new JFrame();
	 * testFrame.setBounds(100, 50, 800, 500);
	 * testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * 
	 * StockPanel gp = new StockPanel(); gp.setBounds(0, 0, 1000, 700);
	 * testFrame.add(gp); testFrame.setVisible(true); }
	 */
	class MyButton extends JButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text, Icon icon) {
			super(text, icon);
			this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			this.setForeground(new Color(51, 125, 86));
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

	class Refresh implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if (tab.getSelectedIndex() == 0) {
				// 刷新库存盘点
				CheckModel cm = new CheckModel();
				inventoryTbl.setModel(cm);
			} else if (tab.getSelectedIndex() == 1) {
				// 刷新库存报溢
				OverModel om = new OverModel();
				overflowTbl.setModel(om);
			} else if (tab.getSelectedIndex() == 2) {
				// 刷新库存报损
				LowModel lm = new LowModel();
				lossTbl.setModel(lm);
			}
		}

	}
}
