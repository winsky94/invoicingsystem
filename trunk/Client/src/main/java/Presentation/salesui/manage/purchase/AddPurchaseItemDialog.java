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
	int dlgWidth = screenWidth * 60 / 100;
	int dlgHeight = screenHeight * 60 / 100;
	Container pnl;
	JTree commodityTree;
	JTable commodityTbl;
	String commodityTblHead[]={"商品编号","商品名","型号","默认进价",""};
	String content[][];
	JButton submitBtn;
	
	public AddPurchaseItemDialog() {
		pnl = this.getContentPane();
		pnl.setLayout(null);
		//
		// ----------------commodityTree-----------------------
		commodityTree = new JTree();
		// !!!!!!!!BL请完善这里!!!!!!!!!!!!!!!!
		commodityTree.setBounds(dlgWidth * 3 / 100, dlgHeight * 3 / 100,
				dlgWidth * 25 / 100, dlgHeight * 80 / 100);
		commodityTree.setBorder(BorderFactory
				.createLineBorder(Color.LIGHT_GRAY));
		pnl.add(commodityTree);
		//----------------commodityTbl-----------------------------
		commodityTbl=new JTable();
		
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
