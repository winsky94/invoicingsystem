package Presentation.salesui.manage.sale;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Presentation.uihelper.UIhelper;

public class SaleDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dialogWidth = screenWidth * 65 / 100;
	int dialogHeight = screenHeight * 65 / 100;
	Container pnl;
	JLabel IDLbl, XSSLbl, clerkLbl, userLbl, stockLbl, saleItemLbl,
			totalOriginLbl, discountValueLbl, couponValueLbl,
			totalToPayLbl,remarkLbl;
	JComboBox<String> XSSCbox;
	JTextField clerkFld,stockFld,discountMoneyFld;
	JTable saleItemTbl;
	JTextArea remarkArea;
	JButton submitBtn,addCouponBtn, addItemBtn, delItemBtn;
	public SaleDialog(){
		
	}
}
