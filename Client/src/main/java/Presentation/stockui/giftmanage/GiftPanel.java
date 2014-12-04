package Presentation.stockui.giftmanage;

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

import Presentation.mainui.MainFrame;
import Presentation.uihelper.DateChooser;

public class GiftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame father;
	MyButton giftBtn, refreshBtn;
	DateChooser fromDC, toDC;
	JScrollPane jsp;
	JTable giftTbl;
	GiftTblModel gtm;
	ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
	Color color = new Color(51, 125, 86);
	Font font = new Font("微软雅黑", Font.PLAIN, 15);

	public GiftPanel(MainFrame frame) {
		father = frame;

		//
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 50, 10, 50);
		// ---------------------------------------
		JPanel topPnl = new JPanel();
		topPnl.setBackground(Color.white);
		// ----------------------------------------
		giftBtn = new MyButton("创建库存赠送单", new ImageIcon("img/stock/gift.png"));
		giftBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				father.setRightComponent(new CreateGiftPanel(father));
			}
		});
		topPnl.add(giftBtn);
		refreshBtn = new MyButton("刷新", new ImageIcon("img/stock/refresh.png"));
		topPnl.add(refreshBtn);
		// ---------------------------------------------
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0.1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gbl.setConstraints(topPnl, c);
		this.add(topPnl);
		// ----------------------------------------------
		gtm = new GiftTblModel();
		giftTbl = new JTable(gtm);
		jsp = new JScrollPane(giftTbl);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 10;
		c.gridheight = c.gridwidth = GridBagConstraints.REMAINDER;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
	}

	/*
	 * public static void main(String[] args){ MainFrame testFrame = new
	 * MainFrame(); testFrame.setBounds(100, 50, 900, 550);
	 * testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * 
	 * JPanel gp = new GiftPanel(testFrame); gp.setBounds(0, 0, 1000, 700);
	 * testFrame.add(gp); testFrame.setVisible(true); }
	 */
	class GiftTblModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "赠送单编号", "日期", "审批状态", "商品编号", "商品名", "型号", "数量",
				"客户编号", "客户名" };

		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
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
			setFont(font);
			setForeground(color);
			setBorderPainted(false);
			setBackground(Color.white);
			setFocusPainted(false);
		}

	}
}
