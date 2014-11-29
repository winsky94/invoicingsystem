package Presentation.promotionui;

import java.awt.Color;
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
	
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int frameWidth = screenWidth * 85 / 100;
	int frameHeight = screenHeight * 85 / 100;
	//头像 info到时候动态获取根据user  size需要父类添加时get
	JLButton receipt,promotion,view,back;
	JPanel headPane;
	Color color=new Color(115,46,126);
	JFrame parent;
	
	public leftPane(MainFrame frame){
		parent=frame;
		setSize(frameWidth*225/1000,frameHeight);
		//去掉
		User user=new User("小金金",UserJob.MANAGER,1000);
		
		headPane=new headPane(frame,this,user);
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
		
	//	GridBagLayout grid=new GridBagLayout();
		//GridBagConstraints c=new GridBagConstraints();
		GridLayout grid=new GridLayout(7,1);
		this.setLayout(grid);
		this.setBackground(color);
		
		//------添加组件
		add(headPane);
		add(receipt);
		add(promotion);
		add(view);
		
	
		
		
		
		
		
		
		
		
	
		
		
	
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==promotion){
			promotion.setFocusable(true);
		
		}
		
	}

}
