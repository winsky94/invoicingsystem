package Presentation.stockui.goodsmanage;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Presentation.uihelper.UIhelper;

public class AddGoodsDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel IDLbl,nameLbl,sizeLbl,defaultPurchasePriceLbl,defaultSalePriceLbl;
	JTextField nameFld,sizeFld,defaultPurchasePriceFld,defaultSalePriceFld;
	JButton submitBtn;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dlgWidth = screenWidth * 60 / 100;
	int dlgHeight = screenHeight * 60 / 100;
	Container pnl;
	public AddGoodsDialog(){
		pnl = this.getContentPane();
		pnl.setBackground(Color.white);
		pnl.setLayout(null);
		//
		
		//
		this.setTitle("添加商品");
		this.setBounds((screenWidth - dlgWidth) / 2,
				(screenHeight - dlgHeight) / 2, dlgWidth, dlgHeight);

		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
