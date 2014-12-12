package Presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;

import Presentation.uihelper.UIhelper;

public class MessageWindow extends JWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int winWidth = screenWidth *28/100;
	int winHeight = screenHeight *3/5;
	JList<String> list;
	JScrollPane jsp;
	public MessageWindow(){
		this.setBounds(20,20,winWidth,winHeight);
		JPanel pnl=new JPanel();
		pnl.setBounds(0,0,winWidth,winHeight);
		pnl.setBackground(Color.white);
		//----------------------
		GridBagLayout gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(5,10,5,10);
		pnl.setLayout(gbl);
		//----------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("消息中心");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		titlePnl.add(title);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 1;
		gbc.weighty = 0.08;
		gbl.setConstraints(titlePnl, gbc);
		pnl.add(titlePnl);
		//----------------------
		gbc.fill=GridBagConstraints.BOTH;
		JPanel mPnl=new JPanel();
		mPnl.setBackground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 6;
		gbc.gridwidth =GridBagConstraints.REMAINDER;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbl.setConstraints(mPnl, gbc);
		pnl.add(mPnl);
		mPnl.setLayout(new GridLayout(1,1));
		//-----JList-------------
		Vector<String> message=new Vector<String>();
		message.add("2014-12-02 08:05 :Your receipt has been approved");
		message.add("2014-12-01 13:05 :Your receipt has been examined");
		list=new JList<String>(message);
		list.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jsp=new JScrollPane(list);
		mPnl.add(jsp);
		//-----------------------
		this.add(pnl);
		this.setVisible(true);	
	}
	public static void main(String[] args) {
		MessageWindow m=new MessageWindow();
	}
}
