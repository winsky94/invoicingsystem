package Presentation.promotionui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentation.mainui.functionPane;

public class listPane extends JPanel{
	JFrame parent;
	public listPane(JFrame frame){
		setSize(frame.getWidth()*3/4,frame.getHeight());
		JPanel button=new functionPane(this,frame);
		add(button);
	}
	

}
