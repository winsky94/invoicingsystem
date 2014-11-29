package Presentation.promotionui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Presentation.mainui.MockFrame;
import Presentation.mainui.functionPane;

public class listPane extends JPanel{
	JFrame parent;
	JSplitPane split;
	int size;
	public listPane(MockFrame frame){
		
		
		
		setSize(frame.getWidth()*1000/1225,frame.getHeight());
		int width=this.getWidth();
		System.out.println(width);
		
	//============functionPane由mainFrame构造
		JPanel button=new functionPane(this,frame,size);
		JPanel pane=new JPanel();
		FlowLayout flow=new FlowLayout();
		flow.setAlignment(FlowLayout.RIGHT);
		pane.setLayout(flow);
		pane.add(button);
		
		this.setLayout(new BorderLayout());
		
	//	button.setLocation(0,0);
		
		add(pane);
		
		
	}
	
	public void paint(){
		
	}
	
	
	

}
