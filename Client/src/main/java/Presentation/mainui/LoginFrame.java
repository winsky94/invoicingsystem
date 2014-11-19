package Presentation.mainui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Presentation.uihelper.UIhelper;
import businesslogic.userbl.User;
import businesslogicservice.userblservice.UserBLService;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private UserBLService service;
	private static final long serialVersionUID = 1L;
	String id, key;
	JTextField idField;
	JPasswordField passwordField;
	int screenHeight, screenWidth, frameHeight, frameWidth;

	public LoginFrame() throws Exception {
		service = new User();// 声明一下 yan 11-18
		// 获得与分辨率匹配的大小
		screenHeight=UIhelper.getScreenHeight();
		screenWidth=UIhelper.getScreenWidth();
		frameHeight = screenHeight * 2 / 3;
		frameWidth = screenWidth * 2 / 9;
		// 设置窗口大小，位置
		this.setSize(frameWidth, frameHeight);
		this.setLocation((screenWidth - frameWidth) / 2,
				(screenHeight - frameHeight) / 2);
		// 窗口标题
		this.setTitle("欢迎使用进销存系统");
		// 设置图标
		//this.setIconImage(UIhelper.getImage("GUI/Login/icon.png"));

		// ----------下面是覆盖整个窗口的MainPanel---------------------------------------------
		JPanel mainPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			// 给panel加上图片
			protected void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("img/Login/background.jpg");
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(),
						icon.getIconHeight(), icon.getImageObserver());
			}
		};
		// 设置mainPanel的大小和位置：同frame一样大小，覆盖整个frame
		mainPanel.setSize(frameWidth, frameHeight);
		mainPanel.setLocation(0, 0);
		// ------------在mainPanel上添加组件------------------------------------------------
		// 设置用户名文本域
		idField = new JTextField();
		idField.setSize(frameWidth * 64 / 100, frameHeight / 16);
		idField.setLocation(frameWidth * 26 / 100, frameHeight * 55 / 100);
		idField.getDocument().addDocumentListener(new idFieldListener());
		idField.setVisible(true);
		// 设置密码域
		passwordField = new JPasswordField();
		passwordField.setSize(frameWidth * 64 / 100, frameHeight / 16);
		passwordField
				.setLocation(frameWidth * 26 / 100, frameHeight * 65 / 100);
		passwordField.addKeyListener(new passwordFieldListener());
		passwordField.setVisible(true);
		// 设置登录按钮
		// 设想：改为圆形按钮
		JButton loginButton = new JButton("登录");
		Font buttonFont = new Font("登录", Font.PLAIN, 13);
		loginButton.setFont(buttonFont);
		loginButton.setSize(frameWidth / 5, frameHeight * 6 / 100);
		loginButton.setLocation((frameWidth - frameWidth / 5) / 2,
				frameHeight * 80 / 100);
		loginButton.addActionListener(new LoginListener());
		loginButton.setVisible(true);

		// 设置用户名标签
		JLabel idLabel = new JLabel("用户名");
		Font idLabelFont = new Font("用户名", Font.BOLD, 14);
		idLabel.setFont(idLabelFont);
		idLabel.setSize(frameWidth / 5, frameHeight / 11);
		idLabel.setLocation(frameWidth * 8 / 100, frameHeight * 54 / 100);
		idLabel.setVisible(true);
		// 设置了密码标签
		JLabel passwordLabel = new JLabel("密码");
		Font passwordLabelFont = new Font("密码", Font.BOLD, 14);
		passwordLabel.setFont(passwordLabelFont);
		passwordLabel.setSize(frameWidth / 5, frameHeight / 11);
		passwordLabel.setLocation(frameWidth * 8 / 100, frameHeight * 64 / 100);
		passwordLabel.setVisible(true);
		// 设置头像区
		JPanel portraitPanel = new JPanel();

		mainPanel.setVisible(true);
		mainPanel.setLayout(null);
		// 向mainPanel添加组件
		mainPanel.add(idLabel);
		mainPanel.add(passwordLabel);
		mainPanel.add(portraitPanel);
		mainPanel.add(loginButton);
		mainPanel.add(idField);
		mainPanel.add(passwordField);
		// 向LoginFrame添加组件
		this.add(mainPanel);
		this.repaint();
		this.setResizable(false);// 不允许调整窗口大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭时结束进程
		this.setVisible(true);// 窗口可见
	}

	public static void main(String[] args) throws Exception {
		new LoginFrame();
	}

	// 下面的类是用户名文本域的事件监听器
	class idFieldListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

	}

	// 下面的类是密码域的事件监听器
	class passwordFieldListener implements KeyListener {

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	// 下面的类是按钮的事件监听器
	class LoginListener implements ActionListener {
		// 11-17 By jin
		public void actionPerformed(ActionEvent e) {
			String ID = idField.getText();
			String passWord = passwordField.getPassword().toString();
			int result = service.login(ID, passWord);
			System.out.println(ID);
			System.out.println(passWord);
			System.out.println(passwordField.getPassword());
			switch (result) {
			case 0:
				System.out.println("成功登录");
			}

		}
	}

}
