package Presentation.salesui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Presentation.uihelper.UserInfoPanel;

public class SalesLeftPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JButton purchaseBtn, saleBtn, memberBtn;
	JPanel userInfoPnl;

	public SalesLeftPanel(int frameWidth, int frameHeight) {
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.NORTH;
		c.insets = new Insets(0, 0, 0, 0);
		// 添加User信息Panel
		/*--------！！！！BL编写者看这里！！！！-------------
		 * 下一行的构造器应当传过去User的信息来构建UserInfoPanel
		 */
		userInfoPnl = new UserInfoPanel();
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight=2;
		c.weightx = 1;
		c.weighty = 0;
		gbl.setConstraints(userInfoPnl, c);
		this.add(userInfoPnl);
		// 客户管理按钮
		memberBtn = new JButton("客户管理",
				new ImageIcon("img/sales/memberMgr.png"));
		memberBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		//memberBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		memberBtn.setForeground(Color.white);
		//memberBtn.setBorderPainted(false);
		memberBtn.setBackground(new Color(47, 73, 136));
		memberBtn.setHorizontalAlignment(SwingConstants.LEFT);
		memberBtn.setFocusPainted(false);
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.gridheight=1;
		c.weighty = 0;
		gbl.setConstraints(memberBtn, c);
		this.add(memberBtn);
		// 进货管理按钮
		purchaseBtn = new JButton("进货管理", new ImageIcon(
				"img/sales/memberMgr.png"));
		purchaseBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		//purchaseBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		purchaseBtn.setForeground(Color.white);
		//purchaseBtn.setBorderPainted(false);
		purchaseBtn.setBackground(new Color(47, 73, 136));
		purchaseBtn.setHorizontalAlignment(SwingConstants.LEFT);
		purchaseBtn.setFocusPainted(false);
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.weighty = 0;
		gbl.setConstraints(purchaseBtn, c);
		this.add(purchaseBtn);
		// 销售管理按钮
		saleBtn = new JButton("销售管理", new ImageIcon(
				"img/sales/memberMgr.png"));
		saleBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		//saleBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		saleBtn.setForeground(Color.white);
		//saleBtn.setBorderPainted(false);
		saleBtn.setBackground(new Color(47, 73, 136));
		saleBtn.setHorizontalAlignment(SwingConstants.LEFT);
		saleBtn.setFocusPainted(false);
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.weighty = 0;
		gbl.setConstraints(saleBtn, c);
		this.add(saleBtn);
		//
		this.setBackground(new Color(47, 73, 136));

	}

}
