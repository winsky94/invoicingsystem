package Presentation.stockui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Presentation.uihelper.UserInfoButton;

public class StockLeftPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton userInfoBtn, goodsBtn, stockBtn, giftBtn, aboutBtn;
	Color stockColor=new Color(51,125,86);
	public StockLeftPanel() {
		this.setLayout(new GridLayout(10, 1));
		//
		/* !!!!!BL看这里！！：这里的构造器应放入User姓名和头像！！！！！！！！！ */
		userInfoBtn = new UserInfoButton("严顺宽", new ImageIcon(
				"img/sales/ysk.png"),stockColor);
		this.add(userInfoBtn);
		// 商品管理按钮
		goodsBtn = new JButton("商品管理", new ImageIcon("img/sales/memberMgr.png"));
		goodsBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		goodsBtn.setForeground(Color.white);
		goodsBtn.setBackground(stockColor);
		goodsBtn.setHorizontalAlignment(SwingConstants.CENTER);
		goodsBtn.setFocusPainted(false);
		goodsBtn.addActionListener(new GoodsBtnListener());
		this.add(goodsBtn);
		// 库存管理按钮
		stockBtn = new JButton("库存管理", new ImageIcon(
				"img/sales/purchaseMgr.png"));
		stockBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		stockBtn.setForeground(Color.white);
		stockBtn.setBackground(stockColor);
		stockBtn.setHorizontalAlignment(SwingConstants.CENTER);
		stockBtn.setFocusPainted(false);
		stockBtn.addActionListener(new StockBtnListener());
		this.add(stockBtn);
		// 库存赠送按钮
		giftBtn = new JButton("库存赠送", new ImageIcon("img/sales/saleMgr.png"));
		giftBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		giftBtn.setForeground(Color.white);
		giftBtn.setBackground(stockColor);
		giftBtn.setHorizontalAlignment(SwingConstants.CENTER);
		giftBtn.setFocusPainted(false);
		giftBtn.addActionListener(new GiftBtnListener());
		this.add(giftBtn);
		// 关于按钮
		aboutBtn = new JButton("关于系统", new ImageIcon("img/icon-about.png"));
		aboutBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		aboutBtn.setForeground(Color.white);
		aboutBtn.setBackground(stockColor);
		aboutBtn.setHorizontalAlignment(SwingConstants.CENTER);
		aboutBtn.setFocusPainted(false);
		aboutBtn.addActionListener(new AboutBtnListener());
		this.add(aboutBtn);
		//
		this.setBackground(stockColor);
	}

	class GoodsBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class StockBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class GiftBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class AboutBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}

	}
}
