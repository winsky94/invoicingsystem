package Presentation.salesui.manage.purchase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;

import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.uihelper.UIhelper;

public class PurchaseReturnPane extends  ChooseGoodsFatherPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dialogWidth = screenWidth * 65 / 100;
	int dialogHeight = screenHeight * 65 / 100;

	JLabel IDLbl, JHSLbl, stockLbl, userLbl, purchaseItemLbl, remarkLbl,
			totalLbl;
	String JHSText, stockText, userText, totalText;
	JButton submitBtn;
	JTextArea remarkArea;
	JTable purchaseItemTbl;
	MainFrame parent;

	public PurchaseReturnPane(MainFrame frame) {
		parent=frame;
		
		this.setLayout(null);
		this.setBackground(Color.white);
		// ---------------下面添加各个组件----------------------------------------
		// -----------------------IDLabel------------------------------------
		IDLbl = new JLabel();
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		// 这里要有一个方法来创建String，使得编号自动生成
		String text = "编号：JHTHD-0000001";
		IDLbl.setText(text);
		IDLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 3 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		this.add(IDLbl);
		// -----------------------JHSLabel供应商------------------------------------
		JHSLbl = new JLabel();
		JHSText = "供应商 ： 李四";
		JHSLbl.setText(JHSText);
		JHSLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		JHSLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 13 / 100,
				dialogWidth * 15 / 100, dialogHeight * 5 / 100);
		this.add(JHSLbl);
		// -------------------stockLbl------------------------------------------
		stockLbl = new JLabel();
		stockText = "仓库 ： 无锡02";
		stockLbl.setText(stockText);
		stockLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		stockLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 23 / 100,
				dialogWidth * 15 / 100, dialogHeight * 5 / 100);
		this.add(stockLbl);
		// -------------------userLbl------------------------------------------
		userLbl = new JLabel();
		// !!!!!!!!!!!BL获取user信息
		userText = "操作员 : 李四";
		userLbl.setText(userText);
		userLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		userLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 33 / 100,
				dialogWidth * 40 / 100, dialogHeight * 5 / 100);
		this.add(userLbl);
		// -------------------purchaseItemLbl-------------------------------
		purchaseItemLbl = new JLabel("进货商品列表 ");
		purchaseItemLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		purchaseItemLbl.setBounds(dialogWidth * 32 / 100,
				dialogHeight * 13 / 100, dialogWidth * 10 / 100,
				dialogHeight * 5 / 100);
		this.add(purchaseItemLbl);
		// -------------------totalLbl-------------------------------
		totalLbl = new JLabel();
		// !!!!!!!!!!!BL获取user信息
		totalText = "总计 : 2000000元";
		totalLbl.setText(totalText);
		totalLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		totalLbl.setBounds(dialogWidth * 60 / 100, dialogHeight * 13 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		this.add(totalLbl);
		// -----------------purchaseItemTbl-----------------------------------
		purchaseItemTbl = new JTable();
		purchaseItemTbl.setBounds(dialogWidth * 32 / 100,
				dialogHeight * 23 / 100, dialogWidth * 65 / 100,
				dialogHeight * 55 / 100);
		purchaseItemTbl.setBackground(Color.black);
		this.add(purchaseItemTbl);
		// -------------------remarkLbl------------------------------------------
		remarkLbl = new JLabel("备注");
		remarkLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		remarkLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 43 / 100,
				dialogWidth * 10 / 100, dialogHeight * 5 / 100);
		this.add(remarkLbl);
		// -----------------remarkArea---------------------------------------
		remarkArea = new JTextArea();
		remarkArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		remarkArea.setBackground(new Color(238, 238, 238));
		remarkArea.setFont(new Font("楷体", Font.PLAIN, 12));
		remarkArea.setBounds(dialogWidth * 3 / 100, dialogHeight * 50 / 100,
				dialogWidth * 28 / 100, dialogHeight * 28 / 100);
		this.add(remarkArea);
		// -----------------submitBtn------------------------------------------
		submitBtn = new JButton("提  交");
		submitBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		submitBtn.setBounds(dialogWidth * 40 / 100, dialogHeight * 85 / 100,
				dialogWidth * 20 / 100, dialogHeight * 6 / 100);
		submitBtn.setFocusPainted(false);
		this.add(submitBtn);
		// ------------------------------------------------------------------
		

	}
}
