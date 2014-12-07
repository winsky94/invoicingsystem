package Presentation.financeui.moneyreceipt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentation.mainui.MainFrame;

public class CollectionDetailPanel extends CollectionAndPaymentPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CollectionDetailPanel(MainFrame frame) {
		super(frame);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("收款单");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.08;
		gbl.setConstraints(titlePnl, c);
		this.add(titlePnl);
		//-----------------------------------
		
	}

}
