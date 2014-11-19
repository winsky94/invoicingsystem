package Presentation.uihelper;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserInfoPanel extends JPanel{
	JPanel portraitPnl;
	JLabel nameLbl,typeLbl;
	
	public UserInfoPanel(){
		this.setBackground(Color.blue);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInfoPanel u=new UserInfoPanel();
		
	}

}
