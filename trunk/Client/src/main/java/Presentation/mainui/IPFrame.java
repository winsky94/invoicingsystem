package Presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	int frameWidth = screenWidth * 25 / 100;
	int frameHeight = screenHeight * 25 / 100;
	// ------------------------
	Font font = new Font("微软雅黑", Font.PLAIN, 14);
	JButton submitBtn, exitBtn;
	JTextField IPFld, portFld;

	public IPFrame() {
		this.setTitle("进销存系统");
		this.setIconImage(UIhelper.getImage("img/icon.png"));
		this.setBounds((screenWidth - frameWidth) / 2,
				(screenHeight - frameHeight) / 2, frameWidth, frameHeight);
		this.setLayout(new GridLayout(1, 1));
		// -------------------
		JPanel pnl = new JPanel();
		pnl.setBackground(Color.white);
		this.add(pnl);
		// -------------------
		pnl.setLayout(new GridLayout(3, 1));
		JPanel top = new JPanel();
		top.setBackground(Color.white);
		pnl.add(top);
		JPanel mid = new JPanel();
		mid.setBackground(Color.white);
		pnl.add(mid);
		JPanel bottom = new JPanel();
		bottom.setBackground(Color.white);
		pnl.add(bottom);
		// -------IP-----------
		JLabel IPLbl = new JLabel("请输入IP：");
		IPLbl.setFont(font);
		top.add(IPLbl);
		IPFld = new JTextField("127.0.0.1",10);
		IPFld.setFont(font);
		top.add(IPFld);
		// -------Port-------------
		JLabel portLbl = new JLabel("端口：");
		portLbl.setFont(font);
		mid.add(portLbl);
		portFld = new JTextField("1099",5);
		portFld.setFont(font);
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
		this.setVisible(true);

	}

	public static void main(String[] args) {
		IPFrame i = new IPFrame();

	}

}
