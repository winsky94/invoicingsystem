package Presentation.stockui.goodsmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import businesslogic.stockbl.goods.GoodsController;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
import vo.GoodsVO;
import Presentation.mainui.MainFrame;
import Presentation.promotionui.addpromotion.AddCouponPanel;
import Presentation.stockui.goodsmanage.AddGoodsPanel.NameFieldListener;
import Presentation.stockui.goodsmanage.AddGoodsPanel.PPriceFieldListener;
import Presentation.stockui.goodsmanage.AddGoodsPanel.SPriceFieldListener;
import Presentation.stockui.goodsmanage.AddGoodsPanel.SizeFieldListener;

public class ModGoodsPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame parent;
	GoodsVO vo;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JButton submitBtn, exitBtn;
	String  pPriceText, sPriceText;
	JTextField nameFld, sizeFld, purchasePriceFld, salePriceFld;
	JLabel IDLbl, lastPurchasePriceLbl, lastSalePriceLbl;

	public ModGoodsPanel(MainFrame frame, GoodsVO goods) {
		parent = frame;
		vo = goods;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("修改商品信息");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.2;
		gbl.setConstraints(titlePnl, c);
		this.add(titlePnl);
		// -----------------------------
		c.fill = GridBagConstraints.BOTH;
		JPanel mPnl = new JPanel();
		mPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(mPnl, c);
		this.add(mPnl);
		mPnl.setLayout(new GridLayout(6, 1));
		// -------name-----------------
		JPanel namePnl = new JPanel();
		namePnl.setBackground(Color.white);
		mPnl.add(namePnl);
		JLabel nameLbl = new JLabel("商品名：");
		nameLbl.setFont(font);
		namePnl.add(nameLbl);
		nameFld = new JTextField(vo.getName());
		nameFld.setFont(font);
		nameFld.setEditable(false);
		;
		namePnl.add(nameFld);
		// -------size-----------------
		JPanel sizePnl = new JPanel();
		sizePnl.setBackground(Color.white);
		mPnl.add(sizePnl);
		JLabel sizeLbl = new JLabel("型号：");
		sizeLbl.setFont(font);
		sizePnl.add(sizeLbl);
		sizeFld = new JTextField(vo.getSize());
		sizeFld.setFont(font);
		sizeFld.setEditable(false);
		sizePnl.add(sizeFld);
		// -------lastPurchasePricePnl-----------------
		JPanel lastPurchasePricePnl = new JPanel();
		lastPurchasePricePnl.setBackground(Color.white);
		mPnl.add(lastPurchasePricePnl);
		lastPurchasePriceLbl = new JLabel("最近进价：" + vo.getLastPurchasePrice());
		lastPurchasePriceLbl.setFont(font);
		lastPurchasePricePnl.add(lastPurchasePriceLbl);
		// -------lastSalePricePnl-----------------
		JPanel lastSalePricePnl = new JPanel();
		lastSalePricePnl.setBackground(Color.white);
		mPnl.add(lastSalePricePnl);
		lastSalePriceLbl = new JLabel("最近售价：" + vo.getLastPrice());
		lastSalePriceLbl.setFont(font);
		lastSalePricePnl.add(lastSalePriceLbl);
		// -------purchasePrice-----------------
		JPanel purchasePricePnl = new JPanel();
		purchasePricePnl.setBackground(Color.white);
		mPnl.add(purchasePricePnl);
		JLabel purchasePriceLbl = new JLabel("默认进价：");
		purchasePriceLbl.setFont(font);
		purchasePricePnl.add(purchasePriceLbl);
		purchasePriceFld = new JTextField(
				String.valueOf(vo.getPurchasePrice()), 6);
		purchasePriceFld.setFont(font);
		purchasePriceFld.getDocument().addDocumentListener(
				new PPriceFieldListener());
		purchasePricePnl.add(purchasePriceFld);
		// -------salePrice-----------------
		JPanel salePricePnl = new JPanel();
		salePricePnl.setBackground(Color.white);
		mPnl.add(salePricePnl);
		JLabel salePriceLbl = new JLabel("默认售价：");
		salePriceLbl.setFont(font);
		salePricePnl.add(salePriceLbl);
		salePriceFld = new JTextField(String.valueOf(vo.getPrice()), 6);
		salePriceFld.setFont(font);
		salePriceFld.getDocument().addDocumentListener(
				new SPriceFieldListener());
		salePricePnl.add(salePriceFld);
		// -------buttons-----------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 10;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		// -------------------------------
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		submitBtn.addActionListener(this);
		btnPnl.add(submitBtn);
		btnPnl.add(new JLabel("          "));
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		exitBtn.addActionListener(this);
		btnPnl.add(exitBtn);
		// ------------------
		JPanel blankPnl2 = new JPanel();
		blankPnl2.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 12;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.2;
		gbl.setConstraints(blankPnl2, c);
		this.add(blankPnl2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitBtn) {
			//监听
		}
		 else if(e.getSource()==exitBtn){
			 parent.setRightComponent(new GoodsPanel(parent));
		 }

	}

	class PPriceFieldListener implements DocumentListener {
		public void changedUpdate(DocumentEvent d) {
			pPriceText = purchasePriceFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			pPriceText = purchasePriceFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			pPriceText = purchasePriceFld.getText();
		}
	}

	class SPriceFieldListener implements DocumentListener {
		public void changedUpdate(DocumentEvent d) {
			sPriceText = salePriceFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			sPriceText = salePriceFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			sPriceText = salePriceFld.getText();
		}
	}
}
