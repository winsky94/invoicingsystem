package Presentation.userui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import vo.UserVO;
import Presentation.mainui.JLeftButton;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.uihelper.UIhelper;

public class UserLeftPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel leftPnl;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int frameWidth = screenWidth * 85 / 100;
	int frameHeight = screenHeight * 85 / 100;
	JLeftButton userBtn, logBtn, aboutBtn, backBtn;
	Color userColor;
	MainFrame parent;
	JPanel headPane;

	public UserLeftPanel(MainFrame frame) {
		userColor = frame.getTheme()[0];
		parent = frame;
		// ----------------------------------
		// ===构造头像
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		UserVO user = frame.getUser();
		this.setLayout(grid);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		headPane = new headPane(parent, this, user);
		grid.setConstraints(headPane, c);
		this.add(headPane);

		JPanel down = new JPanel();
		c.weightx = 0.3;
		c.weighty = 0.4;
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = 1;
		grid.setConstraints(down, c);
		this.add(down);
		down.setBackground(userColor);
		down.setLayout(new GridLayout(6, 1));

		//-----------userBtn--------------

		userBtn = new JLeftButton("用户管理", new ImageIcon(
				"img/user/userMgr.png"), userColor);

		userBtn.addActionListener(this);
		down.add(userBtn);
		//----------logBtn------------------
		logBtn = new JLeftButton("系统日志", new ImageIcon(
				"img/user/log.png"), userColor);
		logBtn.addActionListener(this);
		down.add(logBtn);
		// 关于按钮
		aboutBtn = new JLeftButton("关于系统", new ImageIcon("img/icon-about.png"),
				userColor);
		aboutBtn.addActionListener(this);
		down.add(aboutBtn);
		//

		backBtn = new JLeftButton("收起菜单", new ImageIcon(
				"img/mainFrame/back.png"), userColor);
		backBtn.addActionListener(this);
		c.gridx = 0;
		c.gridy = 8;
		grid.setConstraints(backBtn, c);
		this.add(backBtn);
		this.setBackground(userColor);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
