package Presentation.financeui.moneyreceipt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentation.mainui.MainFrame;

public class AddPaymentPanel extends CollectionAndPaymentPanel {

	/**
	 * 创建付款单
	 * 需要监听
	 */
	private static final long serialVersionUID = 1L;

	public AddPaymentPanel(MainFrame parent) {
		super(parent);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建付款单");
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
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/*		AddPaymentPanel gp = new AddPaymentPanel();
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
*/
	}
}
