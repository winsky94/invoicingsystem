package Presentation.salesui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Presentation.uihelper.UserInfoPanel;

public class SalesLeftPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel userInfoPnl,menuPnl;

	public SalesLeftPanel(JPanel memberMgrPnl,JPanel purchaseMgrPnl,JPanel saleMgrPnl,JPanel aboutPnl,JPanel rightPnl) {
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		// 添加User信息Panel
		/*--------！！！！BL编写者看这里！！！！-------------
		 * 下一行的构造器应当传过去User的信息来构建UserInfoPanel
		 */
		userInfoPnl = new UserInfoPanel();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0.9;
		gbl.setConstraints(userInfoPnl, c);
		this.add(userInfoPnl);
		//
		menuPnl=new SalesLeftBtnPnl(memberMgrPnl, purchaseMgrPnl, saleMgrPnl,aboutPnl,rightPnl);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(menuPnl, c);
		this.add(menuPnl);
		//
		this.setBackground(new Color(47, 73, 136));

	}

}
