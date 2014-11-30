package Presentation.stockui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import po.UserPO.UserJob;
import vo.UserVO;
import Presentation.mainui.JLeftButton;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import businesslogic.userbl.User;

public class StockLeftShortPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLeftButton goodsBtn, stockBtn, giftBtn, aboutBtn;
	MainFrame parent;
	headPane hp;
	Color stockColor=new Color(51,125,86);
	public StockLeftShortPanel(MainFrame frame){
		parent=frame;
		this.setLayout(new GridLayout(10, 1));
		//!!!!!!!!!BL!!!!!!!!!!!
		UserVO user=frame.getUser();
		hp=new headPane(frame,this,user,1);
		this.add(hp);
		// 商品管理按钮
		goodsBtn = new JLeftButton(new ImageIcon("img/stock/goodsMgr.png"),stockColor);
	
		goodsBtn.addActionListener(new GoodsBtnListener());
		this.add(goodsBtn);
		// 库存管理按钮
		stockBtn = new JLeftButton(new ImageIcon(
				"img/stock/stockMgr.png"),stockColor);
	
		stockBtn.addActionListener(new StockBtnListener());
		this.add(stockBtn);
		// 库存赠送按钮
		giftBtn = new JLeftButton(new ImageIcon("img/stock/giftMgr.png"),
				stockColor);
	
		giftBtn.setFocusPainted(false);
		giftBtn.addActionListener(new GiftBtnListener());
		this.add(giftBtn);
		// 关于按钮
		aboutBtn = new JButton(new ImageIcon("img/icon-about.png"));
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
