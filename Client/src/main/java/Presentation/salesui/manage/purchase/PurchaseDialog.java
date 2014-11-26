package Presentation.salesui.manage.purchase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Presentation.uihelper.UIhelper;

public class PurchaseDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dialogWidth = screenWidth * 65 / 100;
	int dialogHeight = screenHeight * 65 / 100;
	Container pnl;
	JLabel IDLbl, JHSLbl, stockLbl, userLbl, purchaseItemLbl, remarkLbl,
			totalLbl;
	JTextField stockFld;
	JButton submitBtn, addItemBtn, delItemBtn;
	JTextArea remarkArea;
	JTable purchaseItemTbl;
	JComboBox<String> JHSCbox;

	public PurchaseDialog() {
		pnl = this.getContentPane();
		pnl.setLayout(null);
		pnl.setBackground(Color.white);
		// ---------------下面添加各个组件----------------------------------------
		// -----------------------IDLabel------------------------------------
		IDLbl = new JLabel();
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		// 这里要有一个方法来创建String，使得编号自动生成
		String text = "编号：JHD-0000001";
		IDLbl.setText(text);
		IDLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 3 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		pnl.add(IDLbl);
		// -----------------------JHSLabel供应商------------------------------------
		JHSLbl = new JLabel("供应商 ");
		JHSLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		JHSLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 13 / 100,
				dialogWidth * 7 / 100, dialogHeight * 5 / 100);
		pnl.add(JHSLbl);
		//----------------------JHSCbox-----------------------------------------
		//!!!!!!!!!!!这里应该传入所有进货商的名字+编号！！！
		String[] memberList = { "请选择供应商", "BL写这里", "JHS-0000001 李四" };
		JHSCbox = new JComboBox<String>(memberList);
		JHSCbox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		JHSCbox.setBackground(Color.white);
		JHSCbox.setBounds(dialogWidth * 10 / 100, dialogHeight * 13 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		pnl.add(JHSCbox);
		//-------------------
		// ------------------------------------------------------------------
		this.setTitle("创建进货单");
		this.setBounds((screenWidth - dialogWidth) / 2,
				(screenHeight - dialogHeight) / 2, dialogWidth, dialogHeight);

		this.setResizable(false);
		this.setModal(true);
		this.setIconImage(UIhelper.getImage("img/sales/purchase-blue.png"));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

}
