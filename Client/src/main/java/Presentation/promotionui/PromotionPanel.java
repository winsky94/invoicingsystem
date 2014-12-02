package Presentation.promotionui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Presentation.mainui.MainFrame;
import Presentation.promotionui.addpromotion.AddBarginPanel;
import Presentation.promotionui.addpromotion.AddCouponPanel;
import Presentation.promotionui.addpromotion.AddDiscountPanel;
import Presentation.promotionui.addpromotion.AddGiftPanel;

public class PromotionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	MainFrame father;
	JTable proTbl;
	JScrollPane jsp;
	PromotionTableModel ptm;
	ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
	MyButton addBtn, delBtn, modBtn, refreshBtn, detailBtn;
	Color color = new Color(115, 46, 126);

	public PromotionPanel(MainFrame myFather) {
		father = myFather;
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 20, 10, 20);
		// --------------------------
		JPanel top = new JPanel();
		top.setBackground(Color.white);
		top.setLayout(new GridLayout(1, 5));
		// --------------------------
		//
		addBtn = new MyButton("制定新策略", new ImageIcon("img/promotion/add.png"));
		addBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JPopupMenu menu = new JPopupMenu();

				menu.setBackground(Color.white);
				menu.setBorder(BorderFactory.createLineBorder(color));
				JMenuItem bargin = new JMenuItem("创建特价包");
				bargin.setFont(new Font("微软雅黑", Font.PLAIN, 14));
				bargin.setOpaque(false);
				bargin.setForeground(color);
				JMenuItem coupon = new JMenuItem("制定代金券赠送策略");
				coupon.setFont(new Font("微软雅黑", Font.PLAIN, 14));
				coupon.setOpaque(false);
				coupon.setForeground(color);
				JMenuItem gift = new JMenuItem("制定赠品赠送策略");
				gift.setFont(new Font("微软雅黑", Font.PLAIN, 14));
				gift.setOpaque(false);
				gift.setForeground(color);
				JMenuItem discount = new JMenuItem("制定打折促销策略");
				discount.setFont(new Font("微软雅黑", Font.PLAIN, 14));
				discount.setOpaque(false);
				discount.setForeground(color);
				menu.add(bargin);
				menu.add(coupon);
				menu.add(gift);
				menu.add(discount);
				bargin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						father.setRightComponent(new AddBarginPanel(father));
					}
				});
				coupon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						father.setRightComponent(new AddCouponPanel(father));
					}
				});
				gift.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						father.setRightComponent(new AddGiftPanel(father));
					}
				});
				discount.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						father.setRightComponent(new AddDiscountPanel(father));
					}
				});
				menu.show(father, e.getX(), e.getY());
				// .addBtn.getX()+110,PromotionPanel.this.addBtn.getY()+110
			}
		});
		top.add(addBtn);
		//
		delBtn = new MyButton("删除策略", new ImageIcon("img/promotion/del.png"));
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog delDlg = new DelProDialog();
			}
		});
		top.add(delBtn);
		//
		modBtn = new MyButton("修改策略", new ImageIcon("img/promotion/modify.png"));
		modBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		top.add(modBtn);
		//
		refreshBtn = new MyButton("刷新列表", new ImageIcon(
				"img/promotion/refresh.png"));
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		top.add(refreshBtn);
		//
		detailBtn = new MyButton("查看详情", new ImageIcon(
				"img/promotion/detail.png"));
		detailBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		top.add(detailBtn);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(top, c);
		this.add(top);
		// --------table-------------------
		ptm = new PromotionTableModel();
		proTbl = new JTable(ptm);
		jsp = new JScrollPane(proTbl);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
	}

	class PromotionTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "编号", "促销起始时间", "促销中止时间", "促销策略类型" };

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
}
