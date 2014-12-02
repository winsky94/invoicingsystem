package Presentation.stockui.goodsmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import vo.GoodsVO;
import businesslogic.stockbl.goods.GoodsController;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
import Presentation.mainui.MainFrame;
import Presentation.uihelper.UIhelper;

public class AddGoodsPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String IDtext, nameText, sizeText, pPriceText, sPriceText, classText;
	JLabel IDLbl, nameLbl, sizeLbl, defaultPurchasePriceLbl,
			defaultSalePriceLbl;
	JTextField nameFld, sizeFld, defaultPurchasePriceFld, defaultSalePriceFld;
	JButton submitBtn;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dlgWidth = screenWidth * 28 / 100;
	int dlgHeight = screenHeight * 60 / 100;
	MainFrame parent;

	public AddGoodsPanel(MainFrame frame, String goodsClass) {
		parent = frame;
		classText = goodsClass;
		this.setBackground(Color.white);
		this.setLayout(null);
		//
		// -----------------------IDLabel------------------------------------
		IDLbl = new JLabel();
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		// 这里要有一个方法来创建String，使得编号自动生成
		// StockGoodsBLService controller=new GoodsController();
		// String currentID=controller.getMaxID();
		// //类编号-size-ID——bl层自己实现了
		IDtext = "编号：系统自动分配噢~";
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
		submitBtn.addActionListener(this);
		this.add(submitBtn);
		this.setVisible(true);
		//

	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource() == submitBtn) {
			StockGoodsBLService controller = new GoodsController();			
			GoodsVO vo = new GoodsVO(IDtext, nameText, sizeText, 0,
					Double.parseDouble(pPriceText),
					Double.parseDouble(sPriceText), 0, 0, classText);
			int result=controller.addGoods(vo);
			if(result!=0){
				JOptionPane.showMessageDialog(null, "            该商品已存在", null,
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			else{
				//怎么返回上一级panel啊~~~~
				//还要记得返回上级panel后new一个goodsModel刷新商品界面
			}
		}
//加一个取消按钮并增加监听
		// else if(e.getSource()==){
		//
		// }
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
}