package Presentation.salesui.manage.purchase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

import Presentation.uihelper.UIhelper;

public class AddPurchaseItemDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dlgWidth = screenWidth * 40 / 100;
	int dlgHeight = screenHeight * 60 / 100;
	Container pnl;
	JTree commodityTree;
	JLabel IDLbl, nameLbl, sizeLbl, priceLbl, numLbl, totalPriceLbl, remarkLbl;
	String IDText, nameText, sizeText, totalPriceText;
	JTextField priceFld, numFld;
	JTextArea remarkArea;
	JButton submitBtn;

	public AddPurchaseItemDialog() {
		pnl = this.getContentPane();
		pnl.setLayout(null);
		//
		// ----------------commodityTree-----------------------
		commodityTree = new JTree();
		// !!!!!!!!BL请完善这里!!!!!!!!!!!!!!!!
		// commodityTree.setBackground(Color.black);
		commodityTree.setBounds(dlgWidth * 3 / 100, dlgHeight * 3 / 100,
				dlgWidth * 40 / 100, dlgHeight * 75 / 100);
		commodityTree.setBorder(BorderFactory
				.createLineBorder(Color.LIGHT_GRAY));
		pnl.add(commodityTree);
		// ---------------IDLbl-----------------------------------
		IDLbl = new JLabel();
		IDText = "商品编号：0000-000-0000";
		// !!!!!!!!!!!!!!!BL!!!!!!!!!!!!!!!
		IDLbl.setText(IDText);
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		IDLbl.setBounds(dlgWidth * 45 / 100, dlgHeight * 5 / 100,
				dlgWidth * 60 / 100, dlgHeight * 5 / 100);
		pnl.add(IDLbl);
		// ---------------nameLbl-----------------------------------
		nameLbl = new JLabel();
		nameText = "商品名：飞利浦护眼灯";
		// !!!!!!!!!!!!!!!BL!!!!!!!!!!!!!!!
		nameLbl.setText(nameText);
		nameLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		nameLbl.setBounds(dlgWidth * 45 / 100, dlgHeight * 10 / 100,
				dlgWidth * 50 / 100, dlgHeight * 5 / 100);
		pnl.add(nameLbl);
		// --------------sizeLbl-------------------------------------
		sizeLbl = new JLabel();
		sizeText = "型号：HR01";
		// !!!!!!!!!!!!!!!BL!!!!!!!!!!!!!!!
		sizeLbl.setText(sizeText);
		sizeLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		sizeLbl.setBounds(dlgWidth * 45 / 100, dlgHeight * 15 / 100,
				dlgWidth * 50 / 100, dlgHeight * 5 / 100);
		pnl.add(sizeLbl);
		// --------------priceLbl-------------------------------------
		priceLbl = new JLabel("单价(元)： ");
		priceLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		priceLbl.setBounds(dlgWidth * 68 / 100, dlgHeight * 15 / 100,
				dlgWidth * 15 / 100, dlgHeight * 5 / 100);
		pnl.add(priceLbl);
		// --------------priceFld-------------------------------------
		priceFld = new JTextField();
		// !!!!!!!!!!!!这里要获取默认进价并填入框中~！！！！！！！！！！！！！！！
		priceFld.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		priceFld.setBounds(dlgWidth * 82 / 100, dlgHeight * 15 / 100,
				dlgWidth * 12 / 100, dlgHeight * 5 / 100);
		pnl.add(priceFld);
		// --------------numLbl-------------------------------------
		numLbl = new JLabel("数量： ");
		numLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		numLbl.setBounds(dlgWidth * 45 / 100, dlgHeight * 20 / 100,
				dlgWidth * 15 / 100, dlgHeight * 5 / 100);
		pnl.add(numLbl);
		// --------------numFld-------------------------------------
		numFld = new JTextField();
		// !!!!!!!!!!!!这里要获取默认进价并填入框中~！！！！！！！！！！！！！！！
		numFld.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		numFld.setBounds(dlgWidth * 53 / 100, dlgHeight * 20 / 100,
				dlgWidth * 12 / 100, dlgHeight * 5 / 100);
		pnl.add(numFld);
		// --------------totalPriceLbl-------------------------------------
		totalPriceLbl = new JLabel();
		totalPriceText = "总价： 5000元";
		totalPriceLbl.setText(totalPriceText);
		totalPriceLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		totalPriceLbl.setBounds(dlgWidth * 68 / 100, dlgHeight * 20 / 100,
				dlgWidth * 30 / 100, dlgHeight * 5 / 100);
		pnl.add(totalPriceLbl);
		// -------------------remarkLbl------------------------------------------
		remarkLbl = new JLabel("备注");
		remarkLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		remarkLbl.setBounds(dlgWidth * 45 / 100, dlgHeight * 30 / 100,
				dlgWidth * 15 / 100, dlgHeight * 5 / 100);
		pnl.add(remarkLbl);
		// -----------------remarkArea---------------------------------------
		remarkArea = new JTextArea();
		remarkArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		remarkArea.setFont(new Font("楷体", Font.PLAIN, 12));
		remarkArea.setBounds(dlgWidth * 45 / 100, dlgHeight * 35 / 100,
				dlgWidth * 50 / 100, dlgHeight * 42 / 100);
		pnl.add(remarkArea);
		// -----------------submitBtn------------------------------------------
		submitBtn = new JButton("增  加");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setBounds(dlgWidth * 40 / 100, dlgHeight * 85 / 100,
				dlgWidth * 20 / 100, dlgHeight * 6 / 100);
		submitBtn.setFocusPainted(false);
		pnl.add(submitBtn);
		this.setBounds((screenWidth - dlgWidth) / 2,
				(screenHeight - dlgHeight) / 2, dlgWidth, dlgHeight);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("增加商品到进货列表");
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);

	}
}
