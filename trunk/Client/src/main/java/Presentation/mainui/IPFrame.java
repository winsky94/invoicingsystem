package Presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentation.uihelper.UIhelper;

public class IPFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int frameWidth = screenWidth * 30 / 100;
	int frameHeight = screenHeight * 35 / 100;
	// ------------------------
	Font font = new Font("微软雅黑", Font.PLAIN, 14);
	JButton submitBtn, exitBtn;
	JComboBox<String> IPFld, portFld;

	public IPFrame() {
		this.setTitle("进销存系统");
		this.setIconImage(UIhelper.getImage("img/icon.png"));
		this.setBounds((screenWidth - frameWidth) / 2,
				(screenHeight - frameHeight) / 2, frameWidth, frameHeight);
		this.setLayout(new GridLayout(1, 1));
		// -------------------
		JPanel pnl = new JPanel(){
			private static final long serialVersionUID = 1L;

			// 给panel加上图片
			protected void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("img/net.png");
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(),
						icon.getIconHeight(), icon.getImageObserver());
			}
		};
		this.add(pnl);
		// -------------------
		pnl.setLayout(new GridLayout(4, 1));
		JPanel titlePnl = new JPanel();
		titlePnl.setOpaque(false);
		pnl.add(titlePnl);
		JLabel title=new JLabel("欢迎使用进销存系统");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		title.setForeground(Color.white);
		titlePnl.add(title);
		//----------------------
		JPanel top = new JPanel();
		top.setOpaque(false);
		pnl.add(top);
		JPanel mid = new JPanel();
		mid.setOpaque(false);
		pnl.add(mid);
		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		pnl.add(bottom);
		// -------IP-----------
		JLabel IPLbl = new JLabel("请输入IP：");
		IPLbl.setForeground(Color.white);
		IPLbl.setFont(font);
		top.add(IPLbl);
		String[] IP={"127.0.0.1"};
		IPFld = new JComboBox<String>(IP);
		IPFld.setFont(font);
		IPFld.setBackground(Color.white);
		IPFld.setEditable(true);
		top.add(IPFld);
		// -------Port-------------
		JLabel portLbl = new JLabel("端口：");
		portLbl.setFont(font);
		portLbl.setForeground(Color.white);
		mid.add(portLbl);
		String[] port={"1099"};
		portFld =  new JComboBox<String>(port);
		portFld.setFont(font);
		portFld.setBackground(Color.white);
		portFld.setEditable(true);
		mid.add(portFld);
		// --------buttons---------
		submitBtn = new JButton("确定");
		submitBtn.setFont(font);
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		bottom.add(submitBtn);
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		bottom.add(new JLabel());
		exitBtn = new JButton("取消");
		exitBtn.setFont(font);
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		bottom.add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		// -------------------
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		IPFrame i = new IPFrame();

	}

}
