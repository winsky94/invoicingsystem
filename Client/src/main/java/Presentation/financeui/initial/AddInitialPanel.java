package Presentation.financeui.initial;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Presentation.financeui.InitialPanel;
import Presentation.mainui.MainFrame;

public class AddInitialPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JTabbedPane tab;
	GoodsInitialPanel goodsInitalPanel;
	AccountInitialPanel accountInitialPanel;
	MemberInitialPanel memberInitialPanel;
	JButton submitBtn, exitBtn;
    MainFrame parent;
	
	public AddInitialPanel(MainFrame frame) {
		parent=frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("期初建账");
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
		// ---------选项卡---------------
		c.fill=GridBagConstraints.BOTH;
		tab = new JTabbedPane();
		tab.setBackground(Color.white);
		tab.setFont(font);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(tab, c);
		this.add(tab);
		//----------------------------
		goodsInitalPanel=new GoodsInitialPanel(parent);
		tab.add("商品信息初始化",goodsInitalPanel);
		goodsInitalPanel.setParent(this);
		//----------------------------
		memberInitialPanel=new MemberInitialPanel(parent);
		tab.add("客户信息初始化",memberInitialPanel);
		memberInitialPanel.setParent(this);
		//----------------------------
		accountInitialPanel=new AccountInitialPanel(parent);
		tab.add("账户信息初始化",accountInitialPanel);
		accountInitialPanel.setParent(this);
		// ---------buttons-----------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		btnPnl.add(submitBtn);
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		btnPnl.add(exitBtn);
	}
	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		AddInitialPanel gp = new AddInitialPanel(parent);
//		gp.setBounds(0, 0, 920, 600);
//		testFrame.add(gp);
//		testFrame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitBtn){
			
		}
		else if(e.getSource()==exitBtn){
			parent.setRightComponent(new InitialPanel(parent));
		}
		
	}
	
	public void setFocus(int i){
		tab.setSelectedIndex(i);
	}
}
