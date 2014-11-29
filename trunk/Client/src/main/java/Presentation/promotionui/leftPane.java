package Presentation.promotionui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import po.UserPO.UserJob;
import businesslogic.userbl.User;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.uihelper.UIhelper;

public class leftPane extends JPanel implements ActionListener{
	
	//头像 info到时候动态获取根据user  size需要父类添加时get
	JLButton receipt,promotion,view;
	JButton aboutBtn,backBtn;
	JPanel headPane;
	Color color;
	MainFrame parent;
	
	public leftPane(MainFrame frame){
		parent=frame;
		setSize(frame.getWidth()*225/1000,frame.getHeight());
		//去掉
		User user=parent.getUser();
		color=parent.getTheme()[0];
		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
	
		this.setLayout(grid);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;c.gridy=0;
		c.gridheight=2;
		
		headPane=new headPane(parent,this,user);
		grid.setConstraints(headPane, c);
		this.add(headPane);
		
		JPanel down=new JPanel();
		c.weightx=0.3;c.weighty=0.4;
		c.gridx=0;c.gridy=2;
		c.gridheight=6;
		c.gridwidth=1;
		grid.setConstraints(down, c);
		this.add(down);
		down.setBackground(color);
		down.setLayout(new GridLayout(6,1));
		
		
		
		ImageIcon receiptImg=new ImageIcon("img/promotion/receiptView.png");
		receipt=new JLButton("单据审批",receiptImg);
		int width=this.getWidth();
		int height=this.getHeight()/10;
		
		receiptImg.setImage(receiptImg.getImage().getScaledInstance(width/4,height-10,Image.SCALE_DEFAULT));
		ImageIcon proImg=new ImageIcon("img/promotion/promotion.png");
		promotion=new JLButton("策略制定",proImg);
		proImg.setImage(proImg.getImage().getScaledInstance(width/4,height-10,Image.SCALE_DEFAULT));
		ImageIcon viewImg=new ImageIcon("img/promotion/view.png");
		view=new JLButton("业绩查看",viewImg);
		viewImg.setImage(viewImg.getImage().getScaledInstance(width/4,height-10,Image.SCALE_DEFAULT));
		
		receipt.addActionListener(this);
		promotion.addActionListener(this);
		view.addActionListener(this);
		
		aboutBtn = new JButton("关于系统", new ImageIcon("img/icon-about.png"));
		aboutBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		aboutBtn.setForeground(Color.white);
		aboutBtn.setBackground(color);
		aboutBtn.setHorizontalAlignment(SwingConstants.CENTER);
		aboutBtn.setFocusPainted(false);
		aboutBtn.addActionListener(this);
		
		
	//	GridBagLayout grid=new GridBagLayout();
		//GridBagConstraints c=new GridBagConstraints();
		
		down.add(receipt);
		down.add(promotion);
		down.add(view);
		down.add(aboutBtn);
		
		
		backBtn=new JButton("收起菜单",new ImageIcon("img/mainFrame/back.png"));
		backBtn.setFont(new Font("楷体", Font.PLAIN, 19));
		backBtn.setForeground(Color.white);
		backBtn.setBackground(color);
		backBtn.setHorizontalAlignment(SwingConstants.CENTER);
		backBtn.setFocusPainted(false);
		backBtn.addActionListener(this);
		c.gridx=0;c.gridy=8;
		grid.setConstraints(backBtn, c);
		this.add(backBtn);
		this.setBackground(color);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==promotion){
			promotion.setFocusable(true);
		
		}
		
	}

}
