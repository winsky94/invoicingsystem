package Presentation.promotionui;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentation.mainui.functionPane;

public class listPane extends JPanel{
	JFrame parent;
	public listPane(JFrame frame){
		
		
		setSize(frame.getWidth()*775/1000,frame.getHeight());
	
		JPanel button=new functionPane(this,frame);
		button.setSize(getWidth(),30);
		this.setLayout(null);
		
		button.setLocation(0,0);
		
		add(button);
	}
	

}
