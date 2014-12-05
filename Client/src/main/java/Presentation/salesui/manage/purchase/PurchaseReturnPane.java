package Presentation.salesui.manage.purchase;

import java.awt.BorderLayout;
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
import Presentation.mainui.outBorder;
import Presentation.uihelper.UIhelper;

public class PurchaseReturnPane extends  ChooseGoodsFatherPane{
	
	MainFrame parent;
	PurchasePane p;
	public PurchaseReturnPane(MainFrame frame,String id) throws Exception {
		parent=frame;
		this.setLayout(new BorderLayout());
		p=new PurchasePane(parent);
		this.add(p,BorderLayout.CENTER);
		p.title.setText("创建进货退货单");
		
		
		

	}
}
