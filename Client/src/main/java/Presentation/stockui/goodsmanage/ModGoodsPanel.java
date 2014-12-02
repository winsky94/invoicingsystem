package Presentation.stockui.goodsmanage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import vo.GoodsVO;
import Presentation.uihelper.UIhelper;

public class ModGoodsPanel extends JPanel {

	/**
	 * 已经传过来了，@王宁，到时候直接获取数据加到相应的JTextField或者label（你看着办）就好了_yan
	 */
	private static final long serialVersionUID = 1L;
	String IDtext, nameText, sizeText, pPriceText, sPriceText;
	JLabel IDLbl, nameLbl, sizeLbl, defaultPurchasePriceLbl,
			defaultSalePriceLbl;
	JTextField nameFld, sizeFld, defaultPurchasePriceFld, defaultSalePriceFld;
	JButton submitBtn;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dlgWidth = screenWidth * 28 / 100;
	int dlgHeight = screenHeight * 60 / 100;

	public ModGoodsPanel(GoodsVO vo) {
		this.setBackground(Color.white);
		this.setLayout(null);
		//
		// -----------------------IDLabel------------------------------------
		IDLbl = new JLabel();
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		// 这里要有一个方法来创建String，使得编号自动生成
		IDtext = "编号：XXXX-XXX-XXXX";
		IDLbl.setText(IDtext);
		IDLbl.setBounds(dlgWidth * 3 / 100, dlgHeight * 3 / 100,
				dlgWidth * 60 / 100, dlgHeight * 6 / 100);
		this.add(IDLbl);
		// -----------------------nameLabel------------------------------------
		nameLbl = new JLabel("商品名:");
		nameLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		nameLbl.setBounds(dlgWidth * 3 / 100, dlgHeight * 13 / 100,
				dlgWidth * 30 / 100, dlgHeight * 6 / 100);
		this.add(nameLbl);
		// ---------------------nameFld---------------------------------------
		nameFld = new JTextField();
		nameFld.setBorder(BorderFactory.createLineBorder(Color.gray));
		nameFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		nameFld.setBounds(dlgWidth * 20 / 100, dlgHeight * 13 / 100,
				dlgWidth * 60 / 100, dlgHeight * 6 / 100);
		nameFld.getDocument().addDocumentListener(new NameFieldListener());
		this.add(nameFld);
		// -----------------------sizeLbl------------------------------------
		sizeLbl = new JLabel("型号:");
		sizeLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		sizeLbl.setBounds(dlgWidth * 3 / 100, dlgHeight * 23 / 100,
				dlgWidth * 30 / 100, dlgHeight * 6 / 100);
		this.add(sizeLbl);
		// ---------------------sizeFld---------------------------------------
		sizeFld = new JTextField();
		sizeFld.setBorder(BorderFactory.createLineBorder(Color.gray));
		sizeFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sizeFld.setBounds(dlgWidth * 20 / 100, dlgHeight * 23 / 100,
				dlgWidth * 60 / 100, dlgHeight * 6 / 100);
		sizeFld.getDocument().addDocumentListener(new SizeFieldListener());
		this.add(sizeFld);
		// -----------------------defaultPurchasePriceLbl------------------------------------
		defaultPurchasePriceLbl = new JLabel("默认进价:");
		defaultPurchasePriceLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		defaultPurchasePriceLbl.setBounds(dlgWidth * 3 / 100,
				dlgHeight * 33 / 100, dlgWidth * 30 / 100, dlgHeight * 6 / 100);
		this.add(defaultPurchasePriceLbl);
		// ---------------------defaultPurchasePriceFld---------------------------------------
		defaultPurchasePriceFld = new JTextField();
		defaultPurchasePriceFld.setBorder(BorderFactory
				.createLineBorder(Color.gray));
		defaultPurchasePriceFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		defaultPurchasePriceFld.setBounds(dlgWidth * 20 / 100,
				dlgHeight * 33 / 100, dlgWidth * 60 / 100, dlgHeight * 6 / 100);
		defaultPurchasePriceFld.getDocument().addDocumentListener(
				new PPriceFieldListener());
		this.add(defaultPurchasePriceFld);
		// -----------------------defaultSalePriceLbl------------------------------------
		defaultSalePriceLbl = new JLabel("默认售价:");
		defaultSalePriceLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		defaultSalePriceLbl.setBounds(dlgWidth * 3 / 100, dlgHeight * 43 / 100,
				dlgWidth * 30 / 100, dlgHeight * 6 / 100);
		this.add(defaultSalePriceLbl);
		// ---------------------defaultSalePriceFld---------------------------------------
		defaultSalePriceFld = new JTextField();
		defaultSalePriceFld.setBorder(BorderFactory
				.createLineBorder(Color.gray));
		defaultSalePriceFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		defaultSalePriceFld.setBounds(dlgWidth * 20 / 100,
				dlgHeight * 43 / 100, dlgWidth * 60 / 100, dlgHeight * 6 / 100);
		defaultSalePriceFld.getDocument().addDocumentListener(
				new SPriceFieldListener());
		this.add(defaultSalePriceFld);
		// -------------------submitBtn---------------------------------------------
		submitBtn = new JButton("确  定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setBounds(dlgWidth * 40 / 100, dlgHeight * 80 / 100,
				dlgWidth * 20 / 100, dlgHeight * 6 / 100);
		submitBtn.setFocusPainted(false);
		this.add(submitBtn);
		//
		this.setBounds((screenWidth - dlgWidth) / 2,
				(screenHeight - dlgHeight) / 2, dlgWidth, dlgHeight);

		this.setVisible(true);
	}

	class NameFieldListener implements DocumentListener {
		public void changedUpdate(DocumentEvent d) {
			nameText = nameFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			nameText = nameFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			nameText = nameFld.getText();
		}
	}

	class SizeFieldListener implements DocumentListener {
		public void changedUpdate(DocumentEvent d) {
			sizeText = sizeFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			sizeText = sizeFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			sizeText = sizeFld.getText();
		}
	}

	class PPriceFieldListener implements DocumentListener {
		public void changedUpdate(DocumentEvent d) {
			pPriceText = defaultPurchasePriceFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			pPriceText = defaultPurchasePriceFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			pPriceText = defaultPurchasePriceFld.getText();
		}
	}

	class SPriceFieldListener implements DocumentListener {
		public void changedUpdate(DocumentEvent d) {
			sPriceText = defaultSalePriceFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			sPriceText = defaultSalePriceFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			sPriceText = defaultSalePriceFld.getText();
		}
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GoodsVO vo=new GoodsVO("0001-SR01-00001","飞利浦日光灯","SR01",0,10,12,10,12,"飞利浦");
		ModGoodsPanel mgp = new ModGoodsPanel(vo);
		mgp.setBounds(0, 0, 920, 600);
		testFrame.add(mgp);
		testFrame.setVisible(true);
	}
}
