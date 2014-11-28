package Presentation.promotionui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class leftPane extends JPanel{
	
	
	//头像 info到时候动态获取根据user  size需要父类添加时get
	JButton receipt,promotion,view,back;
	JPanel headPane;
	
	public leftPane(){
		
		headPane=new headPane(this);
		receipt=new JButton("单据审批",new ImageIcon("img/promotion/receiptView.png"));
		promotion=new JButton("策略制定",new ImageIcon("img/promotion/promotion.png"));
		view=new JButton("业绩查看",new ImageIcon("img/promotion/view.png"));
		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
		this.setLayout(grid);
		
		//------添加组件
		add(headPane);
		add(receipt);
		add(promotion);
		add(view);
		
	
		
		
		
		
		
		
		
		
		
		
		
	
			
	}

}
