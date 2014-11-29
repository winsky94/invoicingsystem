package Presentation.stockui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import businesslogic.userbl.User;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.uihelper.UserInfoButton;

public class StockLeftPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton  goodsBtn, stockBtn, giftBtn, aboutBtn,backBtn;
	Color stockColor;
	MainFrame parent;
	JPanel headPane;
	public StockLeftPanel(MainFrame frame) {
		parent=frame;
		stockColor=frame.getTheme()[0];
		//===构造头像
				GridBagLayout grid=new GridBagLayout();
				GridBagConstraints c=new GridBagConstraints();
			
				User user=frame.getUser();
				this.setLayout(grid);
				
				
				c.fill=GridBagConstraints.HORIZONTAL;
				c.gridx=0;c.gridy=0;
				c.gridheight=2;
				
				headPane=new headPane(parent,this,user);
				grid.setConstraints(headPane, c);
				this.add(headPane);
				
				
				JPanel down=new JPanel();
				c.weightx=0.3;c.weighty=0.4;
				c.gridx=0;c.gridy=2;
				c.gridheight=6;
				c.gridwidth=1;
				grid.setConstraints(down, c);
				this.add(down);
				down.setBackground(stockColor);
				down.setLayout(new GridLayout(6,1));
				
		// 商品管理按钮
		goodsBtn = new JButton("商品管理", new ImageIcon("img/stock/goodsMgr.png"));
		goodsBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		goodsBtn.setForeground(Color.white);
		goodsBtn.setBackground(stockColor);
		goodsBtn.setHorizontalAlignment(SwingConstants.CENTER);
		goodsBtn.setFocusPainted(false);
		goodsBtn.addActionListener(new GoodsBtnListener());
		down.add(goodsBtn);
		// 库存管理按钮
		stockBtn = new JButton("库存管理", new ImageIcon(
				"img/stock/stockMgr.png"));
		stockBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		stockBtn.setForeground(Color.white);
		stockBtn.setBackground(stockColor);
		stockBtn.setHorizontalAlignment(SwingConstants.CENTER);
		stockBtn.setFocusPainted(false);
		stockBtn.addActionListener(new StockBtnListener());
		down.add(stockBtn);
		// 库存赠送按钮
		giftBtn = new JButton("库存赠送", new ImageIcon("img/stock/giftMgr.png"));
		giftBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		giftBtn.setForeground(Color.white);
		giftBtn.setBackground(stockColor);
		giftBtn.setHorizontalAlignment(SwingConstants.CENTER);
		giftBtn.setFocusPainted(false);
		giftBtn.addActionListener(new GiftBtnListener());
		down.add(giftBtn);
		// 关于按钮
		aboutBtn = new JButton("关于系统", new ImageIcon("img/icon-about.png"));
		aboutBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		aboutBtn.setForeground(Color.white);
		aboutBtn.setBackground(stockColor);
		aboutBtn.setHorizontalAlignment(SwingConstants.CENTER);
		aboutBtn.setFocusPainted(false);
		aboutBtn.addActionListener(new AboutBtnListener());
		down.add(aboutBtn);
		//
		
		backBtn=new JButton("收起菜单",new ImageIcon("img/mainFrame/back.png"));
		backBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		backBtn.setForeground(Color.white);
		backBtn.setBackground(stockColor);
		backBtn.setHorizontalAlignment(SwingConstants.CENTER);
		backBtn.setFocusPainted(false);
		backBtn.addActionListener(this);
		c.gridx=0;c.gridy=8;
		grid.setConstraints(backBtn, c);
		this.add(backBtn);
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
